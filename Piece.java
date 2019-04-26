package Pieces;

import java.util.ArrayList;

import Board.Move;

public abstract class Piece {
	private int position;
	private Team pieceTeam;
	Piece(int position, Team color){
		this.position = position;
		this.pieceTeam = color;
	}
	
	public abstract ArrayList<Move> legalMoves(Board board);
}
