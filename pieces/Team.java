package pieces;

public enum Team {
	BLACK {
		@Override
		public boolean isBlack() {
			return true;
		}
	},
	WHITE {
		@Override
		public boolean isBlack() {
			return false;
		}
	};

	public abstract boolean isBlack();
}
