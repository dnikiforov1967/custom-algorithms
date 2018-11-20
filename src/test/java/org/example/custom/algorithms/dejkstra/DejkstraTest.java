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
	public void dejkstraCompareAndFind() {		
	
		BigDecimal[][] edges = {
			{null, new BigDecimal("7.0"), new BigDecimal("9.0"), null, null, new BigDecimal("14.0")},
			{new BigDecimal("7.0"), null, new BigDecimal("10.0"), new BigDecimal("15.0"), null, null},
			{new BigDecimal("9.0"), new BigDecimal("10.0"), null, new BigDecimal("11.0"), null, new BigDecimal("2.0")},
			{null, new BigDecimal("15.0"), new BigDecimal("11.0"), null, new BigDecimal("6.0"), null},
			{null, null, null, new BigDecimal("6.0"), null, new BigDecimal("9.0")},
			{new BigDecimal("14.0"), null, new BigDecimal("2.0"), null, new BigDecimal("9.0"), null}
		};
		
		Node[] nodes = {
			new Node(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 1, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 2, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 3, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 4, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 5, BigDecimal.ZERO, BigDecimal.ZERO)
		};
		
		final Graph graph = new Graph(edges, nodes);
		
		Node next = graph.findNextNodeAndModifyList();
		assertEquals(next, nodes[0]);
		
		nodes[0].setVisited(true);
		nodes[1].setValue(new BigDecimal("7.0"));
		nodes[2].setValue(new BigDecimal("9.0"));
		nodes[5].setValue(new BigDecimal("14.0"));
		
		next = graph.findNextNodeAndModifyList();
		assertEquals(next, nodes[1]);
		
		nodes[1].setVisited(true);		
		nodes[3].setValue(new BigDecimal("22.0"));
		
		next = graph.findNextNodeAndModifyList();
		assertEquals(next, nodes[2]);

		nodes[2].setVisited(true);		
		nodes[3].setValue(new BigDecimal("20.0"));
		nodes[5].setValue(new BigDecimal("11.0"));

		next = graph.findNextNodeAndModifyList();
		assertEquals(next, nodes[5]);
		
		nodes[5].setVisited(true);
		nodes[4].setValue(new BigDecimal("20.0"));

		next = graph.findNextNodeAndModifyList();
		assertEquals(next, nodes[3]);
		
		nodes[3].setVisited(true);
		next = graph.findNextNodeAndModifyList();
		assertEquals(next, nodes[4]);

		nodes[4].setVisited(true);
		next = graph.findNextNodeAndModifyList();
		assertNull(next);
		
	}	
	

	@Test
	public void dejkstraCompletedTest() {
		
		BigDecimal[][] edges = {
			{null, new BigDecimal("7.0"), new BigDecimal("9.0"), null, null, new BigDecimal("14.0")},
			{new BigDecimal("7.0"), null, new BigDecimal("10.0"), new BigDecimal("15.0"), null, null},
			{new BigDecimal("9.0"), new BigDecimal("10.0"), null, new BigDecimal("11.0"), null, new BigDecimal("2.0")},
			{null, new BigDecimal("15.0"), new BigDecimal("11.0"), null, new BigDecimal("6.0"), null},
			{null, null, null, new BigDecimal("6.0"), null, new BigDecimal("9.0")},
			{new BigDecimal("14.0"), null, new BigDecimal("2.0"), null, new BigDecimal("9.0"), null}
		};
		
		Node[] nodes = {
			new Node(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 1, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 2, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 3, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 4, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 5, BigDecimal.ZERO, BigDecimal.ZERO)
		};

		Node[] expectedNodes = {
			new Node(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("7.0"), 1, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("9.0"), 2, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("20.0"), 3, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("20.0"), 4, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("11.0"), 5, BigDecimal.ZERO, BigDecimal.ZERO, true)
		};
		
		final Graph graph = new Graph(edges, nodes);
		graph.weightNodes();
		final List<Node> returnResult = graph.returnResult();
		returnResult.forEach(t->System.out.println(t));
		
		for(int i=0; i<returnResult.size(); i++) {
			assertEquals(0, expectedNodes[i].compareTo(returnResult.get(i)));
		}
	
	}
	
	@Test
	public void dejkstraUnreachableNodeTest() {
		
		BigDecimal[][] edges = {
			{null, new BigDecimal("7.0"), new BigDecimal("9.0"), null, null, new BigDecimal("14.0")},
			{new BigDecimal("7.0"), null, new BigDecimal("10.0"), new BigDecimal("15.0"), null, null},
			{new BigDecimal("9.0"), new BigDecimal("10.0"), null, new BigDecimal("11.0"), null, new BigDecimal("2.0")},
			{null, new BigDecimal("15.0"), new BigDecimal("11.0"), null, null, null},
			{null, null, null, null, null, null},
			{new BigDecimal("14.0"), null, new BigDecimal("2.0"), null, null, null}
		};
		
		Node[] nodes = {
			new Node(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 1, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 2, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 3, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 4, BigDecimal.ZERO, BigDecimal.ZERO),
			new Node(null, 5, BigDecimal.ZERO, BigDecimal.ZERO)
		};

		Node[] expectedNodes = {
			new Node(BigDecimal.ZERO, 0, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("7.0"), 1, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("9.0"), 2, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("20.0"), 3, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(null, 4, BigDecimal.ZERO, BigDecimal.ZERO, true),
			new Node(new BigDecimal("11.0"), 5, BigDecimal.ZERO, BigDecimal.ZERO, true)
		};
		
		final Graph graph = new Graph(edges, nodes);
		graph.weightNodes();
		final List<Node> returnResult = graph.returnResult();
		returnResult.forEach(t->System.out.println(t));
		
		for(int i=0; i<returnResult.size(); i++) {
			assertEquals(0, expectedNodes[i].compareTo(returnResult.get(i)));
		}
	
	}	
	
	
	
}
