//
//  SCserver.java
//  SCserver
//
//  Created by Yiyun Zhang on 3/18/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class SCserver extends Thread {
	static ArrayList<String> equations = new ArrayList<String>();
	static int calcluated = 0;
	private Socket socket = null;
	static ReentrantLock lock = new ReentrantLock(true);

	static void addToList(String s) {
		lock.lock();
		try {
			equations.add(s);
		} finally {
			lock.unlock();
		}
	}

	public SCserver(Socket cs) {
		this.socket = cs;
	}

	public void run() {
		try {
			String line="";
			InputStream in = socket.getInputStream();
			Scanner s = new Scanner(in).useDelimiter("\\A");
			if(s.hasNext()){
				line = s.next();
			}
			else{
				line = "";
			}
			addToList(line);
			calcluated++;
			System.out.println("The successful math equation: " + line);
			System.out.println("The total number of all the successful calculated math equations: " + calcluated);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) throws IOException {
		final ServerSocket server = new ServerSocket(8080);
		System.out.println("Waiting for connection...");
		Thread t = new Thread(){
			public void run(){
				while(true){
					Socket s;
					try {
						s = server.accept();
						SCserver sc = new SCserver(s);
						sc.start();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
}