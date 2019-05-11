package player;

import pieces.Piece;
import board.*;
import pieces.*;
import java.util.*;

public class WhitePlayer extends Player {
	private Board board;
	private ArrayList<Move> standardWhiteMoves;
	private ArrayList<Move> standardBlackMoves;
	
	public WhitePlayer(Board board, ArrayList<Move> standardWhiteMoves, ArrayList<Move> standardBlackMoves) {
		super(board, standardWhiteMoves, standardBlackMoves);
		this.board = board;
		this.standardWhiteMoves = standardWhiteMoves;
		this.standardBlackMoves = standardBlackMoves;
	}

	@Override
	public ArrayList<Piece> getAlivePieces() {
		return this.board.getWhitePieces();
	}

	@Override
	public Team getTeam() {
		return Team.WHITE;
	}

	@Override
	public Player getEnemy() {
		return this.board.blackPlayer();
	}

	@Override
	public AbstractList<Move> findKingCastles(ArrayList<Move> playerMoves, ArrayList<Move> enemyMoves) {
		// TODO Auto-generated method stub
		ArrayList<Move> kingCastles = new ArrayList<Move>();
		if(this.playerKing.isFirstMove() && !this.inCheck()) {
			if(!this.board.getSquare(61).isOccupied() && !this.board.getSquare(62).isOccupied()) {
				Square rookKingSquare = this.board.getSquare(63);
				if(rookKingSquare.getPiece().getPieceType().isRook() && rookKingSquare.isOccupied() && rookKingSquare.getPiece().isFirstMove()) {
					if(Player.getAttackOnSquare(61, enemyMoves).isEmpty() && Player.getAttackOnSquare(62, enemyMoves).isEmpty()) {
						kingCastles.add(new KingCastle(this.board, this.getPlayerKing(), 62, (Rook)rookKingSquare.getPiece(), rookKingSquare.getPiece().getPosition(),61));
					}
				}
			}
			if(!this.board.getSquare(59).isOccupied() && !this.board.getSquare(58).isOccupied() && !this.board.getSquare(57).isOccupied()) {
				Square rookQueenSquare = this.board.getSquare(56);
				if(rookQueenSquare.getPiece().getPieceType().isRook() && rookQueenSquare.isOccupied() && rookQueenSquare.getPiece().isFirstMove()) {
					if(Player.getAttackOnSquare(59, enemyMoves).isEmpty() && Player.getAttackOnSquare(58, enemyMoves).isEmpty() && Player.getAttackOnSquare(57, enemyMoves).isEmpty()) {
						kingCastles.add(new KingCastle(this.board, this.getPlayerKing(), 58, (Rook)rookQueenSquare.getPiece(), rookQueenSquare.getPiece().getPosition(),59));
					}
				}
			}
		}
		return kingCastles;
	}

}