/*
 * Copyright 2018
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example.custom.algorithms.sort.merge;

/**
 *
 * @author dima
 */
public final class SortMerge {
    
    private SortMerge() {}
    
    public static <T extends Comparable<T>> void sort(final T[] array) {
        //start from full range
        sort(array, 0, array.length-1);
    }
    
    static <T extends Comparable<T>> void swap(final T[] array, final int i, final int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    
    private static <T extends Comparable<T>> void sort(final T[] array, final int low, final int top) {
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
