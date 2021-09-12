//
//  State.java
//  HW1
//
//  Created by Yiyun Zhang on 10/13/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class State{
	static int[][] state=null;
	static int w=0;
	static int h=0;

//2.A: State representation
	//load
	public static void load(String name) throws FileNotFoundException{
		ArrayList<Integer> martix=new ArrayList<Integer>();
			Scanner s=new Scanner(new File(name));
			while (s.hasNext()){
				Scanner ss=new Scanner(s.next());
				ss.useDelimiter(",");
				while (ss.hasNextInt()){
					martix.add(ss.nextInt());
				}
				ss.close();
			}
			s.close();	
			w=martix.get(0);
			h=martix.get(1);
			state=new int[h][w];
			int a=0,b=0;
			for (int i=2;i<martix.size();i++){
				if (a<w){
					state[b][a]=martix.get(i);
					a++;
				}
				else{
					a=0;
					b++;
					state[b][a]=martix.get(i);
					a++;
				}
			}
	}
	
	//output
	public static void output(){
		System.out.println(w+","+h+",");
		for (int i=0;i<h;i++){
			for (int j=0;j<w;j++){
				System.out.print(state[i][j]+",");
			}
			System.out.print("\n");
		}
		
	}
	
	//clones
	public static int[][] clones(){
		return state.clone();
	}
	
//2.B: Puzzle Complete Check
	//check
	public static boolean check(){
		for (int i=0;i<h;i++){
			for (int j=0;j<w;j++){
				if(state[i][j]==-1){
					return false;
			}
			}
		}
		return true;
	}
	
//2.D: State Comparison
	//compare
	public static boolean compare(int[][] a, int[][] b){
		if (a.equals(b)){
			return true;
		}
		else{
			return false;
		}
	}
	
//2.E: Normalization
	//normalize
	public static int[][] normalize(int[][] martix){
		int nextIdx=3;
		for (int i=0;i<h;i++){
			for (int j=0;j<w;j++){
				if (martix[i][j]==nextIdx){
					nextIdx++;
				}
				else if (martix[i][j]>nextIdx){
					swapIdx(martix, nextIdx, martix[i][j]);
					nextIdx++;
				}
			}
		}
		return martix;
	}
	
	public static int[][] swapIdx(int[][] martix, int idx1, int idx2){
		for (int i=0;i<h;i++){
			for (int j=0;j<w;j++){
				if (martix[i][j]==idx1){
					martix[i][j]=idx2;
				}
				else if (martix[i][j]==idx2){
					martix[i][j]=idx1;
				}
			}
		}
		return martix;
	}
}