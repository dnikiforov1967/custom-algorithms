/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

	class Node extends AbstractNode<K,V> {

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

	
	public Node put(K key, V value) {
		LinkedList<AbstractNode<K,V>> path = new LinkedList<>();
		final Node node = new Node(key, value);
		final Node assigned = (Node)super.appendNode(node, path);
		balance(assigned);
		AbstractNode<K, V> last = path.pollLast();
		while(last!=null) {
			balance((Node)last);
			last = path.pollLast();
		}
		return assigned;
	}

}
