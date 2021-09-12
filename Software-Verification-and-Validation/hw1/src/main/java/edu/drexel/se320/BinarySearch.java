package edu.drexel.se320;

import java.util.*;

public class BinarySearch {

	
    public static <T extends Comparable<T>> int find(T[] array, T elem) {
    	if(array.length <= 0) {
    		throw new IllegalArgumentException("Invalid input: array is empty");
    	}
    	else if(array.equals(null)) {
    		throw new NullPointerException("Invalid input: array is null");
    	}
    	else if(elem.equals(null)) {
    		throw new NullPointerException("Invalid input: element is null");
    	}
    	int lower_bound = 0;
        int upper_bound = array.length - 1;
        while (lower_bound <= upper_bound) {
            int interval = lower_bound + (upper_bound - lower_bound) / 2;
            if(elem.compareTo(array[interval]) < 0) {
            	upper_bound = interval - 1;
            }
            else if (elem.compareTo(array[interval]) > 0) {
            	lower_bound = interval + 1;
            }
            else {
            	return interval;
            }
        }
        throw new NoSuchElementException("Can't find the element in this array");
    }
}
