import java.util.ArrayList;

//
//  PartA.java
//  CyberneticAutomatonP2
//
//  Created by Yiyun Zhang on 6/5/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

//first-order delayed conditioning
public class PartA {

	public static void main(String[] args) {
		ArrayList<Data> initialState = new ArrayList<Data>();
		Data d = new Data();
		d.add('0');
		d.add('a');
		d.add('1');
		
		d.add('1');
		d.add('b');
		d.add('2');
		
		d.add('2');
		d.add('c');
		d.add('0');
		
		//the initial state machine is the table:
		//0 a 1
		//1 b 2
		//2 c 0
		initialState.add(d);
		ArrayList<Character> inputSet = new ArrayList<Character>();
		inputSet.add('3');
		inputSet.add('d');
		
		inputSet.add('4');
		inputSet.add('a');
		
		inputSet.add('5');
		inputSet.add('e');
		
		inputSet.add('6');
		inputSet.add('b');
		
		//the input set is <(3,d),(4,a),(5,e),(6,b)>
		CyberneticAutomaton c = new CyberneticAutomaton(initialState,inputSet);
		c.start();
		System.out.println("End\n");
		System.out.println("0 = q0\n1 = q1\n2 = q2\n3 = q3\n...");
		System.out.println("a = UCS+\nb = UCS-\nc = E\nd = CS+\ne = CS-");
		System.out.println("Therefore the final transition table is:");
		System.out.println("q0 UCS+ q1");
		System.out.println("q1 UCS- q2");
		System.out.println("q2 E q0");
		System.out.println("q0 CS+ q3");
		System.out.println("q3 UCS+ q4");
		System.out.println("q4 CS- q5");
		System.out.println("q5 UCS- q6");
		System.out.println("q6 E q0");
	}

}
