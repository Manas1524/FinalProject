package pieces;

import player.BlackPlayer;
import player.Player;
import player.WhitePlayer;

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
		
		@Override
        public Player choosePlayerByTeam(WhitePlayer whitePlayer, BlackPlayer blackPlayer) {
            return blackPlayer;
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
		@Override
        public Player choosePlayerByTeam(WhitePlayer whitePlayer, BlackPlayer blackPlayer) {
            return whitePlayer;
        }
	};
	
	public abstract boolean isBlack();

	public abstract boolean isWhite();
	
	public abstract int getDirection();
	
	private static final int UP_DIRECTION = -1;

    private static final int DOWN_DIRECTION = 1;

	public abstract Player choosePlayerByTeam(WhitePlayer whitePlayer, BlackPlayer blackPlayer);}
    
