package pieces;

import board.*;

import java.util.*;

public class Pawn extends Piece {

    private int[] possibleMoves = {8, 16, 7, 9};

    public Pawn(Team team, int position) {
        super(position, team);
    }
    @Override
    public ArrayList<Move> legalMoves(Board board) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		for(int possibleMove: possibleMoves) {
			int potentialMoveCoordinate = this.getPosition() + (this.getTeam().getDirection() + possibleMove);
			if(!BoardFunctionality.isValidCoordinate(potentialMoveCoordinate)) {
				continue;
			}
			if(possibleMove == 8 && !board.getSquare(potentialMoveCoordinate).isOccupied()) {
				legalMoves.add(new ImportantMove(board, this, potentialMoveCoordinate));
			}
			else if(possibleMove == 16 && this.isFirstMove() && (BoardFunctionality.rank2[this.getPosition()]) && this.getPieceTeam().isBlack() || (BoardFunctionality.rank7[this.getPosition()]) && this.getPieceTeam().isWhite()) {
				int behindPosition = this.getPosition() + (this.getTeam().getDirection() * 8);
				if(!board.getSquare(behindPosition).isOccupied() && !board.getSquare(potentialMoveCoordinate).isOccupied()) {
					legalMoves.add(new ImportantMove(board, this, potentialMoveCoordinate));
				}
			}
			else if(possibleMove == 7 && !((BoardFunctionality.file8[this.getPosition()]) && this.getTeam().isWhite() || (BoardFunctionality.file1[this.getPosition()] && this.getTeam().isBlack()))) {
				if(board.getSquare(potentialMoveCoordinate).isOccupied()) {
					Piece pieceOnPotential = board.getSquare(potentialMoveCoordinate).getPiece();
					if(this.getTeam() != pieceOnPotential.getTeam()) {
						legalMoves.add(new ImportantMove(board, this, potentialMoveCoordinate));
					}
				}
			}
			else if(possibleMove == 9 && !((BoardFunctionality.file8[this.getPosition()]) && this.getTeam().isBlack() || (BoardFunctionality.file1[this.getPosition()] && this.getTeam().isWhite()))) {
				if(board.getSquare(potentialMoveCoordinate).isOccupied()) {
					Piece pieceOnPotential = board.getSquare(potentialMoveCoordinate).getPiece();
					if(this.getTeam() != pieceOnPotential.getTeam()) {
						legalMoves.add(new ImportantMove(board, this, potentialMoveCoordinate));
					}
				}
			}
		}
		
		return legalMoves;
    }
	@Override
	public Piece movePiece(Move move) {
		// TODO Auto-generated method stub
		return null;
	}
}