package pieces;
import java.util.ArrayList;

import board.*;
import pieces.*;

public class Rook extends Piece {
	
	private int[] potentialMoves = {-8,-1,1,8};
	private int position;
	private Team pieceTeam;
	
	public Rook(Team pieceTeam, int position) {
		super(position, pieceTeam);
		this.position = position;
		this.pieceTeam = pieceTeam;
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
			
			while(BoardFunctionality.isValidCoordinate(potentialMoveCoordinates))
			{
				if(isFirstColumnExclusion(potentialMoveCoordinates, possibleMove)
						|| (isEightColumnExclusion(potentialMoveCoordinates, possibleMove)))
				{
					break;
				}
			}	
			potentialMoveCoordinates += possibleMove;
			
			//If the coordinate is valid (in the chess board)
			if(BoardFunctionality.isValidCoordinate(potentialMoveCoordinates)) 
			{
				Square potentialMoveSquare = board.getSquare(potentialMoveCoordinates);
				
				if(!potentialMoveSquare.isTileOccupied()) 
				{
					legalMoves.add(new Move.MajorMove(board, this, potentialMoveSquare));
				}
				else
				{
					Piece pieceAtDestination = potentialMoveSquare.getPiece();
					Team pieceTeam = pieceAtDestination.getPieceTeam();
					if(this.pieceTeam != pieceTeam)
					{
						legalMoves.add(new Move.AttackMove(board, this, potentialMoveSquare, pieceAtDestination));
					}
					break;
				}
				
			}
			
		}
		return ImmutableList.copyOf(legalMoves);
	}
	
	@Override
	public String toString() {
		return Piece.PieceType.ROOK.toString();
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
