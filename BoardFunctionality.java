package pieces;

/**
 * All methods/variables are static so they can be used in other classes without instantiating the object
 *
 */
public class BoardFunctionality {
	
	//This class cannot be instantiated, so all the variables must be public in order for us to use them in other classes
	
	public static boolean[] file1 = createFile(0);
	public static boolean[] file2 = createFile(1);
	public static boolean[] file7 = createFile(6);
	public static boolean[] file8 = createFile(7);
	
	//Number is the square that begins the row
	public static boolean[] rank2 = createRank(8);
	public static boolean[] rank7 = createRank(48);
	
	public static final int SQUARE_AMOUNT = 64;
	public static final int SQUARES_PER_ROW = 8;
	
	/**
	 * 
	 * @throws RuntimeException - This method cannot be instantiated
	 */
	public BoardFunctionality() throws RuntimeException{
		System.out.println("Cannot Instantiate");
	}
	
	/**
	 * Checks if the square the piece can move to is actually on the board or not
	 * @param coordinate - The potential coordinate  
	 * @return whether or not the square is in the chess board
	 */
	public static boolean isValidCoordinate(int coordinate) {
		//If the square exists on the board
		if(coordinate >= 0 && coordinate <= 64) {		
			return true;
		}	
		return false;
	}
	
	public static boolean[] createFile(int columnNumber) {
		boolean[] file = new boolean[SQUARES_PER_ROW];
		
		do {
			file[columnNumber] = true;
			columnNumber += SQUARES_PER_ROW;
		}
		while(columnNumber < SQUARES_PER_ROW);
			return file;
	}
	
	public static boolean[] createRank(int rowNumber) {
		boolean[] rank = new boolean[SQUARES_PER_ROW];
		
		do {
			rank[rowNumber] = true;
			rowNumber ++;
		}
		while(rowNumber % SQUARES_PER_ROW != 0);
			return rank;
	}
}
