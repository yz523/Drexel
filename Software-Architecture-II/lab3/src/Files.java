
//
//  Files.java
//  lab3
//
//  Created by Yiyun Zhang on 2/27/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files extends Component {
	private int size = 0;
	private int level = 0;
	private String fileName = "";
	private double date = 0.00;
	

	public Files(String name, double d, int s, int l){
		fileName = name;
		date = d;
		size = s;
		level = l;
	}

	public void accept(Visitor visitor) {
		visitor.visitFile(this);
	}
	
	
	public void operation() {
		String indent = "";
		for(int i=1;i<level;i++){
			indent = indent + "  ";
		}
		System.out.print(indent+"-"+fileName+"  "+size+"KB  "+date+"\n");
	}

	public void total(){
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("temp", true));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			writer.append("1\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void earliest() {
		try {
			FileReader fileReader = new FileReader("temp2");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			String[] n;
			double d = 0.00;
			try {
				while((line = bufferedReader.readLine()) != null) {
					n = line.split(" ");
					d = Double.parseDouble(n[1]);
					if(date<d){
						BufferedWriter writer = null;
						try {
							writer = new BufferedWriter(new FileWriter("temp2"));
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						try {
							writer.append(fileName+" "+date+"\n");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(date==d){
						BufferedWriter writer = null;
						try {
							writer = new BufferedWriter(new FileWriter("temp3",true));
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						try {
							writer.append(fileName+" "+date+"\n");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}   
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}