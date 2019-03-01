/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.arrays;

/**
 *
 * @author dnikiforov
 */
public final class ArrayHelper {

	private ArrayHelper() {
	}

	public static void reverese(int[] A, int i, int j) {
		while (i < j) {
			int temp = A[j];
			A[j] = A[i];
			A[i] = temp;
		}
	}

}
