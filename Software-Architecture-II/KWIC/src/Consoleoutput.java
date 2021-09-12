
//
//  Consoleoutput.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.util.List;

public class Consoleoutput extends Output {
	
	public void console_output(List<String> l){
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
}