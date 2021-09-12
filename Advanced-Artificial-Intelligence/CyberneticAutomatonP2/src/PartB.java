import java.util.ArrayList;

//
//  PartB.java
//  CyberneticAutomatonP2
//
//  Created by Yiyun Zhang on 6/5/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

// Second-order delayed conditioning
public class PartB {

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
		
		inputSet.add('6');
		inputSet.add('c');	
		
		inputSet.add('7');
		inputSet.add('f');
		
		
		inputSet.add('8');
		inputSet.add('d');
		
		inputSet.add('9');
		inputSet.add('g');
		
		inputSet.add('X');
		inputSet.add('e');
		
		//the input set is <(3,d),(4,a),(5,e),(6,b),(6,c),(7,f),(8,d),(9,g),(X,e)>
		CyberneticAutomaton c = new CyberneticAutomaton(initialState,inputSet);
		c.start();
		System.out.println("End");
		System.out.println("0 = q0\n1 = q1\n2 = q2\n3 = q3\n...\nX = q10\n");
		System.out.println("a = UCS+\nb = UCS-\nc = E\nd = CS1+\ne = CS1-\nf = CS2+\ng = CS2-");
		System.out.println("Therefore the final transition table is:");
		System.out.println("q0 UCS+ q1");
		System.out.println("q1 UCS- q2");
		System.out.println("q2 E q0");
		System.out.println("q0 CS1+ q3");
		System.out.println("q3 UCS+ q4");
		System.out.println("q4 CS1- q5");
		System.out.println("q5 UCS- q6");
		System.out.println("q6 E q0");
		System.out.println("q0 CS2+ q7");
		System.out.println("q7 CS1+ q8");
		System.out.println("q8 CS2- q9");
		System.out.println("q9 CS1- q10");
		System.out.println("q10 E q0");
	}

}
