/**
 * Game class contains the main method.
 * Creates an object of the TicTacToe class.
 * @author Tommy
 *
 */
public class Game {
		
	public static void main(String[] args) {
		TicTacToe.printInstructions(); //Print the instructions.
		TicTacToe game = new TicTacToe(Validator.validatePlayerCount(2, 6)); //Setup game.
		game.play(); //Play game.

	}

}