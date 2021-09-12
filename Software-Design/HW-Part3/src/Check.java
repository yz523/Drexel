import java.util.*;

public class Check {

	public static boolean ArrayExist(String[] s,String a){
		boolean e= false;
		for (int i=0;i<s.length;i++){
			if(s[i]!=null){
				if(s[i].equals(a)){
					e = true;
				}
			}
		}
		return e;
	}
	
	public static boolean InRange(int in,int bot,int top){
		if ((bot<=in)&& (in<=top)){
			return true;
		}
		return false;
	}
	
	public static boolean IsInt(String in){
		try{
			Integer.parseInt(in);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static int PosInt(){
		int i = -1;
		while (i<0){
			i = Input.getdata().getInt();
			if (i<0){
				System.out.println("Not a positive number");
			}
		}
		return i;
	}

	public static int IntRange(int bot,int top){
		boolean s = false;
		int r = 100;
		while(!s){
			System.out.println("Enter the number:");
			int t = Input.getdata().getInt();
			if (InRange(t,bot,top)){
				s= true;
				r = t;
			}else{
				System.out.println("Invalid number");
			}
		}
		return r;
	}
	
	public static String StringIn(String in){
		String t ="";
		while((t.equals(null)) || (t.equals(""))){
			System.out.println(in);
			t = Input.getdata().getStr().trim();
			String a = t.replaceAll("\\s+", "");
			if((t.equals("") || (t.equals(null))||(a.equals("")))){
				System.out.println("Invalid input");
			}
		}
		return t;
	}

	public static boolean FileNametf(String in){
		String temp = in.replaceAll("[\\s+/:<>*?\"|]+", "");
		if (temp.equals(in)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static String FileName(String in){
		String i="/";
		while (!(FileNametf(i))){
			i = StringIn(in+"\nThe name CANNOT include \\ / : < > * ? \" | or space");
		}
		return i;
	}
	
	public static String[] MultipleAnsN(String in,int min,int max,int r,boolean e){
		String i= "";
		int c = 0;
		int mr = 0;
		String f =",or enter 0 when finished";
		if (!e){
			mr=1;
			f="";
		}
		String[] t = new String[max];
		
		while(!(i.equals("0"))){
			System.out.println("Enter "+ in + (c+1) + f+":");
			i = String.valueOf(IntRange(mr,r)).trim();
			if (!(i.equals("0"))){
				if(!ArrayExist(t,i)){
					t[c] = i;
					c++;
				}
				else{
					System.out.println(in+" existed");
				}	
			}
			else {
				if(!e){
					if(!ArrayExist(t,i)){
						t[c] = i;
						c++;
					}
					else{
						System.out.println(in+" existed");
					}
				}
			}
			if (c>=max){
				i="0";
			}
			if(i.equals("0")&&c<min){
				System.out.println("At least "+min+" answers should be entered");
				i = "na";
			}
		}
		String[] re = Arrays.copyOfRange(t, 0, c);
		return re; 
	}

	public static String[] MultipleAnsW(String t,int min,int max,boolean e){
		String i= "";
		int c = 0;
		String a = ", or enter 0 when finished";
		if (!e){
			a="";
		}
		String[] temp = new String[max];
		while(!(i.equals("0"))){
			i = StringIn("Enter "+t+(c+1) + a+":");
			if (!(i.equals("0"))){			
				if(!ArrayExist(temp,i)){
					temp[c] = i.trim();
					c++;
				}
				else{
					System.out.println(t+" existed");
				}
			}
			else {
				if(!e){
					if(!ArrayExist(temp,i)){
						temp[c] = i.trim();
						c++;
					}
					else{
						System.out.println(t+" existed");
					}
				}
			}
			if(i.equals("0")&&c<min&&e){
				System.out.println("At least "+min+" answers should be entered");
				i = "na";
			}
			if(i.equals("0")&&(!e)){
				i="na";
			}
			if (c>=max){
				i="0";
			}
		}
		String[] re = Arrays.copyOfRange(temp, 0, c);
		return re;
		
	}
	
	public static String[] arrayToUpper(String[] s){
		for (int i=0;i<s.length;i++){
			s[i] = s[i].toUpperCase();
		}
		return s;
	}
}
