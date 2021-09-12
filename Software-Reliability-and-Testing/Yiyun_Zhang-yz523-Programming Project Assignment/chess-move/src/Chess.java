
public class Chess {
	private String[][] board = new String[8][8];
	
	public String[][] setBoard(String whiteInput, String blackInput) {

		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j] = "0";
			}
		}
		
		whiteInput = whiteInput.replaceAll(",\\s*", "");
		while (!whiteInput.equals("")) {
			int x = Integer.parseInt(Character.toString(whiteInput.charAt(2)-1));
			int y = Integer.parseInt(Character.toString(whiteInput.charAt(1)-49));
			String cur = "W"+ Character.toString(whiteInput.charAt(0));
			board[x][y] = cur;
			whiteInput = whiteInput.substring(3,whiteInput.length());
		}
		
		blackInput = blackInput.replaceAll(",\\s*", "");
		while (!blackInput.equals("")) {
			int x = Integer.parseInt(Character.toString(blackInput.charAt(2)-1));
			int y = Integer.parseInt(Character.toString(blackInput.charAt(1)-49));
			String cur = "B"+ Character.toString(blackInput.charAt(0));
			board[x][y] = cur;
			blackInput = blackInput.substring(3,blackInput.length());
		}
		
		return board;
    }
	
	public void getBoard() {
		for (int i = 7; i >=0; i--) {
			for(int j = 0; j < 8; j++) {
				System.out.format("%6s", board[i][j]+"   ");
			}
			
			System.out.print("\n");
		}
    }
	
	public void getMove(String pieceInput) {
		String result = "";
		int x = Integer.parseInt(Character.toString(pieceInput.charAt(2)-1));
		int y = Integer.parseInt(Character.toString(pieceInput.charAt(1)-49));
		String worb = board[x][y].substring(0,1);
		switch (board[x][y].substring(1,2)) {
		case "K":
			result = kingMove(worb, x, y);
			break;
		case "Q":
			result = queenMove(worb, x, y);
			break;
		case "R":
			result = rookMove(worb, x, y);
			break;
		case "B":
			result = bishopMove(worb, x, y);
			break;
		case "N":
			result = knightMove(worb, x, y);
			break;
		case "P":
			result = pawnMove(worb, x, y);
			break;
		}
		System.out.print("LEGAL MOVES FOR " + pieceInput + ": " + result + "\n\n\n");
		}
	
	public String kingMove(String worb, int x, int y) {
		String result = "";
		if (x-1 >= 0 && (board[x-1][y].equals("0") || !board[x-1][y].substring(0,1).equals(worb))) {
			result = result + (char)(y+97) + (x) + ", ";
		}
		if (x-1 >= 0 && y+1 < 8 && (board[x-1][y+1].equals("0") || !board[x-1][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x) + ", ";
		}
		if (y+1 < 8 && (board[x][y+1] == "0" || !board[x][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x+1) + ", ";
		}
		if (x+1 <8 && y+1 < 8 && (board[x+1][y+1].equals("0") || !board[x+1][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x+2) + ", ";
		}
		if (x+1 <8 && (board[x+1][y] == "0" || !board[x+1][y].substring(0,1).equals(worb))) {
			result = result + (char)(y+97) + (x+2) + ", ";
		}
		if (x+1 <8 && y-1 >= 0 && (board[x+1][y-1].equals("0") || !board[x+1][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x+2) + ", ";
		}
		if (y-1 >= 0 && (board[x][y-1] == "0" || !board[x][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x+1) + ", ";
		}
		if (x-1 >= 0 && y-1 >= 0 && (board[x-1][y-1].equals("0") || !board[x-1][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x) + ", ";
		}
		
		if (!result.equals("")) {
			result = result.substring(0,result.length()-2);
		}
		else {
			result = "None";
		}
		return result;
	}
	
	public String queenMove(String worb, int xx, int yy) {
		String result = "";
		int x = xx;
		int y = yy;
		while (x-1 >= 0 && (board[x-1][y].equals("0") || !board[x-1][y].substring(0,1).equals(worb))) {
			result = result + (char)(y+97) + (x) + ", ";
			if (board[x-1][y].substring(0,1).equals(worb) || (!board[x-1][y].equals("0") && !board[x-1][y].substring(0,1).equals(worb))) {
				break;
			}
			x--;
		}
		x = xx;
		y = yy;
		while (x-1 >= 0 && y+1 < 8 && (board[x-1][y+1].equals("0") || !board[x-1][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x) + ", ";
			if (board[x-1][y+1].substring(0,1).equals(worb) || (!(board[x-1][y+1].equals("0") && !board[x-1][y+1].substring(0,1).equals(worb)))) {
				break;
			}
			x--;
			y++;
		}
		x = xx;
		y = yy;
		while (y+1 < 8 && (board[x][y+1].equals("0") || !board[x][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x+1) + ", ";
			if (board[x][y+1].substring(0,1).equals(worb) || (!(board[x][y+1].equals("0") && !board[x][y+1].substring(0,1).equals(worb)))) {
				break;
			}
			y++;
		}
		x = xx;
		y = yy;
		while (x+1 <8 && y+1 < 8 && (board[x+1][y+1].equals("0") || !board[x+1][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x+2) + ", ";
			if (board[x+1][y+1].substring(0,1).equals(worb) || (!(board[x+1][y+1].equals("0") && !board[x+1][y+1].substring(0,1).equals(worb)))) {
				break;
			}
			x++;
			y++;
		}
		x = xx;
		y = yy;
		while (x+1 <8 && (board[x+1][y].equals("0") || !board[x+1][y].substring(0,1).equals(worb))) {
			result = result + (char)(y+97) + (x+2) + ", ";
			if (board[x+1][y].substring(0,1).equals(worb) || (!(board[x+1][y].equals("0") && !board[x+1][y].substring(0,1).equals(worb)))) {
				break;
			}		
			x++;
		}
		x = xx;
		y = yy;
		while (x+1 <8 && y-1 >= 0 && (board[x+1][y-1].equals("0") || !board[x+1][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x+2) + ", ";
			if (board[x+1][y-1].substring(0,1).equals(worb) || (!(board[x+1][y-1].equals("0") && !board[x+1][y-1].substring(0,1).equals(worb)))) {
				break;
			}
			x++;
			y--;
		}
		x = xx;
		y = yy;
		while (y-1 >= 0 && (board[x][y-1].equals("0") || !board[x][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x+1) + ", ";
			if (board[x][y-1].substring(0,1).equals(worb) || (!(board[x][y-1].equals("0") && !board[x][y-1].substring(0,1).equals(worb)))) {
				break;
			}
			y--;
		}
		x = xx;
		y = yy;
		while (x-1 >= 0 && y-1 >= 0 && (board[x-1][y-1].equals("0") || !board[x-1][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x) + ", ";
			if (board[x-1][y-1].substring(0,1).equals(worb) || (!(board[x-1][y-1].equals("0") && !board[x-1][y-1].substring(0,1).equals(worb)))) {
				break;
			}
			x--;
			y--;
		}
		
		if (!result.equals("")) {
			result = result.substring(0,result.length()-2);
		}
		else {
			result = "None";
		}
		return result;
	}
	
	public String rookMove(String worb, int xx, int yy) {
		String result = "";
		int x = xx;
		int y = yy;
		while (x-1 >= 0 && (board[x-1][y].equals("0") || !board[x-1][y].substring(0,1).equals(worb))) {
			result = result + (char)(y+97) + (x) + ", ";
			if (board[x-1][y].substring(0,1).equals(worb) || (!board[x-1][y].equals("0") && !board[x-1][y].substring(0,1).equals(worb))) {
				break;
			}
			x--;
		}
		x = xx;
		y = yy;
		while (y+1 < 8 && (board[x][y+1].equals("0") || !board[x][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x+1) + ", ";
			if (board[x][y+1].substring(0,1).equals(worb) || (!(board[x][y+1].equals("0") && !board[x][y+1].substring(0,1).equals(worb)))) {
				break;
			}
			y++;
		}
		x = xx;
		y = yy;
		while (x+1 <8 && (board[x+1][y].equals("0") || !board[x+1][y].substring(0,1).equals(worb))) {
			result = result + (char)(y+97) + (x+2) + ", ";
			if (board[x+1][y].substring(0,1).equals(worb) || (!board[x+1][y].equals("0") && !board[x+1][y].substring(0,1).equals(worb))) {
				break;
			}
			x++;
		}
		x = xx;
		y = yy;
		while (y-1 >= 0 && (board[x][y-1].equals("0") || !board[x][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x+1) + ", ";
			if (board[x][y-1].substring(0,1).equals(worb) || (!board[x][y-1].equals("0") && !board[x][y-1].substring(0,1).equals(worb))) {
				break;
			}
			y--;
		}

		if (!result.equals("")) {
			result = result.substring(0,result.length()-2);
		}
		else {
			result = "None";
		}
		return result;
	}
	
	public String bishopMove(String worb, int xx, int yy) {
		String result = "";
		int x = xx;
		int y = yy;
		while (x-1 >= 0 && y+1 < 8 && (board[x-1][y+1].equals("0") || !board[x-1][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x) + ", ";
			if (board[x-1][y+1].substring(0,1).equals(worb) || (!(board[x-1][y+1].equals("0") && !board[x-1][y+1].substring(0,1).equals(worb)))) {
				break;
			}
			x--;
			y++;
		}
		x = xx;
		y = yy;
		while (x+1 <8 && y+1 < 8 && (board[x+1][y+1].equals("0") || !board[x+1][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x+2) + ", ";
			if (board[x+1][y+1].substring(0,1).equals(worb) || (!(board[x+1][y+1].equals("0") && !board[x+1][y+1].substring(0,1).equals(worb)))) {
				break;
			}
			x++;
			y++;
		}
		x = xx;
		y = yy;
		while (x+1 <8 && y-1 >= 0 && (board[x+1][y-1].equals("0") || !board[x+1][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x+2) + ", ";
			if (board[x+1][y-1].substring(0,1).equals(worb) || (!(board[x+1][y-1].equals("0") && !board[x+1][y-1].substring(0,1).equals(worb)))) {
				break;
			}
			x++;
			y--;
		}
		x = xx;
		y = yy;
		while (x-1 >= 0 && y-1 >= 0 && (board[x-1][y-1].equals("0") || !board[x-1][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x) + ", ";
			if (board[x-1][y-1].substring(0,1).equals(worb) || (!(board[x-1][y-1].equals("0") && !board[x-1][y-1].substring(0,1).equals(worb)))) {
				break;
			}
			x--;
			y--;
		}
		
		if (!result.equals("")) {
			result = result.substring(0,result.length()-2);
		}
		else {
			result = "None";
		}
		return result;
	}
	
	public String knightMove(String worb, int x, int y) {
		String result = "";
		if (x-2 >= 0 && y-1 >=0 && (board[x-2][y-1].equals("0") || !board[x-2][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x-1) + ", ";
		}
		if (x-2 >= 0 && y+1 <8 && (board[x-2][y+1].equals("0") || !board[x-2][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x-1) + ", ";
		}
		if (x-1 >= 0 && y-2 >=0 && (board[x-1][y-2].equals("0") || !board[x-1][y-2].substring(0,1).equals(worb))) {
			result = result + (char)(y+95) + (x) + ", ";
		}
		if (x-1 >= 0 && y+2 <8 && (board[x-1][y+2].equals("0") || !board[x-1][y+2].substring(0,1).equals(worb))) {
			result = result + (char)(y+99) + (x) + ", ";
		}
		if (x+2 <8 && y-1 >=0 && (board[x+2][y-1].equals("0") || !board[x+2][y-1].substring(0,1).equals(worb))) {
			result = result + (char)(y+96) + (x+3) + ", ";
		}
		if (x+2 < 8 && y+1 <8 && (board[x+2][y+1].equals("0") || !board[x+2][y+1].substring(0,1).equals(worb))) {
			result = result + (char)(y+98) + (x+3) + ", ";
		}
		if (x+1 < 8 && y-2 >=0 && (board[x+1][y-2].equals("0") || !board[x+1][y-2].substring(0,1).equals(worb))) {
			result = result + (char)(y+95) + (x+2) + ", ";
		}
		if (x+1 < 8 && y+2 <8 && (board[x+1][y+2].equals("0") || !board[x+1][y+2].substring(0,1).equals(worb))) {
			result = result + (char)(y+99) + (x+2) + ", ";
		}
		
		if (!result.equals("")) {
			result = result.substring(0,result.length()-2);
		}
		else {
			result = "None";
		}
		return result;
	}
	
	public String pawnMove(String worb, int x, int y) {
		String result = "";
		if (worb.equals("W")) {
			if (x+1 <8 && (board[x+1][y] == "0" || !board[x+1][y].substring(0,1).equals(worb))) {
				result = result + (char)(y+97) + (x+2) + ", ";
			}
		}
		if (worb.equals("B")) {
			if (x-1 >=0 && (board[x-1][y] == "0" || !board[x-1][y].substring(0,1).equals(worb))) {
				result = result + (char)(y+97) + (x) + ", ";
			}
		}
		
		if (!result.equals("")) {
			result = result.substring(0,result.length()-2);
		}
		else {
			result = "None";
		}
		return result;
	}
}