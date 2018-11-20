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

	public Graph(BigDecimal[][] edges, Node... nodes) {
		this.edges = edges;
		final Stream<Node> stream = Arrays.stream(nodes);
		//Append in both arrays
		stream.forEach((t) -> {
			this.nodes.add(t);
			this.sortedNodes.add(t);
		});
	}

	/**
	 * Method for nodes sorting. TODO - more optimal way to get node with
	 * minimal weight
	 */
	private void sort() {
		Collections.sort(sortedNodes);
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
		while ((vertex = findNextNodeAndModifyList()) != null) {
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
					if (get.getValue() == null || proposedValue.compareTo(get.getValue()) == -1) {
						get.setValue(proposedValue);
					}
				}
			}
			vertex.setVisited(true);
		}
	}

}
