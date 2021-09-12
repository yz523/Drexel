
//
//  Uppercase.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Uppercase extends Output {

	private String fileName = "";
	private String line = "";

	public Uppercase(Pipe pipe) {
		super(pipe);
	}

	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Do you want output the upper case lines?(y/n))\nEnter your choice:");
		usrInput = br.readLine();
		if (usrInput.equals("n")) {
			System.out.print("\n");
		}
		if (!usrInput.equals("n") && !usrInput.equals("y")) {
			System.out.print("\nInvalid input, please try again.\n");
			start();
		}
		if (usrInput.equals("y")) {
			System.out.print(
					"\nChoose your output opotion(upper case)\n1.Console output\n2.File output\nEnter your choice:");
			usrInput = br.readLine();
			if (!usrInput.equals("1") && !usrInput.equals("2")) {
				System.out.print("\nInvalid input, please try again.\n");
			}
			if (usrInput.equals("1")) {
				try {
					for (int i = 0; i < pipe.getSize(); i++) {
						line = (String) pipe.get();
						System.out.println(line.toUpperCase());
						pipe.put(line);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (usrInput.equals("2")) {
				System.out.print("Enter output file name:");
				fileName = br.readLine() + ".txt";
				PrintWriter pw = new PrintWriter(fileName, "UTF-8");
				try {
					for(int i = 0; i <=pipe.getSize(); i++) {
						line = (String) pipe.get();
						pipe.put(line);
						line = line.toUpperCase();
						pw.println(line);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				pw.close();
				System.out.println("File " + fileName + " created");
			}
		}
	}
}
