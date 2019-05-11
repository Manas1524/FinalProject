package board;

import pieces.Piece;

public class PawnAttackingMove extends AttackingMove{

	public PawnAttackingMove(Board board, Piece piece, int endCoordinate, Piece capturedPiece){
		super(board,piece,endCoordinate,capturedPiece);
	}

}
