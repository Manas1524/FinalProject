package pieces;

import java.util.ArrayList;

import board.*;

public class Bishop extends Piece{
	private int[] potentialMoves = {-9,-7,7,9};
	private int position;
	private Team pieceTeam;
	
	public Bishop(Team pieceTeam, int position) {
		super(PieceType.BISHOP, position, pieceTeam, true);
		this.position = position;
		this.pieceTeam = pieceTeam;
	}
	
	public Bishop(Team pieceTeam, int position, boolean firstMove) {
		super(PieceType.BISHOP, position, pieceTeam, firstMove);
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
		
		int potentialMoveCoordinate;
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		for(int possibleMove: potentialMoves) 
		{
			potentialMoveCoordinate = this.position;
			
			while(BoardFunctionality.isValidCoordinate(potentialMoveCoordinate))
			{
				if(isFirstColumnExclusion(potentialMoveCoordinate, possibleMove)
						|| (isEightColumnExclusion(potentialMoveCoordinate, possibleMove)))
				{
					break;
				}
			}	
			potentialMoveCoordinate += possibleMove;
			
			//If the coordinate is valid (in the chess board)
			if(BoardFunctionality.isValidCoordinate(potentialMoveCoordinate)) 
			{
				Piece pieceAtDestination = board.getPiece(potentialMoveCoordinate);
				
				if(pieceAtDestination == null) 
				{
					legalMoves.add(new ImportantMove(board, this, potentialMoveCoordinate));
				}
				else
				{
					
					Team pieceTeam = pieceAtDestination.getPieceTeam();
					
					if(this.pieceTeam != pieceTeam)
					{
						legalMoves.add(new AttackingMove(board, this, potentialMoveCoordinate, pieceAtDestination));
					}
					break;
				}
				
			}
			
		}
		return legalMoves;
	}
	
	public int bonus()
	{
		return this.pieceTeam.bishopBonus(this.position);
	}
	
	@Override
	public String toString() {
		return this.getPieceType().toString();
	}
	
	@Override
	public Piece movePiece(Move move) {
		return PieceFunctionality.INSTANCE.getMovedBishop(ImportantMove.getMovedPiece().getTeam(), ImportantMove.getEndCoordinate());
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
