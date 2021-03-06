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
package org.example.custom.algorithms.struct.avl;

import java.util.LinkedList;
import org.example.custom.algorithms.struct.AbstractNode;
import org.example.custom.algorithms.struct.AbstractTree;

/**
 *
 * @author dnikiforov
 */
public class AvlTree<K extends Comparable<K>, V> extends AbstractTree<K,V>  {

	private class Node extends AbstractNode<K,V> {

		private byte deep = 1;

		public Node(K key, V value) {
			super(key, value);
		}

		public byte getDeep() {
			return deep;
		}

	}

	private byte deep(Node node) {
		return (node == null ? 0 : node.deep);
	}

	@Override
	protected int diffLeftAndRight(AbstractNode<K, V> node) {
		return deep((Node)node.getLeft()) - deep((Node)node.getRight());
	}

	@Override
	protected int fixheight(AbstractNode<K, V> node) {
		byte hl = deep((Node)node.getLeft());
		byte hr = deep((Node)node.getRight());
		((Node)node).deep = (byte) ((hl > hr ? hl : hr) + 1);
		return ((Node)node).deep;
	}

	@Override
	protected AbstractNode<K, V> smallLeftTurn(AbstractNode<K, V> a) {
		Node x = (Node)super.smallLeftTurn(a);
		fixheight(x);
		fixheight((Node)x.getLeft());
		return x;
	}

	@Override
	protected AbstractNode<K, V> smallRightTurn(AbstractNode<K, V> a) {
		Node x = (Node)super.smallRightTurn(a);
		fixheight(x);
		fixheight((Node)x.getRight());
		return x;
	}
	
	@Override
	protected AbstractNode<K,V> balance(AbstractNode<K,V> p)
	{
		final int d = fixheight(p); //Calc new height
		final int diff = diffLeftAndRight(p);
		if( diff== -2 ) //left - right == -2
		{
			final Node b = (Node)p.getRight();
			if( diffLeftAndRight(b) <= 0 ) {
				p = (Node)smallLeftTurn(p);
			} else {
				p = (Node)bigLeftTurn(p);
			}	
		}
		if (diff== 2) //left - right == 2
		{
			final Node b = (Node)p.getLeft();
			if( diffLeftAndRight(b) > 0 ) {
				p = (Node)smallRightTurn(p);
			} else {
				p = (Node)bigRightTurn(p);
			}	
		}
		return p;
	}

	
	public AbstractNode<K,V> put(K key, V value) {
		LinkedList<AbstractNode<K,V>> path = new LinkedList<>();
		final Node node = new Node(key, value);
		final AbstractNode<K,V> assigned = super.appendNode(node, path);
		rebalance(assigned, path);
		return assigned;
	}

}
