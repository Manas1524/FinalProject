package player;

import java.util.AbstractList;
import java.util.ArrayList;

import pieces.Piece;
import pieces.Rook;
import pieces.Team;
import board.*;

public class BlackPlayer extends Player {
	private Board board;
	private ArrayList<Move> standardWhiteMoves;
	private ArrayList<Move> standardBlackMoves;
	
	public BlackPlayer(Board board, ArrayList<Move> standardWhiteMoves, ArrayList<Move> standardBlackMoves) {
		super(board, standardBlackMoves, standardWhiteMoves);
		this.board = board;
		this.standardWhiteMoves = standardWhiteMoves;
		this.standardBlackMoves = standardBlackMoves;
	}

	@Override
	public ArrayList<Piece> getAlivePieces() {
		return this.board.getBlackPieces();
	}

	@Override
	public Team getTeam() {
		return Team.BLACK;
	}

	@Override
	public Player getEnemy() {
		return this.board.whitePlayer();
	}

	@Override
	public AbstractList<Move> findKingCastles(ArrayList<Move> playerMoves, ArrayList<Move> enemyMoves) {
		// TODO Auto-generated method stub
		ArrayList<Move> kingCastles = new ArrayList<Move>();
		if(this.playerKing.isFirstMove() && !this.inCheck()) {
			if(!this.board.getSquare(5).isOccupied() && !this.board.getSquare(6).isOccupied()) {
				Square rookKingSquare = this.board.getSquare(7);
				if(rookKingSquare.getPiece().getPieceType().isRook() && rookKingSquare.isOccupied() && rookKingSquare.getPiece().isFirstMove()) {
					if(Player.getAttackOnSquare(5, enemyMoves).isEmpty() && Player.getAttackOnSquare(6, enemyMoves).isEmpty()) {
						kingCastles.add(new KingCastle(this.board, this.getPlayerKing(), 6, (Rook)rookKingSquare.getPiece(), rookKingSquare.getPiece().getPosition(),5));
					}
				}
			}
			if(!this.board.getSquare(1).isOccupied() && !this.board.getSquare(2).isOccupied() && !this.board.getSquare(3).isOccupied()) {
				Square rookQueenSquare = this.board.getSquare(0);
				if(rookQueenSquare.getPiece().getPieceType().isRook() && rookQueenSquare.isOccupied() && rookQueenSquare.getPiece().isFirstMove()) {
					if(Player.getAttackOnSquare(1, enemyMoves).isEmpty() && Player.getAttackOnSquare(2, enemyMoves).isEmpty() && Player.getAttackOnSquare(3, enemyMoves).isEmpty()) {
						kingCastles.add(new KingCastle(this.board, this.getPlayerKing(), 2, (Rook)rookQueenSquare.getPiece(), rookQueenSquare.getPiece().getPosition(), 3));
					}
				}
			}
		}
		return kingCastles;
	}
}
