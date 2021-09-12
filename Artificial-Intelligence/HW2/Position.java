//
//  Position.java
//  HW2
//
//  Created by Yiyun Zhang on 10/29/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

public class Position {
	private int row;
	private int col;

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public void setcol(int col) {
		this.col = col;
	}

	public void setrow(int row) {
		this.row = row;
	}

	public int getcol() {
		return col;
	}

	public int getrow() {
		return row;
	}
}