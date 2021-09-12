
public class Arr {

	public Arr() {}

	public static String[] stoval(String[] a,String[] b){
		String[] s = null;
		try{
			s = new String[a.length];
			for(int i=0;i<s.length;i++){
				s[i] = b[Integer.parseInt(a[i])-1];
			}
		}
		catch(Exception e){
			System.out.println("Error changing selections to values");
		}
		return s;
	}
}