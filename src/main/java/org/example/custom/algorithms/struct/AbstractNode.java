/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct;

import java.util.Objects;

/**
 *
 * @author dnikiforov
 */
public abstract class AbstractNode<K extends Comparable<K>, V> {

	private AbstractNode<K, V> left, right;

	private K key;
	private V value;

	public AbstractNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public AbstractNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(AbstractNode<K, V> left) {
		this.left = left;
	}

	public AbstractNode<K, V> getRight() {
		return right;
	}

	public void setRight(AbstractNode<K, V> right) {
		this.right = right;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 41 * hash + Objects.hashCode(this.key);
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
		if (!(obj instanceof AbstractNode)) {
			return false;
		}
		final AbstractNode<?, ?> other = (AbstractNode<?, ?>) obj;
		if (!Objects.equals(this.key, other.key)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AbstractNode{" + "key=" + key + '}';
	}

}
