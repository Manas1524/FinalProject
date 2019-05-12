package player;

import pieces.Piece;
import pieces.*;
import board.*;
import java.util.*;

public abstract class Player {

	protected Board board;
	protected King playerKing;
	protected ArrayList<Move> legalMoves;
	private boolean inCheck;
	
	public Player(Board board, ArrayList<Move> legalMoves, ArrayList<Move> enemyMoves) {
		this.board = board;
		this.playerKing = createKing();
		this.legalMoves = legalMoves;
		//Pass in king's current squares and the enemy's possible moves - if the enemy can move to the king's square, it's in check
		//If the list isn't empty, the king is in check
		this.inCheck = !Player.getAttackOnSquare(this.playerKing.getPosition(), enemyMoves).isEmpty();
	}

	private static ArrayList<Move> getAttackOnSquare(int position, ArrayList<Move> moves) {
		ArrayList<Move> attackingMoves = new ArrayList<Move>();
		for(Move move: moves) {
			if(position == move.getEndCoordinate())
				attackingMoves.add(move);
		}
		return attackingMoves;
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
	
	public boolean isLegalMove(Move m) {
		return this.legalMoves.contains(m);
	}
	
	public boolean inCheck() {
		return this.inCheck;
	}

	public boolean inCheckMate() {
		return this.inCheck && !hasEscapeMoves();
	}
	
	public boolean inStaleMate() {
		return this.inCheck && !hasEscapeMoves();
	}
	
	public boolean hasEscapeMoves() {
		//Makes these moves on an imaginary board
		//If the moves are possible, then actually do the move on the real board
		//Only if king is in check mate
		for(Move move: this.legalMoves) {
			MoveTransition transition = makeMove(move);
			if(transition.getMoveStatus().isDone()) {
				return true;
			}
		}
		return false;
	}

	public boolean isCastled() {
		return false;
	}
	
	public MoveTransition makeMove(Move move) {
		if(isLegalMove(move)) {
			return new MoveTransition(this.board, move, MoveStatus.ILLEGAL_MOVE);
		}
		//If illegal, make new board
		Board transitionBoard = move.doMove();
		
		ArrayList<Move> kingAttack = Player.getAttackOnSquare(transitionBoard.currentPlayer().getEnemy().getPlayerKing().getPosition(),
															  transitionBoard.currentPlayer().getLegalMoves());
		
		if(kingAttack.isEmpty() == false) {
			return new MoveTransition(this.board, move, MoveStatus.PLAYER_LEFT_IN_CHECK);
		}
		return new MoveTransition(transitionBoard, move, MoveStatus.DONE);
	}
	
	public King getPlayerKing() {
		return this.playerKing;
	}
	
	public ArrayList<Move> getLegalMoves() {
		return this.legalMoves;
	}
	
	public abstract ArrayList<Piece> getAlivePieces();
	public abstract Team getTeam();
	public abstract Player getEnemy();
}
