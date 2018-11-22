/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.sort.radix;

/**
 *
 * @author dnikiforov
 */
public final class RadixSort {

	private final int RADIX = 0xFF;
	private final int[] counters = new int[256]; //0..255 by radix

	public void sort(int[] A) {
		//Integer consists of 4 bytes in Java. This is universal rule
		int[] B = new int[A.length];
		int[] source, target;
		int index = 0;
		for(int j = 1; j <= 4; j++) { //Four steps
			if (j%2 == 1) {
				source = A;
				target = B;
			}
			else {
				source = B;
				target = A;
			}
			for (int i = 0; i<source.length; i++)
				counters[(source[i] >> 8*(j-1)) & RADIX]++; //Find radix value - byte's AND - in this case let's increase
			for (int i= 1; i<counters.length; i++) counters[i] += counters[i-1];

			for (int i = source.length-1; i>=0; i--) {
				index = (source[i] >> 8*(j-1)) & RADIX;
				counters[index] -= 1;
				target[counters[index]] = source[i];
			}	
			for (int i= 1; i<counters.length; i++) counters[i] = 0;
		}
	}

}