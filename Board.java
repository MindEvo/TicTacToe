/**
 * Class to build a playing board.
 * 
 * Contains member 4 primary member variables and 2 secondary member variables that are
 * to be used in an unfinished method belonging to the Scorer class.
 * 
 * Primary variables are a 2D character array for the board. An integer for the size
 * of the board. A character to represent empty board squares. An integer for the number
 * of players on the board.
 * 
 * @author Tommy
 *
 */
public class Board {

	private char board[][]; //Board layout
	private int boardSize; //Size of the board.
	private char defaultChar = ' '; //Char for the empty squares.
	private int numOfPlayers = 0; //Number of players in the game.

	//The two following variables are to be used for an unfinished method in the Scorer class.
	private int mostRecentMoveRow = 0;
	private int mostRecentMoveCol = 0;

	public Board(int players) {
		/**
		 * The Board constructor takes a parameter for the number of players in the game.
		 * numOfPlayers member variable is set to this parameter. boardSize member variable
		 * is set to the parameter + 1. board array is set to take boardSize as its size for
		 * both indexes. A nested loop fills the board array setting each value within to the
		 * defaultChar member variable.
		 * @param players integer
		 */
		numOfPlayers = players;
		boardSize = players + 1;
		board = new char[boardSize][boardSize];

		for (int row =0; row<boardSize; row++) {
			for (int col =0; col<boardSize; col++) {
				board[row][col] = defaultChar;
			}
		}
	}

	public void setPiece(int row, int col, char player) {
		/**
		 * Standard setter method for adding a piece to the board array.
		 * @param row integer
		 * @param col integer
		 * @param player character
		 */
		board[row-1][col-1] = player;
	}
	
	public char getPiece(int row, int col) {
		/**
		 * Standard getter method for retrieving a piece from the board array.
		 * @param row integer
		 * @param col integer
		 * @return character
		 */
		return board[row][col];
	}
	
	public void removePiece(int row, int col) {
		/**
		 * Method to remove a piece from the board.
		 * This method can be used in conjunction with other methods in the future to add
		 * functionality where the users can play again after a game has concluded.
		 * @param row int
		 * @param col int
		 */
		board[row][col] = defaultChar;
	}
	
	//To be used for an unfinished efficientWinCheck method in the Scorer class.
	public void setMostRecentMoveRow(int row) {
		mostRecentMoveRow= row - 1;
	}
	
	//To be used for an unfinished efficientWinCheck method in the Scorer class.
	public void setMostRecentMoveCol(int col) {
		mostRecentMoveCol= col - 1;
	}

	//To be used for an unfinished efficientWinCheck method in the Scorer class.
	public int getMostRecentMoveRow() {
		return mostRecentMoveRow;
	}
	
	//To be used for an unfinished efficientWinCheck method in the Scorer class.
	public int getMostRecentMoveCol() {
		return mostRecentMoveCol;
	}
	
	public int getBoardSize() {
		/**
		 * Standard getter method for retrieving the size of the board. More
		 * specifically, how many rows and columns exist.
		 * @return int
		 */
		return boardSize;
	}
	
	public int getNumOfPlayers() {
		/**
		 * Standard getter method for retrieving the number of players on the board.
		 * @return int
		 */
		return numOfPlayers;
	}
	
	public char getDefaultChar() {
		/**
		 * Standard getter method for retrieving the defaultChar of the board.
		 * @return char
		 */
		return defaultChar;
	}
	
	public Boolean isBoardFull() {
		/**
		 * Method for determining if all the squares of the board have been taken.
		 * @return
		 * 		A boolean.
		 */
		int emptySpaces = 0;
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				if (board[row][col] == defaultChar) {
					emptySpaces++;
				}
			}
		}
		if (emptySpaces == 0) return true;
		else return false;
	}
	
	public void printBoard() {
		/**
		 * Method for displaying the board.
		 */

		System.out.println();
		int rowNumber = 1, colNumber = 1; // Variables used to print Row/Col numbers along board.

		//Prints the column numbers along the top of the board.
		System.out.print("    ");
		for (int row = 0; row < boardSize; row++) {
			System.out.print("C ");
			colNumber++;
		}
		System.out.println();
		colNumber = 1;
		System.out.print("    ");
		for (int row = 0; row < boardSize; row++) {
			System.out.print(colNumber + " ");
			colNumber++;
		}
		
		//Prints the board, the boundaries, and the row numbers.
		System.out.println(); System.out.println();
		//Outer loop prints out the row numbers.
		for (int row = 0; row<boardSize; row++) {
			System.out.print("R" + rowNumber + "  ");
			rowNumber++;
			//Inner loop prints the board row by row and the boundaries in between.
			for (int col = 0; col <boardSize; col++) {
				System.out.print(board[row][col]);
				//Print the vertical boundary '|' after each index(square) except the last one.
				if (col != boardSize-1) {System.out.print("|");}
			}
			//Print the horizontal boundary '-+' after each row except for the last one.
			if(row != boardSize-1) {
				System.out.println(); System.out.print("    ");
				//Use a loop to print enough of '-+' to create a boundary between rows. Skip
				//the last index.
				//Example: Screen will look like this: -+-+
				for (int i = 0; i <= boardSize - 2; i++) {
					System.out.print("-+");
				}
				//Print this '-' at the last index.
				//Example: Screen will now look like this: -+-+-
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}