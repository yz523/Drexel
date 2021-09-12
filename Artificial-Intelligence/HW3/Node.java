//
//  Node.java
//  HW3
//
//  Created by Yiyun Zhang on 11/10/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.util.ArrayList;

public class Node {

	private State board;
	private ArrayList<Move> previous = new ArrayList<Move>();
	private int cost = 0;

	public Node(State b) {
		board = b;
	}

	public void setboard(State b) {
		board = b;
	}
	
	public State getboard() {
		return board;
	}

	public void setpreviousmove(Move m) {
		previous.add(m);
	}

	public void getpreviousmove(ArrayList<Move> h) {
		for (int i = 0; i < h.size(); i++) {
			setpreviousmove(h.get(i));
		}
	}

	public ArrayList<Move> getmoves() {
		return previous;
	}

	public void setcost(int i) {
		cost = i;
	}
	
	public int getcost() {
		return cost;
	}
}