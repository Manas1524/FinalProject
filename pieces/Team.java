package pieces;

public enum Team {
	BLACK {
		@Override
		public boolean isBlack() {
			return true;
		}

		@Override
		public boolean isWhite() {
			return false;
		}

		@Override
		public int getDirection() {
			return DOWN_DIRECTION;
		}
	},
	WHITE {
		@Override
		public boolean isBlack() {
			return false;
		}

		@Override
		public boolean isWhite() {
			return true;
		}

		@Override
		public int getDirection() {
			return UP_DIRECTION;
		}
	};
	
	public abstract boolean isBlack();

	public abstract boolean isWhite();
	
	public abstract int getDirection();
	
	private static final int UP_DIRECTION = -1;

    private static final int DOWN_DIRECTION = 1;
}
