
//
//  Consoleinput.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consoleinput extends Input {

	public Consoleinput(Pipe pipe) {
		super(pipe);
	}

	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nConsole input start\nPress enter to input next line, and type '0' to stop\n");
		while (!usrInput.equals("0")) {
			usrInput = br.readLine();
			if(!usrInput.equals("0")){
				size++;
				pipe.put(usrInput);
			}
		}
		pipe.setSize(size);
		System.out.print("\nConsole input done\nProcessing...\n\n");
	}	
}
