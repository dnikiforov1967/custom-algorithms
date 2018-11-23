/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.dejkstra;

import java.math.BigDecimal;
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
public class GraphUnitTest {

	public GraphUnitTest() {
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
	public void testNodeExtraction() {
		Graph graph = new Graph((Double[][])null,
				new Graph.Node(BigDecimal.TEN, 0, BigDecimal.TEN, BigDecimal.TEN),
				new Graph.Node(BigDecimal.ONE, 1, BigDecimal.ONE, BigDecimal.ONE),
				new Graph.Node(BigDecimal.ONE, 2, BigDecimal.ONE, BigDecimal.ONE));

		Graph.Node node = graph.extractNextNode();
		assertEquals(1, node.getIndex());
		node = graph.extractNextNode();
		assertEquals(2, node.getIndex());
		node = graph.extractNextNode();
		assertEquals(0, node.getIndex());

	}

	@Test
	public void testNodeRebalance() {

		Graph.Node[] nodes = {
			new Graph.Node(BigDecimal.TEN, 0, BigDecimal.TEN, BigDecimal.TEN),
			new Graph.Node(BigDecimal.ONE, 1, BigDecimal.ONE, BigDecimal.ONE),
			new Graph.Node(BigDecimal.ZERO, 2, BigDecimal.ZERO, BigDecimal.ZERO),
			new Graph.Node(BigDecimal.ONE, 3, BigDecimal.ONE, BigDecimal.ONE)
		};

		Graph graph = new Graph((String[][])null,nodes);

		Graph.Node node = graph.extractNextNode();
		assertEquals(2, node.getIndex());
		graph.rebalanceVertex(nodes[1], new BigDecimal("5.0"));
		node = graph.extractNextNode();
		assertEquals(3, node.getIndex());
		node = graph.extractNextNode();
		assertEquals(1, node.getIndex());
		node = graph.extractNextNode();
		assertEquals(0, node.getIndex());
	}

}
