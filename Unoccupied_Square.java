package pieces;

import pieces.*;

public class Unoccupied_Square extends Square{
	Unoccupied_Square(int coordinate){
		super(coordinate);
	}

	@Override
	public boolean isOccupied() {
		return false;
	}

	@Override
	public Piece getPiece() {
		return null;
	}
	
	@Override
	public String toString() {
		return "-";
	}
}
