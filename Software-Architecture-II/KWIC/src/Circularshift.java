
//
//  Circularshift.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Circularshift {
	private List<String> c_text = new ArrayList<String>();

	public List<String> circularshift(List<String> l) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < l.size(); i++) {
			l.set(i, l.get(i).replaceAll("\\p{P}", ""));
			List<String> word_list = new ArrayList<String>(Arrays.asList(l.get(i).split(" ")));
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
		c_text = result;
		return result;
	}

	public List<String> get_c_text() {
		return c_text;
	}
}