
//
//  Linestorage.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.util.ArrayList;
import java.util.List;

public class Linestorage {
	private List<String> text = new ArrayList<String>();
	
	public void store(List<String> input){
		text = input;
	}
	
	public List<String> get_text(){
		return text;
	}
}