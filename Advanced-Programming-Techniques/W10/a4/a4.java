import java.io.*;
import java.util.*;

public class a4 {
	public static void main(String [] argv) throws IOException{
		account t = new account();
		Scanner reader = new Scanner(new FileInputStream(argv[0]));
		String[] line = new String[10];
		int a = 0;
		while(reader.hasNext()){
			line[a] = reader.nextLine();
			a++;
		}
//init
		try{
		if(line[0].equals("init") && line[2].equals("=")){
			t.init(line[1],line[3],line[4],line[5],line[6]);
            //initlized, exit with code 0
			System.exit(0);
		}
		}catch(Exception e){
            //get format error, exit with code 1
			System.exit(1);
		}
//purchase
		try{
     	if(line[0].equals("purchase") && line[2].equals("=")){
         t.purchase(line[1],line[3],line[4],line[5],line[6]);
            //purchaseded, exit with code 0
			System.exit(0);
		}
	  }catch(Exception e){
          //get format error, exit with code 1

		  System.exit(1);
	  }
//change
	  	try{
		if(line[0].equals("change")){
			String[] cc = new String[9];
			int p=0;
            //get the numbers before "=" and sign them to cc[0]~cc[3]
			for(int i=0;i<10;i++){
				if(line[i]!= null && line[i].equals("=")){
					p = i;
				}
			}
			for(int z=1;z<p;z++){
				cc[z] = line[z];
			}
            //get the rest number and sign them to c[4]-cc[7]
			for(int y=5;y<9;y++){
				cc[y] = line[p+1];
				p++;
			}
            //change all null to 0
			for(int x=1;x<9;x++){
				if(cc[x]==null){
					cc[x]="0";
				}
			}
			for(int j=1;j<9;j++){
			}
		t.change(cc[1],cc[2],cc[3],cc[4],cc[5],cc[6],cc[7],cc[8]);
		System.exit(0);
		}
		}catch(Exception e){
            //get format error, exit with code 1
			System.exit(1);
		}
//report
			if(line[0].equals("report") && line[1]==null){
				t.report();
                //reported, exit with code 0
				System.exit(0);
			}
			else{
                //get format error, exit with code 1
			System.exit(1);
			
		}
	}
}
