//
//  SCclient.java
//  SCclient
//
//  Created by Yiyun Zhang on 3/18/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

public class SCclient implements Runnable {

	private String equation;
	static GUI ui;
	static Evaluation eval;
	static Calculator calculator;

	public SCclient(String s) {
		this.equation = s;
	}

	public void run() {
		Socket socket;
		try {
			socket = new Socket("localhost", 8080);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();	
			out.write(equation.getBytes(Charset.defaultCharset()));
			in.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Connected.");
		ui = new GUI();
		calculator = new Calculator();
		eval = new Evaluation();
		calculator.setUI(ui);
		ui.setGUI(eval);
	}
}
