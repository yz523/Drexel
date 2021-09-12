//PipeImpl.java
import java.util.*;
 
public class PipeImpl implements Pipe{
 
    private List buffer = new ArrayList();
    private int size = 0;
 
    public synchronized boolean put(Object obj){
        boolean bAdded = buffer.add(obj);
        notify();
        return bAdded;
    }
 
    public synchronized Object get() throws InterruptedException{
        while(buffer.isEmpty()) wait(); //pipe empty - wait
        Object obj = buffer.remove(0);
        return obj;
    }
    
    public synchronized void setSize(int obj){
    	size = obj;
    }
    
    public synchronized int getSize(){
    	return size;
    }
}

