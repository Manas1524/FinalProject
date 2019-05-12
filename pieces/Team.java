package pieces;

import board.BoardFunctionality;
import player.BlackPlayer;
import player.Player;
import player.WhitePlayer;

public enum Team {
	  WHITE() {

	        @Override
	        public boolean isWhite() {
	            return true;
	        }

	        @Override
	        public boolean isBlack() {
	            return false;
	        }

	        @Override
	        public int getDirection() {
	            return UP_DIRECTION;
	        }
	        
	        @Override
	        public int getOppositeDirection() {
	            return DOWN_DIRECTION;
	        }
	        
	        @Override
	        public boolean isPawnPromotionSquare(final int position) {
	            return BoardFunctionality.file1[position];
	        }
	        
	        @Override
	        public Player choosePlayerByTeam(WhitePlayer whitePlayer, BlackPlayer blackPlayer) {
	            return blackPlayer;
	        }

	        @Override
	        public String toString() {
	            return "White";
	        }

	    },
	    BLACK() {

	        @Override
	        public boolean isWhite() {
	            return false;
	        }

	        @Override
	        public boolean isBlack() {
	            return true;
	        }

	        @Override
	        public int getDirection() {
	            return DOWN_DIRECTION;
	        }
	        
	        @Override
	        public boolean isPawnPromotionSquare(int position) {
	            return BoardFunctionality.file1[position];
	        }
	        
	        @Override
	        public Player choosePlayerByTeam(WhitePlayer whitePlayer, BlackPlayer blackPlayer) {
	            return blackPlayer;
	        }

	        @Override
	        public String toString() {
	            return "Black";
	        }

			@Override
			public int getOppositeDirection() {
				return UP_DIRECTION;
			}

	       
	    };
	
	 	public abstract int getDirection();

	    public abstract int getOppositeDirection();

	    public abstract boolean isWhite();

	    public abstract boolean isBlack();

	    public abstract boolean isPawnPromotionSquare(int position);

	    public abstract Player choosePlayerByTeam(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer);
	
	private static final int UP_DIRECTION = -1;

    private static final int DOWN_DIRECTION = 1;
}
