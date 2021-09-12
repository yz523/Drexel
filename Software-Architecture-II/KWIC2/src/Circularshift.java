
//
//  Circularshift.java
//  KWIC2
//
//  Created by Yiyun Zhang on 2/4/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Circularshift extends Filter {
	private List<String> text = new ArrayList<String>();
	private List<String> result = new ArrayList<String>();
	private String line = "";

	public Circularshift(Pipe input_) {
		super(input_,null);
	}
	
	public void transform() {
		try {
			for(int z = 0; z < input_.getSize(); z++) {
				line = (String) input_.get();
				text.add(line);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < text.size(); i++) {
			text.set(i, text.get(i).replaceAll("\\p{P}", ""));
			List<String> word_list = new ArrayList<String>(Arrays.asList(text.get(i).split(" ")));
			for (int j = 0; j < word_list.size(); j++) {
				StringBuilder sb = new StringBuilder();
				for (String s : word_list) {
					sb.append(s);
					sb.append(" ");
				}
				result.add(sb.toString().trim());
				String first = word_list.get(0);
				word_list.remove(0);
				word_list.add(first);
			}
		}
		for (int k = 0; k < result.size(); k++) {
			input_.put(result.get(k));
			input_.setSize(k);
		}
	}
}

		