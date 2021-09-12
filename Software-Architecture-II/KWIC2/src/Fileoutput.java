
//
//  Fileoutput.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Fileoutput extends Output{
	
	public Fileoutput(Pipe pipe) {
		super(pipe);
	}

	public void start() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter output file name:");
		usrInput = br.readLine() + ".txt";
		PrintWriter pw = new PrintWriter(usrInput, "UTF-8");
		try {
			for(int i = 0; i <=pipe.getSize(); i++) {
				line = (String) pipe.get();
				pw.println(line);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pw.close();
		System.out.println("File " + usrInput + " created");
	}
}