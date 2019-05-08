package pieces;

import java.util.ArrayList;

//import Board.Move;
import UI.Gameboard;
import board.*;

public abstract class Piece {
	private int position;
	private Team pieceTeam;
	private boolean isFirstMove;
	
	Piece(int position, Team color){
		this.position = position;
		this.pieceTeam = color;
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
	
	public enum PieceType {
		
		PAWN("P"),
		KNIGHT("N"),
		BISHOP("B"),
		ROOK("R"),
		QUEEN("Q"),
		KING("K");
		
		PieceType(String pieceName){
			this.pieceName = pieceName;
		}
		
	}
}
