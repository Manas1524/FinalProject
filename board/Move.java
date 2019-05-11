package board;

import board.Board.Builder;
import pieces.Piece;

public abstract class Move {
	private Board board;
	public static Piece piece;
	private static int endCoordinate;
	private static Move WRONG_MOVE = new WrongMove();
	public Move(Board board, Piece piece, int endCoordinate){
		this.board = board;
		this.piece = piece;
		this.endCoordinate = endCoordinate;
	}
	
	public Board getBoard() {
		return board;
	}

	public static Piece getPiece() {
		return piece;
	}

	public static int getEndCoordinate() {
		return endCoordinate;
	}
	
	public boolean isAttackingMove() {
		return false;
	}
	
	public boolean isCastlingMove() {
		return false;
	}
	
	public Piece getCapturedPiece() {
		return null;
	}
	
	public int hashCode() { 
		int code = 1;
		code = 31 * code + piece.hashCode();
		code = 31 * code + endCoordinate;
		return code;
	}
	
	public boolean equals(final Object a) {
		if(this == a) {
			return true;
		}
		if(!(a instanceof Move)) {
			return false;
		}
		Move otherMove = (Move)a;
		return this.getStartCoordinate() == otherMove.getStartCoordinate() && this.endCoordinate == otherMove.getEndCoordinate() && getPiece().equals(otherMove.getPiece());
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
		
		builder.setPieceAtSquare(this.piece.movePiece(this));
		builder.setMove(this.board.currentPlayer().getEnemy().getTeam());
		
		return builder.build();
	}

	public int getStartCoordinate() {
		return this.getPiece().getPosition();
	}

	public static Move getWRONG_MOVE() {
		return WRONG_MOVE;
	}
	
}
