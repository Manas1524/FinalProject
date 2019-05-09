package pieces;

import java.util.ArrayList;

import Board.*;

public class Queen extends Piece
{
	private int[] potentialMoves = {-9, -8, -7, -1, 1, 7, 8, 9};
	private int position;
	private Team pieceTeam;
	
	public Queen(int position, Team pieceTeam) {
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
				if(file1EdgeCase(potentialMoveCoordinates, possibleMove)
						|| (file8EdgeCase(potentialMoveCoordinates, possibleMove)))
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
					legalMoves.add(new ImportantMove(board, this, potentialMoveCoordinates));
				}
				else
				{
					Piece pieceAtDestination = potentialMoveSquare.getPiece();
					Team pieceTeam = pieceAtDestination.getTeam();
					if(this.pieceTeam != pieceTeam)
					{
						legalMoves.add(new AttackingMove(board, this, potentialMoveCoordinates, pieceAtDestination));
					}
					break;
				}
				
			}
			
		}
		return legalMoves;
		
	}
	
	/**
	 * Description: checks if queen is in first column to prevent illegal move
	 * @param currentPosition
	 * @param potentialMoveCoordinate
	 * @return
	 */
	public static boolean file1EdgeCase(int currentSquare, int possibleMove)
	{
		boolean isEdgeCase = (BoardFunctionality.file1[currentSquare] && (possibleMove == 1) || possibleMove == -1 || possibleMove == -9 || possibleMove == 7);
		return isEdgeCase;
	}
	
	/**
	 * Description: checks if rook is in eighth column to prevent illegal move
	 * @param currentPosition
	 * @param potentialMoveCoordinate
	 * @return
	 */
	public static boolean file8EdgeCase(int currentSquare, int possibleMove)
	{
		boolean isEdgeCase = (BoardFunctionality.file8[currentSquare] && (possibleMove == 1) || possibleMove == -1 || possibleMove == 9 || possibleMove == -7);
		return isEdgeCase;
	}
	 
	 
}
