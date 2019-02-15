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
package org.example.custom.algorithms.struct;

import java.util.Objects;

/**
 *
 * @author dnikiforov
 */
public abstract class AbstractNode<K extends Comparable<K>, V> {

	private AbstractNode<K, V> left, right;

	private final K key;
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

	protected final void setValue(V value) {
		this.value = value;
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
