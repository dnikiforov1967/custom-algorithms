/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.sort.radix;

import java.util.Arrays;
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
public class RadixUnitTest {
	
	public RadixUnitTest() {
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
	public void testRadixSort() {
		int[] array = {10, 8, 11, 22, 1, 4, 7, 22, 16, 2, 12, 7, 5, 13, 6};
		int[] expectedArray = {1,2,4,5,6,7,7,8,10,11,12,13,16,22,22};
		final RadixSort radixSort = new RadixSort();
		array = radixSort.sort(array);
		assertArrayEquals(expectedArray, array);
	}
}
