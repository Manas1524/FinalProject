package board;

import board.Board.Builder;
import pieces.*;

public abstract class Castle extends Move{
	Rook rook;
	int rookStartCoordinate;
	int rookEndCoordinate;
	public Castle(Board board, Piece piece, int endCoordinate, Rook rook, int rookStartCoordinate, int rookEndCoordinate){
		super(board,piece,endCoordinate);
		this.rook = rook;
		this.rookStartCoordinate = rookStartCoordinate;
		this.rookEndCoordinate = rookEndCoordinate;
	}
	
	public Rook getCastleRook() {
		return this.rook;
	}
	
	public boolean isCastlingMove() {
		return true;
	}
	
	public Board doMove() {
		// TODO Auto-generated method stub
		Builder builder = new Builder();
		
		for(Piece piece: this.board.currentPlayer().getActivePieces) {
			if(this.piece.equals(piece) && !this.rook.equals(piece)) {
				builder.setPieceAtSquare(piece);
			}
		}
		
		for(Piece piece: this.board.currentPlayer().getOpponent().getActivePieces()) {
			builder.setPieceAtSquare(piece);
		}
		
		builder.setPieceAtSquare(this.piece.movePiece(this));
		builder.setPieceAtSquare(new Rook(this.getCastleRook().getTeam(), this.rookEndCoordinate, false));
		builder.setMoveMaker(this.board.currentPlayer().getOpponent().getTeam());
		return builder.build();
	}
}
