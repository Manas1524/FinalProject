package Board;

import Pieces.Piece;

public class Occupied_Square extends Square{
	private Piece pieceOnSquare;
	Occupied_Square(int coordinate, Piece squarePiece){
		super(coordinate);
		pieceOnSquare = squarePiece;
		
	}

	@Override
	public boolean isOccupied() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Piece getPiece() {
		// TODO Auto-generated method stub
		return pieceOnSquare;
	}
	
}
