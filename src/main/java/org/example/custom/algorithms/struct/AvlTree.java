/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct;

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

	byte deep(Node node) {
		return (node == null ? 0 : node.deep);
	}

	int diffLeftAndRight(Node node) {
		return deep((Node)node.getLeft()) - deep((Node)node.getRight());
	}

	void fixheight(Node node) {
		byte hl = deep((Node)node.getLeft());
		byte hr = deep((Node)node.getRight());
		node.deep = (byte) ((hl > hr ? hl : hr) + 1);
	}

	@Override
	AbstractNode<K, V> smallLeftTurn(AbstractNode<K, V> a) {
		Node x = (Node)super.smallLeftTurn(a);
		fixheight(x);
		fixheight((Node)x.getLeft());
		return x;
	}

	@Override
	AbstractNode<K, V> smallRightTurn(AbstractNode<K, V> a) {
		Node x = (Node)super.smallRightTurn(a);
		fixheight(x);
		fixheight((Node)x.getRight());
		return x;
	}
	
	Node balance(Node p)
	{
		fixheight(p); //Calc new height
		if( diffLeftAndRight(p)== -2 ) //left - right == -2
		{
			if( diffLeftAndRight((Node)p.getRight()) <= 0 ) {
				p = (Node)smallLeftTurn(p);
			} else {
				p = (Node)bigLeftTurn(p);
			}	
		}
		if (diffLeftAndRight(p)== 2) //left - right == 2
		{
			if( diffLeftAndRight((Node)p.getLeft()) <= 0 ) {
				p = (Node)smallRightTurn(p);
			} else {
				p = (Node)bigRightTurn(p);
			}	
		}
		return p;
	}

	
	public Node put(K key, V value) {
		final Node node = new Node(key, value);
		return node;
	}

}
