
//
//  Generator.java
//  lab1
//
//  Created by Yiyun Zhang on 1/30/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Generator extends PipeImpl{
	private String fileName = "";
	private String line = "";
	private Pipe pipe = null;
	
	public Generator(Pipe pipe) {
		this.pipe = pipe;
	}

	public void start() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter file name:");
		fileName = br.readLine() + ".txt";
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader br2 = new BufferedReader(fileReader);
			System.out.println("File " + fileName + " open successful, processing...\n");
			while ((line = br2.readLine()) != null) {
				pipe.put(line);
			}
			br2.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Can NOT open file " + fileName+"\n");
			start();
		}
	}
}
