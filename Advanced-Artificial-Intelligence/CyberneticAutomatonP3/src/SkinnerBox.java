import java.util.ArrayList;

//
//  SkinnerBox.java
//  CyberneticAutomatonP3
//
//  Created by Yiyun Zhang on 6/9/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

// Second-order delayed conditioning
public class SkinnerBox {

	public static void main(String[] args) {
		ArrayList<Data> initialState = new ArrayList<Data>();
		Data d = new Data();
		d.add('0');
		d.add('F');
		d.add('R');
		
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
		d.add('e');
		d.add('5');
		
		d.add('0');
		d.add('f');
		d.add('6');
		
		d.add('0');
		d.add('g');
		d.add('7');
		
		d.add('0');
		d.add('h');
		d.add('8');
		
		//the initial state machine is the table:
		//0 F R
		//0 a 1
		//0 b 2
		//0 c 3
		//0 d 4
		//0 e 5
		//0 f 6
		//0 g 7
		//0 h 8
		initialState.add(d);
		ArrayList<Character> inputSet = new ArrayList<Character>();
		inputSet.add('0');
		inputSet.add('a');
		
		inputSet.add('9');
		inputSet.add('b');
		
		inputSet.add('X');
		inputSet.add('f');
		
		inputSet.add('Y');
		inputSet.add('F');
		
		//the input set is <(0,a),(9,b),(X,f),(Y,F)>
		CyberneticAutomaton c = new CyberneticAutomaton(initialState,inputSet);
		c.start();
		System.out.println("End");
		System.out.println("R = qR\n0 = q0\n1 = q1\n2 = q2\n3 = q3\n...X = q10\nY = q11");
		System.out.println("a = U1N\nb = 1E\nc = 1S\nd = 1W\ne = 2N\nf = 2E\ng = 2S\nh = 2W");
		System.out.println("Therefore the final transition table is:");
		System.out.println("q0 F qR");
		System.out.println("q0 1N q1");
		System.out.println("q0 1E q2");
		System.out.println("q0 1S q3");
		System.out.println("q0 1W q4");
		System.out.println("q0 2N q5");
		System.out.println("q0 2E q6");
		System.out.println("q0 2S q7");
		System.out.println("q0 2W q8");
		System.out.println("q1 1E q9");
		System.out.println("q9 2E q10");
		System.out.println("q10 F q11");
	}

}
