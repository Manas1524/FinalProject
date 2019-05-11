package player;

public enum MoveStatus {
	DONE{ 
		@Override
		boolean isDone() {
			return true;
		}
	}, 
	ILLEGAL_MOVE {
		@Override
		boolean isDone() {
			return false;
		}
	}, PLAYER_LEFT_IN_CHECK {
		@Override
		boolean isDone() {
			return false;
		}
	};
	abstract boolean isDone();
}
