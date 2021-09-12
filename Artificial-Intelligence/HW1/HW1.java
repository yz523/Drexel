//
//  HW1.java
//  HW1
//
//  Created by Yiyun Zhang on 10/13/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;

public class HW1{
	public static void main(String[] args) throws FileNotFoundException{
		State.load(args[0]);
		randomWalks(State.state, Integer.parseInt(args[1]));
	}

//2.F: Random Walks
	public static void randomWalks(int[][] state, int N){
		State.output();
		
		for (int i=0;i<N;i++){
			Move m=rand(state);
			System.out.println("\n("+m.getpiece()+","+m.getmove()+")\n");
			Move.applyMove(state, m);
            //normalize the resulting game state
			State.state=State.normalize(State.state);
			State.output();
            //if we have reached the goal, or if we have executed N moves, stop; otherwise, go back to 1
			if (State.check()){
				System.out.println("Well Played.");
				break;
			}
		}
	}
		
	public static Move rand(int[][] state){
		//generate all the moves that can be generated in the board
		Piece[] p=Move.allPossibleMove(state);
		HashMap<Integer, Move> m=new HashMap<Integer, Move>();
		int i=0;
		for (Piece piece:p){
			for (char ch:piece.getmoves()){
				m.put(i,new Move(piece.getpiece(), ch));
				i++;
			}
		}
		//select one at random
		int j=new Random().nextInt(m.size());
		return m.get(j);		
	}
}