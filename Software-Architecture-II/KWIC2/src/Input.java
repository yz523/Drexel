
//
//  Input.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Input extends PipeImpl{
	protected String usrInput = "";
	protected List<String> inputText = new ArrayList<String>();
	protected Pipe pipe = null;
	protected int size = 0;
	
	public Input(Pipe pipe) {
		this.pipe = pipe;
	}
	
	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Choose your input option\n1.Console input\n2.File input\n");
		System.out.print("Enter your choice:");
		usrInput = br.readLine();
		if (usrInput.equals("1")) {
			Consoleinput consoleInput = new Consoleinput(pipe);
			consoleInput.start();
		} else if (usrInput.equals("2")) {
			Fileinput fileInput = new Fileinput(pipe);
			fileInput.start();
		} else {
			System.out.print("\nInvalid input, please try again\n");
			start();
		}
	}
}
