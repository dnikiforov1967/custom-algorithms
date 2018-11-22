/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.sort.radix;

import java.util.Arrays;

/**
 *
 * @author dnikiforov
 */
public class GenericRadixSort<T extends ByteWrapper> {
	
	private final int[] counters = new int[127]; //0..255 by radix
	
	public Object[] sort(T[] array, int byteCount) {
		//Integer consists of 4 bytes in Java. This is universal rule
		Object[] storage = new Object[array.length];
		Object[] source = array, target = storage;
		int index = 0;
		for(int j = 1; j <= byteCount; j++) {
			
			for (int i = 0; i<source.length; i++) {
				final T xObj = (T)source[i];
				final byte element = xObj.toByteArray()[byteCount-j];
				final int position = element;
				counters[position]++; //Find radix value - byte's AND - in this case let's increase
				//System.out.println("Position of "+source[i]+" is "+position+", counters "+counters[position]);
				
			}
			for (int i= 1; i<counters.length; i++) counters[i] += counters[i-1];

			for (int i = source.length-1; i>=0; i--) {
				System.out.println(source[i]);
			}
			//for (int i = 0; i<source.length; i++) {
			final int jIndex = byteCount-j;
			Arrays.stream(source).forEach((o)->{
				final T obj = (T)o;
				final byte[] toByteArray = obj.toByteArray();
				final byte element = toByteArray[jIndex];
				counters[element] -= 1;
				System.out.println("Element "+obj+" in position "+counters[element]);
				target[counters[element]] = obj;
			}
				);	
			//}	
			
			for (int i= 1; i<counters.length; i++) counters[i] = 0;
			source = target;
		}
		return source;
	}	
	
}
