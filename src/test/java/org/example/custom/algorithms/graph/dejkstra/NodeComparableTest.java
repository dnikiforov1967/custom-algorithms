/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.graph.dejkstra;

import org.example.custom.algorithms.graph.dejkstra.Graph;
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
public class NodeComparableTest {

	public NodeComparableTest() {
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
	public void testComparable() {
		Graph.Node nodeA = new Graph.Node(1, 0, 0);
		Graph.Node nodeB = new Graph.Node(1, 0, 0);
		
		nodeA.setValue(BigDecimal.ONE);
		nodeB.setValue(new BigDecimal(Double.MAX_VALUE));
		int compareTo = nodeA.compareTo(nodeB);
		assertEquals(-1, compareTo);		

		nodeA.setValue(new BigDecimal(Double.MAX_VALUE));
		nodeB.setValue(BigDecimal.ONE);
		compareTo = nodeA.compareTo(nodeB);
		assertEquals(1, compareTo);		

		nodeA.setValue(BigDecimal.ONE);
		nodeB.setValue(BigDecimal.ONE);
		compareTo = nodeA.compareTo(nodeB);
		assertEquals(0, compareTo);		
		
	}

}
