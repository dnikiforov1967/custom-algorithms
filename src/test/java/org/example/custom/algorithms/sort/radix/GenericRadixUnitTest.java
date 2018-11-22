/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.sort.radix;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dnikiforov
 */
public class GenericRadixUnitTest {

	static class StringWrapper extends ByteWrapper<String> {

		public StringWrapper(String obj, int fixedLength) {
			super(obj, fixedLength);
		}

		@Override
		protected byte[] convert() {
			return obj.getBytes();
		}

		@Override
		public String toString() {
			return obj;
		}

	}

	public GenericRadixUnitTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	@Test
	public void hello() {
		StringWrapper[] array = {
			new StringWrapper("01", 2),
			new StringWrapper("02", 2),
			new StringWrapper("06", 2),
			new StringWrapper("10", 2),
			new StringWrapper("17", 2),
			new StringWrapper("11", 2),
			new StringWrapper("13", 2),
			new StringWrapper("05", 2),};

		GenericRadixSort<StringWrapper> grs = new GenericRadixSort<>();
		grs.sort(array, 2);
		
	}

	//@Test
	public void testByteCheck() {
		String s = "7163";
		final byte[] bytes = s.getBytes();
		assertEquals(4, bytes.length);
		for(byte b : bytes) {
			System.out.println(b&0xFF);
		};
	}

}
