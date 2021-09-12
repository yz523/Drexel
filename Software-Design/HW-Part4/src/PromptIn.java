import java.util.*;

public class PromptIn extends Input implements java.io.Serializable{

	private static PromptIn data;
	private PromptIn(){}
	
	private static final long serialVersionUID = 1L;
	
	public static Input getdata(){
		if (data==null) data=new PromptIn();
		return data;
	}
	
	public int getInt(){
		String str = "";
		Scanner s = new Scanner(System.in);
		while (!(Check.IsInt(str))){
			str = s.nextLine();
			if(!(Check.IsInt(str))){
				Output.getdata().displayMessage("Enter the integer:");
			}
		}
		int re = Integer.parseInt(str);
		return re;
	}
	
	public String getStr(){
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		return str;
	}
}
