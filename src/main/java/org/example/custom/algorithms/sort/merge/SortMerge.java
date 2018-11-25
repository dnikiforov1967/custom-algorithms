/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.sort.merge;

import java.util.List;

/**
 *
 * @author dima
 */
public final class SortMerge<T extends Comparable<T>> {
    
    public void sort(final T[] array) {
        //start from full range
        sort(array, 0, array.length-1);
    }
    
    void swap(final T[] array, final int i, final int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    
    private void sort(final T[] array, final int low, final int top) {
        if (low==top) return;
        if (low==top-1) {
            if (array[low].compareTo(array[top])==1) {
                swap(array,low,top);
                return;
            }
        }
        //sort 1/2 of piece
        int middle = (low + top)/2;
        sort(array, low, middle);
        sort(array, middle+1, top);
        Object[] result = new Object[top-low+1];
        int i=low, j=middle+1, k=0;
        while(i<=middle || j<=top) {
            //we have reached limit in first half
            if (i > middle) {
                result[k++] = array[j++];
            } else if (j > top) {
                result[k++] = array[i++];
            } else {
                if (array[i].compareTo(array[j])==1) {
                    result[k++]=array[j++];
                } else {
                    result[k++]=array[i++];
                }
            }
        }
        for(int m=0, p=low; m<result.length; m++) {
            array[p++]=(T)result[m];
        }
    }    
    
}
