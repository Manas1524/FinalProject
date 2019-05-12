package player;

import java.util.ArrayList;

import board.Board;
import board.Move;
import pieces.Piece;
import pieces.Team;
import board.*;

public class BlackPlayer extends Player {
	private Board board;
	private ArrayList<Move> standardWhiteMoves;
	private ArrayList<Move> standardBlackMoves;
	
	public BlackPlayer(Board board, ArrayList<Move> standardWhiteMoves, ArrayList<Move> standardBlackMoves) {
		super(board, standardBlackMoves, standardWhiteMoves);
		this.board = board;
		this.standardWhiteMoves = standardWhiteMoves;
		this.standardBlackMoves = standardBlackMoves;
	}

	@Override
	public ArrayList<Piece> getAlivePieces() {
		return this.board.getBlackPieces();
	}

	@Override
	public Team getTeam() {
		return Team.BLACK;
	}

	@Override
	public Player getEnemy() {
		return this.board.whitePlayer();
	}	
}
