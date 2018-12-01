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

import java.util.Arrays;

/**
 *
 * @author dnikiforov
 */
public abstract class ByteWrapper<T> implements ByteConvertable {
	
	protected final int fixedLength;
	private final byte[] byteArray;
	protected final T obj;
	
	public ByteWrapper(T obj, final int fixedLength) {
		this.fixedLength = fixedLength;
		this.obj = obj;
		final byte[] convert = convert();
		if (convert.length < fixedLength) {
			byteArray = Arrays.copyOf(convert, fixedLength);
		} else if (convert.length > fixedLength) {
			throw new ArrayIndexOutOfBoundsException("Byte conversion exceeds "+fixedLength);
		} else {
			byteArray = convert;
		}
	}

        /**
         * Method maps object to byte array
         * @return byte representation of object
         */
	abstract protected byte[] convert();
	
	@Override
	public byte[] toByteArray() {
		return byteArray;
	}

	@Override
	public int getFixedLength() {
		return fixedLength;
	}
	
	
	
}
