
public class Main {

	public static void main(String[] args) {
		Chess c = new Chess();
		String whiteInput = "Rf1, Kg1, Pf2, Ph2, Pg3, Qf5";
		String blackInput = "Kb8, Ne8, Pa7, Pb7, Pc7, Ra5";
		String pieceInput = "Rf1";
		c.setBoard(whiteInput, blackInput);
		c.getBoard();
		c.getMove(pieceInput);
	}
	
}
