/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct.avl;

/**
 *
 * @author dima
 */
final class Node<T extends Comparable<T>> {
    private int height = 1;
    private Node left, right;
    private T value;

    Node(T value) {
        this.value = value;
    }
}