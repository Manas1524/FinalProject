package pieces;

import pieces.*;

public class Occupied_Square extends Square{
	private Piece pieceOnSquare;
	public Occupied_Square(int coordinate, Piece squarePiece){
		super(coordinate);
		pieceOnSquare = squarePiece;
		
	}

	@Override
	public boolean isOccupied() {
		return true;
	}

	@Override
	public Piece getPiece() {
		return this.pieceOnSquare;
	}
	
	@Override
	public String toString() {
		return getPiece().getPieceTeam().isBlack() ? getPiece().toString().toLowerCase() : getPiece().toString();
	}
	
}
