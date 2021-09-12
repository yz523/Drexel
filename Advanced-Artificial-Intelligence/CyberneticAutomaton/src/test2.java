import java.util.ArrayList;

//
//  test2.java
//  CyberneticAutomaton
//
//  Created by Yiyun Zhang on 4/27/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

public class test2 {

	public static void main(String[] args) {
		ArrayList<Data> initialState = new ArrayList<Data>();
		Data d = new Data();
		d.add('a');
		d.add('0');
		d.add('a');
		
		d.add('a');
		d.add('1');
		d.add('b');
		
		d.add('b');
		d.add('1');
		d.add('c');
		
		d.add('b');
		d.add('0');
		d.add('a');
		
		d.add('c');
		d.add('0');
		d.add('c');
		
		d.add('c');
		d.add('1');
		d.add('c');	
		//the initial state machine is the table:
		//a 0 a
		//a 1 b
		//b 1 c
		//b 0 a
		//c 0 c
		//c 1 c
		initialState.add(d);
		ArrayList<Character> inputSet = new ArrayList<Character>();
		inputSet.add('a');
		inputSet.add('0');
		
		inputSet.add('a');
		inputSet.add('1');
		
		inputSet.add('b');
		inputSet.add('2');
		//the input set is <(a,0),(a,1),(b,2)>
		CyberneticAutomaton c = new CyberneticAutomaton(initialState,inputSet);
		c.start();
		System.out.println("End");
	}

}
