
//
//  Alphabetizer.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabetizer {
	private List<String> a_text = new ArrayList<String>();

	public List<String> alphabetical(List<String> l) {
		Collections.sort(l, String.CASE_INSENSITIVE_ORDER);
		a_text = l;
		return l;
	}

	public List<String> get_a_text() {
		return a_text;
	}
}