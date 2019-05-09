package player;

import pieces.*;
import board.*;
import java.util.*;

public class WhitePlayer extends Player {
	
	public WhitePlayer(Board board, ArrayList<Move> standardWhiteMoves, ArrayList<Move> standardBlackMoves) {
		super(board, standardWhiteMoves, standardBlackMoves);
	}

	@Override
	public ArrayList<Piece> getAlivePieces() {
		return this.board.getWhitePieces();
	}
}