package junitlab;

import static org.junit.Assert.*;
import org.junit.*;

public class TestCode {
	
	@Test
	public void testInOrder()
	{
	     Integer [] TestArray = new Integer[] {1,2,3,4,5};
	     Integer [] CorrectArray = new Integer[] {1,3,2,4,5};
	     MergeSort.mergeSort(TestArray);
	     assertTrue(!CompareArrays(TestArray, CorrectArray));
	 }
	@Test
	public void testNotInOrder()
	{     
	Integer [] TestArray = new Integer[] {1,3,2,4};
    Integer [] CorrectArray = new Integer[] {1,2,3,4};
    MergeSort.mergeSort(TestArray);
    assertTrue(CompareArrays(TestArray, CorrectArray));

	}
	@Test
	public void Testlength(){
		Integer [] TestArray = new Integer[] {1,2,3,4,5};
		MergeSort.mergeSort(TestArray);
		assertTrue(Testsize(TestArray.length,5));
		
		
		Integer [] TestArray2 = new Integer[] {2,3,4,5};
		MergeSort.mergeSort(TestArray2);
		assertTrue(Testsize(TestArray2.length,4));
		
		Integer [] TestArray3 = new Integer[] {3,4,5};
		MergeSort.mergeSort(TestArray3);
		assertTrue(Testsize(TestArray3.length,3));
	}
	
	private boolean Testsize(int i, int j){
		if (i==j){
			return true;
		}
			return false;
	}
	
	private boolean CompareArrays(Integer[] TestArray, Integer[] CorrectArray) {
		for(int i=0; i< TestArray.length; i++){
			if(TestArray[i] != CorrectArray[i])
				return false;
		}
		return true;
	}
}