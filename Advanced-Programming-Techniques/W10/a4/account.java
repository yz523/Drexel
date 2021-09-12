import java.io.*;
import java.util.*;

public class account {
	int ONE = 1, FIVE = 5, TEN = 10, TWE = 20;

    //drawer initiation
	public void init(String t, String a, String b, String c, String d){
		int amt = Integer.parseInt(t);
		int one = Integer.parseInt(a);
      int five = Integer.parseInt(b);	
	 	int ten = Integer.parseInt(c);
		int twe = Integer.parseInt(d);

		try{
        //create the local file to store one, five, ten, twenty
		PrintWriter writer = new PrintWriter("drawer");
		writer.println(one);
		writer.println(five);
		writer.println(ten);
		writer.println(twe);
		writer.println(0);
		writer.close();
		if(amt!=one*ONE+five*FIVE+ten*TEN+twe*TWE){
			File f = new File("drawer");
			f.delete();
            //if the amount is not equal, delete the file and exit with code 2
			System.exit(2);
		}
		else{
            //success and exit with code 0
			System.exit(0);
		}
		}catch(Exception e){
            //get format error and exit with code 1
			System.exit(1);
		}
	}
	
    //purchase function
	public void purchase(String t, String a, String b, String c, String d){
	  	int w = 0, x = 0, y = 0, z = 0, price = 0, one = 0, five = 0, ten = 0,twe = 0, i = 0;
	  	int[] drawer = new int[5];
		try{
		price = Integer.parseInt(t);
      one = Integer.parseInt(a);
      five = Integer.parseInt(b);
		ten = Integer.parseInt(c);
		twe = Integer.parseInt(d);
		try{
            //input the data from local file
		Scanner src;
		FileReader fin = new FileReader("drawer");
		src = new Scanner(fin);
		while(src.hasNext()){
			drawer[i] = Integer.parseInt(src.nextLine());
			i++;
		}
		}catch(Exception e){
		//get input error and exit with code 4
            System.exit(4);
		}
            //caculate the price difference
		int change = (one * ONE + five * FIVE + ten * TEN + twe * TWE) - price;
            //get money from the right side and put them in the drawer
		one += drawer[0];
		five += drawer[1];
		ten += drawer[2];
		twe += drawer[3];
            //add the amount sale to previous sale data
		price += drawer[4];
		
		if(change < 0){
            //if the money is less than the price, exit with code 2
			System.exit(2);
		}
            //calculate the change and give out the money
		else{
			if((change / TWE) > 0){
				 z = change / TWE;
				twe -= (change / TWE);
				change -= ((change / TWE) * TWE);
			}
			if((change / TEN) > 0){
				y = change / TEN;
				ten -= (change / TEN);
				change -= ((change / TEN) * TEN);
			}
			if((change / FIVE) > 0){
				x = change / FIVE;
				five -= (change / FIVE);
				change -= ((change / FIVE) * FIVE);
			}
			if((change / ONE) > 0){
				w = change / ONE;
				one -= (change / ONE);
				change -= ((change / ONE) * ONE);
			}
		}
            
        //if the data in the drawer all greater or equal to 0, then the deal success, refresh the drawer data
		PrintWriter writer = new PrintWriter("drawer");
		if(one >= 0 && five >= 0 && ten >=0 && twe >= 0){
      System.out.println(w + " " + x + " " + y + " " + z);
		writer.println(one);
      writer.println(five);
      writer.println(ten);
		writer.println(twe);
		writer.println(price);
		writer.close();
		}
            //the deal fails, let the drawer data as old version
		else{
		writer.println(drawer[0]);
      writer.println(drawer[1]);
		writer.println(drawer[2]);
		writer.println(drawer[3]);
		writer.println(drawer[4]);
		writer.close();	
		System.exit(3);
		}
            //get the format error and exit with code 1
		}catch(Exception e){
			System.exit(1);
		}
 	}

	public void change(String a, String b, String c, String d, String w, String x, String y, String z){
	int[] drawer = new int[5];
	int i = 0;
	int leftone = Integer.parseInt(a);
	int leftfive = Integer.parseInt(b);
	int leftten = Integer.parseInt(c);
	int lefttwe = Integer.parseInt(d);
	int rightone = Integer.parseInt(w);
	int rightfive = Integer.parseInt(x);
	int rightten = Integer.parseInt(y);
	int righttwe = Integer.parseInt(z);
	int lo=leftone;
	int lf=leftfive;
	int lten=leftten;
	int ltwe=lefttwe;
	int ro=rightone;
	int rf=rightfive;
	int rten=rightten;
	int rtwe=righttwe;
	if((leftone*ONE+leftfive*FIVE+leftten*TEN+lefttwe*TWE)!=(rightone*ONE+rightfive*FIVE+rightten*TEN+righttwe*TWE)){
        //check if left and right are equal, if not exit with code 2
		System.exit(2);
	}
	else{
		try{
            //get drawer from local file
			Scanner src;
			FileReader fin = new FileReader("drawer");
			src = new Scanner(fin);
			while(src.hasNext()){
				drawer[i] =	Integer.parseInt(src.nextLine());
				i++;
			}
		}catch(Exception e){
            //get input error and exit with code 4
			System.exit(4);
		}
        //add left side's money to the drawer and give out the right side's money
		lo += drawer[0];
		lf += drawer[1];
		lten += drawer[2];
		ltwe += drawer[3];
		ro = lo - ro;
		rf = lf - rf;
		rten = lten - rten;
		rtwe = ltwe - rtwe;
		try{
			PrintWriter writer = new PrintWriter("drawer");
			if(ro >= 0 && rf >= 0 && rten >= 0 && rtwe >= 0){
                //if the change success, refresh the drawer data
				System.out.println(rightone+" "+rightfive+" "+rightten+" "+righttwe);
				writer.println(ro);
				writer.println(rf);
				writer.println(rten);
				writer.println(rtwe);
				writer.println(drawer[4]);
				writer.close();
			}
			else{
                //if the change fails, keep the drawer as old version. Exit with code 3
				writer.println(drawer[0]);
				writer.println(drawer[1]);
				writer.println(drawer[2]);
				writer.println(drawer[3]);
				writer.println(drawer[4]);
				writer.close();
				System.exit(3);
			}
		}catch(Exception e){
            //get the input error and exit with code 4
			System.exit(4);
		}
	}
	System.exit(0);
	}

	public void report(){
	try{
        //get the last data from drawer, which is total amount of sale so far
		int[] drawer = new int[5];
		int i = 0;
		Scanner src;
		FileReader fin = new FileReader("drawer");
		src = new Scanner(fin);
		while(src.hasNext()){
			drawer[i] =	Integer.parseInt(src.nextLine());
			i++;
		}
        //outpur sale:total = drawer data
		System.out.println(drawer[4] + " "  + ":" + " "  +
				(drawer[0]*ONE+drawer[1]*FIVE+drawer[2]*TEN+drawer[3]*TWE) + " " + "=" + " " + drawer[0] + " " + drawer[1] + " " + drawer[2] + " " + drawer[3]);
        //success output and exit with code 0
		System.exit(0);
	}catch(Exception e){
        //get input error and exit with code 4
		System.exit(4);
	}
	}
}
