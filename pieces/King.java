package pieces;

import java.util.*;

import board.*;
import pieces.Piece.PieceType;

public class King extends Piece{
	
	private int[] potentialMoves = {-9, -8, -7, -1, 1, 7, 8, 9};
	
	private int position;
	private Team pieceTeam;
	
	public King(Team pieceTeam, int position) {
		super(PieceType.KING, position, pieceTeam, true);
		this.position = position;
		this.pieceTeam = pieceTeam;
	}
	
	public King(Team pieceTeam, int position, boolean firstMove) {
		super(PieceType.KING, position, pieceTeam, firstMove);
		this.position = position;
		this.pieceTeam = pieceTeam;
	}
	
	public ArrayList<Move> legalMoves(Board board){
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		//for(int possibleMove: potentialMoves) {
		for(int i = 0; i < potentialMoves.length; i++) {
			int possibleMove = potentialMoves[i];
			int potentialMoveCoordinate = this.position + possibleMove;
			
			if(file1EdgeCase(potentialMoveCoordinate, possibleMove) || file8EdgeCase(potentialMoveCoordinate, possibleMove)) {
				continue;
			}
			//If the coordinate is valid (in the chess board)
			if(BoardFunctionality.isValidCoordinate(potentialMoveCoordinate)) {
				Piece potentialMoveSquare = board.getSquare(potentialMoveCoordinate).getPiece();
					//If the square is not occupied by ANY piece, no matter the team, it is legal
					if(potentialMoveSquare == null) {
						//Add the piece to the legalMoves list
						legalMoves.add(new ImportantMove(board, this, potentialMoveCoordinate));
					}
					else{
						Piece pieceAtDestination = potentialMoveSquare;
						Team pieceTeam = pieceAtDestination.getTeam();
						
						//If there is no piece there/The piece there is of the opposite team
						if(this.pieceTeam != pieceTeam) {
							//It is a legal move, so add it to the arrayList
							legalMoves.add(new AttackingMove(board, this, potentialMoveCoordinate, pieceAtDestination));
						}
					}
			}
		}
		return legalMoves;
	}

	public static boolean file1EdgeCase(int currentSquare, int possibleMove) {
		boolean isEdgeCase = (BoardFunctionality.file1[currentSquare] && ((possibleMove == -9) || (possibleMove == -1)
				|| (possibleMove == 7)));
		
		return isEdgeCase;
	}
	
	public static boolean file8EdgeCase(int currentSquare, int possibleMove) {
		boolean isEdgeCase = (BoardFunctionality.file8[currentSquare] && ((possibleMove == -7) || (possibleMove == 1) || (possibleMove == 9)));
		
		return isEdgeCase;
	}

	public String toString() {
		return this.getPieceType().toString();
	}
	
	public Piece movePiece(Move move) {
		return null;
	}

}