/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct.avl;

import org.example.custom.algorithms.struct.AbstractNode;
import org.example.custom.algorithms.struct.BaseTest;
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
	//@Test
	public void putTestLeft() {
		AvlTree<Integer, String> avlTree = new AvlTree<>();
		final AbstractNode<Integer, String> nodeC = avlTree.put(3, "C");
		final AbstractNode<Integer, String> nodeA = avlTree.put(1, "A");		
		final AbstractNode<Integer, String> nodeB = avlTree.put(2, "B");
		assertEquals(nodeA, nodeB.getLeft());
		assertEquals(nodeC, nodeB.getRight());
	}
	
	//@Test
	public void putTestRight() {
		AvlTree<Integer, String> avlTree = new AvlTree<>();
		final AbstractNode<Integer, String> nodeA = avlTree.put(1, "A");
		final AbstractNode<Integer, String> nodeC = avlTree.put(3, "C");
		final AbstractNode<Integer, String> nodeB = avlTree.put(2, "B");
		assertEquals(nodeA, nodeB.getLeft());
		assertEquals(nodeC, nodeB.getRight());
	}	

	@Test
	public void putTestMix() {
		AvlTree<Integer, String> avlTree = new AvlTree<>();
		avlTree.put(6, "F");
		avlTree.put(1, "A");
		avlTree.put(3, "C");
		avlTree.put(4, "D");
		avlTree.put(4, "DD");
		avlTree.put(2, "B");
		AbstractNode<Integer, String> get = avlTree.get(4);
		assertEquals("DD",get.getValue());
		AbstractNode<Integer, String> nodeC = avlTree.get(3);
		AbstractNode<Integer, String> nodeB = avlTree.get(2);
		assertEquals(nodeB,nodeC.getLeft());
	}	
	
}
