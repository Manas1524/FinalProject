package board;

import java.awt.Frame;

import board.Board;

public class ChessDriver 
{
	public static void main(String[] args) 
	{
		Board board = Board.createStartingBoard();
		System.out.println(board);
		Frame frame = new Frame();
	}
}
