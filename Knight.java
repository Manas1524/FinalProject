package pieces;

import java.util.*;

import board.*;

public class Knight extends Piece{
	
	private int[] potentialMoves = {-17, -15, -10, -6, 6, 10, 15, 17};
	private int position;
	public Knight(int position, Team pieceColor) {
		super(position, pieceColor);
		this.position = position;
	}
	/**
	 * @Override
	 */
	public ArrayList<Move> legalMoves(Board board) {
		
		int potentialMoveCoordinates;
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		for(int possibleMove: potentialMoves) {
			potentialMoveCoordinates = this.position + possibleMove;
			
			//If the coordinate is valid (in the chess board)
			if(true) {
				Tile potentialMoveTile = board.getTile(potentialMoveCoordinates);
				
				if(!potentialMoveTile.isTileOccupied()) {
					legalMoves.add(new Move());
				}
				ele{
					Piece pieceAtDestination = potentialMoveTile();
					Team pieceTeam = pieceAtDestination
				}
			}
		}
	}
	
}
