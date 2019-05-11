package board;

import pieces.Piece;

public class AttackingMove extends Move {
	
	private final Piece capturedPiece;
	
	public AttackingMove(Board board, Piece piece, int endCoordinate, Piece capturedPiece){
		super(board,piece,endCoordinate);
		this.capturedPiece = capturedPiece;
	}
	@Override
	public Board doMove() {
		// TODO Auto-generated method stub
		return null;
	}
}
