
//
//  Fileinput.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Fileinput extends Input {
	private String file_name = "";
	private String line_input = "";

	public List<String> file_input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter file name:");
		file_name = br.readLine() + ".txt";
		try {
			FileReader fileReader = new FileReader(file_name);
			BufferedReader br2 = new BufferedReader(fileReader);
			System.out.println("File " + file_name + " open successful, processing...\n");
			while ((line_input = br2.readLine()) != null) {
				input_text.add(line_input);
			}
			br2.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Can NOT open file " + file_name+"\n");
			file_input();
		}
		return input_text;
	}
}
