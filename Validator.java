import java.util.Scanner;

/**
 * Validator class validates all the user input that will used throughout the game. Contains three static methods.
 * 	First method is used to ensure that the user enters the correct number of players.
 * 	Second method is used to ensure that the user enters characters for the player's names.
 * 	Third method is used to ensure that the users enter correct integers for their moves. 
 * @author Tommy
 */
public class Validator {
	
	public static int validatePlayerCount(int min, int max) {
		/**
		 * Takes two parameters representing the minimum and maximum amount of players
		 * for the game.
		 * If the user enters a number that doesn't fit the range, or doesn't enter a 
		 * number at all then we want them to continue to enter values until they
		 * enter a number that fits the required parameters.
		 * 
		 * Create a Scanner object to handle input.
		 * Create a do while loop and prompt the user to enter a number. Have the 
		 * condition be that the number fits a range.
		 * Catch any input values that aren't numbers and print out an error message.
		 */
		Scanner input = new Scanner(System.in);
		int number = 0;		
		Boolean done = false;

		do {

			try {
				/**
				 * Prompt the user to input a number between 2 and 6.
				 * If the user enters anything other than an integer, continue to prompt
				 * them until an integer is entered. Once an integer has been entered,
				 * check that it is within the required min, max range. If it is within
				 * the range break the loop and return the number.
				 */
				System.out.println("Select between 2-6 players.");
				while(!input.hasNextInt()){
					System.out.println("Invalid Input");
					input.next();
				}
				number = input.nextInt();
				if (number >= min && number <= max) {
					done = true;
				}
			}

			catch (Exception e) {
				/**
				 * Catch all exception errors and return an input error message.
				 */
				System.out.println("Input Error.");
			}

		} while (done == false);

		return number;		
	}

	public static char validatePlayerName(Board b, Player p) {
		/**
		 * Method takes in two parameters for a board object and a player object. From the board
		 * object we pull the number of players on the board. From the player object we set the
		 * player names to user input using a Scanner object. Use a do while loop to continuously prompt
		 * the user to enter values until the desired values for player names are set. 
		 * 
		 */
		Scanner inputName = new Scanner(System.in);
		char temp = ' '; // temp will hold the character that is being checked.
		Boolean done = false; // parameter to break the try-catch-loop if conditions are met.

		do {

			try {
				/**
				 * Prompt the user to enter a name by choosing a character. Allow them to use symbols
				 * if they want. Verify that what they input through the Scanner is a character. If the
				 * user inputs a character then check the rest of the player object to verify that they
				 * have not picked a character that is already in use.
				 */
				System.out.println("Player " + (Player.getNextPlayerTurn() + 1) + ":");
				System.out.println("Enter your name by choosing one character(letter or symbol).\n"
						+ "If more than one character is entered, the first character will be used.");
				temp = inputName.next().charAt(0);
				int count = 0; // This will be used to determine duplicate names.
				//Loop through the player object and count how many duplicate names.
				for (int i = 0; i < b.getNumOfPlayers(); i++) {
					if (temp == p.getPlayerName(i)) {
						count++;
					}
				}
				//If the count of duplicates is zero we can toggle to the next player and break the loop.
				if (count == 0) {p.togglePlayer(b.getNumOfPlayers()); break;}
			}

			catch (Exception e) {
				/**
				 * Catch all exception errors and re-prompt the user to enter an appropriate value.
				 */
				System.out.println("That is not a valid input. "
						+ "Please enter a single character for you name.");
			}
			
		} while (done == false);
		
		return temp;
	}
	
	public static void validateMove(int min, int max, Board b, Player p) {
		/**
		 * Method takes in parameters for a board object, a player object, and two integers representing
		 * the range of a legal move which prevents out of bounds errors. Use a do while loop to prompt
		 * users to enter correct values for their move inputs. The board and player objects give the
		 * player and position data necessary to perform the move checks.
		 */
		Scanner playerMove = new Scanner(System.in); //Read in the user's desired move.
		int rowCheck = 0; //Used to perform a check.
		int colCheck = 0; //Used to perform a check.
		Boolean done = false; //Used to break the do while loop when conditions are met.

		do {

			try {
				//Ask user to enter a row number. If the user enters anything but an integer
				//then use a while loop to trap them until they enter an integer.
				System.out.println("Enter row number:");
				while(!playerMove.hasNextInt()) {
					System.out.println("That won't work. Try a number on the board.");
					playerMove.next();
				}
				//When an integer is entered assign it to the rowCheck variable.
				rowCheck = playerMove.nextInt();
				
				//Ask user to enter a column number. As above use a while loop to get until an int is received.
				System.out.println("Enter column number:");
				while(!playerMove.hasNextInt()) {
					System.out.println("Hmmmmm. Try a number on the board instead.");
					playerMove.next();
				}
				//Assign the integer to the colCheck variable.
				colCheck = playerMove.nextInt();
				
				//Now check that the user's desired move is a valid move.
				if ((rowCheck >= min && rowCheck <= max) && (colCheck >= min && colCheck <= max)) {
					//Verify that the square is empty and available for the move.
					if (b.getPiece(rowCheck-1, colCheck-1) == ' ') {
						b.setPiece(rowCheck, colCheck, p.getPlayer());
						System.out.println("Nice move!");
						done = true;
					}
					//If the square is occupied tell the user to try a different move.
					else System.out.println("That space is occupied. Try again.");
				}
				//If the square is out of bounds tell the user to choose a different square within the board.
				else System.out.println("The square you have chosen does not exist. Select a row and column from (1-" + b.getBoardSize() + ")");
			}

			catch (Exception e) {
				//Catch all exception errors and tell the user to pick another square.
				System.out.println("The square you chose does not exist. Let's try this again!.");
			}

		} while (done == false);

	}
	
}