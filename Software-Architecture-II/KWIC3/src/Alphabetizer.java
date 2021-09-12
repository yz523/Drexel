
//
//  Alphabetizer.java
//  KWIC3
//
//  Created by Yiyun Zhang on 2/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alphabetizer {
	private List<String> text = new ArrayList<String>();

	public List<String> alphabetical(List<String> l) {
		Collections.sort(l, String.CASE_INSENSITIVE_ORDER);
		text = l;
		return l;
	}

	public List<String> getText() {
		return text;
	}
}