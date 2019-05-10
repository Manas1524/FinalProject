package board;

import pieces.Piece;

public class PawnEnPassant extends AttackingMove {
	public PawnEnPassant(Board board, Piece piece, int endCoordinate, Piece capturedPiece){
		super(board,piece,endCoordinate,capturedPiece);
	}
}
