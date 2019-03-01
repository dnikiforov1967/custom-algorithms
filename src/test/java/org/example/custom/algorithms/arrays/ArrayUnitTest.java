/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.arrays;

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
public class ArrayUnitTest {
	
	public ArrayUnitTest() {
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
	public void reverse() {
		final int[] direct = new int[] {5,9,2,2,5,7,1,1,34,89,55};
		final int[] reverse = new int[] {55,89,34,1,1,7,5,2,2,9,5};		
		ArrayHelper.reverese(direct, 0, direct.length-1);
		assertArrayEquals(reverse, direct);
	}
}
