
//
//  Consoleoutput.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//


public class Consoleoutput extends Output {
	
	public Consoleoutput(Pipe pipe) {
		super(pipe);
	}

	public void start(){
		
		try {
			for(int i = 0; i <=pipe.getSize(); i++) {
				line = (String) pipe.get();
				System.out.println(line);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}