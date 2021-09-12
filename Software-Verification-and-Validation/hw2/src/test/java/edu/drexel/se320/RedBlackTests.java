package edu.drexel.se320;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.rules.ExpectedException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import org.junit.Rule;
import org.junit.Test;

public class RedBlackTests {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPutNullKey() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("first argument to put() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(null, "Hello");
    }
    
    @Test
    public void testPutNullVal() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,null);
        assertEquals(tree.contains(1), false);
    }

    @Test
    public void testPut() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        tree.put(2,"Hello2");
        tree.put(3,"Hello3");
        tree.put(4,"Hello4");
        assertEquals(tree.get(1), "Hello1");
        assertEquals(tree.get(2), "Hello2");
        assertEquals(tree.get(3), "Hello3");
        assertEquals(tree.get(4), "Hello4");
    }
    
    @Test
    public void testPutSameNodeh() {
    	RedBlackBST<Integer,String> tree = new RedBlackBST<>();
    	tree.put(1, "Hello1");
    	tree.put(1, "Hello2");
    	assertEquals(tree.get(1), "Hello2");
    }
    
    @Test
    public void testGetNullKey() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("argument to get() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.get(null);
    }

    @Test
    public void testNullRoot() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();      
        assertEquals(tree.isEmpty(), true);
    }
    
    @Test
    public void testGetNullNode() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1, null);
        assertEquals(tree.get(1), null);
    }
    
    @Test
    public void testGet() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        tree.put(3,"Hello3");
        tree.put(2,"Hello2");
        tree.put(4,"Hello4");
        assertEquals(tree.get(3),"Hello3");
    }
    
    @Test
    public void testContainsNoKey() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        assertEquals(tree.contains(1), false);
    }
    
    @Test
    public void testContainslKey() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1, "Hello");  
        assertEquals(tree.contains(1), true);
    }
    
    @Test
    public void testDeleteMin1() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(2,"Hello2");
        tree.put(1,"Hello1");
        tree.put(3,"Hello3");
        tree.deleteMin();
        assertEquals(tree.contains(1),false);
    }
    
    @Test
    public void testDeleteMin2() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(4,"Hello4");
        tree.put(3,"Hello3");
        tree.put(2,"Hello2");
        tree.put(1,"Hello1");
        tree.deleteMin();
        assertEquals(tree.contains(1),false);
    }

    @Test
    public void testEmptyDeleteMin() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("BST underflow");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.deleteMin();
    }
    
    @Test
    public void test1DeleteMin() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        tree.deleteMin();
        assertEquals(tree.contains(1),false);
    }
    
    @Test
    public void testEmptyDeleteMax() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("BST underflow");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.deleteMax();
    }
    
    @Test
    public void testDeleteMax() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(3,"Hello3");
        tree.put(1,"Hello1");
        tree.put(4,"Hello4");
        tree.deleteMax();
        assertEquals(tree.contains(4),false);
    }
    
    @Test
    public void test1DeleteMax() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        tree.deleteMax();
        assertEquals(tree.contains(1),false);
    }
  
    
    @Test
    public void testDeleteMax1() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        tree.put(2,"Hello2");
        tree.put(3,"Hello3");
        tree.put(4,"Hello4");
        tree.deleteMax();
        assertEquals(tree.contains(4),false);
    }
    
    @Test
    public void testDelete() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        tree.delete(1);
        assertEquals(tree.contains(1),false);
    }
    
    @Test
    public void testDelete2() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(4,"Hello3");
        tree.put(3,"Hello2");
        tree.put(2,"Hello1");
        tree.put(1,"Hello1");
        tree.delete(2);
        tree.delete(1);
        assertEquals(tree.contains(1),false);
    }
    
    @Test
    public void testDelete3() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(4,"Hello3");
        tree.put(2,"Hello2");
        tree.put(1,"Hello1");
        tree.put(3,"Hello1");
        tree.delete(4);
        tree.delete(2);
        tree.delete(1);
        assertEquals(tree.contains(4),false);
        assertEquals(tree.contains(2),false);
        assertEquals(tree.contains(1),false);
    }
    
    @Test
    public void testDeleteNullKey() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("argument to delete() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.delete(null);
    }
    
    @Test
    public void testDeleteNullVal() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.delete(1);
        assertEquals(tree.get(1),null);
    }
    
    @Test
    public void testMoveRedLeft() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(10,"Hello2");
        tree.put(1,"Hello1");
        tree.put(2,"Hello3");
        tree.put(3,"Hello3");
        tree.delete(1);
        assertEquals(tree.get(1),null);
    }
    
    @Test
    public void testMoveRedRight() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(10,"Hello10");
        tree.put(3,"Hello3");
        tree.put(2,"Hello2");
        tree.put(1,"Hello1");
        tree.delete(3);
        assertEquals(tree.get(3),null);
    }
   
    @Test
    public void testmin() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("called min() with empty symbol table");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.min();
    }
    
    @Test
    public void testmax() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("called max() with empty symbol table");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.max();
    }
    
    @Test
    public void testfloorNullKey() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("argument to floor() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.floor(null);
    }
    
    @Test
    public void testfloorEmptyKey() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("called floor() with empty symbol table");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.floor(1);
    }
    
    @Test
    public void testnullfloor() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(3,"Hello3");
        assertEquals(tree.floor(2),null);
    }
    
    @Test
    public void testfloor() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        int n = tree.floor(2);
        assertEquals(n,1);
    }
    
    @Test
    public void testsamefloor() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        int n = tree.floor(1);
        assertEquals(n,1);
    }
    
    @Test
    public void testrightfloor() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(2,"Hello3");
        tree.put(1,"Hello1");
        tree.put(3,"Hello2");
        int n = tree.floor(3);
        assertEquals(n,3);
    }
    
    @Test
    public void testceilingNullKey() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("argument to ceiling() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.ceiling(null);
    }
    
    @Test
    public void testceilingEmptyKey() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("called ceiling() with empty symbol table");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.ceiling(1);
    }
    
    @Test
    public void testCeiling() {
    	 RedBlackBST<Integer,String> tree = new RedBlackBST<>();
         tree.put(1,"Hello1");
         int n = tree.ceiling(1);
         assertEquals(n,1);
    }
    
    @Test
    public void testNullCeiling() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(3,"Hello3");
        assertEquals(tree.ceiling(4),null);
    }

    @Test
    public void testLeftCeiling() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(2,"Hello3");
        tree.put(1,"Hello1");
        tree.put(3,"Hello2");
        int n = tree.ceiling(1);
        assertEquals(n,1);
    }
    
    @Test
    public void testSameCeiling() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        int n = tree.ceiling(0);
        assertEquals(n,1);
    }
    
    @Test
    public void testRankNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("argument to rank() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.rank(null);
    }
    
    @Test
    public void testRankEmpty() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        assertEquals(tree.rank(1),0);
    }
    
    @Test
    public void testKeyNullLow() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("first argument to keys() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.keys(null,1);
    }
    
    @Test
    public void testKeyNullHigh() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("second argument to keys() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.keys(1,null);
    }
    
    @Test
    public void testKeys() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(2,"Hello3");
        tree.put(1,"Hello1");
        tree.put(3,"Hello2");
        LinkedList<Integer> L = new LinkedList<Integer>();
        L.add(1);
        L.add(2);
        L.add(3);
        assertEquals(tree.keys(1,3), L);
    }
    
    @Test
    public void testKeys2() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        LinkedList<Integer> L = new LinkedList<Integer>();
        assertEquals(tree.keys(2,3), L);
    }
    
    @Test
    public void testKeys3() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(3,"Hello1");
        LinkedList<Integer> L = new LinkedList<Integer>();
        assertEquals(tree.keys(1,2), L);
    }
    
    @Test
    public void testNullSizeLow() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("first argument to size() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.size(null,1);
    }
    
    @Test
    public void testNullSizeHigh() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("second argument to size() is null");
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.size(1,null);
    }
    
    @Test
    public void testSize() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        tree.put(1,"Hello1");
        tree.put(2,"Hello1");
        int n = tree.size(1,2);
        assertEquals(n, 2);
    }
    
    @Test
    public void test0Size() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        int n = tree.size(1,2);
        assertEquals(n, 0);
    }
    
    @Test
    public void testNegativeSize() {
        RedBlackBST<Integer,String> tree = new RedBlackBST<>();
        int n = tree.size(2,1);
        assertEquals(n, 0);
    }
}
