/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct.randtree;

import java.util.Objects;

/**
 *
 * @author dima
 */
final class RandomNode<T extends Comparable<T>, V extends Object> {
    private T key;
	private V value;
    private int random;

	public RandomNode(T key, V value) {
		this.key = key;
		this.value = value;
	}
	
}
