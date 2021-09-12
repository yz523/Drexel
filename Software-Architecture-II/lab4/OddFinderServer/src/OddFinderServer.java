
//
//  OddFinderServer.java
//  lab4
//
//  Created by Yiyun Zhang on 3/6/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class OddFinderServer {

	public static void main(String[] args) {
		ServerSocket server;
		System.out.println("Waiting for connection");
		try {
			server = new ServerSocket(8080);
			Socket s = server.accept();
			System.out.println("Connected");
			ServerThread st = new ServerThread(s);
			Thread t = new Thread(st);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class ServerThread implements Runnable {
	Socket socket = null;

	public ServerThread(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> odds = new ArrayList<String>();
			ObjectInputStream objectInput;
			try {
				objectInput = new ObjectInputStream(socket.getInputStream());
				Object object;
				try {
					object = objectInput.readObject();
					list = (ArrayList<String>) object;
					ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
					for (int i = 0; i < list.size(); i++) {
						if (Integer.parseInt(list.get(i)) % 2 != 0) {
							odds.add(list.get(i));
						}
					}
					objectOutput.writeObject(odds);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}