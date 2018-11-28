package org.example.custom.algorithms.struct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class TurnsUnitTest {
	
	static class XNode extends AbstractNode<Integer, String> {
		
		public XNode(Integer key, String value) {
			super(key, value);
		}
		
	}

	final static AbstractTree<Integer, String> abstractTree = new AbstractTree<Integer, String>() {
			
	};

	
	public TurnsUnitTest() {
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
	public void smallLeftTurnTest() {
		XNode nodeA = new XNode(1,"A");
		XNode nodeB = new XNode(2,"B");
		XNode nodeC = new XNode(3,"C");
		XNode nodeD = new XNode(4,"D");
		XNode nodeE = new XNode(5,"E");
		
		nodeA.setRight(nodeB);
		nodeA.setLeft(nodeE);
		nodeB.setLeft(nodeC);
		nodeB.setRight(nodeD);
		
		final AbstractNode<Integer, String> newTop = abstractTree.smallLeftTurn(nodeA);
		assertEquals(nodeB,newTop);
		assertEquals(nodeA,nodeB.getLeft());
		assertEquals(nodeD,nodeB.getRight());
		assertEquals(nodeE,nodeA.getLeft());
		assertEquals(nodeC,nodeA.getRight());
		
	}

	@Test
	public void smallRightTurnTest() {
		XNode nodeA = new XNode(1,"A");
		XNode nodeB = new XNode(2,"B");
		XNode nodeC = new XNode(3,"C");
		XNode nodeD = new XNode(4,"D");
		XNode nodeE = new XNode(5,"E");
		
		nodeA.setLeft(nodeB);
		nodeA.setRight(nodeE);
		nodeB.setLeft(nodeC);
		nodeB.setRight(nodeD);
		
		final AbstractNode<Integer, String> newTop = abstractTree.smallRightTurn(nodeA);
		assertEquals(nodeB,newTop);
		assertEquals(nodeA,nodeB.getRight());
		assertEquals(nodeC,nodeB.getLeft());
		assertEquals(nodeD,nodeA.getLeft());
		assertEquals(nodeE,nodeA.getRight());
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void smallTurnNullTest() {
		XNode nodeA = new XNode(1,"A");
		XNode nodeB = null;
		XNode nodeE = new XNode(5,"E");
		
		nodeA.setLeft(nodeB);
		nodeA.setRight(nodeE);
		
		AbstractNode<Integer, String> newTop = abstractTree.smallRightTurn(nodeA);
		
	}	

	@Test(expected = IllegalStateException.class)
	public void smallTurnNullTest2() {
		XNode nodeA = new XNode(1,"A");
		XNode nodeB = null;
		XNode nodeE = new XNode(5,"E");
		
		nodeA.setLeft(nodeB);
		nodeA.setRight(nodeE);
		
		AbstractNode<Integer, String> newTop = abstractTree.smallRightTurn(nodeA);
	}

	@Test
	public void smallTurnNullTest3() {
		XNode nodeA = new XNode(1,"A");
		XNode nodeB = null;
		XNode nodeE = new XNode(5,"E");
		
		nodeA.setLeft(nodeB);
		nodeA.setRight(nodeE);
		
		AbstractNode<Integer, String> newTop = abstractTree.smallLeftTurn(nodeA);
		assertEquals(nodeE,newTop);

		nodeA = new XNode(1,"A");
		nodeB = null;
		nodeE = new XNode(5,"E");
		nodeA.setLeft(nodeE);
		nodeA.setRight(nodeB);

		newTop = abstractTree.smallRightTurn(nodeA);
		assertEquals(nodeE,newTop);
		
	}
	
	@Test
	public void testBigLeftTurn() {
		XNode nodeA = new XNode(1,"A");
		XNode nodeL = new XNode(2,"L");
		XNode nodeB = new XNode(3,"B");
		XNode nodeC = new XNode(4,"C");
		XNode nodeM = new XNode(5,"M");
		XNode nodeN = new XNode(6,"N");
		XNode nodeR = new XNode(7,"R");
		
		nodeA.setLeft(nodeL);
		nodeA.setRight(nodeB);
		
		nodeB.setLeft(nodeC);
		nodeB.setRight(nodeR);
		
		nodeC.setLeft(nodeM);
		nodeC.setRight(nodeN);

		AbstractNode<Integer, String> newRoot = abstractTree.bigLeftTurn(nodeA);
		assertEquals(nodeC, newRoot);
		assertEquals(nodeA, nodeC.getLeft());
		assertEquals(nodeB, nodeC.getRight());
		assertEquals(nodeL, nodeA.getLeft());
		assertEquals(nodeM, nodeA.getRight());
		assertEquals(nodeN, nodeB.getLeft());
		assertEquals(nodeR, nodeB.getRight());
		
	}
	
	@Test
	public void testBigRightTurn() {
		XNode nodeA = new XNode(1,"A");
		XNode nodeL = new XNode(2,"L");
		XNode nodeB = new XNode(3,"B");
		XNode nodeC = new XNode(4,"C");
		XNode nodeM = new XNode(5,"M");
		XNode nodeN = new XNode(6,"N");
		XNode nodeR = new XNode(7,"R");

		
		nodeA.setLeft(nodeB);
		nodeA.setRight(nodeR);
		
		nodeB.setLeft(nodeL);
		nodeB.setRight(nodeC);
		
		nodeC.setLeft(nodeM);
		nodeC.setRight(nodeN);
		
		AbstractNode<Integer, String> newRoot = abstractTree.bigRightTurn(nodeA);
		assertEquals(nodeC, newRoot);
		assertEquals(nodeB, nodeC.getLeft());
		assertEquals(nodeA, nodeC.getRight());
		assertEquals(nodeN, nodeA.getLeft());
		assertEquals(nodeR, nodeA.getRight());
		assertEquals(nodeL, nodeB.getLeft());
		assertEquals(nodeM, nodeB.getRight());
		
	}
	
	
	
}
