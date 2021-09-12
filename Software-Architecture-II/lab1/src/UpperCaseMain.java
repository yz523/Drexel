
//
//  UpperCaseMain.java
//  lab1
//
//  Created by Yiyun Zhang on 1/30/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.IOException;

public class UpperCaseMain {
 
    public static void main(String args[]) throws IOException {
        //Create a pipe between a Generator and Filter
        Pipe pipe = new PipeImpl();
 
        //create the Generator and Filter
		Generator generator = new Generator(pipe);
		Converter converter = new Converter(pipe);
		
        //start the generator and the filter
		generator.start();
		converter.start();
    }
}

