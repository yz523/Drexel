
//
//  Input.java
//  KWIC3
//
//  Created by Yiyun Zhang on 2/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
	protected String usr_input = "";
	protected List<String> input_text = new ArrayList<String>();
	
	public List<String> input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Choose your input option\n1.Console input\n2.File input\n3.Command Line\n");
		System.out.print("Enter your choice:");
		usr_input = br.readLine();
		if (usr_input.equals("1")) {
			Consoleinput c = new Consoleinput();
			input_text = c.input();
		} else if (usr_input.equals("2")) {
			Fileinput f = new Fileinput();
			input_text = f.input();
		} else if (usr_input.equals("3")) {
			Event e = new Event();
			e.update();
		}else {
			System.out.print("\nInvalid input, please try again\n");
			input();
		}
		return input_text;
	}
}
