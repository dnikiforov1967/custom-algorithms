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
		Node nodeA = new Node(null, 1, BigDecimal.ONE, BigDecimal.ONE);
		Node nodeB = new Node(null, 1, BigDecimal.ONE, BigDecimal.ONE);
		
		nodeA.setVisited(false);
		nodeB.setVisited(true);
		int compareTo = nodeA.compareTo(nodeB);
		assertEquals(-1, compareTo);
		
		nodeA.setVisited(true);
		nodeB.setVisited(false);
		compareTo = nodeA.compareTo(nodeB);
		assertEquals(1, compareTo);

		nodeA.setVisited(true);
		nodeB.setVisited(true);		
		compareTo = nodeA.compareTo(nodeB);
		assertEquals(0, compareTo);
		
		nodeA.setVisited(false);
		nodeB.setVisited(false);		
		compareTo = nodeA.compareTo(nodeB);
		assertEquals(0, compareTo);
		
		nodeA.setValue(BigDecimal.ONE);
		nodeB.setValue(null);
		compareTo = nodeA.compareTo(nodeB);
		assertEquals(-1, compareTo);		

		nodeA.setValue(null);
		nodeB.setValue(BigDecimal.ONE);
		compareTo = nodeA.compareTo(nodeB);
		assertEquals(1, compareTo);		

		nodeA.setValue(BigDecimal.ONE);
		nodeB.setValue(BigDecimal.ONE);
		compareTo = nodeA.compareTo(nodeB);
		assertEquals(0, compareTo);		
		
	}
}
