/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct.avl;

import org.example.custom.algorithms.struct.AbstractNode;
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
public class NodeEquivalenceUnitTest {
	
	public NodeEquivalenceUnitTest() {
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
	public void equalsTest() {
		AbstractNode<Integer, String> nodeA = new AbstractNode<Integer, String>(3,"A") {
			
		};
		AbstractNode<Integer, String> nodeB = new AbstractNode<Integer, String>(3,"C") {
			
		};		
		assertEquals(nodeA, nodeB);
	}
	@Test
	public void noEqualsTest() {
		AbstractNode<Integer, String> nodeA = new AbstractNode<Integer, String>(3,"A") {
			
		};
		AbstractNode<Integer, String> nodeB = new AbstractNode<Integer, String>(4,"A") {
			
		};		
		assertNotEquals(nodeA, nodeB);
	}	
	
}
