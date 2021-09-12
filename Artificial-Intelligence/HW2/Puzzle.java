//
//  Puzzle.java
//  HW2
//
//  Created by Yiyun Zhang on 10/29/17.
//  Copyright © 2017 Yiyun Zhang. All rights reserved.
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Puzzle {
    
    private State board;
    private boolean complete = false;
    private ArrayList<Move> solution = new ArrayList<Move>();
    private ArrayList<State> nodes = new ArrayList<State>();
    private Queue<Node> queue = new LinkedList<Node>();
    private Node ends;
    private int explored = 0;
    private double time = 0;
    
    
    public void setBoard(State b) {
        board = b;
    }
    
    public State getBoard() {
        return board;
    }
    
    
    public ArrayList<Move> getSolutionPath() {
        return solution;
    }
    
    public boolean getPuzzleSolved() {
        return complete;
    }
    
    // breadth-first strategy
    public void bfs() {
        double start = System.currentTimeMillis();
        complete = false;
        nodes.clear();
        explored = 0;
        Node root = new Node(board);
        queue.add(root);
        Node current = null;
        
        while (!complete) {
            current = queue.remove();
            nodes.add(current.getboard());
            // get current node's state and do bfs
            breadthfirst(current);
        }
        
        solution = current.getmoves();
        for (Move m : current.getmoves()) {
            m.outputmove();
        }
        this.board.output();
        double end = System.currentTimeMillis();
        time = end - start;
        System.out.print("Explored node:"+explored+"\n");
        System.out.print("Time took:"+time+"ms\n");
        System.out.print("Solution size:"+current.getmoves().size()+"\n\n");
    }
    
    // actual breadth-first search strategy
    public void breadthfirst(Node n) {
        normalize(n.getboard());
        check(n.getboard());
        if (complete == false) {
            ArrayList<Move> moves = allPossibleMove(n.getboard());
            int size= nodes.size();
            for (Move move : moves) {
                normalize(move.getboardmove());
                State s = move.getboardmove();
                boolean b = false;
                for (int i = 0; i < size; i++) {
                    State ss = nodes.get(i);
                    // compare state, if not repeated, then continue
                    boolean b2 = compare(s, ss);
                    if (b2 == true) {
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    // applyMoveCloning and backtrace previous move
                    State ss = applyMoveCloning(n.getboard(), move);
                    nodes.add(ss);
                    Node nodes= new Node(ss);
                    nodes.getpreviousmove(n.getmoves());
                    nodes.setpreviousmove(move);
                    queue.add(nodes);
                    explored++;
                }
            }
        }
    }
    
    //depth-first strategy
    public void dfs() {
        explored = 0;
        double start = System.currentTimeMillis();
        complete = false;
        nodes.clear();
        Node root = new Node(board);
        while (!complete) {
            // do dfs directly from root
            depthfirst(root);
        }
        for (Move m : ends.getmoves()) {
            m.outputmove();
        }
        this.board.output();
        double end = System.currentTimeMillis();
        time = end - start;
        System.out.print("Explored node:"+explored+"\n");
        System.out.print("Time took:"+time+"ms\n");
        System.out.print("Solution size:"+ends.getmoves().size()+"\n\n");
    }
    
    // actual depth-first search strategy
    public void depthfirst(Node n) {
        normalize(n.getboard());
        check(n.getboard());
        if (complete == true) {
            ends = n;
            return;
        } else {
            nodes.add(n.getboard());
            ArrayList<Move> moves = allPossibleMove(n.getboard());
            int size = nodes.size();
            for (Move move : moves) {
                if (complete == false) {
                    boolean b = false;
                    normalize(move.getboardmove());
                    State s = move.getboardmove();
                    for (int i = 0; i < size; i++) {
                        // compare state, if not repeated, then continue
                        State ss = nodes.get(i);
                        boolean b1 = compare(s, ss);
                        if (b1 == true) {
                            b = true;
                            break;
                        }
                    }
                    if (b) {
                        continue;
                    } else {
                        // applyMoveCloning and backtrace previous move
                        State ss = applyMoveCloning(n.getboard(), move);
                        Node node = new Node(ss);
                        node.getpreviousmove(n.getmoves());
                        node.setpreviousmove(move);
                        depthfirst(node);
                        explored++;
                    }
                } else {
                    return;
                }
            }
        }
    }
    
    // 2.A: State representation
    // load
    public void load(String name) throws NumberFormatException, IOException {
        BufferedReader r = new BufferedReader(new FileReader(name));
        boolean b = true;
        int i = 0;
        int col = 0;
        int row = 0;
        int[][] bo = null;
        String line;
        
        while ((line = r.readLine()) != null) {
            String[] s = line.split(",");
            if (b == true) {
                col = Integer.parseInt(s[0]);
                row = Integer.parseInt(s[1]);
                b = false;
                bo = new int[row][col];
                continue;
            }
            for (int j = 0; j < s.length; j++) {
                bo[i][j] = Integer.parseInt(s[j]);
            }
            i++;
        }
        r.close();
        board = new State(col, row, bo);
    }
    
    // 2.B: Puzzle Complete Check
    // check
    public void check(State s) {
        boolean b = false;
        for (int i = 0; i < s.getheight(); i++) {
            for (int j = 0; j < s.getwidth(); j++) {
                if (s.getboard()[i][j] == -1) {
                    b = true;
                }
            }
        }
        if (b == false) {
            complete = true;
        }
    }
    
    // 2.C: Move Generation
    // returns a list of all the moves the piece can perform
    public ArrayList<Move> pieceallPossibleMove(Piece p, State s) {
        boolean r = true, l = true, u = true, d = true;
        
        int[][] bo = s.getboard();
        ArrayList<Position> pos = p.getposition();
        int size = pos.size();
        for (int i = 0; i < size; i++) {
            int row = pos.get(i).getrow();
            int col = pos.get(i).getcol();
            if ((bo[row][col + 1] != p.getnumber()
                 && bo[row][col + 1] >= 1)
                || (bo[row][col + 1] < 0 && !p.ispiece())) {
                r = false;
            }
            if ((bo[row][col - 1] != p.getnumber()
                 && bo[row][col - 1] >= 1)
                || (bo[row][col - 1] < 0 && !p.ispiece())) {
                l = false;
            }
            if ((bo[row - 1][col] != p.getnumber()
                 && bo[row - 1][col] >= 1)
                || (bo[row - 1][col] < 0 && !p.ispiece())) {
                u = false;
            }
            if ((bo[row + 1][col] != p.getnumber()
                 && bo[row + 1][col] >= 1)
                || (bo[row + 1][col] < 0 && !p.ispiece())) {
                d = false;
            }
        }
        
        ArrayList<Move> moves = new ArrayList<Move>(4);
        if (r) {
            int[][] b = s.clones().getboard();
            for (int i = size - 1; i >= 0; i--) {
                int row = pos.get(i).getrow();
                int col = pos.get(i).getcol();
                if (b[row][col + 1] == 0) {
                    int j = b[row][col];
                    b[row][col] = b[row][col + 1];
                    b[row][col + 1] = j;
                } else {
                    b[row][col + 1] = p.getnumber();
                    b[row][col] = 0;
                }
                
            }
            
            Move m = new Move(s.getwidth(), s.getheight(), b);
            m.setpiece(p);
            m.setpiecemove(Direction.right);
            moves.add(m);
        }
        if (l) {
            int[][] b = s.clones().getboard();
            for (int i = 0; i < size; i++) {
                int row = pos.get(i).getrow();
                int col = pos.get(i).getcol();
                if (b[row][col - 1] == 0) {
                    int j = b[row][col];
                    b[row][col] = b[row][col - 1];
                    b[row][col - 1] = j;
                } else {
                    b[row][col - 1] = p.getnumber();
                    b[row][col] = 0;
                }
            }
            Move m = new Move(s.getwidth(), s.getheight(), b);
            m.setpiece(p);
            m.setpiecemove(Direction.left);
            moves.add(m);
        }
        if (u) {
            int[][] b = s.clones().getboard();
            for (int i = 0; i < size; i++) {
                int row = pos.get(i).getrow();
                int col = pos.get(i).getcol();
                if (b[row - 1][col] == 0) {
                    int j = b[row][col];
                    b[row][col] = b[row - 1][col];
                    b[row - 1][col] = j;
                } else {
                    b[row - 1][col] = p.getnumber();
                    b[row][col] = 0;
                }
            }
            Move m = new Move(s.getwidth(), s.getheight(), b);
            m.setpiece(p);
            m.setpiecemove(Direction.up);
            moves.add(m);
        }
        if (d) {
            int[][] b = s.clones().getboard();
            for (int i = size - 1; i >= 0; i--) {
                int row = pos.get(i).getrow();
                int col = pos.get(i).getcol();
                if (b[row + 1][col] == 0) {
                    int j = b[row][col];
                    b[row][col] = b[row + 1][col];
                    b[row + 1][col] = j;
                } else {
                    b[row + 1][col] = p.getnumber();
                    b[row][col] = 0;
                }
            }
            Move m = new Move(s.getwidth(), s.getheight(), b);
            m.setpiece(p);
            m.setpiecemove(Direction.down);
            moves.add(m);
        }
        
        return moves;
    }
    
    // returns all the moves that can be done in a board
    public ArrayList<Move> allPossibleMove(State s) {
        ArrayList<Move> m = new ArrayList<Move>();
        for (int i = 0; i < s.getpiece().size(); i++) {
            ArrayList<Move> moves = pieceallPossibleMove(s.getpiece().get(i + 2), s);
            if (!moves.isEmpty()) {
                for (int j = 0; j < moves.size(); j++) {
                    m.add(moves.get(j));
                }
            }
        }
        return m;
    }
    
    // performs the move in the state
    public void applyMove(State s, Move m) {
        s.setboard(m.getboardmove().getboard());
        s.movepieces();
    }
    
    // first clones the state, and then applies the move
    public State applyMoveCloning(State b, Move m) {
        State s = b.clones();
        applyMove(s, m);
        return s;
    }
    
    // 2.D: State Comparison
    // compare
    public boolean compare(State s1, State s2) {
        for (int i = 0; i < s1.getheight(); i++) {
            for (int j = 0; j < s1.getwidth(); j++) {
                if (s1.getboard()[i][j] != s2.getboard()[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // 2.F: Random Walks
    public void randomWalks(State s, int n) {
        int i = 0;
        while (complete != true && i < n) {
            s.output();
            // generate all the moves that can be generated in the board
            ArrayList<Move> m = allPossibleMove(s);
            Random r = new Random();
            int j = r.nextInt(m.size());
            Move moves = m.get(j);
            moves.outputmove();
            applyMove(s, moves);
            // normalize the resulting game state
            normalize(s);
            // if we have reached the goal, or if we have executed N moves, stop; otherwise,
            // go back to 1
            check(this.board);
            i++;
        }
        s.output();
    }
    
    // 2.E: Normalization
    // normalize
    public void normalize(State board) {
        int nextIdx = 3;
        for (int i = 0; i < board.getheight(); i++) {
            for (int j = 0; j < board.getwidth(); j++) {
                if (board.getboard()[i][j] == nextIdx) {
                    nextIdx++;
                } else if (board.getboard()[i][j] > nextIdx) {
                    swapIdx(nextIdx, board.getboard()[i][j], board);
                    nextIdx++;
                }
            }
        }
        board.movepieces();
    }
    
    private void swapIdx(int idx1, int idx2, State board) {
        
        for (int i = 0; i < board.getheight(); i++) {
            for (int j = 0; j < board.getwidth(); j++) {
                if (board.getboard()[i][j] == idx1) {
                    board.getboard()[i][j] = idx2;
                } else if (board.getboard()[i][j] == idx2) {
                    board.getboard()[i][j] = idx1;
                }
            }
        }
    }
}