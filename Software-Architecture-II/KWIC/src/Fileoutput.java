
//
//  Fileoutput.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public class Fileoutput extends Output{
	
	public void file_output(List<String> l) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter output file name:");
		usr_input = br.readLine() + ".txt";
		PrintWriter writer = new PrintWriter(usr_input, "UTF-8");
		for (int i = 0; i < l.size(); i++) {
			writer.println(l.get(i));
		}
		writer.close();
		System.out.println("File " + usr_input + " created");
	}
}