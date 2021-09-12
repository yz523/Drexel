
//
//  Output.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Output {
	protected String usr_input = "";
	
	public void output(List<String> l) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Choose your output option\n1.Console output\n2.File output\n");
		System.out.print("Enter your choice:");
		usr_input = br.readLine();
		if (usr_input.equals("1")) {
			Consoleoutput c = new Consoleoutput();
			System.out.print("\n");
			 c.console_output(l);
		} else if (usr_input.equals("2")) {
			Fileoutput f = new Fileoutput();
			f.file_output(l);
		} else {
			System.out.print("\nInvalid input, please try again\n");
			output(l);
		}
	}
}