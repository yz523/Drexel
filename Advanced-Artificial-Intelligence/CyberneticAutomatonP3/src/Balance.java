import java.util.ArrayList;

//
//  Balance.java
//  CyberneticAutomatonP3
//
//  Created by Yiyun Zhang on 6/9/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

// Second-order delayed conditioning
public class Balance {

	public static void main(String[] args) {
		ArrayList<Data> initialState = new ArrayList<Data>();
		Data d = new Data();
		d.add('0');
		d.add('a');
		d.add('1');
		
		d.add('0');
		d.add('b');
		d.add('2');
		
		d.add('0');
		d.add('c');
		d.add('3');
		
		d.add('0');
		d.add('d');
		d.add('4');
		
		d.add('0');
		d.add('B');
		d.add('R');
		
		d.add('0');
		d.add('F');
		d.add('P');
		
		//the initial state machine is the table:
		//0 a 1
		//0 b 2
		//0 c 3
		//0 d 4
		//0 B R
		//0 F P
		initialState.add(d);
		ArrayList<Character> inputSet = new ArrayList<Character>();
		inputSet.add('0');
		inputSet.add('b');
		
		inputSet.add('5');
		inputSet.add('b');
		
		inputSet.add('6');
		inputSet.add('B');
		
		inputSet.add('7');
		inputSet.add('F');
		
		//the input set is <(0,b),(5,b),(6,B),(7,F)>
		CyberneticAutomaton c = new CyberneticAutomaton(initialState,inputSet);
		c.start();
		System.out.println("End");
		System.out.println("R = qR\n0 = q0\n1 = q1\n2 = q2\n3 = q3\n...");
		System.out.println("a = PP\nb = PN\nc = NP\nd = NN");
		System.out.println("Therefore the final transition table is:");
		System.out.println("q0 PP qR");
		System.out.println("q0 PN q1");
		System.out.println("q0 NP q2");
		System.out.println("q0 NN q3");
		System.out.println("q0 B q4");
		System.out.println("q0 F q5");
		System.out.println("q2 PN q5");
		System.out.println("q5 B q6");
		System.out.println("q6 F q7");
	}

}
