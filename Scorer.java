/**
 * The Scorer class creates an object that reads Board Class objects and
 * determines whether a winning condition has been satisfied.
 * 
 * Four primary methods all that return Boolean values:
 * 		First method checks diagonals on the board. Returns true if 3 adjacent diagonal
 * 		squares contain values that are equal to each other.
 * 		Second method checks horizontal on the board. Returns true if 3 adjacent horizontal
 * 		squares contain values that are equal to each other.
 * 		Third method checks verticals on the board. Returns true if 3 adjacent vertical squares
 * 		contain values that are equal to each other.
 * 
 * 		One condition to the above three methods is that the equivalent value found cannot
 * 		be the defaultChar of the board object being checked.
 * 
 * 		The fourth method uses the first three methods to determine if any of the 3 winning
 * 		conditions have been satisfied.
 * @author Tommy
 *
 */
public class Scorer {

	public Boolean checkDiagonals(Board b) {
		//The nested for loops will sweep through the board along diagonals in both directions.
		//First nested loop counts the \ diagonals.
		for (int col = 0; col < b.getBoardSize() - 2; col ++) {
			for(int row = 0; row < b.getBoardSize() - 2; row++) {
				//First check that the piece is not the default char.
				if(b.getPiece(row, col) != b.getDefaultChar()) {
					//Now look for a match to the lower right.
					if (b.getPiece(row, col) == b.getPiece(row + 1, col + 1)) {
						//If a match is found, then look to the next lower right for another match.
						if (b.getPiece(row + 1, col + 1) == b.getPiece(row + 2, col + 2)) {
							return true;
						}
					}					
				}				
			}
		}

		//This nested loop counts the / diagonals
		for (int col = 2; col < b.getBoardSize(); col ++) {
			for(int row = 0; row < b.getBoardSize() - 2; row ++) {
				//First check that the piece is not the default char.
				if(b.getPiece(row, col) != b.getDefaultChar()) {
					//Now look for a match to the lower right.
					if (b.getPiece(row, col) == b.getPiece(row + 1, col - 1)) {
						//If a match is found, then look to the next lower right for another match.
						if (b.getPiece(row + 1, col - 1) == b.getPiece(row + 2, col - 2)) {
							return true;
						}
					}					
				}				
			}
		}

		return false;
	}
	
	
	public Boolean checkHorizontalRows(Board b) {
		//The nested for loop will iterate through the board, row by row.
		//The loop is looking for 3 consecutive matching values.
		//Since we 
		for (int rowNumber = 0; rowNumber < b.getBoardSize(); rowNumber++) {
			for (int colNumber = 0; colNumber < b.getBoardSize() - 2; colNumber++) {
				//Run a sequence of conditional checks.
				//First check that the initial square (0,0) is not the default char.
				if(b.getPiece(rowNumber, colNumber) != b.getDefaultChar()) {
					//Secondly check if initial square matches it's next adjacent square.
					if (b.getPiece(rowNumber, colNumber) == b.getPiece(rowNumber, colNumber + 1)) {
						//If a match is found, then check if the adjacent for the next adjacent match.
						if (b.getPiece(rowNumber, colNumber + 1) == b.getPiece(rowNumber, colNumber + 2)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public Boolean checkVerticalColumns(Board b) {
		//The nested for loop will iterate through the board, column by column.
		//The loop is looking for 3 consecutive matching values.
		
		for (int colNumber = 0; colNumber < b.getBoardSize(); colNumber ++) {
			for (int rowNumber = 0; rowNumber < b.getBoardSize() - 2; rowNumber ++) {
				//Run a sequence of conditional checks.
				//First check the initial square (0,0) is not the default char.
				if(b.getPiece(rowNumber, colNumber) != b.getDefaultChar()) {
					//Secondly check if initial square matches it's adjacent next square.
					if(b.getPiece(rowNumber, colNumber) == b.getPiece(rowNumber + 1, colNumber)) {
						//If a match is found, then check if the adjacent square matches its next adjacent square.
						if (b.getPiece(rowNumber + 1, colNumber) == b.getPiece(rowNumber + 2, colNumber)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public Boolean checkWin(Board b) {
		//Run all of the above methods to check the verticals, horizontals, and diagonals for a matching of
		//three in a row. Return true if one of the checks passes.
		
		//if (efficientWinCheck(b) == true) {return true;} 
		if (checkDiagonals(b) == true) {return true;}
		if (checkVerticalColumns(b) == true) {return true;}
		if (checkHorizontalRows(b) == true) {return true;}
		
		//If none of the checks pass return false.
		return false;
	}

	
	

	/** INCOMPLETE (NOT WORKING) METHOD
	 * The following method was an attempt at a more efficient way of determining the winner
	 * of the game by only using the last piece placed on the board as a reference for which
	 * squares to check for equivalence. I was not able to get this method to work properly
	 * since I was having issues with pieces that were placed close to or on the edge of the
	 * board. 
	 * @param b
	 * @return
	 */
	public Boolean efficientWinCheck(Board b) {
		/**
		 * 		Check the last piece placed on the board and see if it completes a sequence of 3 adjacent squares.
		 * 
		 * 		First check if the piece is on the edge of the board (0).
		 * 		If not, check if its adjacent to the edge (1).
		 * 
		 * Reference diagrams:
		 * 
		 * 				  6              5            4         3       2
		 * 			0|0|0|0|0|0|0	0|0|0|0|0|0   0|0|0|0|0  0|0|0|0  0|0|0	
		 * 			0|1|1|1|1|1|0	0|1|1|1|1|0	  0|1|1|1|0  0|1|1|0  0|1|0
		 * 			0|1|2|2|2|1|0	0|1|2|2|1|0   0|1|2|1|0  0|1|1|0  0|0|0
		 * 			0|1|2|2|2|1|0	0|1|2|2|1|0   0|1|1|1|0  0|0|0|0
		 * 			0|1|2|2|2|1|0	0|1|1|1|1|0   0|0|0|0|0
		 * 			0|1|1|1|1|1|0	0|0|0|0|0|0
		 * 			0|0|0|0|0|0|0
		 * 
		 * 		If piece is placed in the (0) region, count twice inward.
		 * 		If piece is placed in the (1) region, count either A:(one out, one in) or B:(twice inward).
		 * 		**Note the special case for the 2 player grid if piece is at (1) we only count once in and once out.
		 */
		
		int row = b.getMostRecentMoveRow();
		int col = b.getMostRecentMoveCol();
		
		//The region (0) case from above.
		if ((row == 0 | row == b.getBoardSize()) && (col == 0 | col == b.getBoardSize())) {
			
			//Starting with the top (0) row.
			if (row == 0) {
				
				//First check for 3 matching going down the columns of the row.
				if (b.getPiece(row, col) == b.getPiece(row + 1, col) && (b.getPiece(row + 1, col) == b.getPiece(row + 2, col))) {
					return true;
				}
				
				//Next check across the row. Starting with the corners. We can also check the corner diagonals here.
				else if (col == 0 | col == b.getBoardSize()) {
					if (col == 0) {
						if (b.getPiece(row, col) == b.getPiece(row, col + 1) && b.getPiece(row, col + 1) == b.getPiece(row, col + 2)) {
							return true;
						}
						else if (b.getPiece(row, col) == b.getPiece(row + 1, col + 1) && b.getPiece(row + 1, col + 1) == b.getPiece(row + 2, col + 2)) {
							return true;
						}
					}
					else if (col == b.getBoardSize()) {
						if (b.getPiece(row, col) == b.getPiece(row, col - 1) && b.getPiece(row, col - 1) == b.getPiece(row, col - 2)) {
							return true;
						}						
						else if (b.getPiece(row, col) == b.getPiece(row - 1, col - 1) && b.getPiece(row - 1, col - 1) == b.getPiece(row - 2, col - 2)) {
							return true;
						}
					}
				}
			}
			

			else if (row == b.getBoardSize()) {
				
			}
		}
		/*
		else if ((row == 1 | row == b.getBoardSize() - 1) && (col == 1 | col == b.getBoardSize() - 1)) {
			//The region (1) case from above.
		}
		
		else if ((row == 2 | row == b.getBoardSize() - 2) && (col == 2 | col == b.getBoardSize() - 2)) {
			
		}
		
		else if ((row > 2 | row < b.getBoardSize() - 2) && (col > 2 | col < b.getBoardSize() - 2)) {
			
		}
		*/
		return false;
	}
	
}