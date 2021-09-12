
//
//  Converter.java
//  lab1
//
//  Created by Yiyun Zhang on 1/30/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Converter extends Filter {
	private String line = "";
	private String usrInput = "";

	public Converter(Pipe input_) {
		super(input_, null);
	}

	public void transform() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter output file name:");
		try {
			usrInput = br.readLine() + ".txt";
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream(new File(usrInput)),true); 
				while ((line = (String) input_.get()) != "") {
					String uppercase = line.toUpperCase();
					pw.println(uppercase);
					System.out.println(uppercase);
				}
				pw.close();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
