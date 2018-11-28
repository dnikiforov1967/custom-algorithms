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

	/**
	 * A	B
	 * B	C	-->	D	A D	E	E	C
	 *
	 *
	 *
	 *
	 * @param a Turn-around node
	 * @return
	 */
	AbstractNode<K, V> smallRightTurn(AbstractNode<K, V> a) {
		if (a == null) {
			throw new IllegalStateException("Root is null");
		}		
		final AbstractNode<K, V> b = a.getLeft();
		if (b == null) {
			throw new IllegalStateException("Left subtree is null");
		}
		//Keep b.left;
		//Keep a.right;
		final AbstractNode<K, V> bright = b.getRight();
		a.setLeft(bright);
		b.setRight(a);
		return b;
	}

	/**
	 * A	B
	 * C	B	-->	A	E D	E	C	D
	 *
	 *
	 *
	 *
	 * @param a Turn-around node
	 * @return
	 */
	AbstractNode<K, V> smallLeftTurn(AbstractNode<K, V> a) {
		if (a == null) {
			throw new IllegalStateException("Root is null");
		}
		final AbstractNode<K, V> b = a.getRight();
		if (b == null) {
			throw new IllegalStateException("Right subtree is null");
		}
		//Keep a.left;
		//Keep b.right;
		final AbstractNode<K, V> bleft = b.getLeft();
		a.setRight(bleft);
		b.setLeft(a);
		return b;
	}

	AbstractNode<K, V> bigRightTurn(AbstractNode<K, V> a) {
		if (a == null) {
			throw new IllegalStateException("Root is null");
		}
		AbstractNode<K, V> b = a.getLeft();
		final AbstractNode<K, V> c = smallLeftTurn(b);
		a.setLeft(c);
		return smallRightTurn(a);
	}

	/**
	 *						A
	 *				L							B
	 *								C	
	 *							M		N				R
	 * 
	 *								||
	 * 
	 *								C
	 *					A						B
	 *				L		M				N		R
	 * 
	 * @param a
	 * @return 
	 */
	AbstractNode<K, V> bigLeftTurn(AbstractNode<K, V> a) {
		if (a == null) {
			throw new IllegalStateException("Root is null");
		}
		AbstractNode<K, V> b = a.getRight();
		final AbstractNode<K, V> c = smallRightTurn(b);
		a.setRight(c);
		return smallLeftTurn(a);		
	}

}
