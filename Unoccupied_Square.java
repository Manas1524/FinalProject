package pieces;

import pieces.Piece;

public class Unoccupied_Square extends Square{
	Unoccupied_Square(int coordinate){
		super(coordinate);
	}

	@Override
	public boolean isOccupied() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Piece getPiece() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
