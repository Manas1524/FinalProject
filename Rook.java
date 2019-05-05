package pieces;
import java.util.ArrayList;

import Board.*;
import pieces.*;


public class Rook extends Piece {
	
	private int[] potentialMoves = {-8,-1,1,8};
	private int position;
	public Rook(int position, Team pieceColor) {
		super(position, pieceColor);
		this.position = position;
	}
	
	/**
	 * Description: calculates all legal moves
	 * @param: Board 
	 * @return: ArrayList of possible moves
	 */
	public ArrayList<Move> legalMoves(Board board) 
	{
		
		int potentialMoveCoordinates;
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		for(int possibleMove: potentialMoves) 
		{
			potentialMoveCoordinates = this.position;
			
			while(isValidCoordinate(potentialMoveCoordinates))
			{
				if(isFirstColumnExclusion(potentialMoveCoordinates, possibleMove)
						|| (isEightColumnExclusion(potentialMoveCoordinates, possibleMove)))
				{
					break;
				}
			}	
			potentialMoveCoordinates += possibleMove;
			
			//If the coordinate is valid (in the chess board)
			if(isValidCoordinate(potentialMoveCoordinates)) 
			{
				Square potentialMoveSquare = board.getSquare(potentialMoveCoordinates);
				
				if(!potentialMoveTile.isTileOccupied()) 
				{
					legalMoves.add(new Move.MajorMove(board, this, potentialMoveCoordinate));
				}
				else
				{
					Piece pieceAtDestination = potentialMoveTile.getPiece();
					Team pieceTeam = pieceAtDestination.getPieceTeam();
					if(this.Team != Team)
					{
						legalMoves.add(new Move.AttackMove(board, this, potentialMoveCoordinate, pieceAtDestination))
					}
					break;
				}
				
			}
			
		}
		return ImmutableList.copyOf(legalMoves);
	}
	
	/**
	 * Description: checks if rook is in first column to prevent illegal move
	 * @param currentPosition
	 * @param potentialMoveCoordinate
	 * @return
	 */
	public static boolean isFirstColumnExclusion(int currentPosition, int potentialMoveCoordinate)
	{
		return Move.FIRST_COLUMN(currentPosition) && (potentialMoveCoordinate == -1);
	}
	
	/**
	 * Description: checks if rook is in eighth column to prevent illegal move
	 * @param currentPosition
	 * @param potentialMoveCoordinate
	 * @return
	 */
	public static boolean isEightColumnExclusion(int currentPosition, int potentialMoveCoordinate)
	{
		return Move.EIGHT_COLUMN(currentPosition) && (potentialMoveCoordinate == 1);
	}

}
