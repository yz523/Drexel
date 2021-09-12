
//
//  Consoleinput.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Consoleinput extends Input {

	public List<String> console_input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nConsole input start\nPress enter to input next line, and type '0' to stop\n");
		while (!usr_input.equals("0")) {
			usr_input = br.readLine();
			if(!usr_input.equals("0")){
				input_text.add(usr_input);
			}
		}
		System.out.print("\nConsole input done\nProcessing...\n\n");
		return input_text;
	}	
}
