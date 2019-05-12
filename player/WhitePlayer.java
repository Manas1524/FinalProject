package player;

import pieces.Piece;
import board.*;
import pieces.*;
import java.util.*;

public class WhitePlayer extends Player {
	private Board board;
	private ArrayList<Move> standardWhiteMoves;
	private ArrayList<Move> standardBlackMoves;
	
	public WhitePlayer(Board board, ArrayList<Move> standardWhiteMoves, ArrayList<Move> standardBlackMoves) {
		super(board, standardWhiteMoves, standardBlackMoves);
		this.board = board;
		this.standardWhiteMoves = standardWhiteMoves;
		this.standardBlackMoves = standardBlackMoves;
	}

	@Override
	public ArrayList<Piece> getAlivePieces() {
		return this.board.getWhitePieces();
	}

	@Override
	public Team getTeam() {
		return Team.WHITE;
	}

	@Override
	public Player getEnemy() {
		return this.board.blackPlayer();
	}

}