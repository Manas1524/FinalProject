package board;

import javax.management.RuntimeErrorException;

import pieces.Piece;

public class WrongMove extends Move{
	public WrongMove(){
		super(null,null,-1);
	}
	@Override
	public Board doMove() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Can't do the move");
	}
}
