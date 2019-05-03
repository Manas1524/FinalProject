package pieces;

import java.util.ArrayList;

//import Board.Move;
import UI.Gameboard;
import board.Board;
import board.Move;

public abstract class Piece {
	private int position;
	private Team pieceTeam;
	Piece(int position, Team color){
		this.position = position;
		this.pieceTeam = color;
	}
	
	public Team getTeam() {
		return this.pieceTeam;
	}
	public abstract ArrayList<Move> legalMoves(Board board);
}
