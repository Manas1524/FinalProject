package Board;

import pieces.Piece;

public abstract class Move {
	private final Board board;
	private final Piece piece;
	private final int endCoordinate;
	
	public Move(Board board, Piece piece, int endCoordinate){
		this.board = board;
		this.piece = piece;
		this.endCoordinate = endCoordinate;
	}
	
	public abstract Board doMove();
}
