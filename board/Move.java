package board;

import pieces.Piece;

public abstract class Move {
	final Board board;
	final Piece piece;
	final int endCoordinate;
	
	public Move(Board board, Piece piece, int endCoordinate){
		this.board = board;
		this.piece = piece;
		this.endCoordinate = endCoordinate;
	}
	
	public abstract Board doMove();
}
