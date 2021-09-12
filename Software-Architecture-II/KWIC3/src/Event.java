
//
//  Event.java
//  KWIC3
//
//  Created by Yiyun Zhang on 2/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Event implements Observer{
	public String usrInput = "";
	public List<String> lines = new ArrayList<String>();
	public List<String> result = new ArrayList<String>();
	
	public void update() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nAdd command for adding a new line when typing in 'a'\n");
		System.out.print("Delete command for deleting a line when typing in 'd'\n");
		System.out.print("Print command for printing shifts sorted alphabetically when typing in 'p'\n");
		System.out.print("Quit command for exiting the system when typing in 'q'\n");
		System.out.print("Add, Delete, Print, Quit:");
		while (true) {
			usrInput = br.readLine();
			if(usrInput.equals("a")){
				System.out.print(">");
				usrInput = br.readLine();
				lines.add(usrInput);
				System.out.print("Add, Delete, Print, Quit:");
			}
			else if(usrInput.equals("d")){
				System.out.print(">");
				usrInput = br.readLine();
				for(int i=0;i<lines.size();i++){
					if(lines.get(i).equals(usrInput)){
						lines.remove(i);
					}
				}
				System.out.print("Add, Delete, Print, Quit:");
			}
			else if(usrInput.equals("p")){
				Circularshift c = new Circularshift();
				c.circularshift(lines);
				Alphabetizer a = new Alphabetizer();
				result = a.alphabetical(c.getText());
				System.out.print("-------------------------\n");
				for(int i=0;i<result.size();i++){
					System.out.println(result.get(i));
				}
				System.out.print("\nAdd, Delete, Print, Quit:");
			}
			else if(usrInput.equals("q")){
				System.out.print("\nExiting the system");
				System.exit(0);
			}
			else{
				System.out.print("Add, Delete, Print, Quit:");
			}
		}
	}
}