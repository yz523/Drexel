
//
//  Output.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Output extends PipeImpl{
	protected String usrInput = "";
	protected String line = "";
	protected Pipe pipe = null;
	
	public Output(Pipe pipe) {
		this.pipe = pipe;
	}
	
	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nChoose your output option(KWIC result)\n1.Console output\n2.File output\n");
		System.out.print("Enter your choice:");
		usrInput = br.readLine();
		if (usrInput.equals("1")) {
			Consoleoutput consoleoutput = new Consoleoutput(pipe);
			System.out.print("\n");
			consoleoutput.start();
		} else if (usrInput.equals("2")) {
			Fileoutput fileoutput = new Fileoutput(pipe);
			fileoutput.start();
		} else {
			System.out.print("\nInvalid input, please try again\n");
			start();
		}
	}
}