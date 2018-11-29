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
public class BalanceUnitTest extends BaseTest {
	
	
	public BalanceUnitTest() {
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
	public void balanceOfListTest() {
		AvlTree<Integer, String> avlTree = new AvlTree<>();
		final AvlTree.Node nodeA = avlTree.new Node(1,"A");
		final AvlTree.Node nodeB = avlTree.new Node(2,"B");
		final AvlTree.Node nodeC = avlTree.new Node(3,"C");
		nodeB.setRight(nodeC);
		avlTree.fixheight(nodeB);
		assertEquals(2,nodeB.getDeep());
		nodeA.setRight(nodeB);
		avlTree.fixheight(nodeA);
		assertEquals(3,nodeA.getDeep());
		final AvlTree.Node balanced = avlTree.balance(nodeA);
		assertEquals(nodeB, balanced);
		assertEquals(nodeA, balanced.getLeft());
		assertEquals(nodeC, balanced.getRight());
	}
}
