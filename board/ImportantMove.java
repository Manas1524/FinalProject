package board;

import board.Board.Builder;
import pieces.Piece;

public class ImportantMove extends Move{

	public ImportantMove(Board board, Piece piece, int endCoordinate){
		super(board,piece,endCoordinate);
	}
	
	@Override
	public Board doMove() {
		// TODO Auto-generated method stub
		Builder builder = new Builder();
		
		for(Piece piece: this.board.currentPlayer().getActivePieces) {
			if(this.piece.equals(piece)) {
				builder.setPieceAtSquare(piece);
			}
		}
		
		for(Piece piece: this.board.currentPlayer().getOpponent().getActivePieces()) {
			builder.setPieceAtSquare(piece);
		}
		
		builder.setPieceAtSquare(null);
		builder.setMoveMaker(this.board.currentPlayer().getOpponent().getAlliance());
		
		return builder.build();
	}
	
	public boolean equals(Object other)
	{
		return this == other || other instanceof ImportantMove && super.equals(other);
	}
	
	public String toString()
	{
		return piece.getPieceType().toString() + BoardFunctionality.getPosition(this.endCoordinate);
	}
	
	@Override
	public Board execute() {
		return null;
	}
}
