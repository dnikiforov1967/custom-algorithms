/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.nums;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author dnikiforov
 */
public final class NumbersHelper {

	private NumbersHelper() {

	}

	public static Queue<Integer> fibonacci(int n) {
		Queue<Integer> queue = new LinkedList<>();
		int digA=0, digB=1;
		while(digB<=n) {
			queue.add(digB);
			int s = digB;
			digB = digA + digB;
			digA = s;
		}
		return queue;
	}
	
	/**
	 * Method returns the queue of prime numbers <= n
	 * @param n
	 * @return 
	 */
	public static Queue<Integer> primeNumbers(int n) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> out = new LinkedList<>();
		for (int i = 2; i <= n; i++) {
			queue.add(i);
		}

		int factor=2;
		while (!queue.isEmpty()) {
			final Iterator<Integer> it = queue.iterator();
			while (it.hasNext()) {
				int val = it.next();
				if (val != factor && val % factor == 0) {
					it.remove();
				}
			}
			if (!queue.isEmpty()) {
				final Integer poll = queue.poll();
				out.add(poll);
				if(!queue.isEmpty()) {
					factor=queue.peek();
				}	
			}
		}
		return out;
	}

	/**
	 * Method to find greatest common divider
	 *
	 * @param a
	 * @param b
	 * @return greatest common divider
	 */
	public static int findGCD(int a, int b) {
		int max = (a > b ? a : b);
		int min = (a > b ? b : a);
		int rest = max % min;
		while (rest > 0) {
			max = min;
			min = rest;
			rest = max % min;
		}
		return min;
	}

}
