import org.junit.Test;

public class ChessTest {

	@Test
	public void testSetBoard() throws Exception {
		Chess testSubject = new Chess();
		String whiteInput = "Rf1, Kg1, Pf2, Ph2, Pg3";
		String blackInput = "Kb8, Ne8, Pa7, Pb7, Pc7, Ra5";
		String[][] result;

		// default test
		result = testSubject.setBoard(whiteInput, blackInput);
	}

	@Test
	public void testGetBoard() throws Exception {
		Chess testSubject = new Chess();
		testSubject.getBoard();
	}

	@Test
	public void testGetMove() throws Exception {
		Chess testSubject = new Chess();
		String whiteInput = "";
		String blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		String pieceInput = "";

		//test1
		whiteInput = "Ka1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ka1";
		testSubject.getMove(pieceInput);
		
		//test2
		whiteInput = "Ra1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ra1";
		testSubject.getMove(pieceInput);
		
		//test3
		whiteInput = "Ba1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ba1";
		testSubject.getMove(pieceInput);
		
		//test4
		whiteInput = "Qa1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qa1";
		testSubject.getMove(pieceInput);
		
		//test5
		whiteInput = "Na1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Na1";
		testSubject.getMove(pieceInput);
		
		//test6
		whiteInput = "Pa1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa1";
		testSubject.getMove(pieceInput);
	}

	@Test
	public void testKingMove() throws Exception {
		Chess testSubject = new Chess();
		String whiteInput = "";
		String blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		String pieceInput = "";

		//test1
		whiteInput = "Ka1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ka1";
		testSubject.getMove(pieceInput);
		
		//test2
		whiteInput = "Ka8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ka8";
		testSubject.getMove(pieceInput);
		
		//test3
		whiteInput = "Kh1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Kh1";
		testSubject.getMove(pieceInput);
		
		//test4
		whiteInput = "Kh8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Kh8";
		testSubject.getMove(pieceInput);
		
		//test5
		whiteInput = "Ka1, Pa2, Pb2, Pb1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ka1";
		testSubject.getMove(pieceInput);
				
		//test6
		whiteInput = "Ka1";
		blackInput = "Pa2, Pb2, Pb1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ka1";
		testSubject.getMove(pieceInput);	
		
		//test7
		whiteInput = "Ka8, Pa7, Pb7, Pb8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ka8";
		testSubject.getMove(pieceInput);
		
		//test8
		whiteInput = "Ka8";
		blackInput = "Pa7, Pb7, Pb8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ka8";
		testSubject.getMove(pieceInput);
		
		//test9
		whiteInput = "Kh1, Pg1, Pg2, Ph2";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Kh1";
		testSubject.getMove(pieceInput);
		
		//test10
		whiteInput = "Kh1";
		blackInput = "Pg1, Pg2, Ph2";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Kh1";
		testSubject.getMove(pieceInput);
		
		//test11
		whiteInput = "Kh8, Ph7, Pg7, Pg8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Kh8";
		testSubject.getMove(pieceInput);
		
		//test12
		whiteInput = "Kh8";
		blackInput = "Ph7, Pg7, Pg8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Kh8";
		testSubject.getMove(pieceInput);
	}

	@Test
	public void testQueenMove() throws Exception {
		Chess testSubject = new Chess();
		String whiteInput = "";
		String blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		String pieceInput = "";

		//test1
		whiteInput = "Qa1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qa1";
		testSubject.getMove(pieceInput);
		
		//test2
		whiteInput = "Qa8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qa8";
		testSubject.getMove(pieceInput);
		
		//test3
		whiteInput = "Qh1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qh1";
		testSubject.getMove(pieceInput);
		
		//test4
		whiteInput = "Qh8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qh8";
		testSubject.getMove(pieceInput);
		
		//test5
		whiteInput = "Qa1, Pa2, Pb2, Pb1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qa1";
		testSubject.getMove(pieceInput);
				
		//test6
		whiteInput = "Qa1";
		blackInput = "Pa2, Pb2, Pb1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qa1";
		testSubject.getMove(pieceInput);	
		
		//test7
		whiteInput = "Qa8, Pa7, Pb7, Pb8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qa8";
		testSubject.getMove(pieceInput);
		
		//test8
		whiteInput = "Qa8";
		blackInput = "Pa7, Pb7, Pb8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qa8";
		testSubject.getMove(pieceInput);
		
		//test9
		whiteInput = "Qh1, Pg1, Pg2, Ph2";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qh1";
		testSubject.getMove(pieceInput);
		
		//test10
		whiteInput = "Qh1";
		blackInput = "Pg1, Pg2, Ph2";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qh1";
		testSubject.getMove(pieceInput);
		
		//test11
		whiteInput = "Qh8, Ph7, Pg7, Pg8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qh8";
		testSubject.getMove(pieceInput);
		
		//test12
		whiteInput = "Qh8";
		blackInput = "Ph7, Pg7, Pg8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Qh8";
		testSubject.getMove(pieceInput);
		
	}

	@Test
	public void testRookMove() throws Exception {
		Chess testSubject = new Chess();
		String whiteInput = "";
		String blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		String pieceInput = "";

		//test1
		whiteInput = "Ra1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ra1";
		testSubject.getMove(pieceInput);
		
		//test2
		whiteInput = "Ra8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ra8";
		testSubject.getMove(pieceInput);
		
		//test3
		whiteInput = "Rh1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Rh1";
		testSubject.getMove(pieceInput);
		
		//test4
		whiteInput = "Rh8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Rh8";
		testSubject.getMove(pieceInput);
		
		//test5
		whiteInput = "Ra1, Pa2, Pb2, Pb1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ra1";
		testSubject.getMove(pieceInput);
				
		//test6
		whiteInput = "Ra1";
		blackInput = "Pa2, Pb2, Pb1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ra1";
		testSubject.getMove(pieceInput);	
		
		//test7
		whiteInput = "Ra8, Pa7, Pb7, Pb8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ra8";
		testSubject.getMove(pieceInput);
		
		//test8
		whiteInput = "Ra8";
		blackInput = "Pa7, Pb7, Pb8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ra8";
		testSubject.getMove(pieceInput);
		
		//test9
		whiteInput = "Rh1, Pg1, Pg2, Ph2";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Rh1";
		testSubject.getMove(pieceInput);
		
		//test10
		whiteInput = "Rh1";
		blackInput = "Pg1, Pg2, Ph2";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Rh1";
		testSubject.getMove(pieceInput);
		
		//test11
		whiteInput = "Rh8, Ph7, Pg7, Pg8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Rh8";
		testSubject.getMove(pieceInput);
		
		//test12
		whiteInput = "Rh8";
		blackInput = "Ph7, Pg7, Pg8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Rh8";
		testSubject.getMove(pieceInput);
		
	}

	@Test
	public void testKnightMove() throws Exception {
		Chess testSubject = new Chess();
		String whiteInput = "";
		String blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		String pieceInput = "";

		//test1
		whiteInput = "Na1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Na1";
		testSubject.getMove(pieceInput);
		
		//test2
		whiteInput = "Na8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Na8";
		testSubject.getMove(pieceInput);
		
		//test3
		whiteInput = "Nh1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Nh1";
		testSubject.getMove(pieceInput);
		
		//test4
		whiteInput = "Nh8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Nh8";
		testSubject.getMove(pieceInput);
		
		//test5
		whiteInput = "Na1, Pc2, Pb3";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Na1";
		testSubject.getMove(pieceInput);
		
		//test6
		whiteInput = "Na1";
		blackInput = "Pc2, Pb3";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Na1";
		testSubject.getMove(pieceInput);
		
		//test7
		whiteInput = "Na8, Pb6, Pc7";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Na8";
		testSubject.getMove(pieceInput);
		
		//test8
		whiteInput = "Na8";
		blackInput = "Pb6, Pc7";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Na8";
		testSubject.getMove(pieceInput);
		
		//test9
		whiteInput = "Nh1, Pf2, Pg3";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Nh1";
		testSubject.getMove(pieceInput);
		
		//test10
		whiteInput = "Nh1";
		blackInput = "Pf2, Pg3";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Nh1";
		testSubject.getMove(pieceInput);
		
		//test11
		whiteInput = "Nh8, Pf7, Pg6";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Nh8";
		testSubject.getMove(pieceInput);
		
		//test12
		whiteInput = "Nh8";
		blackInput = "Pf7, Pg6";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Nh8";
		testSubject.getMove(pieceInput);
	}
				
	
	@Test
	public void testBishopMove() throws Exception {
		Chess testSubject = new Chess();
		String whiteInput = "";
		String blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		String pieceInput = "";

		//test1
		whiteInput = "Ba1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ba1";
		testSubject.getMove(pieceInput);
		
		//test2
		whiteInput = "Ba8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ba8";
		testSubject.getMove(pieceInput);
		
		//test3
		whiteInput = "Bh1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Bh1";
		testSubject.getMove(pieceInput);
		
		//test4
		whiteInput = "Bh8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Bh8";
		testSubject.getMove(pieceInput);
		
		//test5
		whiteInput = "Ba1, Pa2, Pb2, Pb1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ba1";
		testSubject.getMove(pieceInput);
				
		//test6
		whiteInput = "Ba1";
		blackInput = "Pa2, Pb2, Pb1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa1";
		testSubject.getMove(pieceInput);	
		
		

	}

	@Test
	public void testPawnMove() throws Exception {
		Chess testSubject = new Chess();
		String whiteInput = "";
		String blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		String pieceInput = "";
		
		//White
		//test1
		whiteInput = "Pa1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa1";
		testSubject.getMove(pieceInput);
		
		//test2
		whiteInput = "Pa8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa8";
		testSubject.getMove(pieceInput);
		
		//test3
		whiteInput = "Ph1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph1";
		testSubject.getMove(pieceInput);
		
		//test4
		whiteInput = "Ph8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph8";
		testSubject.getMove(pieceInput);
		
		//test5
		whiteInput = "Pa1, Pa2, Pb2, Pb1";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa1";
		testSubject.getMove(pieceInput);
				
		//test6
		whiteInput = "Pa1";
		blackInput = "Pa2, Pb2, Pb1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa1";
		testSubject.getMove(pieceInput);	
		
		
		//test7
		whiteInput = "Pa8, Pa7, Pb7, Pb8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa8";
		testSubject.getMove(pieceInput);
		
		//test8
		whiteInput = "Pa8";
		blackInput = "Pa7, Pb7, Pb8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa8";
		testSubject.getMove(pieceInput);
		
		//test9
		whiteInput = "Ph1, Pg1, Pg2, Ph2";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph1";
		testSubject.getMove(pieceInput);
		
		//test10
		whiteInput = "Ph1";
		blackInput = "Pg1, Pg2, Ph2";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph1";
		testSubject.getMove(pieceInput);
		
		//test11
		whiteInput = "Ph8, Ph7, Pg7, Pg8";
		blackInput = "";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph8";
		testSubject.getMove(pieceInput);
		
		//test12
		whiteInput = "Ph8";
		blackInput = "Ph7, Pg7, Pg8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph8";
		testSubject.getMove(pieceInput);
		
		//Black
		//test1
		whiteInput = "";
		blackInput = "Pa1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa1";
		testSubject.getMove(pieceInput);
		
		//test2
		whiteInput = "";
		blackInput = "Pa8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa8";
		testSubject.getMove(pieceInput);
		
		//test3
		whiteInput = "";
		blackInput = "Ph1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph1";
		testSubject.getMove(pieceInput);
		
		//test4
		whiteInput = "";
		blackInput = "Ph8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph8";
		testSubject.getMove(pieceInput);
		
		//test5
		whiteInput = "";
		blackInput = "Pa1, Pa2, Pb2, Pb1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa1";
		testSubject.getMove(pieceInput);
				
		//test6
		whiteInput = "Pa2, Pb2, Pb1";
		blackInput = "Pa1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa1";
		testSubject.getMove(pieceInput);	
		
		
		//test7
		whiteInput = "";
		blackInput = "Pa8, Pa7, Pb7, Pb8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa8";
		testSubject.getMove(pieceInput);
		
		//test8
		whiteInput = "Pa7, Pb7, Pb8";
		blackInput = "Pa8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Pa8";
		testSubject.getMove(pieceInput);
		
		//test9
		whiteInput = "";
		blackInput = "Ph1, Pg1, Pg2, Ph2";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph1";
		testSubject.getMove(pieceInput);
		
		//test10
		whiteInput = "Pg1, Pg2, Ph2";
		blackInput = "Ph1";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph1";
		testSubject.getMove(pieceInput);
		
		//test11
		whiteInput = "";
		blackInput = "Ph8, Ph7, Pg7, Pg8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph8";
		testSubject.getMove(pieceInput);
		
		//test12
		whiteInput = "Ph7, Pg7, Pg8";
		blackInput = "Ph8";
		testSubject.setBoard(whiteInput, blackInput);
		pieceInput = "Ph8";
		testSubject.getMove(pieceInput);
	}
}