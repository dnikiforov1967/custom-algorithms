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
	
	private static <T extends Comparable<T>> int chooseIndexOfMaxElement(T[] array, int i, int j) {
		return (array[j].compareTo(array[i])==1 ? j : i);
	}
	
	static <T extends Comparable<T>> void rebuildHeap(T[] array, int heapEnd) {
		int i = 0;
		int j = 2*i + 1; 
		while(j <= heapEnd) {
			int iSwap = j;
			if (j+1 <= heapEnd) {
				iSwap = chooseIndexOfMaxElement(array, j, j+1);
			}
			if (array[i].compareTo(array[iSwap])==-1) {
				swap(array, i, iSwap);
				i = iSwap;
				j = 2*i + 1;
			} else {
				break;
			}
		}
	}
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		buildHeapNlogN(array);
		for(int i=array.length-1; i>0; i--) {
			swap(array, 0, i);
			rebuildHeap(array, i-1);
		}
	}	

}
