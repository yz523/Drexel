//
//  HW2.java
//  HW2
//
//  Created by Yiyun Zhang on 10/29/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.io.IOException;

public class HW2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Puzzle p = new Puzzle();
		p.load(args[0]);
		if(args[1].equals("bfs")) {
		p.bfs();
		}
		if(args[1].equals("dfs")) {
		p.dfs();
		}
	}
}