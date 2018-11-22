/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.dejkstra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 ** This class provides methods to find optimal ways between vertexes in
 * weighted equal-directional graph
 *
 * @author dnikiforov
 */
public final class Graph {

	//Original order
	private final List<Node> nodes = new ArrayList<>();
	//Dynamic order
	private final List<Node> sortedNodes = new LinkedList<>();
	//Array of ages
	private final BigDecimal[][] edges;

	//Binary red-black heap. Many nodes can have the same value - important !
	NavigableMap<BigDecimal, NavigableMap<Integer, Node>> vertexToCheck = new TreeMap<>();

	public Graph(String[][] edges, Node... nodes) {
		initializeNodes(nodes);
		if (edges == null) {
			this.edges = null;
			return;
		}
		final Stream<String[]> edgesStream = Arrays.stream(edges);
		this.edges = edgesStream.map(new Function<String[], BigDecimal[]>() {
			@Override
			public BigDecimal[] apply(String[] t) {
				final Stream<BigDecimal> map
						= Arrays.stream(t).map(
								(e) -> {
									return (e == null ? null : new BigDecimal(e));
								});
				final BigDecimal[] toArray = map.toArray(BigDecimal[]::new);
				return toArray;
			}
		}).toArray(BigDecimal[][]::new);		
	}

	public Graph(Double[][] edges, Node... nodes) {
		initializeNodes(nodes);
		if (edges == null) {
			this.edges = null;
			return;
		}
		final Stream<Double[]> edgesStream = Arrays.stream(edges);
		this.edges = edgesStream.map(new Function<Double[], BigDecimal[]>() {
			@Override
			public BigDecimal[] apply(Double[] t) {
				final Stream<BigDecimal> map
						= Arrays.stream(t).map(
								(e) -> {
									return (e == null ? null : new BigDecimal(e));
								});
				final BigDecimal[] toArray = map.toArray(BigDecimal[]::new);
				return toArray;
			}
		}).toArray(BigDecimal[][]::new);
	}

	private void initializeNodes(Node[] nodes) {
		final Stream<Node> stream = Arrays.stream(nodes);
		stream.forEach((t) -> {
			//Undefind values should be set to null if index is 0
			if (t.getIndex() == 0 && t.getValue()==null) {
				t.setValue(BigDecimal.ZERO);
			} else if (t.getValue()==null) {
				//Undefind values should be set to max possible double
				t.setValue(new BigDecimal(Double.MAX_VALUE));
			}
			this.nodes.add(t.getIndex(), t);
			appendVertexToMap(t);
		});
	}

	void appendVertexToMap(Node vertex) {
		final BigDecimal value = vertex.getValue();
		NavigableMap<Integer, Node> map = vertexToCheck.get(value);
		if (map == null) {
			map = new TreeMap<>();
			vertexToCheck.put(value, map);
		}
		map.put(vertex.getIndex(), vertex);
	}

	Node extractNextNode() {
		Node node = null;
		final Map.Entry<BigDecimal, NavigableMap<Integer, Node>> firstEntry = vertexToCheck.firstEntry();
		if (firstEntry != null) {
			final NavigableMap<Integer, Node> map = firstEntry.getValue();
			node = map.pollFirstEntry().getValue();
			if (map.isEmpty()) {
				vertexToCheck.remove(node.getValue());
			}
		}
		return node;
	}

	void removeVertexFromMap(Node vertex) {
		final BigDecimal value = vertex.getValue();
		final NavigableMap<Integer, Node> map = vertexToCheck.get(value);
		if (map == null) {
			return;
		}
		map.remove(vertex.getIndex());
		if (map.isEmpty()) {
			vertexToCheck.remove(vertex.getValue());
		}
	}

	/**
	 * Method to find next node to check and remove visited The performance
	 * O(n*n) while with sort it should be O(n*n*ln(n))
	 */
	Node findNextNodeAndModifyList() {
		Node nextNode = null;
		final Iterator<Node> iterator = sortedNodes.iterator();
		while (iterator.hasNext()) {
			final Node next = iterator.next();
			//Remove node if visited, go to next element
			if (next.isVisited()) {
				iterator.remove();
				continue;
			}
			if (nextNode == null || next.compareTo(nextNode) == -1) {
				nextNode = next;
			}
		}
		return nextNode;
	}

	public void printNodes() {
		sortedNodes.forEach((t) -> {
			System.out.println(t);
		});
	}

	public List<Node> returnResult() {
		final List<Node> unmodifiableList = Collections.unmodifiableList(nodes);
		return unmodifiableList;
	}

	/**
	 ** Method to find weights of vertexes in graph
	 */
	public void weightNodes() {
		Node vertex = null;
		//Extract node to heap and check for nullity
		while ((vertex = extractNextNode()) != null) {
			BigDecimal valueStart = vertex.getValue();
			int index = vertex.getIndex();
			BigDecimal[] paths = edges[index];
			for (int i = 0; i < paths.length; i++) {
				BigDecimal path = paths[i];
				if (path != null) {
					final Node get = nodes.get(i);
					//Skip visited nodes
					if (get.isVisited()) {
						continue;
					}
					BigDecimal proposedValue = valueStart.add(path);
					//If neighbor node has undefined value or new value is less, update value
					if (proposedValue.compareTo(get.getValue()) == -1) {
						rebalanceVertex(get, proposedValue);
					}
				}
			}
			vertex.setVisited(true);
		}
	}

	void rebalanceVertex(final Node get, final BigDecimal proposedValue) {
		//KEY IS CHANGED !!!
		removeVertexFromMap(get);
		get.setValue(proposedValue);
		appendVertexToMap(get);
	}

}
