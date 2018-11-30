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
package org.example.custom.algorithms.sort.radix;

/**
 *
 * @author dnikiforov
 */
public final class RadixSort {

	private final int RADIX = 0xFF;
	private final int[] counters = new int[256]; //0..255 by radix

	public int[] sort(int[] A) {
		//Integer consists of 4 bytes in Java. This is universal rule
		int[] B = new int[A.length];
		int[] source = A, target = B;
		int index = 0;
		for(int j = 1; j <= 4; j++) { //Four steps
			for (int i = 0; i<source.length; i++)
				counters[(source[i] >> 8*(j-1)) & RADIX]++; //Find radix value - byte's AND - in this case let's increase
			for (int i= 1; i<counters.length; i++) counters[i] += counters[i-1];

			for (int i = source.length-1; i>=0; i--) {
				index = (source[i] >> 8*(j-1)) & RADIX;
				counters[index] -= 1;
				target[counters[index]] = source[i];
			}	
			for (int i= 1; i<counters.length; i++) counters[i] = 0;
                        int[] swap = source;
			source = target;
                        target = swap;
		}
		return source;
	}

}