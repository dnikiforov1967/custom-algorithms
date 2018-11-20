/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.dejkstra;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author dnikiforov
 */
public final class Edge {
	
	private Node vertexA;
	private Node vertexB;
	private BigDecimal path;

	public Edge(Node vertexA, Node vertexB, BigDecimal path) {
		this.vertexA = vertexA;
		this.vertexB = vertexB;
		this.path = path;
	}

	public Node getVertexA() {
		return vertexA;
	}

	public void setVertexA(Node vertexA) {
		this.vertexA = vertexA;
	}

	public Node getVertexB() {
		return vertexB;
	}

	public void setVertexB(Node vertexB) {
		this.vertexB = vertexB;
	}

	public BigDecimal getPath() {
		return path;
	}

	public void setPath(BigDecimal path) {
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
