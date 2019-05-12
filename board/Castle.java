package board;

import pieces.Piece;

public abstract class Castle extends Move{
	public Castle(Board board, Piece piece, int endCoordinate){
		super(board,piece,endCoordinate);
	}
}
