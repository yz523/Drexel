import java.util.*;
import java.io.*;

public class Csv {

private BufferedReader fin;
private String line;
private ArrayList<String> field = null;
private String fieldSep;
    
public Csv(String file, String sep) {
        fieldSep = sep;
    try {
        FileReader inFile = new FileReader(file);
        fin = new BufferedReader(inFile);
    }catch (Exception e){
        System.out.println(e);
    }
}
    
public String getLine() {
    try {
        line = fin.readLine();
        if (line != null)
        field = split(line, fieldSep);
    }catch (Exception e){
        System.out.println(e);
    }
    return line;
}
    
private static ArrayList split(String line, String sep) {
    ArrayList list = new ArrayList();
    int i, j;
    if (line.length() == 0)
        return list;
       i = 0;
    
        do {
            if (i < line.length() && line.charAt(i) == '"') {
                StringBuffer field = new StringBuffer();
                j = advquoted(line, ++i, sep, field);
                list.add(field.toString());
            }else{
                j = line.indexOf(sep, i);
                if (j == -1)
                    j = line.length();
                list.add(line.substring(i, j));
            }
            i = j + sep.length();
        } while (j < line.length());
        return list;
}

private static int advquoted(String s, int i, String sep, StringBuffer field) {
    int j;
    for (j = i; j < s.length(); j++) {
        if (s.charAt(j) == '"' && (++j == s.length() || s.charAt(j) != '"')) {
            int k = s.indexOf(sep, j);
            if (k == -1)
            k = s.length();
            field.append(s.substring(j, k));
            j = k;
            break;
        }
        field.append(s.charAt(j));
    }
    return j;
}
    
public String getfield(int n) {
    if (n < 0 || n >= field.size())
        return null;
    else
        return (String) field.get(n);
}

public static void main(String args[]) {
    String line;
    String f = "test.csv";
    Csv csvf = new Csv(f, ",");
    while ((line = csvf.getLine()) != null) {
        System.out.println("line = `" + line + "'");
        for (int i = 0; i < csvf.field.size(); i++)
            System.out.println("field[" + i + "] = `" + csvf.getfield(i) + "'");
        }
    }
}