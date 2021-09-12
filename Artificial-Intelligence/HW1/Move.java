//
//  Move.java
//  HW1
//
//  Created by Yiyun Zhang on 10/13/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

//2.C: Move Generation
public class Move{
	public int piece;
	public char idx;
	
	public int getpiece(){
		return piece;
	}
	
	public char getmove(){
		return idx;
	}
	
	public Move(int currentPieceNum, char currentMove){
		piece=currentPieceNum;
		idx=currentMove;
	}
	
	//returns a list of all the moves the piece can perform
	public static Piece piecePossibleMove(int[][] state, int pieces, int z){
		ArrayList<int[]> pos=pos(state, pieces);
		ArrayList<int[]> l=pos(state, 0);
		ArrayList<Character> result=new ArrayList<Character>();
		result.addAll(calc(pos, l));
		if (pieces==2){
			ArrayList<int[]> c=pos(state, -1);
			result.addAll(calc(pos, c));
		}
		Set<Character> set=new HashSet<Character>();
		
		for (Character ch:result){
			if (pos.size() > 1 && ((ch=='u')||ch=='d')){
				int n=0;
				for (int i=0;i<result.size();i++){
					if (result.get(i)==ch){
						n++;
					}
					if (n==pos.size()){
						set.add(ch);
					}
				}
			}
			else{
				set.add(ch);
			}
		}	
		if(z==1){
		System.out.println("Possible move for piece"+pieces+":"+set);
		}
		
		return new Piece(pieces, set);
	}
	//returns all the moves that can be done in a board
	public static Piece[] allPossibleMove(int[][] state){
		ArrayList<Integer> a=new ArrayList<Integer>();
		for (int[] row:state){
			for (int value:row){
				if (!a.contains(value) && (value >=2)){
					a.add(value);
				}
			}
		}
		
		Piece[] result=new Piece[a.size()];
		for (int i=0;i<a.size();i++){
			int n=a.get(i);
			result[i]=piecePossibleMove(state, n,1);
		}
		return result;
	}
	
	//performs the move in the state
	public static void applyMove(int[][] state, Move m){
		ArrayList<int[]> currentpos=pos(state, m.getpiece());
		Piece p=piecePossibleMove(state, m.getpiece(),0);
		int n=0;
		
		for (int[] pos:currentpos){
			if (p.available(m.getmove())){
				int w=pos[1];
				int h=pos[0];
				if (m.getmove()=='u'){
					state[h-1][w]=m.getpiece();					
				}
				else if (m.getmove()=='d'){
					state[h+1][w]=m.getpiece();
				}
				else if (m.getmove()=='l'){
					state[h][w-1]=m.getpiece();
				}
				else if (m.getmove()=='r'){
					state[h][w+1]=m.getpiece();
					n++;
				}
				if (m.getmove()!='r'||n<=1){
					state[h][w]=0;
				}
			}
		}
		State.state=state;
	}
	
	//first clones the state, and then applies the move
	public static int[][] applyMoveCloning(int[][] state, Move m){
		ArrayList<int[]> p=pos(state, m.getpiece());
		Piece piece=piecePossibleMove(state, m.getpiece(),0);
		int i=0;
		
		for (int[] posi:p){
			if (piece.available(m.getmove())){
				int w=posi[1];
				int h=posi[0];
				if (m.getmove()=='u'){
					state[h-1][w]=m.getpiece();					
				}
				else if (m.getmove()=='d'){
					state[h+1][w]=m.getpiece();
				}
				else if (m.getmove()=='l'){
					state[h][w-1]=m.getpiece();
				}
				else if (m.getmove()=='r'){
					state[h][w+1]=m.getpiece();
					i++;
				}
				if (m.getmove()!='r'||i<=1){
					state[h][w]=0;
				}
			}
		}
		return state;
	}
	
    //helper functions
	public static ArrayList<int[]> pos(int[][] state, int piece){
		ArrayList<int[]> l=new ArrayList<int[]>();
		int w=0;
		int h=0;
		for (int[] row:state){
			for (int num:row){
				if (num==piece){
					l.add(new int[]{h, w});
				}
				w++;
			}
			h++;
			w=0;
		}
		
		return l;
	}
	
	public static ArrayList<Character> calc(ArrayList<int[]> piece, ArrayList<int[]> state){
		ArrayList<Character> moves=new ArrayList<Character>();
		for (int[] i:piece){
			int a=i[1];
			int b=i[0];
			for (int[] j:state){
				int x=j[1];
				int y=j[0];
				if ((y==(b-1)) && (x==a)){
					moves.add('u');
				}
				if ((y==(b+1)) && (x==a)){
					moves.add('d');
				}
				if ((x==(a-1)) && (y==b)){
					moves.add('l');
				}
				if ((x==(a+1)) && (y==b)){
					moves.add('r');
				}
			}
			
		}
		return moves;
	}
}

class Piece{
	public int pieces;
	public Set<Character> moves;
	
	public Piece(int i, Set<Character> s){
		pieces=i;
		moves=s;
	}
	
	public int getpiece(){
		return pieces;
	}
	
	public Set<Character> getmoves(){
		return moves;
	}
	
	public boolean available(char ch){
		if (moves.contains(ch)){
			return true;
		}
		else{
			return false;
		}
	}
}	