abstract public class Output {

	static private Output data;
	static private String type = "console";
	protected Output() {};
	abstract void displayMessage(String msg);

	public static Output getdata(){
		if(type=="console"){
			data = PromptOut.getdata();
		}		
		return data;
	}
	
	public static void setType(String s){
		type = s;
	}
}