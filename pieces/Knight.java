package pieces;

import java.util.*;

import board.*;
import pieces.Piece.PieceType;

public class Knight extends Piece{
	/**
	 * List of all potential destinations for the piece to move
	 * In certain spots in the chess board, these numbers don't all work
	 * We will call these scenarios edgeCases (Will be referred to later on)
	 */
	private int[] potentialMoves = {-17, -15, -10, -6, 6, 10, 15, 17};
	
	private int position;
	private Team pieceTeam;
	
	public Knight(Team pieceTeam, int position) {
		super(PieceType.ROOK, position, pieceTeam, true);
		this.position = position;
		this.pieceTeam = pieceTeam;
	}
	
	public Knight(Team pieceTeam, int position, boolean firstMove) {
		super(PieceType.ROOK, position, pieceTeam, firstMove);
		this.position = position;
		this.pieceTeam = pieceTeam;
	}
	/**
	 * @Override
	 */
	public ArrayList<Move> legalMoves(Board board) {
		
		int potentialMoveCoordinate;
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		for(int possibleMove: potentialMoves) {
			potentialMoveCoordinate = this.position + possibleMove;
			
			//If the coordinate is valid (in the chess board)
			if(BoardFunctionality.isValidCoordinate(potentialMoveCoordinate)) {
				Square potentialMoveSquare = board.getSquare(potentialMoveCoordinate);
				
				//
				if( file1EdgeCase(this.position, possibleMove) == true ||
					file2EdgeCase(this.position, possibleMove) == true ||
					file7EdgeCase(this.position, possibleMove) == true ||
					file8EdgeCase(this.position, possibleMove) == true) {
					continue;
				}
				
				//If the square is not occupied by ANY piece, no matter the team, it is legal
				if(!potentialMoveSquare.isOccupied()) {
					//Add the piece to the legalMoves list
					legalMoves.add(new ImportantMove(board, this, potentialMoveCoordinate));
				}
				else{
					Piece pieceAtDestination = potentialMoveSquare.getPiece();
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
	
	@Override
	public String toString() {
		return Piece.PieceType.KNIGHT.toString();
	}
	
	public static boolean file1EdgeCase(int currentSquare, int possibleMove) {
		/**
		 * This boolean determines if the move is an edge case or not (see definition above)
		 * -17, -10, 6, and 15 are the only possible edgeCase coordinates in the first file
		 */
		boolean isEdgeCase = (BoardFunctionality.file1[currentSquare] && ((possibleMove == -17) || (possibleMove == -10)
				|| (possibleMove == 6) || (possibleMove == 15)));
		
		return isEdgeCase;
	}
	
	public static boolean file2EdgeCase(int currentSquare, int possibleMove) {
		boolean isEdgeCase = (BoardFunctionality.file2[currentSquare] && ((possibleMove == -10) || (possibleMove == 6)));
		
		return isEdgeCase;
	}
	
	public static boolean file7EdgeCase(int currentSquare, int possibleMove) {
		boolean isEdgeCase = (BoardFunctionality.file7[currentSquare] && ((possibleMove == -6) || (possibleMove == 10)));
		
		return isEdgeCase;
	}
	
	public static boolean file8EdgeCase(int currentSquare, int possibleMove) {
		boolean isEdgeCase = (BoardFunctionality.file8[currentSquare] && ((possibleMove == -15) || (possibleMove == -6)
				|| (possibleMove == 10) || (possibleMove == 17)));
		
		return isEdgeCase;
	}
	@Override
	public Piece movePiece(Move move) {
		return PieceFunctionality.INSTANCE.getMovedBishop(ImportantMove.getMovedPiece().getTeam(), ImportantMove.getEndCoordinate());
	}
}
