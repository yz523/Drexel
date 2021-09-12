//interface Pipe
interface Pipe{
    public boolean put(Object obj);
    public Object get() throws InterruptedException;
    public void setSize(int obj);
    public int getSize();
}

