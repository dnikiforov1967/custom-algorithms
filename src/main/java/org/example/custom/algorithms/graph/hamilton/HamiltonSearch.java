/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.graph.hamilton;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author dnikiforov
 */
public final class HamiltonSearch {
	
	private HamiltonSearch() {
		
	}

	public static List<List<Integer>> stupidSearch(Integer[][] matrix) {
		List<List<Integer>> hamiltonCycles = new ArrayList<>();
		//First of all the array should be checked for the size correction
		final int sizeY = matrix.length;
		for (int i = 0; i < sizeY; i++) {
			if (matrix[i].length != sizeY) {
				throw new IllegalArgumentException("Graph matrix should be equal-dimentional !");
			}
		}
		//Because Hamilton's graph means what all vertexes should be visited, no matter where we start
		//Choose 0th vertex as start is always OK
		//Graph can have many Hamilton's ways

		//Technically: we need to build chain
		Deque<Integer> stack = new LinkedList<>();
		boolean[] visited = new boolean[sizeY];
		//Initially all vertexes are available
		for (int i = 0; i < sizeY; i++) {
			visited[i] = false;
		}
		int visitedCount = 0;
		revision(0, visited, stack, matrix, sizeY, hamiltonCycles);
		return hamiltonCycles;
	}

	/**
	 *
	 * @param checked the index of checked vertex
	 * @param visited tracking of visited nodes
	 * @param matrix quadrat matrix of ribs
	 * @param N matrix size
	 */
	private static void revision(int check, boolean visited[], Deque<Integer> stack, Integer[][] matrix, final int N, List<List<Integer>> hamiltonCycles) {
		visited[check] = true;
		stack.push(check);
		if (stack.size() == N) {
			if (matrix[check][0] != null) {
				List<Integer> list = new ArrayList<>();
				list.addAll(stack);
				Collections.reverse(list);
				hamiltonCycles.add(list);

			}
		} else {
			for (int i = 1; i < N; i++) {
				if (check == i) {
					continue; //ignore itself
				}
				if (matrix[check][i] == null) {
					continue; //deadway
				}
				if (visited[i] == true) {
					continue; //no visit twice
				}
				revision(i, visited, stack, matrix, N, hamiltonCycles); //Next vertex
			}
		}
		visited[check] = false; //After chains build we should restore the state - it shall be used sharedly
		stack.pop();
	}

}
