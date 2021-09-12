//
//  State.java
//  HW3
//
//  Created by Yiyun Zhang on 11/10/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.util.HashMap;
import java.util.Map;

public class State {
	private int width;
	private int height;
	private int[][] board;
	private Map<Integer, Piece> piece = new HashMap<Integer, Piece>();

	public State(int w, int h, int[][] b) {
		width = w;
		height = h;
		board = b;
		movepieces();
	}

	public void setboard(int[][] b) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = b[i][j];
			}
		}
	}
	
	public int[][] getboard() {
		return board;
	}

	public int getwidth() {
		return width;
	}

	public int getheight() {
		return height;
	}

	public Map<Integer, Piece> getpiece() {
		return piece;
	}

	// 2.A: State representation
	// output
	public void output() {
		System.out.print(width + "," + height + ",\n");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}
	}

	// clone
	public State clones() {
		int[][] clonedState = new int[height][width];

		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				clonedState[row][column] = board[row][column];
			}
		}

		State boardClone = new State(width, height, clonedState);
		return boardClone;
	}

	// helper function
	public void movepieces() {
		piece.clear();
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				int boardValue = board[row][column];
				if (boardValue > 1) {
					Position position = new Position(row, column);
					if (piece.containsKey(boardValue)) {
						piece.get(boardValue).getposition().add(position);
					} else {
						Piece p = new Piece(boardValue);
						p.getposition().add(position);
						if (boardValue == 2) {
							p.setpiece();
						}
						piece.put(boardValue, p);
					}
				}
			}
		}
	}
}
