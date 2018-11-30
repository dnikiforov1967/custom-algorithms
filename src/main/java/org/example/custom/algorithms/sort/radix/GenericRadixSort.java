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
public final class GenericRadixSort<T extends ByteWrapper> {

    private final int[] counters = new int[127]; //0..127 by byte value

    public T[] sort(T[] array, int byteCount) {

        Object[] storage = new Object[array.length];
        Object[] source = array, target = storage;
        int index = 0;
        for (int j = 1; j <= byteCount; j++) {

            final int jIndex = byteCount - j;
            for (int i = 0; i < source.length; i++) {
                final T obj = (T) source[i];
                final byte position = obj.toByteArray()[jIndex];
                counters[position]++;
            }
            
            for (int i = 1; i < counters.length; i++) {
                counters[i] += counters[i - 1];
            }

            for (int i = source.length - 1; i >= 0; i--) {
                final T obj = (T) source[i];
                final byte[] toByteArray = obj.toByteArray();
                final byte position = toByteArray[jIndex];
                int p = counters[position] -= 1;
                target[p] = obj;
            }

            for (int i = 1; i < counters.length; i++) {
                counters[i] = 0;
            }
            
            Object[] swap = source;
            source = target;
            target = swap;
        }
        return (T[])source;
    }

}
