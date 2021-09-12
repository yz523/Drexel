public class PromptOut extends Output{
	
	private static PromptOut data;
	private PromptOut(){}
	
	public static Output getdata(){
		if (data == null) data=new PromptOut();
		return data;
	}

	public void displayMessage(String s){
		System.out.println(s);
	}


}
