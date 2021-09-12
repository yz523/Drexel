
//
//  main.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException {
        //Create a pipe between a Generator and Filter
        Pipe pipe = new PipeImpl();
        
        //create the Generator and Filter
        Input input = new Input(pipe);
		Circularshift circularshift = new Circularshift(pipe);
		Alphabetizer alphabetizer = new Alphabetizer(pipe);
		Output output = new Output(pipe);
		Uppercase uppercase = new Uppercase(pipe);
		
        //start the generator and the filter
		input.start();
		System.out.println("Input done");
		uppercase.start();
		circularshift.start();
		System.out.println("\nCirculatshift done");
		uppercase.start();
		alphabetizer.start();
		System.out.println("\nAlphabetizer done");
		uppercase.start();
		output.start();
	}
}
