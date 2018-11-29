/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct;

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
public class PutUnitTest extends BaseTest {
	
	public PutUnitTest() {
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
	public void putTest() {
		AvlTree<Integer, String> avlTree = new AvlTree<>();
		final AvlTree.Node nodeC = avlTree.put(3, "C");
		final AvlTree.Node nodeB = avlTree.put(2, "B");
		final AvlTree.Node nodeA = avlTree.put(1, "A");
		assertEquals(nodeB, nodeC.getLeft());
		assertEquals(nodeA, nodeB.getLeft());
	}
}
