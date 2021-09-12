//
//  GUI.java
//  SCclient
//
//  Created by Yiyun Zhang on 3/18/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Evaluation eval;

	JButton zero = new JButton("0");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton seven = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");
	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton mul = new JButton("*");
	JButton div = new JButton("/");
	JButton equal = new JButton("=");
	JButton clear = new JButton("C");
	JTextField display = new JTextField();

	GUI() {
		JPanel p = new JPanel(new GridLayout(1, 0, 1, 1));
		p.add(display);
		display.setEditable(false);
		display.setBackground(Color.white);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		JPanel p1 = new JPanel(new GridLayout(1, 0, 1, 1));
		p1.add(seven);
		p1.add(eight);
		p1.add(nine);
		p1.add(add);
		JPanel p2 = new JPanel(new GridLayout(1, 0, 1, 1));
		p2.add(four);
		p2.add(five);
		p2.add(six);
		p2.add(sub);
		JPanel p3 = new JPanel(new GridLayout(1, 0, 1, 1));
		p3.add(one);
		p3.add(two);
		p3.add(three);
		p3.add(mul);
		JPanel p4 = new JPanel(new GridLayout(1, 0, 1, 1));
		p4.add(zero);
		p4.add(equal);
		p4.add(clear);
		p4.add(div);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1, 5, 5));
		add(p);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		pack();
		setVisible(true);
	}

	public void setGUI(Evaluation e) {
		this.eval = e;
	}

	public Evaluation getGUI() {
		return this.eval;
	}
}