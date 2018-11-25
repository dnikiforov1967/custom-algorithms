package org.example.custom.algorithms.sort.merge;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dima
 */
public class MergeSortUnitTest {
    
    public MergeSortUnitTest() {
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
    public void testSwap() {
        Integer[] array = {1,2,4,3,5,6};
        Integer[] expectedArray = {1,2,3,4,5,6};
        SortMerge.swap(array, 2, 3);
        assertArrayEquals(expectedArray, array);
    }
    
    @Test
    public void testSortEven() {
        Integer[] array = {1,4,6,2,5,3};
        Integer[] expectedArray = {1,2,3,4,5,6};
        SortMerge.sort(array);
        assertArrayEquals(expectedArray,array);
    }    
    
    @Test
    public void testSortOdd() {
        Integer[] array = {1,7,4,6,2,5,3};
        Integer[] expectedArray = {1,2,3,4,5,6,7};
        SortMerge.sort(array);
        assertArrayEquals(expectedArray,array);
    }        
 
    @Test
    public void testSortOddDoublets() {
        Integer[] array = {1,6,7,4,5,6,2,5,3};
        Integer[] expectedArray = {1,2,3,4,5,5,6,6,7};
        SortMerge.sort(array);
        assertArrayEquals(expectedArray,array);
    }    
    
    @Test
    public void testSortEvenDoublets() {
        Integer[] array = {1,6,7,4,5,6,2,5,3,1};
        Integer[] expectedArray = {1,1,2,3,4,5,5,6,6,7};
        SortMerge.sort(array);
        assertArrayEquals(expectedArray,array);
    }        
    
}
