
//
//  Fileinput.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Fileinput extends Input {
	private String fileName = "";
	private String line = "";

	public Fileinput(Pipe pipe) {
		super(pipe);
	}
	
	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter file name:");
		fileName = br.readLine() + ".txt";
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader br2 = new BufferedReader(fileReader);
			System.out.println("File " + fileName + " open successful, processing...\n");
			while ((line = br2.readLine()) != null) {
				size++;
				pipe.put(line);
			}
			pipe.setSize(size);
			br2.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Can NOT open file " + fileName+"\n");
			start();
		}		
	}
}
