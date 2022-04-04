import java.util.Scanner;
/**
 * TicTacToe Class contains the game logic for Tic Tac Toe.
 * 
 * Class has four member variables: a Board Class object, a Player Class object,
 * a Scanner object, and an integer with the number of players.
 * 
 * The constructor takes in an integer of how many players are participating in the game.
 * This integer is used to initialize the board class member variable and the int numPlayers.
 * 
 * Class has one method 'Play' that runs the Tic Tac Toe game logic loop until a winner is
 * decided.
 * 
 * @author Tommy
 *
 */
public class TicTacToe {
	private Board b;
	private Player p;
	Scanner playerMove = new Scanner(System.in);
	private int numPlayers;
	
	public TicTacToe(int Players) {
		b = new Board(Players);
		p = new Player();
		numPlayers = Players;
		for (int i = 0; i <Players; i++) {
			p.setPlayerName(i, Validator.validatePlayerName(b, p));
		}
	}
	
	public void play() {
		/**
		 * The Play Method will handle run the handle the games structure and execute the logic.
		 * 3 variables will be created and used in the method.
		 * 		A Scorer object to check the board for a winner.
		 * 		A boolean as a stop condition for the primary loop.
		 * 		An integer to keep track of what round it is for the players.
		 * 
		 * The Validator class will be used to verify that users are inputing proper values
		 * for their moves.
		 * 
		 * A while loop will be used to execute the game until the break/win condition is met.
		 */
		Scorer scoreboard = new Scorer(); //Used for player input.
		Boolean win = false; //Used to exit the following while loop.
		int round = 1; //Used to tell users which round of the match they are in.
		
		/**
		 * The while loop will start by telling the users what round they are in.
		 * Outputting the current round is nested into an IF statement. The condition being
		 * that whenever the turn goes back to the first player the current round is printed
		 * to the screen. The board is then displayed and the users are asked in turn to enter
		 * their moves. Validator class is used to verify users input moves properly. After
		 * a valid move is entered the Scorer object checks if a winner exists. If a winner
		 * does exist, a message to the winner is displayed and the loop breaks. Lastly
		 * there is a tie game check. If no more moves are possible on the board, a message is
		 * displayed to the users and the loop breaks.
		 */
		while(win == false) {
			//Print the round. Execute each time before player 1's turn is up.
			if (Player.getNextPlayerTurn() == 0) {
				System.out.println("\n--- ROUND " + round + " ---" + "\n--- FIGHT ! ---");
				round ++;
			}
			//Print the board to the screen.
			b.printBoard();
			//Find the next player and ask them for their move.
			System.out.println(p.getPlayer() + ": It's your turn.");
			//Validate that the user is inputting their move properly and execute it.
			Validator.validateMove(0, b.getBoardSize(), b, p);
			//Switch over to the next player.
			//Check if there is a winner.
  			win = scoreboard.checkWin(b);
  			//If there is a winner, print a message and break the loop.
  			if (win == true) {b.printBoard(); System.out.println( p.getPlayer() + " is the Winner!"); break;}
  			//If the board is full and no more moves are possible print a message and break the loop.
			if (b.isBoardFull()) {b.printBoard(); System.out.println("Tie Game!"); break;}
			p.togglePlayer(numPlayers);
		}		

	}
	
	public static void printInstructions() {
		/**
		 * Prints the details of the game to the users.
		 */
		System.out.println("Tic Tac Toe 2.0");
		System.out.println("Instructions: Tic Tac Toe 2.0 is a game for 2-6 Players.");
		System.out.println("Instead of a 3x3 board, the board is an (n+1)x(n+1) "
				+ "board \nwhere 'n' is the number of players. \nFor example: a 3 player "
				+ "game will use a 4x4 board.\n");
	}

}