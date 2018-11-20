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

	
	//Node does not have default or no-arg constructor
	public Node(BigDecimal value, int index, BigDecimal x, BigDecimal y) {
		this.value = value;
		this.index = index;
		this.x = x;
		this.y = y;
	}

	//default-access constructor for test purposes
	Node(BigDecimal value, int index, BigDecimal x, BigDecimal y, boolean visited) {
		this.value = value;
		this.index = index;
		this.x = x;
		this.y = y;
		this.visited = visited;
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

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
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
		if (t.visited == true && this.visited == false) {
			return -1;
		} else if (t.visited == this.visited) {
			if (t.value == null && this.value != null) {
				return -1;
			} else if (this.value == null && t.value == null) {
				return 0;
			} else if (this.value == null && t.value != null) {
				return 1;
			} else {
				return this.value.compareTo(t.value);
			}
		} else if (t.visited == false && this.visited == true) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Index " + index + ", Value " + value + ", Visited " + visited;
	}

}
