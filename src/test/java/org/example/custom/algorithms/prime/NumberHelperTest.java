/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.prime;

import java.util.Arrays;
import org.example.custom.algorithms.nums.NumbersHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
		
        //The first card should be always minimal
        int[] reorder = new int[deck.length];
        Arrays.sort(deck); //sort in increase
        for(int i=0; i<deck.length; i++) {
			int start=0;
			for(int j=start; j<deck.length; j += 2)
				reorder[j] = deck[i];
		}
		return reorder;
    }
}

/**
 *
 * @author dnikiforov
 */
public class NumberHelperTest {

	public NumberHelperTest() {
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

	@Test
	public void fibonacciTest() {
		final int[] primes = new int[11];
		final int[] muster = new int[] {1,1,2,3,5,8,13,21,34,55,89};
		int k=0;
		for(int i : NumbersHelper.fibonacci(100)) {
			primes[k++]=i;
		}
		assertArrayEquals(muster, primes);
	}	
	
}
