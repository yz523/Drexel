/**
 *
 * @author santi
 */
public class HW5 {
    
    
    public static void main(String args[]) {
    	System.out.println("=======OthelloMinimax=======");
        // Create the game state with the initial position for an 8x8 board:
        OthelloState state = new OthelloState(8);
        OthelloPlayer players[] = {new OthelloRandomPlayer(),
                                   new OthelloMinimax(Integer.parseInt(args[0]))};
        
        do{
            // Display the current state in the console:
            System.out.println("\nCurrent state, " + OthelloState.PLAYER_NAMES[state.nextPlayerToMove] + " to move:");
            System.out.print(state);
            
            // Get the move from the player:
            OthelloMove move = players[state.nextPlayerToMove].getMove(state);            
            System.out.println(move);
            state = state.applyMoveCloning(move);            
        }while(!state.gameOver());

        // Show the result of the game:
        System.out.println("\nFinal state with score: " + state.score());
        System.out.println(state);
        
        System.out.println("=======OthelloMonteCarlo=======");
        // Create the game state with the initial position for an 8x8 board:
        OthelloState state1 = new OthelloState(8);
        OthelloPlayer players1[] = {new OthelloRandomPlayer(),
                                   new OthelloMonteCarlo()};
        
        do{
            // Display the current state in the console:
            System.out.println("\nCurrent state, " + OthelloState.PLAYER_NAMES[state1.nextPlayerToMove] + " to move:");
            System.out.print(state1);
            
            // Get the move from the player:
            OthelloMove move = players1[state1.nextPlayerToMove].getMove(state1);            
            System.out.println(move);
            state1 = state1.applyMoveCloning(move);            
        }while(!state1.gameOver());

        // Show the result of the game:
        System.out.println("\nFinal state with score: " + state1.score());
        System.out.println(state1);
    }    
    
    
    
}
