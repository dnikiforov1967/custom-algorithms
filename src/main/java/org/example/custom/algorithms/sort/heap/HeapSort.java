/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.sort.heap;

/**
 *
 * @author dima
 */
public final class HeapSort {

	private HeapSort() {
	}

	public static <T extends Comparable<T>> void sort(T[] array) {

	}

	static int initialIndex(int idx) {
		int rest = idx % 2;
		if (rest == 0) {
			return idx / 2 - 1;
		} else {
			return idx / 2;
		}

	}

	static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
		T x = array[i];
		array[i] = array[j];
		array[j] = x;
	}
	
	private static <T extends Comparable<T>> void buildHeapNlogN(T[] array, int tail) {
		//we suppose till tail it's a heap
		int j = tail;
		int i = initialIndex(j);
		while(i>=0) {
			if (array[i].compareTo(array[j])==-1) {
				swap(array,i,j);
				//Top element
				if (i==0) {
					break;
				}				
				j = i;
				i = initialIndex(j);
			} else {
				break;
			}
		}
		
	}

	static <T extends Comparable<T>> void buildHeapNlogN(T[] array) {
		for(int i=1; i<array.length; i++) {
			buildHeapNlogN(array, i);
		}
	}

}
