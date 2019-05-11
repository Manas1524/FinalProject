package board;

import pieces.Piece;

public class ImportantMove extends Move{

	public ImportantMove(Board board, Piece piece, int endCoordinate){
		super(board,piece,endCoordinate);
	}
	
	public boolean equals(Object other)
	{
		return this == other || other instanceof ImportantMove && super.equals(other);
	}
	
	public String toString()
	{
		return piece.getPieceType().toString() + BoardFunctionality.getPosition(this.endCoordinate);
	}
}
