package player;

import pieces.*;
import board.*;
import java.util.*;

public class BlackPlayer extends Player {

	public BlackPlayer(Board board, ArrayList<Move> standardWhiteMoves, ArrayList<Move> standardBlackMoves) {
		super(board, standardBlackMoves, standardWhiteMoves);
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
