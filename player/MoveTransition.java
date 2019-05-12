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
	
	private Board fromBoard;
    private Board toBoard;
    private Move transitionMove;
  

	public MoveTransition(Board transitionBoard, Move move, MoveStatus moveStatus) {
		this.transitionBoard = transitionBoard;
		this.move = move;
		this.moveStatus = moveStatus;
	}

	public MoveStatus getMoveStatus() {
		return this.moveStatus;
	}
	
	public Board getFromBoard() {
	        return this.fromBoard;
	}

	public Board getToBoard() {
	         return this.toBoard;
	}
	    
	public Move getTransitionMove() {
	        return this.transitionMove;
	}

}
