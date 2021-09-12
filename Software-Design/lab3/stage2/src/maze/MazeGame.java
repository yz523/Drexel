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
public class MazeGame extends MazeFactory
{
	/**
	 * Creates a small maze.
	 */
	
	
	public static Maze createMaze(MazeFactory m)
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

	public static void main(String[] args) throws FileNotFoundException
	{
		Maze maze = new Maze();
		Scanner s = new Scanner(System.in);
		String path = "D:/workspace/mazelab/large.maze";
		if(args.length == 0){
			maze = createMaze();
		}
		else{
		if(args[0].equals("red")){
			maze = RedMazeFactory.MakeMaze(path);
			}
		if(args[0].equals("blue")){
			maze = BlueMazeFactory.MakeMaze(path);
			}
		}
		
	    MazeViewer viewer = new MazeViewer(maze);
	    viewer.run();
	}
}
