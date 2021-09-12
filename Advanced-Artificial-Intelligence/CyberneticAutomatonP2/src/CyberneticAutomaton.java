import java.util.ArrayList;

//
//  CyberneticAutomaton.java
//  CyberneticAutomatonP2
//
//  Created by Yiyun Zhang on 6/5/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

public class CyberneticAutomaton {
	ArrayList<Data> Q = new ArrayList<Data>();
	char q0, ql, c, qa, al, ol, o, ad, a, b, q;
	ArrayList<Character> input = new ArrayList<Character>();
	ArrayList<Character> s = new ArrayList<Character>();
	ArrayList<Character> P = new ArrayList<Character>();
	ArrayList<Character> R = new ArrayList<Character>();
	boolean temporary = true;
	boolean permanent = false;
	char e = 'e';
	int r = -1;
	char max = '0';
	double C, Phatb, Deltae, sd;

	public CyberneticAutomaton(ArrayList<Data> init, ArrayList<Character> in) {
		Q = init;
		q0 = init.get(0).geti(0);
		input = in;
	}

	// main algorithm
	public void start() {
		// setup
		c = q0;
		ql = q0;
		al = e;
		o = e;
		ol = e;
		// step2
		step2();
		System.out.println("Input set: \n" + input);
		// dominant input symbol-strength pair
		int largest = 0;
		int pos = 0;
		for (int i = 0; i < input.size(); i++) {
			if (i % 2 != 0) {
				int tmp = input.get(i) - 48;
				if (tmp >= largest) {
					largest = tmp;
					pos = i;
				}
			}
		}
		// Perform Create New Transitions.
		CreateNewTransitons(input.get(pos - 1), input.get(pos));
		ol = o;
		// Output the symbol o with strength
		output(o, sd * CC(c, ad) / 1 + CC(c, ad));
		// Mark temporary
		temporary = true;
		// Perform Update Expectations.
		UpdateExpectations();
		ql = c;
		c = transit(c, ad);
		al = ad;
		for (int i = 0; i < s.size(); i++) {
			if (c == R.get(i)) {
				// perform Apply Reward
				ApplyReward();
			}
			if (c == P.get(i)) {
				// perform Apply Punishment
				ApplyPunishment();
			} else {
				// perform Apply Conditioning
				ApplyConditioning();
			}
		}
		// Go to step 2
		step2();
	}

	// step 2
	public void step2() {
		if (0 > r) {
			if (transit(c, e) != 'e') {
				if (temporary == true) {
					permanent = true;
				}
				ql = c;
				c = transit(c, e);
			}
			qa = c;
			al = e;
			ol = e;
			temporary = false;
			Phat(0);
			r++;
			step2();
		}
	}

	// operation that perform transit function
	public char transit(char c1, char c2) {
		int pos = 0;
		for (int i = 0; i < Q.get(0).size(); i++) {
			if (i % 3 == 0) {
				pos = i;
				if (Q.get(0).geti(pos) == c1 && Q.get(0).geti(pos + 1) == c2) {
					return Q.get(0).geti(pos + 2);
				}
			}
		}
		return e;
	}

	public void Phat(int i) {
		System.out.println("State for step " + i + ": \n" + Q.get(i).get());
		if(i == 0){
			System.out.println("(initial state)");
		}
		System.out.println("State table:");
		ArrayList<Character> temp = new ArrayList<Character>();
		temp = Q.get(i).get();
		for(int j = 0; j < temp.size(); j++){
			System.out.print(temp.get(j)+" ");
			if((j+1) % 3 == 0){
				System.out.print("\n");
			}
		}
	}

	public char phat(double d) {
		return 0;
	}

	// Perform Create New Transitions.
	public void CreateNewTransitons(char c1, char c2) {
		int ii = 0;
		char current = '0';
		
		ArrayList<Character> newList = new ArrayList<Character>();
		for (int i = 0; i < input.size(); i++) {
			newList.add(input.get(i));
		}

		if (temporary == true) {
			Q.remove(Q.size());
		}
		for (int i = 0; i < input.size(); i++) {
			if (i % 2 == 0) {
				char left = input.get(i);
				char right = input.get(i + 1);
				for (int j = 0; j < Q.get(0).size(); j++) {
					if (j % 3 == 0) {
						if (Q.get(0).geti(j) == left && Q.get(0).geti(j + 1) == right) {
							output(Q.get(0).geti(j + 2), sd * CC(c, ad) / 1 + CC(c, ad));
							current = Q.get(0).geti(j + 2);
							s.add(current);
							if(newList.size()==0){		
							}
							else{
								newList.remove(0);
								newList.remove(0);
							}
							Phatb = (1 - 0) / (current - 1);
							C = 0.1;
						}
						else{
							if(newList.size()==0){
							}
							else{
								ii++;
								Data tmpData = Q.get(0);
								if(newList.get(1)=='c'){
									tmpData = Q.get(0);
									tmpData.add(current);
									tmpData.add('c');
									tmpData.add('0');
									current = '0';
									Q.add(tmpData);
									if(newList.size()==0){		
									}
									else{
										newList.remove(0);
										newList.remove(0);
									}
								}
								tmpData.add(current);
								tmpData.add(newList.get(1));
								tmpData.add(newList.get(0));
								current = newList.get(0);
								Q.add(tmpData);
								Phat(ii);
								newList.remove(0);
								newList.remove(0);
								System.out.println("Current state: " + current);
								if(newList.size()==0){
									ii++;
									tmpData = Q.get(0);
									tmpData.add(current);
									tmpData.add('c');
									tmpData.add('0');
									Q.add(tmpData);
									Phat(ii);
								}
							}
						}
					}
				}
			}
		}
		if (!newList.isEmpty()) {
			for (int k = 1; k < Q.get(0).size(); k++) {
				if (Q.get(0).geti(k) >= Q.get(0).geti(k - 1)) {
					max = Q.get(0).geti(k);
				}
			}
			temporary = true;
		}
	}

	// Output the symbol with strength
	public void output(char o, double strength) {
		if (o != 'e') {
			System.out.println("Current state: " + o);
		}
	}

	// Perform Update Expectations.
	public void UpdateExpectations() {
		if (E(ql, al, c, ad) != e) {
			Deltae = deltaE(ql, al, c, ad);
			Deltae = 0.05 * (1 - E(ql, al, c, ad));
			C = CC(ql, al) * (1 - 0.05 * deltaE(ql, al, c, ad));
			Deltae = deltaE(c, ad, ql, al);
			Deltae = 0.05 * (1 - E(c, ad, ql, al));
			C = CC(c, ad) * (1 - 0.05 * deltaE(c, ad, ql, al));
		} else {
			double E = E(ql, al, c, ad);
			E = 0.05;
			double EE = E(c, ad, ql, al);
			EE = 0.05;
		}
		for (int i = 0; i < input.size(); i++) {
			if (E(ql, al, c, ad) != e && input.get(i) != a) {
				Deltae = deltaE(ql, al, c, ad);
				Deltae = -0.05 * (1 - E(ql, al, c, ad));
				C = CC(ql, al) * (1 - 0.05 * deltaE(ql, al, c, ad));
				Deltae = deltaE(c, ad, ql, al);
				Deltae = -0.05 * (1 - E(c, ad, ql, al));
				C = CC(c, ad) * (1 - 0.05 * deltaE(c, ad, ql, al));
			}
		}
		for (int i = 0; i < Q.size(); i++) {
			if (E(c, ad, ql, al) != e && input.get(i) != a) {
				Deltae = deltaE(c, ad, ql, al);
				Deltae = -0.05 * (1 - E(c, ad, ql, al));
				C = CC(ql, al) * (1 - 0.05 * deltaE(c, ad, ql, al));
				Deltae = deltaE(ql, al, c, ad);
				Deltae = -0.05 * (1 - E(ql, al, c, ad));
				C = CC(c, ad) * (1 - 0.05 * deltaE(ql, al, c, ad));
			}
		}
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i) == input.get(i)) {
				if (E(c, a, c, b) != 'e') {
					Deltae = deltaE(c, a, c, b);
					Deltae = -0.05 * (1 - E(c, a, c, b));
					C = CC(c, a) * (1 - 0.05 * deltaE(c, a, c, b));
				} else {
					double E = E(c, a, c, b);
					E = 0.05;
				}
			} else if (s.get(i) == input.get(i)) {
				if (E(c, a, c, b) != 'e') {
					Deltae = deltaE(c, a, c, b);
					Deltae = -0.05 * (1 - E(c, a, c, b));
					C = CC(c, a) * (1 - 0.05 * deltaE(c, a, c, b));

				}
			}
		}
		R = s;
		P = s;
	}

	public double E(char c1, char c2, char c3, char c4) {
		return c1;
	}

	public char CC(char c1, char c2) {
		return c2;
	}

	public double deltaE(char c1, char c2, char c3, char c4) {
		return c3;
	}

	public char deltaC(char c1, char c2) {
		return c2;
	}

	// perform Apply Reward
	public void ApplyReward() {
		int t = 1;
		char B, C, b = 0;
		if (temporary = true) {
			for (int i = 0; i < s.size(); i++) {
				B = s.get(i);
				B = (char) (((phat(B) + 0 * t * sd * (1 / CC(q, a)))) / (1 + 0 * t * sd * (1 / CC(ql, a))));
				b = (char) (phat(b) / (1 + 0 * t * sd * (1 / CC(ql, a))));
				C = CC(c, ad);
				C = (char) (0 * t * sd);
				temporary = false;
				for (int j = 0; i < Q.size(); j++) {
					B = s.get(j);
					B = (char) (((phat(B) + 0 * 0 * t * sd * (1 / CC(q, a)))) / (1 + 0 * 0 * t * sd * (1 / CC(ql, a))));
					b = (char) (phat(b) / (1 + 0 * 0 * t * sd * (1 / CC(ql, a))));
					C = CC(c, ad);
					C = (char) (0 * t * sd);
				}
				temporary = false;
				t = 0 * t;
			}
		}
	}

	// perform Apply Punishment
	public void ApplyPunishment() {
		int t = 1;
		char B, C, b = 0;
		if (temporary = true) {
			for (int i = 0; i < s.size(); i++) {
				B = s.get(i);
				B = (char) (phat(B) / 1 + 0 * t * sd * (1 / CC(ql, a)));
				b = (char) ((phat(b) + (1 / s.get(i) - 1) * 0 * t * sd * (1 / CC(ql, a)))
						/ (1 + 0 * t * sd * (1 / CC(ql, a))));
				C = CC(c, ad);
				C = (char) (0 * t * sd);
				temporary = false;
				for (int j = 0; i < Q.size(); j++) {
					B = s.get(i);
					B = (char) (phat(B) / 1 + 0 * t * sd * (1 / CC(ql, a)));
					b = (char) ((phat(b) + (1 / s.get(i) - 1) * 0 * t * sd * (1 / CC(ql, a)))
							/ (1 + 0 * t * sd * (1 / CC(ql, a))));
					C = CC(c, ad);
					C = (char) (0 * t * sd);
				}
				temporary = false;
				t = 0 * t;
			}
		}
	}

	// Apply Conditioning.
	public void ApplyConditioning() {
		char p, c, b = 0;
		if (ol != 'e' && o != ol) {
			for (int i = 0; i < input.size(); i++) {
				if (E(ql, al, ql, a) != 'e') {
					p = phat(ol);
					p = (char) ((phat(ol) + 0.2 * sd * (1 / CC(ql, a))) / (1 + 0.2 * sd * (1 / CC(ql, a))));
					b = (char) (phat(b) / (1 + 0.2 * sd * (1 / CC(ql, a))));
				}
			}
			for (int i = 0; i < Q.size(); i++) {
				if (transit(q, a) == ql) {
					p = phat(ol);
					p = (char) ((phat(ol) + 0.2 * sd * (1 / CC(ql, a))) / (1 + 0.2 * sd * (1 / CC(ql, a))));
					b = (char) (phat(b) / (1 + 0.2 * sd * (1 / CC(ql, a))));
				}
			}
			for (int i = 0; i < input.size(); i++) {
				if (E(ql, al, ql, a) != 'e') {
					c = deltaC(ql, a);
					c = (char) (0.2 * sd);
					UpdateConditioning(ql, a, sd * (1 / CC(ql, a)));
				}
			}
			for (int i = 0; i < Q.size(); i++) {
				for (int j = 0; j < input.size(); j++) {
					if (transit(Q.get(0).geti(i), input.get(j)) == ql) {
						c = deltaC(q, a);
						c = (char) (0.2 * sd);
						UpdateConditioning(ql, a, sd * (1 / CC(ql, a)));
					}
				}
			}
		}
	}

	// Apply Update Conditioning
	public void UpdateConditioning(char qhat, char ahat, double d) {
		char p, b = 0;
		if (d > 0) {
			for (int i = 0; i < input.size(); i++) {
				if (E(ql, al, ql, a) != 'e') {
					p = phat(ol);
					p = (char) ((phat(ol) + 0.2 * sd * (1 / CC(qhat, a))) / (1 + 0.2 * sd * (1 / CC(qhat, a))));
					b = (char) (phat(b) / (1 + 0.2 * sd * (1 / CC(ql, a))));
				}
			}
			for (int i = 0; i < Q.size(); i++) {
				if (transit(q, a) == ql) {
					p = phat(ol);
					p = (char) ((phat(ol) + 0.2 * sd * (1 / CC(q, a))) / (1 + 0.2 * sd * (1 / CC(q, a))));
					b = (char) (phat(b) / (1 + 0.2 * sd * (1 / CC(q, a))));
				}
			}
			for (int i = 0; i < input.size(); i++) {
				if (E(ql, al, ql, a) != 'e') {
					c = deltaC(ql, a);
					c = (char) (0.2 * sd);
					UpdateConditioning(qhat, a, d * (1 / CC(qhat, a)));
				}
			}
			for (int i = 0; i < Q.size(); i++) {
				for (int j = 0; j < input.size(); j++) {
					if (transit(Q.get(0).geti(i), input.get(j)) == ql) {
						c = deltaC(q, a);
						c = (char) (0.2 * sd);
						UpdateConditioning(q, a, d * (1 / CC(q, a)));
					}
				}
			}
		}
	}
}
