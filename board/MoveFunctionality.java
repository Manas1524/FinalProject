package board;

public class MoveFunctionality {
	private MoveFunctionality() {
		throw new RuntimeException("Not Instantiable");
	}
	
	public Move makeMove(Board board, int startCoordinate, int endCoordinate) {
		for(Move move: board.findLegalMoves()) {
			if(move.getStartCoordinate() == startCoordinate && move.getEndCoordinate() == endCoordinate) {
				return move;
			}
		}
		return Move.getWRONG_MOVE();
	}
}
