package Board;
import java.util.*;
import Pieces.Piece;

public abstract class Square {
	
	int squareCoordinate;
	
	private static final Map<Integer, Unoccupied_Square> EMPTY_SQUARES_CACHE = createAllEmptySquares();
	
	Square(int coordinate){
		squareCoordinate = coordinate;
	}
	


	private static Map<Integer, Unoccupied_Square> createAllEmptySquares() {
		// TODO Auto-generated method stub
		Map<Integer, Unoccupied_Square> unoccupiedSquares = new HashMap<>();
		for(int i = 0; i < 64; i++) {
			unoccupiedSquares.put(i, new Unoccupied_Square(i));
		}
		return unoccupiedSquares;
	}



	public abstract boolean isOccupied();
	public abstract Piece getPiece();
}
