package pieces;

import java.util.ArrayList;

//import Board.Move;
import UI.*;
import board.*;

public abstract class Piece {
	private int position;
	private Team pieceTeam;
	private boolean firstMove;
	private PieceType pieceType;
	private int code;
	
	Piece(PieceType pieceType, int position, Team color, boolean firstMove){
		this.position = position;
		this.pieceTeam = color;
		this.pieceType = pieceType;
		this.firstMove = firstMove;
		this.code = calculateCode();
	}
	
	public Team getTeam() {
		return this.pieceTeam;
	}
	
	public abstract ArrayList<Move> legalMoves(Board board);

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @return the pieceTeam
	 */
	public Team getPieceTeam() {
		return pieceTeam;
	}
	
	/**
	 * @return isFirstMove
	 */
	public boolean isFirstMove() {
		return this.firstMove;
	}
	
	public abstract Piece movePiece(Move move);
	
	public enum PieceType {
		
		PAWN("P") {
			@Override
			public boolean isKing() {
				return false;
			}

			@Override
			public boolean isRook() {
				return false;
			}
		},
		KNIGHT("N") {
			@Override
			public boolean isKing() {		
				return false;
			}

			@Override
			public boolean isRook() {
				return false;
			}
		},
		BISHOP("B") {
			@Override
			public boolean isKing() {			
				return false;
			}

			@Override
			public boolean isRook() {
				return false;
			}
		},
		ROOK("R") {
			@Override
			public boolean isKing() {			
				return false;
			}

			@Override
			public boolean isRook() {
				return true;
			}
		},
		QUEEN("Q") {
			@Override
			public boolean isKing() {			
				return false;
			}

			@Override
			public boolean isRook() {
				return false;
			}
		},
		KING("K") {
			@Override
			public boolean isKing() {
				return true;
			}

			@Override
			public boolean isRook() {
				return false;
			}
		};
		String pieceName;
		PieceType(String pieceName){
			this.pieceName = pieceName;
		}
		
		public abstract boolean isKing();
		public abstract boolean isRook();
	}
	
	public int calculateCode()
	{
		int code = pieceType.hashCode();
		code = 31 * code + pieceTeam.hashCode();
		code = 31 * code + position;
		code = 31 * code + (isFirstMove() ? 1:0);
		return code;
	}
	
	public boolean equals(Object a) {
		if(this == a) {
			return true;
		}
		if(!(a instanceof Piece)){
			return false;
		}
		Piece otherPiece = (Piece)a;
		return position == otherPiece.getPosition() && pieceType == otherPiece.getPieceType() && pieceTeam == otherPiece.getTeam() && isFirstMove() == otherPiece.isFirstMove();
	}
	public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setPieceTeam(Team pieceTeam) {
		this.pieceTeam = pieceTeam;
	}

	public void setFirstMove(boolean firstMove) {
		this.firstMove = firstMove;
	}
}
