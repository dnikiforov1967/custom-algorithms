/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.graph.hamilton;

import java.util.List;
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
public class HamiltonTest {
	
	public HamiltonTest() {
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

	@Test(expected = IllegalArgumentException.class)
	public void noSquareMatrixTest() {
		Integer[][] matrix = {
			{1,1,1},
			{2,6,null}
		};
		HamiltonSearch.stupidSearch(matrix);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void differentSubArrayLengthMatrixTest() {
		Integer[][] matrix = {
			{1,1},
			{2}
		};
		HamiltonSearch.stupidSearch(matrix);
	}	
	
	@Test
	public void triangularMatrixTest() {
		Integer[][] matrix = {
			{null,1,1},
			{1,null,1},
			{1,1,null},
		};
		final List<List<Integer>> search = HamiltonSearch.stupidSearch(matrix);
	}	
	
	@Test
	public void classicHamiltonMatrixTest() {
		Integer[][] matrix = {
			{null,2   ,null,null,5   ,6   ,null,null,null,null,null,null,null,null,null,null,null,null,null,null}, //1
			{1   ,null,3   ,null,null,null,7   ,null,null,null,null,null,null,null,null,null,null,null,null,null}, //2
			{null,2   ,null,4   ,null,null,null,8   ,null,null,null,null,null,null,null,null,null,null,null,null}, //3
			{null,null,3   ,null,5   ,null,null,null,9   ,null,null,null,null,null,null,null,null,null,null,null}, //4
			{1   ,null,null,4   ,null,null,null,null,null,10  ,null,null,null,null,null,null,null,null,null,null}, //5
			{1   ,null,null,null,null,null,null,null,null,null,11  ,12  ,null,null,null,null,null,null,null,null}, //6
			{null,2   ,null,null,null,null,null,null,null,null,null,12  ,13  ,null,null,null,null,null,null,null}, //7
			{null,null,3   ,null,null,null,null,null,null,null,null,null,13  ,14  ,null,null,null,null,null,null}, //8
			{null,null,null,4   ,null,null,null,null,null,null,null,null,null,14  ,15  ,null,null,null,null,null}, //9
			{null,null,null,null,5   ,null,null,null,null,null,11  ,null,null,null,15  ,null,null,null,null,null}, //10
			{null,null,null,null,null,6   ,null,null,null,10  ,null,null,null,null,null,16  ,null,null,null,null}, //11
			{null,null,null,null,null,6   ,7   ,null,null,null,null,null,null,null,null,null,17  ,null,null,null}, //12
			{null,null,null,null,null,null,7   ,8   ,null,null,null,null,null,null,null,null,null,18  ,null,null}, //13
			{null,null,null,null,null,null,null,8   ,9   ,null,null,null,null,null,null,null,null,null,19  ,null}, //14
			{null,null,null,null,null,null,null,null,9   ,10  ,null,null,null,null,null,null,null,null,null,20  }, //15
			{null,null,null,null,null,null,null,null,null,null,11  ,null,null,null,null,null,17  ,null,null,20  }, //16
			{null,null,null,null,null,null,null,null,null,null,null,12  ,null,null,null,16  ,null,18  ,null,null}, //17
			{null,null,null,null,null,null,null,null,null,null,null,null,13  ,null,null,null,17  ,null,19  ,null}, //18
			{null,null,null,null,null,null,null,null,null,null,null,null,null,14  ,null,null,null,18  ,null,20  }, //19
			{null,null,null,null,null,null,null,null,null,null,null,null,null,null,15  ,16  ,null,null,19  ,null}, //20
		};		
		final List<List<Integer>> search = HamiltonSearch.stupidSearch(matrix);
		System.out.println(search.get(0));
	}	
	
	@Test
	public void noHamiltonTest() {
		Integer[][] matrix = {
			{null,1   ,1   ,1   },
			{1   ,null,1   ,null},
			{1   ,   1,null,null},
			{1   ,null,null,null},
		};
		final List<List<Integer>> search = HamiltonSearch.stupidSearch(matrix);
		assertEquals(0,search.size());
	}		
	
	
}
