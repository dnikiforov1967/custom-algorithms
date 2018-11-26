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
		while (i >= 0) {
			if (array[i].compareTo(array[j]) == -1) {
				swap(array, i, j);
				//Top element
				if (i == 0) {
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
		for (int i = 1; i < array.length; i++) {
			buildHeapNlogN(array, i);
		}
	}

	public static <T extends Comparable<T>> void buildHeap(T[] array) {
		for (int i = array.length / 2; i >= 0; i--) {
			rebuildHeap(array, i, array.length-1);
		}
	}

	static <T extends Comparable<T>> void rebuildHeap(T[] array, int top, int heapEnd) {
		int largestChild;
		int leftChild;
		int rightChild;
		for (;;) {
			largestChild = top;
			leftChild = 2 * top + 1;
			rightChild = 2 * top + 2;

			if (leftChild <= heapEnd && array[leftChild].compareTo(array[largestChild]) == 1) {
				largestChild = leftChild;
			}
			if (rightChild <= heapEnd && array[rightChild].compareTo(array[largestChild]) == 1) {
				largestChild = rightChild;
			}
			if (largestChild == top) {
				break;
			}
			swap(array, top, largestChild);
			top = largestChild;
		}
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		buildHeap(array);
		for (int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			rebuildHeap(array, 0, i - 1);
		}
	}

}
