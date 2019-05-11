package pieces;

import board.*;
import pieces.Piece.PieceType;

import java.util.*;

import board.*;

public class Pawn extends Piece {

    private int[] possibleMoves = {8, 16, 7, 9};
    private int position;
    private Team pieceTeam;

	public Pawn(Team pieceTeam, int position) {
		super(PieceType.Pawn, position, pieceTeam, true);
		this.position = position;
		this.pieceTeam = pieceTeam;
	}
	
	public Pawn(Team pieceTeam, int position, boolean firstMove) {
		super(PieceType.Pawn, position, pieceTeam, firstMove);
		this.position = position;
		this.pieceTeam = pieceTeam;
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
					legalMoves.add(new PawnJump(board, this, potentialMoveCoordinate));
				}
			}
			else if(possibleMove == 7 && !((BoardFunctionality.file8[this.getPosition()]) && this.getTeam().isWhite() || (BoardFunctionality.file1[this.getPosition()] && this.getTeam().isBlack()))) {
				if(board.getSquare(potentialMoveCoordinate).isOccupied()) {
					Piece pieceOnPotential = board.getSquare(potentialMoveCoordinate).getPiece();
					if(this.getTeam() != pieceOnPotential.getTeam()) {
						legalMoves.add(new PawnAttack(board, this, potentialMoveCoordinate, pieceOnPotential));
					}
				}
			}
			else if(possibleMove == 9 && !((BoardFunctionality.file8[this.getPosition()]) && this.getTeam().isBlack() || (BoardFunctionality.file1[this.getPosition()] && this.getTeam().isWhite()))) {
				if(board.getSquare(potentialMoveCoordinate).isOccupied()) {
					Piece pieceOnPotential = board.getSquare(potentialMoveCoordinate).getPiece();
					if(this.getTeam() != pieceOnPotential.getTeam()) {
						legalMoves.add(new PawnAttack(board, this, potentialMoveCoordinate, pieceOnPotential));
					}
				}
			}
		}
		
		return legalMoves;
    }
	
	public String toString() {
		return this.getPieceType().toString();
	}
	@Override
	public Piece movePiece(Move move) {
		return PieceFunctionality.INSTANCE.getMovedBishop(ImportantMove.getMovedPiece().getTeam(), ImportantMove.getEndCoordinate());
	}
}
