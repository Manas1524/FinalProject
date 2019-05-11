package player;

import board.*;
import pieces.*;

/**
 * This is the transition between each board when each move is made
 * @author gandhi1524
 *
 */
public class MoveTransition {
	private Board transitionBoard;
	private Move move;
	//MoveStatus is if the move is legal, a castle, check, etc.
	private MoveStatus moveStatus;
	
	public MoveTransition(Board transitionBoard, Move move, MoveStatus moveStatus) {
		this.transitionBoard = transitionBoard;
		this.move = move;
		this.moveStatus = moveStatus;
	}
}
