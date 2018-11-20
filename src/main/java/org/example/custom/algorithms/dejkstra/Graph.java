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
import java.util.List;
import java.util.stream.Stream;

/**
 ** This class provides methods to find optimal ways between vertexes in weighted equal-directional graph
 *
 * @author dnikiforov
 */
public final class Graph {

	//Original order
	private final List<Node> nodes = new ArrayList<>();
	//Dynamic order
	private final List<Node> sortedNodes = new ArrayList<>();
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
	

	//Order nodes by visited,value asc
	private void sort() {
		Collections.sort(sortedNodes);
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
	public void findWeights() {
		sort();
		final Node start = sortedNodes.get(0);
		//End process when last node is visited
		if (start.isVisited()) {
			return;
		} else {
			weightNeighbors();
			findWeights();
		}

	}

	private void weightNeighbors() {
		final Node vertex = sortedNodes.get(0);
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
