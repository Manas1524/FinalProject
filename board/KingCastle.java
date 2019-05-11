package board;

import pieces.Piece;
import pieces.Rook;

public class KingCastle extends Castle{
	public KingCastle(Board board, Piece piece, int endCoordinate, Rook rook, int rookStartCoordinate, int rookEndCoordinate){
		super(board,piece,endCoordinate, rook, rookStartCoordinate, rookEndCoordinate);
	}
	
	public String toString() {
		return "O-O";
	}
}
