package board;

import board.Board.Builder;
import pieces.*;

public class PawnJump extends Move{
	public PawnJump(Board board, Piece piece, int endCoordinate){
		super(board,piece,endCoordinate);
	}
	
	public Board doMove() {
		// TODO Auto-generated method stub
		Builder builder = new Builder();
		
		for(Piece piece: this.board.currentPlayer().getAlivePieces()) {
			if(this.piece.equals(piece)) {
				builder.setPieceAtSquare(piece);
			}
		}
		
		for(Piece piece: this.board.currentPlayer().getEnemy().getAlivePieces()) {
			builder.setPieceAtSquare(piece);
		}
		Pawn movedPawn = (Pawn)this.piece.movePiece(this);
		builder.setPieceAtSquare((movedPawn));
		builder.setEnPassantPawn(movedPawn);
		
		return builder.build();
	}

}
