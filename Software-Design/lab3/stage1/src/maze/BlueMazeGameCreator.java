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
public class BlueMazeGameCreator extends MazeGameCreator
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
		Room r[] = new GreenRoom[2];
		r[0] = new GreenRoom(0);
		r[1] = new GreenRoom(1);
	
		r[0].setSide(Direction.North, new BlueWall() );
		r[0].setSide(Direction.South, new BlueWall() );
		Door d0 = new BrownDoor(r[0], r[1]);
		r[0].setSide(Direction.West, new BlueWall() );
		r[0].setSide(Direction.East, d0 );
		
		r[1].setSide(Direction.North, new BlueWall() );
		r[1].setSide(Direction.South, new BlueWall() );
		r[1].setSide(Direction.West, d0 );
		r[1].setSide(Direction.East, new BlueWall() );
		
		maze.addRoom(r[0]);
		maze.addRoom(r[1]);
		maze.setCurrentRoom(r[1]);
		return maze;
	
	}
	
	public static Room[] MakeRoom(final String path) throws FileNotFoundException{
		Room r[] = new GreenRoom[50];
		File f = new File(path);
		Scanner s = new Scanner(f);
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
					r[n] = new GreenRoom(n);
					d[1] = l.next();
					d[2] = l.next();
					d[3] = l.next();
					d[4] = l.next();
				}
			}
			l.close();
		}
		s.close();
		return r;
	}
	
	
	public static Door[] MakeDoor(final String path, final Room[] r) throws FileNotFoundException
	{
		Door dr[] = new BrownDoor[50];
		File f = new File(path);
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			String str = s.nextLine();
			Scanner l = new Scanner(str);
			while(l.hasNext()){
				String data = l.next();
				if(data.equals("door")){
					String[] d_ = new String[4];
					d_[0] = l.next();
					d_[1] = l.next();
					int r1 = Integer.parseInt(d_[1]);
					d_[2] = l.next();
					int r2 = Integer.parseInt(d_[2]);
					d_[3] = l.next();
					int n = Integer.parseInt(d_[0].substring(1,2));
					dr[n] = new BrownDoor(r[r1],r[r2]);
					if(d_[3].equals("open")){
						dr[n].setOpen(true);
					}
					else{
						dr[n].setOpen(false);
					}
				}
			}
			l.close();
		}
		s.close();
		return dr;
	}
	
	public static Wall[] MakeWall(final String path, final Room[] r) throws FileNotFoundException
	{
		Wall wl[] = new BlueWall[200];
		File f = new File(path);
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			String str = s.nextLine();
			Scanner l = new Scanner(str);
			while(l.hasNext()){
				String data = l.next();
				if(data.equals("room")){
				String[] w = new String[5];
				w[0] = l.next();
				int n = Integer.parseInt(w[0]);
				w[1] = l.next();
				w[2] = l.next();
				w[3] = l.next();
				w[4] = l.next();
				if(w[1].equals("wall")){
					r[n].setSide(Direction.North, new BlueWall());
				}
				if(w[2].equals("wall")){
					r[n].setSide(Direction.South, new BlueWall());
				}
				if(w[3].equals("wall")){
					r[n].setSide(Direction.West, new BlueWall());
				}
				if(w[4].equals("wall")){
					r[n].setSide(Direction.East, new BlueWall());
				}
				}
			}
			l.close();
		}
		s.close();
		return wl;
	}
		
	

	public static Maze MakeMaze(final String path) throws FileNotFoundException
	{
		Maze maze = new Maze();
		File f = new File(path);
		Scanner s = new Scanner(f);
		Room r[] = new GreenRoom[50];
		Door dr[] = new BrownDoor[50];
		Wall wl[] = new BlueWall[200];
		r = MakeRoom(path);
		dr = MakeDoor(path,r);
		wl = MakeWall(path,r);
		int rn = -1;
	
		while(s.hasNextLine()){
			String str = s.nextLine();
			Scanner l = new Scanner(str);
				String data = l.next();
				
				if(data.equals("room")){
					rn++;
					int n = 0;
					String[] d = new String[5];
					d[0] = l.next();
					n = Integer.parseInt(d[0]);
					d[1] = l.next();
					d[2] = l.next();
					d[3] = l.next();
					d[4] = l.next();
					if(d[1].substring(0,1).equals("d")){
						int rt = Integer.parseInt(d[1].substring(1,2));
						r[n].setSide(Direction.North, dr[rt]);
					}
					if(isInteger(d[1])){
						r[n].setSide(Direction.North, r[Integer.parseInt(d[1])]);
					}
					if(d[2].substring(0,1).equals("d")){
						int rt = Integer.parseInt(d[2].substring(1,2));
						r[n].setSide(Direction.South, dr[rt]);
					}
					if(isInteger(d[2])){
						r[n].setSide(Direction.South, r[Integer.parseInt(d[2])]);
					}
					if(d[3].substring(0,1).equals("d")){
						int rt = Integer.parseInt(d[3].substring(1,2));
						r[n].setSide(Direction.West, dr[rt]);
					}
					if(isInteger(d[3])){
						r[n].setSide(Direction.West, r[Integer.parseInt(d[3])]);
					}
					if(d[4].substring(0,1).equals("d")){
						int rt = Integer.parseInt(d[4].substring(1,2));
						r[n].setSide(Direction.East, dr[rt]);
					}
					if(isInteger(d[4])){
						r[n].setSide(Direction.East, r[Integer.parseInt(d[4])]);
					}
				}
				l.close();
			}
		for(int i=0;i<=rn;i++){
			maze.addRoom(r[i]);
		}
		s.close();
		return maze;
		}
	
}

