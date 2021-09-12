import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author santi
 */
public class OthelloMonteCarlo extends OthelloPlayer {
	//As explained in class, each node in the game tree stores (at least): 
	//its parent, its children, the action that led to this state, 
	//the number of times this node has been visited and the average score found so far for this node.
	private class Node {
		private Node parent;
		private List<Node> children = new ArrayList<Node>();
		private OthelloMove actions;
		private int visited;
		private int score;
		private int average;
		private OthelloState board;
		private List<OthelloMove> moves = new ArrayList<OthelloMove>();

		
		public Node(OthelloState s) {
			board = s;
			score = s.score();
			generateMoves();
		}

		public void generateMoves() {
			List<OthelloMove> moves = board.generateMoves();
			if (!moves.isEmpty()) {
				this.moves = moves;
			}
		}
		
		public void setparent(Node n) {
			parent = n;
		}

		public void setaction(OthelloMove m) {
			actions = m;
		}

		public void setscore(int s) {
			average = s;
		}

		public void visited() {
			visited++;
		}

		public void addNodeToTree(Node n) {
			children.add(n);
		}
		
		public Node getparent() {
			return parent;
		}

		public List<OthelloMove> getNodeMoves() {
			return moves;
		}

		public OthelloMove getaction() {
			return actions;
		}

		public OthelloState getboard() {
			return board;
		}

		public List<Node> getchildren() {
			return children;
		}

		public int getscore() {
			return score;
		}
	}
	
	//Try running the Monte Carlo Tree Search agent with enough iterations so that 
	//it can play at a decent level (values like 10000, 50000, or even 100000 or 1000000 
	//if your implementation is fast enough!).
	public OthelloMove getMove(OthelloState s) {
		return MonteCarloTreeSearch(s, 10000);
	}
	
	//an agent that plays Othello using Monte Carlo Tree Search
	public OthelloMove MonteCarloTreeSearch(OthelloState board, int iterations) {
		Node root = createNode(board);
		for (int i = 0; i < iterations; i++) {
			Node node = treePolicy(root);
			if (node != null) {
				Node node2 = defaultPolicy(node);
				int node2score = score(node2);
				backup(node, node2score);
			}
		}
		return action(bestChild(root));
	}
	

	//crateNode(board): just creates a game tree node from the given board. 
	private Node createNode(OthelloState board) {
		Node n = new Node(board);
		return n;
	}

	//bestChild(node): if the next player to move in node is PLAYER1, 
	//it returns the child with the maximum average score, 
	//if the next player to move in the node is PLAYER2, 
	//then it returns the child with the minimum average score.
	private Node bestChild(Node n) {
		int node = 0;
		int maximum = 0;
		List<Node> l = n.getchildren();
		OthelloState board = n.getboard();
		if (board.nextPlayerToMove == 0) {
			l = n.getchildren();
			if (!l.isEmpty()) {
				for (int i = 0; i < l.size(); i++) {
					int average = l.get(i).getscore();
					if (average > maximum) {
						maximum = average;
						node = i;
					}
				}
				return l.get(node);
			}
		} 
		else {
			node = 0;
			maximum = 0;
			l = n.getchildren();
			if (!l.isEmpty()) {
				for (int i = 0; i < l.size(); i++) {
					int average = l.get(i).getscore();
					if (average < maximum) {
						maximum = average;
						node = i;
					}
				}
				return l.get(node);
			}
		}
		return null;
	}

	//treePolicy(node): this function does the following:
	private Node treePolicy(Node n) {
		List<OthelloMove> moves = n.getNodeMoves();
		//If 'node' still has any children that are not in the tree, 
		//then it generates one of those children ('newnode')
		//it adds 'newnode' as a child to 'node', and returns 'newnode'.
		if (!moves.isEmpty()) {
			OthelloMove m= moves.remove(0);
			OthelloState s = n.getboard().applyMoveCloning(m);
			Node newnode = new Node(s);
			newnode.setparent(n);
			newnode.setaction(m);
			n.addNodeToTree(newnode);
			return newnode;
		}
		
		//If 'node' is not a terminal but all its children are in the tree
		//then: 90% of the times "nodetmp = bestChild(node)"
		//and 10% of the times "nodetmp = [a child of node at random]" 
		if (moves.isEmpty() && !n.getchildren().isEmpty()) {
			Node nodetmp;
			Random r = new Random();
			int i = r.nextInt(10);
			if (i < 9) {
				nodetmp = bestChild(n);
			} 
			 //If 'node' is a terminal node (no actions can be performed). 
			//Then it returns "node"
			else {
				int j = r.nextInt(n.getchildren().size());
				nodetmp = n.getchildren().get(j);
			}
			//Then, the function returns "treePolicy(nodetmp)"
			return treePolicy(nodetmp);
		}
		return n;
	}

	//defautPolicy(node): this function just uses the random agent to select actions at 
	//random for each player, until the game is over, and returns the final state of the game.
	private Node defaultPolicy(Node node) {
		List<Node> l = node.getchildren();
		if (!l.isEmpty()) {
			Random r = new Random();
			int i = r.nextInt(l.size());
			Node n = l.get(i);
			return defaultPolicy(n);
		}
		return node;
	}

	//score(node2): returns the score of the game (you can use the built-in score function in the Othello package
	//you do NOT need to use the complex evaluation function you created for the previous assignment)
	private int score(Node node2) {
		return node2.getscore();
	}
	
	//backup(node,score): increments in 1 the number of times "node" has been visited, 
	//and updates the average score in "node" with the value "score". 
	//If "node" has a parent, then it calls "backup(node.parent,score)".
	private void backup(Node node, int score) {
		node.visited();
		node.setscore(score);
		if (node.getparent() != null) {
			backup(node.parent, score);
		}
	}
	
	private OthelloMove action(Node n){
		if (n != null) {
			return n.getaction();
		}
		else{
			return null;
		}
	}
}