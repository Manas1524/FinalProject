package board;

import pieces.*;

public class QueenCastle extends Castle{
	public QueenCastle(Board board, Piece piece, int endCoordinate, Rook rook, int rookStartCoordinate, int rookEndCoordinate){
		super(board,piece,endCoordinate, rook, rookStartCoordinate, rookEndCoordinate);
	}
	public String toString() {
		return "O-O-O";
	}
}
