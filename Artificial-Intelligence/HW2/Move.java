//
//  Move.java
//  HW2
//
//  Created by Yiyun Zhang on 10/29/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

public class Move {

	private Direction dir;
	private Piece piece;
	private State board;

	public Move(State b) {
		this.board = b;
	}

	public Move(int w, int h, int[][] b) {
		this.board = new State(w, h, b);
	}

	public void setpiece(Piece p) {
		piece = p;
	}

	public Piece getpiece() {
		return piece;
	}

	public void setpiecemove(Direction d) {
		dir = d;
	}

	public Direction getpiecemove() {
		return dir;
	}

	public void setboardmove(int w, int h, int[][] b) {
		this.board = new State(w, h, b);
	}

	public State getboardmove() {
		return board;
	}

	public void outputmove() {
		System.out.print("("+piece.getnumber()+","+dir+")"+"\n");
	}
}