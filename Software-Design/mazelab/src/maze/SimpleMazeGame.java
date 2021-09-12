/*
 * SimpleMazeGame.java
 * Copyright (c) 2008, Drexel University.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Drexel University nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY DREXEL UNIVERSITY ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL DREXEL UNIVERSITY BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import maze.ui.MazeViewer;

/**
 * 
 * @author Sunny
 * @version 1.0
 * @since 1.0
 */
public class SimpleMazeGame
{
	/**
	 * Creates a small maze.
	 */
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	
	public static Maze createMaze()
	{
		
		Maze maze = new Maze();
		Room r[] = new Room[2];
		r[0] = new Room(0);
		r[1] = new Room(1);
	
		r[0].setSide(Direction.North, new Wall() );
		r[0].setSide(Direction.South, new Wall() );
		Door d0 = new Door(r[0], r[1]);
		r[0].setSide(Direction.West, new Wall() );
		r[0].setSide(Direction.East, d0 );
		
		r[1].setSide(Direction.North, new Wall() );
		r[1].setSide(Direction.South, new Wall() );
		r[1].setSide(Direction.West, d0 );
		r[1].setSide(Direction.East, new Wall() );
		
		maze.addRoom(r[0]);
		maze.addRoom(r[1]);
		maze.setCurrentRoom(r[1]);
		return maze;
	
	}

	public static Maze loadMaze(final String path) throws FileNotFoundException
	{
		Maze maze = new Maze();
		File f = new File(path);
		Scanner s = new Scanner(f);
		File f_ = new File(path);
		Scanner s_ = new Scanner(f_);
		Room r[] = new Room[50];
		Door dr[] = new Door[50];
		int dn = -1;
		int rn = 0;
		
		
		while(s.hasNextLine()){
			String str = s.nextLine();
			Scanner l = new Scanner(str);
			while(l.hasNext()){
				String data = l.next();
				
				if(data.equals("room")){
					int n = 0;
					String[] d = new String[5];
					d[0] = l.next();
					n = Integer.parseInt(d[0]);
					r[n] = new Room(n);
					d[1] = l.next();
					d[2] = l.next();
					d[3] = l.next();
					d[4] = l.next();
					rn = n;
				}
				
				if(data.equals("door")){
					String[] d_ = new String[4];
					dn++;
					d_[0] = l.next();
					d_[1] = l.next();
					int r1 = Integer.parseInt(d_[1]);
					d_[2] = l.next();
					int r2 = Integer.parseInt(d_[2]);
					d_[3] = l.next();
					dr[dn] = new Door(r[r1],r[r2]);
					if(d_[3].equals("open")){
						dr[dn].setOpen(true);
					}
					else{
						dr[dn].setOpen(false);
					}
				}
			}
			l.close();
		}
		
		while(s_.hasNextLine()){
			String str = s_.nextLine();
			Scanner l = new Scanner(str);
			while(l.hasNext()){
				String data = l.next();
				
				if(data.equals("room")){
					int n = 0;
					String[] d = new String[5];
					d[0] = l.next();
					n = Integer.parseInt(d[0]);
					d[1] = l.next();
					d[2] = l.next();
					d[3] = l.next();
					d[4] = l.next();
					if(d[1].equals("wall")){
						r[n].setSide(Direction.North, new Wall());
					}
					if(d[1].substring(0,1).equals("d")){
						int rt = Integer.parseInt(d[1].substring(1,2));
						r[n].setSide(Direction.North, dr[rt]);
					}
					if(isInteger(d[1])){
						r[n].setSide(Direction.North, r[Integer.parseInt(d[1])]);
					}
					if(d[2].equals("wall")){
						r[n].setSide(Direction.South, new Wall());
					}
					if(d[2].substring(0,1).equals("d")){
						int rt = Integer.parseInt(d[2].substring(1,2));
						r[n].setSide(Direction.South, dr[rt]);
					}
					if(isInteger(d[2])){
						r[n].setSide(Direction.South, r[Integer.parseInt(d[2])]);
					}
					if(d[3].equals("wall")){
						r[n].setSide(Direction.West, new Wall());
					}
					if(d[3].substring(0,1).equals("d")){
						int rt = Integer.parseInt(d[3].substring(1,2));
						r[n].setSide(Direction.West, dr[rt]);
					}
					if(isInteger(d[3])){
						r[n].setSide(Direction.West, r[Integer.parseInt(d[3])]);
					}
					if(d[4].equals("wall")){
						r[n].setSide(Direction.East, new Wall());
					}
					if(d[4].substring(0,1).equals("d")){
						int rt = Integer.parseInt(d[4].substring(1,2));
						r[n].setSide(Direction.East, dr[rt]);
					}
					if(isInteger(d[4])){
						r[n].setSide(Direction.East, r[Integer.parseInt(d[4])]);
					}
				}
			}
			l.close();
		}
		
		
		for(int i=0;i<=rn;i++){
			maze.addRoom(r[i]);
		}
		s.close();
		s_.close();
		return maze;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Maze maze = new Maze();
		
		if(args.length == 0){
			maze = createMaze();
		}
		else{
			maze = loadMaze(args[0]);
		}
		
	    MazeViewer viewer = new MazeViewer(maze);
	    viewer.run();
	}
}

