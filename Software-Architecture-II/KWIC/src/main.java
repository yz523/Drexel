
//
//  main.java
//  KWIC
//
//  Created by Yiyun Zhang on 1/21/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException {
		Input i = new Input();
		Linestorage l = new Linestorage();
		l.store(i.input());
		Circularshift c = new Circularshift();
		c.circularshift(l.get_text());
		Alphabetizer a = new Alphabetizer();
		a.alphabetical(c.get_c_text());
		Output o = new Output();
		o.output(a.get_a_text());
	}
}
