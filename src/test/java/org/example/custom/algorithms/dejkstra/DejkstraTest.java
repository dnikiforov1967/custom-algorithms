/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.dejkstra;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author dnikiforov
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DejkstraTest {
	
	public DejkstraTest() {
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
	public void dejkstraCompletedTest() {
		
		Double[][] edges = {
			{null, 7.0, 9.0, null, null, 14.0},
			{7.0, null, 10.0, 15.0, null, null},
			{9.0, 10.0, null, 11.0, null, 2.0},
			{null, 15.0, 11.0, null, 6.0, null},
			{null, null, null, 6.0, null, 9.0},
			{14.0, null, 2.0, null, 9.0, null}
		};
		
		Node[] nodes = {
			new Node(0, 0.0, 0.0),
			new Node(1, 0.0, 0.0),
			new Node(2, 0.0, 0.0),
			new Node(3, 0.0, 0.0),
			new Node(4, 0.0, 0.0),
			new Node(5, 0.0, 0.0)
		};

		Node[] expectedNodes = {
			new Node(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("7.0"), 1, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("9.0"), 2, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("20.0"), 3, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("20.0"), 4, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("11.0"), 5, BigDecimal.ZERO, BigDecimal.ZERO)
		};
		
		final Graph graph = new Graph(edges, nodes);
		graph.weightNodes();
		final List<Node> returnResult = graph.returnResult();
		
		for(int i=0; i<returnResult.size(); i++) {
			assertEquals(0, expectedNodes[i].compareTo(returnResult.get(i)));
		}
	
	}
	
	@Test
	public void dejkstraUnreachableNodeTest() {
		
		String[][] edges = {
			{null, "7.0", "9.0", null, null, "14.0"},
			{"7.0", null, "10.0", "15.0", null, null},
			{"9.0", "10.0", null, "11.0", null, "2.0"},
			{null, "15.0", "11.0", null, null, null},
			{null, null, null, null, null, null},
			{"14.0", null, "2.0", null, null, null}
		};
		
		Node[] nodes = {
			new Node(0, "0.0", "0.0"),
			new Node(1, "0.0", "0.0"),
			new Node(2, "0.0", "0.0"),
			new Node(3, "0.0", "0.0"),
			new Node(4, "0.0", "0.0"),
			new Node(5, "0.0", "0.0")
		};

		Node[] expectedNodes = {
			new Node(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("7.0"), 1, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("9.0"), 2, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("20.0"), 3, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal(Double.MAX_VALUE), 4, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("11.0"), 5, BigDecimal.ZERO, BigDecimal.ZERO)
		};
		
		final Graph graph = new Graph(edges, nodes);
		graph.weightNodes();
		final List<Node> returnResult = graph.returnResult();
		
		for(int i=0; i<returnResult.size(); i++) {
			assertEquals(0, expectedNodes[i].compareTo(returnResult.get(i)));
		}
	
	}	
	
	@Test
	public void dejkstraStringConstructorTest() {
		
		String[][] edges = {
			{null, "7.0", "9.0", null, null, "14.0"},
			{"7.0", null, "10.0", "15.0", null, null},
			{"9.0", "10.0", null, "11.0", null, "2.0"},
			{null, "15.0", "11.0", null, null, null},
			{null, null, null, null, null, null},
			{"14.0", null, "2.0", null, null, null}
		};
		
		Node[] nodes = {
			new Node(0, "0.0", "0.0"),
			new Node(1, "0.0", "0.0"),
			new Node(2, "0.0", "0.0"),
			new Node(3, "0.0", "0.0"),
			new Node(4, "0.0", "0.0"),
			new Node(5, "0.0", "0.0")
		};

		Node[] expectedNodes = {
			new Node(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("7.0"), 1, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("9.0"), 2, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("20.0"), 3, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal(Double.MAX_VALUE), 4, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(new BigDecimal("11.0"), 5, BigDecimal.ZERO, BigDecimal.ZERO)
		};
		
		final Graph graph = new Graph(edges, nodes);
		graph.weightNodes();
		final List<Node> returnResult = graph.returnResult();
		
		for(int i=0; i<returnResult.size(); i++) {
			assertEquals(0, expectedNodes[i].compareTo(returnResult.get(i)));
		}		
	
	}
	
}
