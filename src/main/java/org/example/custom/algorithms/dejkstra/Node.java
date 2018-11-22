/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.dejkstra;

import java.math.BigDecimal;

/**
 ** Class Node reflects the position and weight of graph vertex
 *
 *
 * @author dnikiforov
 */
public final class Node implements Comparable<Node> {

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
