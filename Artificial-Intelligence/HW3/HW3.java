//
//  HW3.java
//  HW3
//
//  Created by Yiyun Zhang on 11/10/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.io.IOException;

public class HW3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Puzzle p = new Puzzle();
		p.load(args[0]);
		if(args[1].equals("bfs")) {
		p.bfs();
		}
		if(args[1].equals("dfs")) {
		p.dfs();
		}
		if(args[1].equals("astar")) {
		p.ass();
		}
	}
}