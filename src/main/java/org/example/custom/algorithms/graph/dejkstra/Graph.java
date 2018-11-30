/*
 * Copyright 2018
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.custom.algorithms.graph.dejkstra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 ** This class provides methods to find optimal ways between vertexes in
 * weighted equal-directional graph
 *
 * @author dnikiforov
 */
public final class Graph {

	class Edge {

		private Node vertexA;
		private Node vertexB;
		private BigDecimal path;

		Edge(Node vertexA, Node vertexB, BigDecimal path) {
			this.vertexA = vertexA;
			this.vertexB = vertexB;
			this.path = path;
		}

		Node getVertexA() {
			return vertexA;
		}

		void setVertexA(Node vertexA) {
			this.vertexA = vertexA;
		}

		Node getVertexB() {
			return vertexB;
		}

		void setVertexB(Node vertexB) {
			this.vertexB = vertexB;
		}

		BigDecimal getPath() {
			return path;
		}

		void setPath(BigDecimal path) {
			this.path = path;
		}

		@Override
		public int hashCode() {
			int hash = 3;
			hash = 31 * hash + Objects.hashCode(this.vertexA);
			hash = 31 * hash + Objects.hashCode(this.vertexB);
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Edge other = (Edge) obj;
			if (!Objects.equals(this.vertexA, other.vertexA)) {
				return false;
			}
			if (!Objects.equals(this.vertexB, other.vertexB)) {
				return false;
			}
			return true;
		}

	}

	public static final class Node implements Comparable<Node> {

		//Value in Graph
		private BigDecimal value;
		//Index (begins from 0, zero - initial path point)
		private final int index;
		//Mark node as visited (analysed)
		private boolean visited = false;
		//Geographical coordinates
		private final BigDecimal x, y;

		public Node(int index, String x, String y) {
			this.value = null;
			this.index = index;
			this.x = new BigDecimal(x);
			this.y = new BigDecimal(y);
		}

		public Node(int index, double x, double y) {
			this.value = null;
			this.index = index;
			this.x = new BigDecimal(x);
			this.y = new BigDecimal(y);
		}

		//default-access constructor for test purposes
		Node(BigDecimal value, int index, BigDecimal x, BigDecimal y) {
			this.value = value;
			this.index = index;
			this.x = x;
			this.y = y;
		}

		public BigDecimal getX() {
			return x;
		}

		public BigDecimal getY() {
			return y;
		}

		public BigDecimal getValue() {
			return value;
		}

		void setValue(BigDecimal value) {
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public boolean isVisited() {
			return visited;
		}

		void setVisited(boolean visited) {
			this.visited = visited;
		}

		@Override
		public int hashCode() {
			int hash = 7;
			hash = 23 * hash + this.index;
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Node other = (Node) obj;
			if (this.index != other.index) {
				return false;
			}
			return true;
		}

		@Override
		public int compareTo(Node t) {
			if (t.value == null && this.value != null) {
				return -1;
			} else if (this.value == null && t.value == null) {
				return 0;
			} else if (this.value == null && t.value != null) {
				return 1;
			} else {
				return this.value.compareTo(t.value);
			}
		}

		@Override
		public String toString() {
			return "Index " + index + ", Value " + value + ", Visited " + visited;
		}

	}

	//Original order
	private final List<Node> nodes = new ArrayList<>();
	//Dynamic order
	private final List<Node> sortedNodes = new LinkedList<>();
	//Array of ages
	private final BigDecimal[][] edges;
	private static final BigDecimal MAX_VALUE = new BigDecimal(Double.MAX_VALUE);

	//Binary red-black heap. Many nodes can have the same value - important !
	NavigableMap<BigDecimal, NavigableMap<Integer, Node>> vertexToCheck = new TreeMap<>();

	public Graph(final String[][] edges, final Node... nodes) {
		initializeNodes(nodes);
		if (edges == null) {
			this.edges = null;
			return;
		}
		final Stream<String[]> edgesStream = Arrays.stream(edges);
		this.edges = edgesStream.<BigDecimal[]>map((t) -> {
			final Stream<BigDecimal> map
					= Arrays.stream(t).map(
							(e) -> {
								return (e == null ? null : new BigDecimal(e));
							});
			final BigDecimal[] toArray = map.toArray(BigDecimal[]::new);
			return toArray;
		}
		).toArray(BigDecimal[][]::new);
	}

	public Graph(final Double[][] edges, final Node... nodes) {
		initializeNodes(nodes);
		if (edges == null) {
			this.edges = null;
			return;
		}
		final Stream<Double[]> edgesStream = Arrays.stream(edges);
		this.edges = edgesStream.<BigDecimal[]>map((t) -> {
			final Stream<BigDecimal> map
					= Arrays.stream(t).map(
							(e) -> {
								return (e == null ? null : new BigDecimal(e));
							});
			final BigDecimal[] toArray = map.toArray(BigDecimal[]::new);
			return toArray;
		}).toArray(BigDecimal[][]::new);
	}

	private void initializeNodes(final Node[] nodes) {
		final Stream<Node> stream = Arrays.stream(nodes);
		stream.forEach((t) -> {
			//Undefind values should be set to null if index is 0
			if (t.getIndex() == 0 && t.getValue() == null) {
				t.setValue(BigDecimal.ZERO);
			} else if (t.getValue() == null) {
				//Undefind values should be set to max possible double
				t.setValue(MAX_VALUE);
			}
			this.nodes.add(t.getIndex(), t);
			if (t.getValue() != null && !t.getValue().equals(MAX_VALUE)) {
				appendVertexToMap(t);
			}
		});
	}

	void appendVertexToMap(final Node vertex) {
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

	void removeVertexFromMap(final Node vertex) {
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
