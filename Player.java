/**
 * Player class creates an object for each player of the game.
 * A static array holds a set of char representing players 1-6.
 * A static integer initialized to 0 holds the current players turn.
 * A function will repeatedly iterate this static integer from 0-5.
 * @author Tommy
 *
 */
public class Player {

	private static char players[] = {'1','2','3','4','5','6'};
	private static int playerTurn = 0;

	public Player() {
		/**
		 * Default Constructor
		 */
	}

	public void togglePlayer(int numPlayers) {
		/**
		 * Function will iterate the static variable playerTurn.
		 * @param numPlayers integer
		 * 
		 * playerTurn will initialize to zero. togglePlayer() will increment this
		 * static variable by +1 until a value of numPlayers is reached. 
		 * The next iteration will reset the static variable to zero.
		 * 
		 * First check if the static variable is equal to numPlayers, if it is change it to zero.
		 * If not, increment the static variable by 1.
		 */
		if (playerTurn == numPlayers-1) {playerTurn = 0;}
		else playerTurn++;
	}
	
	public char getPlayerName(int playerNumber) {
		/**
		 * Returns the char of the player at the passed through index.
		 */
		return players[playerNumber];
	}
	
	public void setPlayerName(int playerNumber, char name) {
		/**
		 * Reads two parameters, the player number and a character.
		 * Sets the passed through player's name to the passed through char. 
		 */
		players[playerNumber] = name;
	}

	public char getPlayer() {
		/**
		 * Returns the name of the player whose turn it is.
		 */
		return players[playerTurn];
	}
		
	public static int getNextPlayerTurn() {
		/**
		 * Return the number of the player whose turn it is.
		 */
		return playerTurn;
	}

}