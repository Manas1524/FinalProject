package UI;

import board.Board;

public class ChessDriver 
{
	public static void main(String[] args) 
	{
		Board board = Board.createStartingBoard();
		System.out.println(board);
		Fram frame = new Fram();
	}
}
