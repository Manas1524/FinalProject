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
	
	public boolean isAttackingMove() {
		return true;
	}

	public Piece getCapturedPiece() {
		return this.capturedPiece;
	}
	
	public int hashCode() {
		return this.capturedPiece.hashCode() + super.hashCode();
	}
	
	public boolean equals(final Object a) {
		if(this == a) {
			return true;
		}
		if(!(a instanceof AttackingMove)) {
			return false;
		}
		AttackingMove otherAttackingMove = (AttackingMove)a;
		return super.equals(otherAttackingMove) && getCapturedPiece().equals(otherAttackingMove.getCapturedPiece());
	}
}
