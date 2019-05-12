package board;

import board.Board.Builder;
import pieces.Piece;

public abstract class Move {
	public Board board;
	public Piece piece;
	public final int endCoordinate;
	public boolean firstMove;
	public static Move WRONG_MOVE = new WrongMove();
	public Move(Board board, Piece piece, int endCoordinate){
		this.board = board;
		this.piece = piece;
		this.endCoordinate = endCoordinate;
		this.firstMove = piece.isFirstMove();
	}
	
	public Move(Board board, int endCoordinate){
		this.board = board;
		this.piece = null;
		this.endCoordinate = endCoordinate;
		this.firstMove = false;
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
	
	public int calculateCode()
	{
		int code = 1;
		code = 31 * code + this.endCoordinate;
		code = 31 * code + this.piece.calculateCode();
		code = 31 * code + this.piece.getPosition();
		return code;
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
	
	public boolean equals(Object other)
	{
		if(this == other)
		{
			return true;
		}
		
		if(!(other instanceof Move))
		{
			return false;
		}
		Move otherMove = (Move) other;
		return getEndCoordinate() == otherMove.getEndCoordinate() && getPiece().equals(otherMove.getPiece()) && getStartCoordinate() == otherMove.getStartCoordinate();
	}
	
	public Board run()
	{
		Builder b = new Builder();
		for(Piece p : this.board.currentPlayer().getAlivePieces())
		{
			
			if(!this.piece.equals(p))
			{
				b.setPieceAtSquare(p);
			}
		}
		for(Piece p : this.board.currentPlayer().getEnemy().getAlivePieces())
		{
			b.setPieceAtSquare(p);
		}
		b.setPieceAtSquare(this.piece.movePiece(this));
		b.setMove(this.board.currentPlayer().getEnemy().getTeam());
		return b.build();
	}

	public int getStartCoordinate() {
		return this.getPiece().getPosition();
	}

	public static Move getWRONG_MOVE() {
		return WRONG_MOVE;
	}

}
