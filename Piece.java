package pieces;

import java.util.ArrayList;

//import Board.Move;
import UI.Gameboard;
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
		return this.isFirstMove;
	}
	
	public abstract Piece movePiece(Move move);
	
	public enum PieceType {
		
		PAWN("P"),
		KNIGHT("N"),
		BISHOP("B"),
		ROOK("R"),
		QUEEN("Q"),
		KING("K");
		String pieceName;
		PieceType(String pieceName){
			this.pieceName = pieceName;
		}
		
	}
	
	public int calculateCode()
	{
		int code = pieceType.hashCode();
		code = 31 * code + pieceTeam.hashCode();
		code = 31 * code + position;
		code = 31 * code + (isFirstMove ? 1:0);
		return code;
	}
}
