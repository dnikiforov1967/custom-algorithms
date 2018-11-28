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
public abstract class AbstractTree<K extends Comparable<K>, V> {

	protected AbstractNode<K, V> head;
	
	public final AbstractNode<K, V> smallRightTurn(AbstractNode<K, V> a) {
		final AbstractNode<K, V> b = a.getLeft();
		//Keep b.left;
		//Keep a.right;
		final AbstractNode<K, V> bright = b.getRight();
		a.setLeft(bright);
		b.setRight(a);
		return b;
	}

	AbstractNode<K, V> smallLeftTurn(AbstractNode<K, V> a) {
		final AbstractNode<K, V> b = a.getRight();
		//Keep a.left;
		//Keep b.right;
		final AbstractNode<K, V> bleft = b.getLeft();
		a.setRight(bleft);
		b.setLeft(a);
		return b;
	}

	AbstractNode<K, V> bigRightTurn(AbstractNode<K, V> a) {
		AbstractNode<K, V> b = a.getLeft();
		AbstractNode<K, V> c = b.getRight();
		//b.left kept
		//a.right kept
		b.setRight(c.getLeft());
		a.setLeft(b.getRight());
		c.setLeft(b);
		c.setRight(a);
		return c;
	}

	AbstractNode<K, V> bigLeftTurn(AbstractNode<K, V> a) {
		AbstractNode<K, V> b = a.getRight();
		AbstractNode<K, V> c = b.getLeft();
		//a.left kept
		//b.right kept
		a.setRight(c.getLeft());
		b.setLeft(c.getRight());
		c.setLeft(a);
		c.setRight(b);
		return c;
	}	
	
}
