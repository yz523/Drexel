import java.io.*;
import java.util.*;

public class PhoneDict {
    
   public static HashMap<String, String> map;
    
    public static void mkdir(String file) throws IOException{
        Scanner src;
        String line, key;
        
        map = new HashMap<String, String>();
        FileReader fin = new FileReader(file);
        src = new Scanner(fin);
        
        while(src.hasNext()){
            key="";
            line = src.nextLine();
            for(int i=0;i<line.length();++i){
                String x = line.substring(i,i+1);
                switch (x){
                    case "a": key += "2"; break;
                    case "b": key += "2"; break;
                    case "c": key += "2"; break;
                    case "d": key += "3"; break;
                    case "e": key += "3"; break;
                    case "f": key += "3"; break;
                    case "g": key += "4"; break;
                    case "h": key += "4"; break;
                    case "i": key += "4"; break;
                    case "j": key += "5"; break;
                    case "k": key += "5"; break;
                    case "l": key += "5"; break;
                    case "m": key += "6"; break;
                    case "n": key += "6"; break;
                    case "o": key += "6"; break;
                    case "p": key += "7"; break;
                    case "q": key += "7"; break;
                    case "r": key += "7"; break;
                    case "s": key += "7"; break;
                    case "t": key += "8"; break;
                    case "u": key += "8"; break;
                    case "v": key += "8"; break;
                    case "w": key += "9"; break;
                    case "x": key += "9"; break;
                    case "y": key += "9"; break;
                    case "z": key += "9"; break;
                    case "A": key += "2"; break;
                    case "B": key += "2"; break;
                    case "C": key += "2"; break;
                    case "D": key += "3"; break;
                    case "E": key += "3"; break;
                    case "F": key += "3"; break;
                    case "G": key += "4"; break;
                    case "H": key += "4"; break;
                    case "I": key += "4"; break;
                    case "J": key += "5"; break;
                    case "K": key += "5"; break;
                    case "L": key += "5"; break;
                    case "M": key += "6"; break;
                    case "N": key += "6"; break;
                    case "O": key += "6"; break;
                    case "P": key += "7"; break;
                    case "Q": key += "7"; break;
                    case "R": key += "7"; break;
                    case "S": key += "7"; break;
                    case "T": key += "8"; break;
                    case "U": key += "8"; break;
                    case "V": key += "8"; break;
                    case "W": key += "9"; break;
                    case "X": key += "9"; break;
                    case "Y": key += "9"; break;
                    case "Z": key += "9"; break;
                }
            }
            if(map.get(key) != null){
                line += "|"+map.get(key);
            }
            map.put(key,line);
        }
    }
    
    public static String translate(String line) throws IOException{
        String res ="", temp ="",value = "";
		  if((line.trim()).equals("")){
			  res= "";
			  return res;
		  }
        while(line.length() > 0){
            if(line.substring(0,1).equals("0")){
                line = line.substring(1,line.length());
            }
            if(!line.substring(0,1).equals("0")){
					if(line.indexOf("0") != -1 ){
						temp = line.substring(0,line.indexOf("0"));
                  line = line.substring(line.indexOf("0")+1,line.length());
					}
					else{
                  temp = line.substring(0,line.length());
                  line = "";
					}
					 value = map.get(temp);
					 if(value == null){
					 	for(int i=0;i<temp.length();++i){
							res += "*";
						}
						res += " ";
					 }
					 else{
						if(value.contains("|")){
							res += "(" + value + ")" + " ";
						}
						else{
					 		res += value + " ";
						}
					 }
				}
		  }
		  return res;
	 }
    
	public static void main(String [] argv) throws IOException{
        Scanner stdin;
        String line;
        stdin = new Scanner(System.in);
        
        mkdir("word");
        while((line = stdin.nextLine()) != null){
            System.out.println(translate(line));
        }
	}
}
