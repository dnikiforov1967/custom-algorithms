/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct.rbt;

/**
 *
 * @author dima
 */
final class Node<T> {
    private Color color = Color.RED;
    private Node left, right;
    private T value;

    Node(T value) {
        this.value = value;
        left = new Node(null);
        right = new Node(null);
        left.color=Color.BLACK;
        right.color=Color.BLACK;
    }
}