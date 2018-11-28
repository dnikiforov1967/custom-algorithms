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

	private class Node extends AbstractNode<K,V> {

		private byte deep = 1;

		public Node(K key, V value) {
			super(key, value);
		}

	}

	private Node head;

	byte deep(Node node) {
		return (node == null ? 0 : node.deep);
	}

	int bfactor(Node node) {
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
		if( bfactor(p)== -2 ) //left - right == -2
		{
			if( bfactor((Node)p.getRight()) <= 0 ) {
				p = (Node)smallLeftTurn(p);
			} else {
				p = (Node)bigLeftTurn(p);
			}	
		}
		//TO DO mirror case
		return p; // No balance
	}	

}
