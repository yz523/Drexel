//
//  Piece.java
//  HW3
//
//  Created by Yiyun Zhang on 11/10/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.util.ArrayList;

public class Piece {

	private ArrayList<Position> position;
	private boolean bool = false;
	private int number = 0;

	public Piece(int i) {
		number = i;
		position = new ArrayList<Position>(2);
	}

	public void setposition(ArrayList<Position> p) {
		position = p;
	}

	public ArrayList<Position> getposition() {
		return position;
	}

	public void setnumber(int n) {
		number = n;
	}

	public int getnumber() {
		return number;
	}

	public void setpiece() {
		bool = true;
	}

	public boolean ispiece() {
		return bool;
	}

	public void outputposition() {
		System.out.print("Piece["+number+"]");
		for (Position p : position) {
			System.out.print(p.getrow()+","+p.getcol());
		}
		System.out.print("\n");
	}
}