
//
//  ConcreteVisitor.java
//  lab3
//
//  Created by Yiyun Zhang on 2/27/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.*;

public class ConcreteVisitor implements Visitor {
	private int total = 0;

	public void visitFile(Files file) {
		file.operation();
	}

	public void visitFolder(Folder folder) {
		folder.operation();
	}

	public void visitTotalFile(Folder folder) {
		folder.total();
		try {
			FileReader fileReader = new FileReader("temp");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line="";
			try {
				while((line = bufferedReader.readLine()) != null) {
				    if(line.equals("1")){
				    	total += 1;
				    }
				}
			} catch (IOException e) {
				e.printStackTrace();
			}   
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("\nTotal file: " + total);
		File file = new File("temp");
		if(file.delete()){}
	}

	public void visitEarliestFile(Folder folder) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("temp2"));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			writer.append("a 99.99\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		folder.earliest();
		try {
			FileReader fileReader = new FileReader("temp3");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line="";
			System.out.println("\nEarliest files:");
			try {
				while((line = bufferedReader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}   
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		File file = new File("temp2");
		if(file.delete()){}
		File file2 = new File("temp3");
		if(file2.delete()){}
	}
}