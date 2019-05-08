package pieces;

/**
 * All methods/variables are static so they can be used in other classes without instantiating the object
 *
 */
public class BoardFunctionality {
	
	//This class cannot be instantiated, so all the variables must be public in order for us to use them in other classes
	
	public static boolean[] file1 = fillFileArrays(0);
	public static boolean[] file2 = fillFileArrays(1);
	public static boolean[] file7 = fillFileArrays(6);
	public static boolean[] file8 = fillFileArrays(7);
	
	public static boolean[] rank1 = fillRankArrays(0);
	public static boolean[] rank2 = fillRankArrays(8);
	public static boolean[] rank3 = fillRankArrays(16);
	public static boolean[] rank4 = fillRankArrays(24);
	public static boolean[] rank5 = fillRankArrays(32);
	public static boolean[] rank6 = fillRankArrays(40);
	public static boolean[] rank7 = fillRankArrays(48);
	public static boolean[] rank8 = fillRankArrays(56);
	
	public static int squareAmount = 64;
	public static int squaresPerRow = 8;
	
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
	
	public static boolean[] fillFileArrays(int columnNumber) {
		boolean[] file = new boolean[squareAmount];
		
		do {
			file[columnNumber] = true;
			columnNumber += squaresPerRow;
		}
		while(columnNumber < squaresPerRow);
			return file;
	}
}
