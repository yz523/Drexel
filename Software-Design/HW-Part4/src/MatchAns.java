public class MatchAns {

	public MatchAns() {}

	public static String[] match(String[] a,String[] b){
		String[] c = null;
		try{
			c = new String[a.length];
			for(int i=0;i<c.length;i++){
				c[i] = b[Integer.parseInt(a[i])-1];
			}
		}
		catch(Exception e){
			Output.getdata().displayMessage("error");
		}
		return c;
	}
}
