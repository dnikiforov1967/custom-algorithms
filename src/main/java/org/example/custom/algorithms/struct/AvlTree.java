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
public class AvlTree<K extends Comparable<K>, V> {

	private static class Node<K, V> {

		private Node<K, V> left, right;
		private byte deep = 1;

		private K key;
		private V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	private Node<K, V> head;

	byte deep(Node<K, V> node) {
		return (node == null ? 0 : node.deep);
	}

	int bfactor(Node<K, V> node) {
		return deep(node.right) - deep(node.left);
	}

	void fixheight(Node<K, V> node) {
		byte hl = deep(node.left);
		byte hr = deep(node.right);
		node.deep = (byte) ((hl > hr ? hl : hr) + 1);
	}

	Node<K, V> smallRightTurn(Node<K, V> a) {
		final Node<K, V> b = a.left;
		//Keep b.left;
		//Keep a.right;
		final Node<K, V> bright = b.right;
		a.left = bright;
		b.right = a;
		return b;
	}

	Node<K, V> smallLeftTurn(Node<K, V> a) {
		final Node<K, V> b = a.right;
		//Keep a.left;
		//Keep b.right;
		final Node<K, V> bleft = b.left;
		a.right = bleft;
		b.left = a;
		return b;
	}

	Node<K, V> bigRightTurn(Node<K, V> a) {
		Node<K, V> b = a.left;
		Node<K, V> c = b.right;
		//b.left kept
		//a.right kept
		b.right = c.left;
		a.left = b.right;
		c.left = b;
		c.right = a;
		return c;
	}

	Node<K, V> bigLeftTurn(Node<K, V> a) {
		Node<K, V> b = a.right;
		Node<K, V> c = b.left;
		//a.left kept
		//b.right kept
		a.right = c.left;
		b.left = c.right;
		c.left = a;
		c.right = b;
		return c;
	}

}
