import java.util.ArrayList;

//
//  Data.java
//  CyberneticAutomaton
//
//  Created by Yiyun Zhang on 4/27/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

public class Data {
	ArrayList<Character> data = new ArrayList<Character>();
	
	public void add(Character s){
		data.add(s);
	}
	
	public ArrayList<Character> get(){
		return data;
	}
	
	public char geti(int i){
		return data.get(i);
	}
	
	public int size(){
		return data.size();
	}
}
