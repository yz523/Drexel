//
//  Evaluation.java
//  SCclient
//
//  Created by Yiyun Zhang on 3/18/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

public class Evaluation {

	public int eval(String s) {
		String[] equation = s.split(" ");
		int left = Integer.parseInt(equation[0]);
		String eval = equation[1];
		int right = Integer.parseInt(equation[2]);
		int result = 0;
		switch (eval) {
		case "+":
			result = left + right;
			break;
		case "-":
			result = left - right;
			break;
		case "*":
			result = left * right;
			break;
		case "/":
			result = left / right;
			break;
		}
		return result;
	}
}