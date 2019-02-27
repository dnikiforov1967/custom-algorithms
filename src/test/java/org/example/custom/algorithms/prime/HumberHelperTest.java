/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.prime;

import java.util.function.IntFunction;
import org.example.custom.algorithms.nums.NumbersHelper;
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
public class HumberHelperTest {

	public HumberHelperTest() {
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

	@Test
	public void gcdTest() {
		assertEquals(1, NumbersHelper.findGCD(13, 44));
		assertEquals(11, NumbersHelper.findGCD(11, 44));
		assertEquals(2, NumbersHelper.findGCD(6, 4));
		assertEquals(3, NumbersHelper.findGCD(15, 9));
	}
	
	@Test
	public void primeTest() {
		final int[] primes = new int[5];
		final int[] muster = new int[] {2,3,5,7,11};
		int k=0;
		for(int i : NumbersHelper.primeNumbers(12)) {
			primes[k++]=i;
		}
		assertArrayEquals(muster, primes);
	}
	
	
}
