/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.sort.heap;

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
public class HeapSortUnitTest {
	
	public HeapSortUnitTest() {
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
	public void testIndex() {
		int i = HeapSort.initialIndex(10);
		assertEquals(4, i);
		i = HeapSort.initialIndex(11);
		assertEquals(5, i);
	}
	
    @Test
    public void testSwap() {
        Integer[] array = {1,2,4,3,5,6};
        Integer[] expectedArray = {1,2,3,4,5,6};
        HeapSort.swap(array, 2, 3);
        assertArrayEquals(expectedArray, array);
    }

    @Test
    public void testBuildHeapNlogN() {
        Integer[] array = {4,1,7,12,5,8,2,6};
        Integer[] expectedArray = {12,7,8,6,5,4,2,1};
		HeapSort.buildHeapNlogN(array);
        assertArrayEquals(expectedArray, array);
    }	

	
    @Test
    public void testSort() {
        Integer[] array = {4,1,7,12,5,8,2,6};
        Integer[] expectedArray = {1,2,4,5,6,7,8,12};
		HeapSort.sort(array);
		assertArrayEquals(expectedArray, array);
    }		

    @Test
    public void testSortWithDoubles() {
        Integer[] array = {4,1,5,7,12,5,8,2,7,6};
        Integer[] expectedArray = {1,2,4,5,5,6,7,7,8,12};
		HeapSort.sort(array);
		assertArrayEquals(expectedArray, array);
    }		
	
	
}
