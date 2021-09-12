
//
//  NumberFeederClient.java
//  lab4
//
//  Created by Yiyun Zhang on 3/6/18.
//  Copyright © 2018 Yiyun Zhang. All rights reserved.
//

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class NumberFeederClient {

	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("localhost", 8080);
				ArrayList<String> list = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter the array list:\n>");
				String line;
				line = br.readLine();
				String[] str = line.split(" ");
				for (int i = 0; i < str.length; i++) {
					if(isInt(str[i])){
						list.add(str[i]);
					}
				}
				ObjectOutputStream objectOutput;
				objectOutput = new ObjectOutputStream(s.getOutputStream());
				objectOutput.writeObject(list);
				ObjectInputStream objectInput;
				objectInput = new ObjectInputStream(s.getInputStream());
				Object object;
				try {
					object = objectInput.readObject();
					list = (ArrayList<String>) object;
					int c=0;
					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i)+" ");
						c=i;
					}
					c += 1;
					System.out.print("\nThere are "+c+" odd numbers\n");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isInt(String string) {
		try { 
	        Integer.parseInt(string); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}
