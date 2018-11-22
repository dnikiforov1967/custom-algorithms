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
         * @return 
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
