package board;

import pieces.Piece;

public abstract class Move {
	final Board board;
	final Piece piece;
	final int endCoordinate;
	final boolean firstMove;
	
	public Move(Board board, Piece piece, int endCoordinate){
		this.board = board;
		this.piece = piece;
		this.endCoordinate = endCoordinate;
		this.firstMove = piece.isFirstMove();
	}
	
	public Move(Board board, int endCoordinate)
	{
		this.board = board;
		this.endCoordinate = endCoordinate;
		this.piece = null;
		this.firstMove = false;
	}
	
	public abstract Board doMove();
}
