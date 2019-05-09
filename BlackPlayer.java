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
}
