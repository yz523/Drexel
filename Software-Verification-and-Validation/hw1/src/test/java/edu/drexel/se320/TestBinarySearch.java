package edu.drexel.se320;

import edu.drexel.se320.BinarySearch;
import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class TestBinarySearch {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
    @Test
    public void testbinarysearch_1() {
    	Integer[] array = new Integer[] {3};
    	int elem = new Integer(3);
    	int expected = 0;
    	int result = new Integer(0);
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
  
    @Test(expected = NoSuchElementException.class)
    public void testbinarysearch_2() {
    	Integer[] array = new Integer[] {3};
    	int elem = new Integer(2);
    	BinarySearch.find(array, elem);
    	thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Can't find the element in this array");
    }
	
    @Test
    public void testbinarysearch_3() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,55,77};
    	int elem = new Integer(1);
    	int expected = 0;
    	int result = new Integer(0);
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
    
    @Test
    public void testbinarysearch_4() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,55,77};
    	int elem = new Integer(77);
    	int expected = 7;
    	int result = new Integer(0);
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
    
    @Test
    public void testbinarysearch_5() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,55,77};
    	int elem = new Integer(10);
    	int expected = 4;
    	int result = new Integer(0);
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
    
    
    @Test(expected = NoSuchElementException.class)
    public void testbinarysearch_6() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,55,77};
    	int elem = new Integer(2);
    	BinarySearch.find(array, elem);
    	thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Can't find the element in this array");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testbinarysearch_7() {
    	Integer[] array = new Integer[] {};
    	int elem = new Integer(3);
    	BinarySearch.find(array, elem);
    	thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input: array is empty");
    }
    
    @Test(expected = NullPointerException.class)
    public void testbinarysearch_8() {
    	Integer[] array = null;
    	int elem = new Integer(3);
    	BinarySearch.find(array, elem);
    	thrown.expect(NullPointerException.class);
        thrown.expectMessage("Invalid input: array is null");
    }
    
    @Test(expected = NullPointerException.class)
    public void testbinarysearch_9() {
    	Integer[] array = new Integer[] {2,8,15,44,47,53,66,79};
    	Integer elem = null;
    	BinarySearch.find(array, elem);
    	thrown.expect(NullPointerException.class);
        thrown.expectMessage("Invalid input: element is null");
    }
    
    @Test
    public void testbinarysearch_10() {
    	Integer[] array = new Integer[] {2,5,8,9,10,13,17};
    	int elem = new Integer(2);
    	int expected = 0;
    	int result = new Integer(0);
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
    
    @Test
    public void testbinarysearch_11() {
    	Integer[] array = new Integer[] {2,5,8,9,10,13,17};
    	int elem = new Integer(9);
    	int expected = 3;
    	int result = new Integer(0);
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
    
    @Test
    public void testbinarysearch_12() {
    	Integer[] array = new Integer[] {2,5,8,9,10,13,17};
    	int elem = new Integer(17);
    	int expected = 6;
    	int result = new Integer(0);
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testbinarysearch_13() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,55,77};
    	int elem = new Integer(Integer.MAX_VALUE+1);
    	BinarySearch.find(array, elem);
    	thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Can't find the element in this array");
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testbinarysearch_14() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,55,77,Integer.MAX_VALUE+1};
    	int elem = new Integer(Integer.MAX_VALUE+1);
    	BinarySearch.find(array, elem);
    	thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Can't find the element in this array");
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testbinarysearch_15() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,55,77};
    	int elem = new Integer(Integer.MIN_VALUE-1);
    	BinarySearch.find(array, elem);
    	thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Can't find the element in this array");
    }
    
    @Test
    public void testbinarysearch_16() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,55,Integer.MIN_VALUE-1,77};
    	int elem = new Integer(Integer.MIN_VALUE-1);
    	int result = new Integer(0);	
    	int expected = 7;
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testbinarysearch_17() {
    	Integer[] array = new Integer[] {1,4,8,9,10,55,77};
    	int elem = new Integer(0);
    	BinarySearch.find(array, elem);
    	thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Can't find the element in this array");
    }
    
    @Test
    public void testbinarysearch_18() {
    	Integer[] array = new Integer[] {0,1,4,8,9,10,55,77};
    	int elem = new Integer(0);
    	int result = new Integer(0);	
    	int expected = 0;
    	result = BinarySearch.find(array, elem);
        assertEquals(result, expected);
    }
    
    @Test(expected = java.lang.Error.class)
    public void testbinarysearch_19() {
    	Float[] array = new Float[] {(float)0, (float)1,(float)4,(float)8,(float)9,(float)10,(float)55,(float)77};
    	Double elem = new Double(0);
    	BinarySearch.find(array, elem);
    	thrown.expect(java.lang.Error.class);
        thrown.expectMessage("Unresolved compilation problem:");
    }
    
    @Test(expected = java.lang.ArithmeticException.class)
    public void testbinarysearch_20() {
    	Integer[] array = new Integer[] {0,1,4,8,9,10,55,77};
    	int elem = new Integer(1/0);
    	System.out.println(elem);
    	BinarySearch.find(array, elem);
    	thrown.expect(java.lang.ArithmeticException.class);
        thrown.expectMessage("/ by zero");
    }
    
    @Test(expected = java.lang.ArithmeticException.class)
    public void testbinarysearch_21() {
    	Integer[] array = new Integer[] {0,1,4/0,8,9,10,55,77};
    	int elem = new Integer(1);
    	System.out.println(elem);
    	BinarySearch.find(array, elem);
    	thrown.expect(java.lang.ArithmeticException.class);
        thrown.expectMessage("/ by zero");
    }
}