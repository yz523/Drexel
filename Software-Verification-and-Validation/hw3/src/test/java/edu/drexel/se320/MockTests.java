package edu.drexel.se320;

import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import org.mockito.InOrder;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.List;
import java.io.IOException;

public class MockTests {

    public MockTests() {}

    /**
     * Demonstrate a working mock from the Mockito documentation.
     * http://static.javadoc.io/org.mockito/mockito-core/2.11.0/org/mockito/Mockito.html#verification
     */
    @Test
    public void testMockDemo() {
         List mockedList = mock(List.class);

         mockedList.add("one");
         mockedList.clear();

         verify(mockedList).add("one");
         verify(mockedList).clear();
    }

    @Test
    public void testServerConnectionFailureGivesNull() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
        Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(false);
   
        // If you pass the mock above appropriately after refactoring, this test
        // should pass.  Until then, it will fail.
        assertNull(c.requestFile("DUMMY", "DUMMY"));
    }
    
    //Test that if the attempt to connectTo(...) the server fails
    //the client code calls no further methods on the connection.
    @Test
    public void test1() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
        Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(false);
        c.requestFile("DUMMY", "DUMMY");
        
        verify(sc,never()).requestFileContents(anyString());
        verify(sc,never()).read();
        verify(sc,never()).moreBytes();
        verify(sc,never()).closeConnection();
    }
    
    //if the connection succeeds and the file name is invalid
    //the client code should actually call closeConnection
    //but should not call any other methods after the filename is revealed to be invalid.
    @Test
    public void test2() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
        Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(false);
        c.requestFile("DUMMY", "DUMMY");

        verify(sc,never()).read();
        verify(sc,never()).moreBytes();
        verify(sc).closeConnection();;
    }
    
    //Test that if the connection succeeds and the file is valid and non-empty
    //that the connection asks for at least some part of the file.
    @Test
    public void test3() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
        Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);
        c.requestFile("DUMMY", "DUMMY");

        verify(sc).moreBytes();
    }
    
    //Test that if the connection succeeds and the file is valid but empty
    //the client returns an empty string.
    @Test
    public void test4() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
        Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);

        assertEquals(c.requestFile("DUMMY", "DUMMY"),"");
    }
    
    //Test that if the client successfully reads part of a file
    //and then an IOException occurs before the file is fully read (i.e., moreBytes() has not returned false)
    //the client still returns null to indicate an error, rather than returning a partial result.
    @Test
    public void test5() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
        Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);
        when(sc.moreBytes()).thenThrow(new IOException());
        
        assertNull(c.requestFile("DUMMY", "DUMMY"));
    }
    
    //Test that if the initial server connection succeeds
    //then if a IOException occurs while retrieving the file (requesting, or reading bytes, either one) the client still explicitly closes the server connection.
    @Test
    public void test6() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
        Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenThrow(new IOException());
        c.requestFile("DUMMY", "DUMMY");
        
        verify(sc).closeConnection();
    }
    
    //Test that the client simply returns unmodified the contents if it reads a file from the server starting with "reset"
    // i.e., it doesn't interpret such file contents as special commands.
    @Test
    public void test7() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
    	Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);
        when(sc.moreBytes()).thenReturn(true, false);
        when(sc.read()).thenReturn("\n");
        
        assertEquals(c.requestFile("DUMMY", "reset-DUMMY"),"\n");
    }
    
    //If the server returns the file in two pieces (i.e., two calls to read() must be executed)
    //the client concatenates them in the correct order).
    @Test
    public void test8() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
    	Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);
        when(sc.moreBytes()).thenReturn(true, true, false);
        when(sc.read()).thenReturn("abc","def");
        
        assertEquals(c.requestFile("DUMMY", "DUMMY"),"abcdef");
    }
    
    //If read() ever returns null, the client treats this as the empty string.
    @Test
    public void test9() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
    	Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);
        when(sc.moreBytes()).thenReturn(true, false);
        when(sc.read()).thenReturn(null);
        
        assertEquals(c.requestFile("DUMMY", "DUMMY"),"");
    }
    
    //Test that if any of the connection operations fails the first time it is executed with an IOException, the client returns null.
    //connectTo throw IOException
    @Test
    public void test10_1() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
    	Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenThrow(new IOException());
        
        assertNull(c.requestFile("DUMMY", "DUMMY"));
    }
    
    //requestFileContents throw IOException
    @Test
    public void test10_2() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
    	Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenThrow(new IOException());
        
        assertNull(c.requestFile("DUMMY", "DUMMY"));
    }
    
    //moreBytes throw IOException
    @Test
    public void test10_3() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
    	Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);
        when(sc.moreBytes()).thenThrow(new IOException());
        
        assertNull(c.requestFile("DUMMY", "DUMMY"));
    }
    
    //read throw IOException
    @Test
    public void test10_4() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
    	Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);
        when(sc.moreBytes()).thenReturn(true);
        when(sc.read()).thenThrow(new IOException());
        
        assertNull(c.requestFile("DUMMY", "DUMMY"));
    }
    
    //closeConnection throw IOException
    @Test
    public void test10_5() throws IOException {
    	ServerConnection sc = mock(ServerConnection.class);
    	Client c = new Client(sc);
        when(sc.connectTo(anyString())).thenReturn(true);
        when(sc.requestFileContents(anyString())).thenReturn(true);
        when(sc.moreBytes()).thenReturn(true);
        when(sc.read()).thenThrow(new IOException());
        doThrow(new IOException()).when(sc).closeConnection();
        
        assertNull(c.requestFile("DUMMY", "DUMMY"));
    }
}