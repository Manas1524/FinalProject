package pieces;

import java.util.*;
import board.*;

public class King extends Piece{
	
	private int[] potentialMoves = {-9, -8, -7, -1, 1, 7, 8, 9};
	
	private int position;
	private Team pieceTeam;
	
	public King(int position, Team pieceTeam) {
		super(position, pieceTeam);
		this.position = position;
		this.pieceTeam = pieceTeam;
	}
	
	public ArrayList<Move> legalMoves(Board board){
		ArrayList<Move> legaLMoves = new ArrayList<Move>();
		
		//for(int possibleMove: potentialMoves) {
		for(int i = 0; i < potentialMoves.length; i++) {
			int possibleMove = potentialMoves[i];
			int potentialMoveCoordinate = this.position + possibleMove;
			
			if(file1EdgeCase(potentialMoveCoordinate, possibleMove) || file8EdgeCase(potentialMoveCoordinate, possibleMove)) {
				continue;
			}
			//If the coordinate is valid (in the chess board)
			if(BoardFunctionality.isValidCoordinate(potentialMoveCoordinate) && ()) {
				Square potentialMoveSquare = board.getSquare(potentialMoveCoordinate);
				
				
			}
		}
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
}