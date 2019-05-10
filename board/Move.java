package board;

import board.Board.Builder;
import pieces.Piece;

public abstract class Move {
	final Board board;
	final Piece piece;
	final int endCoordinate;
	final static Move WRONG_MOVE = new WrongMove();
	public Move(Board board, Piece piece, int endCoordinate){
		this.board = board;
		this.piece = piece;
		this.endCoordinate = endCoordinate;
	}
	
	public Board getBoard() {
		return board;
	}

	public Piece getPiece() {
		return piece;
	}

	public int getEndCoordinate() {
		return endCoordinate;
	}

	public Board doMove() {
		// TODO Auto-generated method stub
		Builder builder = new Builder();
		
		for(Piece piece: this.board.currentPlayer().getActivePieces) {
			if(this.piece.equals(piece)) {
				builder.setPieceAtSquare(piece);
			}
		}
		
		for(Piece piece: this.board.currentPlayer().getOpponent().getActivePieces()) {
			builder.setPieceAtSquare(piece);
		}
		
		builder.setPieceAtSquare(this.piece.movePiece(this));
		builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
		
		return builder.build();
	}

	public int getStartCoordinate() {
		return this.getPiece().getPosition();
	}

	public static Move getWRONG_MOVE() {
		return WRONG_MOVE;
	}

}
