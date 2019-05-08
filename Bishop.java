package pieces;

import java.util.ArrayList;

import board.*;

public class Bishop extends Piece{
	private int[] potentialMoves = {-9,-7,7,9};
	private int position;
	private Team pieceTeam;
	
	public Bishop(Team pieceTeam, int position) {
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
				
				if(!potentialMoveSquare.isOccupied()) 
				{
					legalMoves.add(new Move.MajorMove(board, this, potentialMoveSquare));
				}
				else
				{
					Piece pieceAtDestination = potentialMoveSquare.getPiece();
					Team pieceTeam = pieceAtDestination.getPieceTeam();
					
					if(this.pieceTeam != pieceTeam)
					{
						legalMoves.add(new Move.AttackMove(board, this, potentialMoveSquare, pieceAtDestination))
					}
					break;
				}
				
			}
			
		}
		return legalMoves;
	}
	
	@Override
	public String toString() {
		return Piece.PieceType.BISHOP.toString();
	}
	
	/**
	 * Description: checks if bishop is in first column to prevent illegal move
	 * @param currentPosition
	 * @param potentialMoveCoordinate
	 * @return
	 */
	public static boolean isFirstColumnExclusion(int currentPosition, int potentialMoveCoordinate)
	{
		return BoardFunctionality.file1[currentPosition] && (potentialMoveCoordinate == -9 || potentialMoveCoordinate == 7);
	}
	
	/**
	 * Description: checks if bishop is in eighth column to prevent illegal move
	 * @param currentPosition
	 * @param potentialMoveCoordinate
	 * @return
	 */
	public static boolean isEightColumnExclusion(int currentPosition, int potentialMoveCoordinate)
	{
		return BoardFunctionality.file8[currentPosition] && (potentialMoveCoordinate == 9 || potentialMoveCoordinate == -7);
	}
}
