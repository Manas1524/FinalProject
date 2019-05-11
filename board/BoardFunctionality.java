package board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pieces.*;

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
	public static boolean[] rank1 = createRank(0);
	public static boolean[] rank2 = createRank(8);
	public static boolean[] rank3 = createRank(16);
	public static boolean[] rank4 = createRank(24);
	public static boolean[] rank5 = createRank(32);
	public static boolean[] rank6 = createRank(40);
	public static boolean[] rank7 = createRank(48);
	public static boolean[] rank8 = createRank(56);
	
	public static final int SQUARE_AMOUNT = 64;
	public static final int SQUARES_PER_ROW = 8;
	
	public final ArrayList<String> ALGEBRAIC_NOTATION = makeAlgebreicNotation();
	public final Map<String, Integer> POSITION_TO_COORDINATE = initializePositionToCoordinateMap();
	public static final int START_TILE_INDEX = 0;
    public static final int NUM_TILES_PER_ROW = 8;
    public static final int NUM_TILES = 64;
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
	
	private Map<String, Integer> initializePositionToCoordinateMap() {
        final Map<String, Integer> positionToCoordinate = new HashMap<>();
        for (int i = START_TILE_INDEX; i < NUM_TILES; i++) {
            positionToCoordinate.put(ALGEBRAIC_NOTATION.get(i), i);
        }
        return positionToCoordinate;
    }
	
	public static int getCoordinate(String position)
	{
		return makePositionMap().get(position);
	}
	
	public int getCoordinateAtPosition(final String position) {
        return POSITION_TO_COORDINATE.get(position);
    }
	
	public static int getPosition(int coordinate)
	{
		return makeAlgebreicNotation().initializePositionToCoordinateMap();
	}
	
	 private static ArrayList<String> makeAlgebreicNotation() {
	        ArrayList<String> notationList = new ArrayList<String>();
	        String[] notation = {
	                "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
	                "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
	                "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
	                "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
	                "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
	                "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
	                "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
	                "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"
	        };
	        
	        for(String temp: notation) {
	        	notationList.add(temp);
	        }
	        return notationList;
	    }
	 
	public static boolean isEndGame(final Board board) {
        return board.currentPlayer().inCheckMate() ||
               board.currentPlayer().inStaleMate();
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
