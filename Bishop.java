package pieces;

import java.util.ArrayList;

import Board.Move;
import Board.Square;

public class Bishop {
	private int[] potentialMoves = {-9,-7,7,9};
	private int position;
	public Bishop(int position, Team pieceColor) {
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
	 * Description: checks if bishop is in first column to prevent illegal move
	 * @param currentPosition
	 * @param potentialMoveCoordinate
	 * @return
	 */
	public static boolean isFirstColumnExclusion(int currentPosition, int potentialMoveCoordinate)
	{
		return Move.FIRST_COLUMN(currentPosition) && (potentialMoveCoordinate == -9 || potentialMoveCoordinate == 7);
	}
	
	/**
	 * Description: checks if bishop is in eighth column to prevent illegal move
	 * @param currentPosition
	 * @param potentialMoveCoordinate
	 * @return
	 */
	public static boolean isEightColumnExclusion(int currentPosition, int potentialMoveCoordinate)
	{
		return Move.EIGHT_COLUMN(currentPosition) && (potentialMoveCoordinate == 9 || potentialMoveCoordinate == -7);
	}

}
