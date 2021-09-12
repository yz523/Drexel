abstract public class Input {
	
	static private Input data;
	protected Input() {};
	abstract String getStr();
	abstract int getInt();
	
	public static Input getdata(){
		data = PromptIn.getdata();
		return data;
	}
}
