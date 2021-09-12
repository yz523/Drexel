import java.util.List;

/**
 *
 * @author santi
 */
public class OthelloMinimax extends OthelloPlayer {
	private int depth = 0;
	
	public OthelloMinimax(int i) {
		this.depth = i;
	}

	public OthelloMove getMove(OthelloState state) {
		List<OthelloMove> moves = state.generateMoves();
		int[] actions = new int[moves.size()];
		int x = 0, y = 0;
		if (!moves.isEmpty()) {
			for (int i = 0; i < moves.size(); i++) {
				//choose move to position with highest minimax value
				if (state.nextPlayerToMove == 1) {
					actions[i] = decision(depth, state, false);
				} 
				else {
					actions[i] = decision(depth, state, true);
				}
			}
			for (int j = 0; j < actions.length; j++) {
				if (state.nextPlayerToMove == 1) {
					if (actions[j] < y) {
						y = actions[j];
						x = j;
					}
				} 
				else {
					if (actions[j] > y) {
						y = actions[j];
						x = j;
					}
				}
			}
			return moves.get(x);
		}
		return null;
	}

	//inputs: state,current state in game 
	//return the a in Actions(state) maximizing min-Value
	public int decision(int depth, OthelloState state, boolean b) {
		if (depth == 0 || state.gameOver()) {
			return state.score();
		}
		if (b) {
			int a = Integer.MAX_VALUE;
			List<OthelloMove> move = state.generateMoves();
			//for a in successors m, let v equal to the max value of v and minvalue(m)
			for (OthelloMove m : move) {
				OthelloState s = state.applyMoveCloning(m);
				int v = decision(depth - 1, s, false);
				a = maxvalue(a, v);
			}
			return a;
		}
		else {
			int a = Integer.MIN_VALUE;
			List<OthelloMove> moves = state.generateMoves();
			//for a in successors m, let v equal to the min value of v and maxvalue(m)
			for (OthelloMove m : moves) {
				OthelloState s = state.applyMoveCloning(m);
				int v = decision(depth - 1, s, true);
				a = minvalue(a, v);
			}
			return a;
		}
	}
	
	//helper comparation functions
	private int maxvalue(int i, int j) {
		if (j > i) {
			return j;
		}
		return i;
	}

	private int minvalue(int i, int j) {
		if (j < i) {
			return j;
		}
		return i;
	}
}
