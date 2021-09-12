
//
//  Alphabetizer.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabetizer extends Filter {
	private List<String> text = new ArrayList<String>();
	private String line = "";

	public Alphabetizer(Pipe input_) {
		super(input_,null);
	}

	public void transform() {
		try {
			for(int i = 0; i <= input_.getSize(); i++) {			
				line = (String) input_.get();
				text.add(line);	
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
		Collections.sort(text, String.CASE_INSENSITIVE_ORDER);
		for (int j = 0; j < text.size(); j++) {
			input_.put(text.get(j));
		}
	}
}