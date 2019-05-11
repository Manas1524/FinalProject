package player;

import pieces.*;
import board.*;
import java.util.*;

public abstract class Player {

	protected Board board;
	protected King playerKing;
	protected ArrayList<Move> legalMoves;
	
	public Player(Board board, ArrayList<Move> allowedMoves, ArrayList<Move> enemyMoves) {
		this.board = board;
		this.playerKing = createKing();
		this.legalMoves = legalMoves;
	}

	//Makes sure the king is still alive
	private King createKing() {
		for(Piece piece: getAlivePieces()) {
			if(piece.getPieceType().isKing()) {
				return (King) piece;
			}
		}
		throw new RuntimeException("Should not reach here because board doesn't exist anymore");
	}
	//IMPLEMENT LATER
	public boolean isLegalMove(Move m) {
		return this.legalMoves.contains(m);
	}
	
	public boolean inCheck() {
		return false;
	}
	
	public boolean inCheckMate() {
		return false;
	}
	
	public boolean inStaleMate() {
		return false;
	}
	
	public boolean isCastled() {
		return false;
	}
	
	public MoveTransition makeMove() {
		return null;
	}
	
	public abstract ArrayList<Piece> getAlivePieces();
	public abstract Team getTeam();
	public abstract Player getEnemy();
}
