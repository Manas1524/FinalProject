package pieces;

import java.util.ArrayList;

import board.*;
import pieces.Team;

public abstract class Piece {
	private int position;
	private Team pieceTeam;
	private boolean isFirstMove;
	private PieceType pieceType;
	private int code;
	
	Piece(PieceType pieceType, int position, Team color, boolean firstMove){
		this.position = position;
		this.pieceTeam = color;
		this.pieceType = pieceType;
		this.isFirstMove = firstMove;
		this.code = calculateCode();
	}
	
	public Team getTeam() {
		return this.pieceTeam;
	}
	
	public abstract ArrayList<Move> legalMoves(Board board);

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @return the pieceTeam
	 */
	public Team getPieceTeam() {
		return pieceTeam;
	}

	/**
	 * @return isFirstMove
	 */
	public boolean isFirstMove() {
		return this.isFirstMove;
	}
	
	public abstract Piece movePiece(Move move);
	
	
	public enum PieceType {
		
		PAWN(100, "P") {
            public boolean isPawn() {
                return true;
            }
            public boolean isBishop() {
                return false;
            }
            public boolean isRook() {
                return false;
            }
            public boolean isKing() {
                return false;
            }
        },
        KNIGHT(320, "N") {
            public boolean isPawn() {
                return false;
            }
            public boolean isBishop() {
                return false;
            }
            public boolean isRook() {
                return false;
            }
            public boolean isKing() {
                return false;
            }
        },
        BISHOP(350, "B") {
            public boolean isPawn() {
                return false;
            }
            public boolean isBishop() {
                return true;
            }
            public boolean isRook() {
                return false;
            }
            public boolean isKing() {
                return false;
            }
        },
        ROOK(500, "R") {
            public boolean isPawn() {
                return false;
            }
            public boolean isBishop() {
                return false;
            }
            public boolean isRook() {
                return true;
            }
            public boolean isKing() {
                return false;
            }
        },
        QUEEN(900, "Q") {
            public boolean isPawn() {
                return false;
            }
            public boolean isBishop() {
                return false;
            }
            public boolean isRook() {
                return false;
            }
            public boolean isKing() {
                return false;
            }
        },
        KING(20000, "K") {
            public boolean isPawn() {
                return false;
            }
            public boolean isBishop() {
                return false;
            }
            public boolean isRook() {
                return false;
            }
            public boolean isKing() {
                return true;
            }
        };
		int value;
        String pieceName;

        public int getPieceValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.pieceName;
        }

        PieceType(final int val, final String pieceName) {
            this.value = val;
            this.pieceName = pieceName;
        }
        public abstract boolean isPawn();
        public abstract boolean isBishop();
        public abstract boolean isRook();
        public abstract boolean isKing();
		}
		
	
	
	public int hashCode()
	{
		return code;
	}
	
	public int calculateCode()
	{
		int code = this.pieceType.hashCode();
		code = 31 * code + pieceTeam.hashCode();
		code = 31 * code + position;
		code = 31 * code + (isFirstMove() ? 1:0);
		return code;
	}
	
	public boolean equals(Object a) {
		if(this == a) {
			return true;
		}
		if(!(a instanceof Piece)){
			return false;
		}
		Piece otherPiece = (Piece)a;
		return position == otherPiece.getPosition() && pieceType == otherPiece.getPieceType() && pieceTeam == otherPiece.getTeam() && isFirstMove() == otherPiece.isFirstMove();
	}
	public PieceType getPieceType() {
		return pieceType;
	}

	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setPieceTeam(Team pieceTeam) {
		this.pieceTeam = pieceTeam;
	}

	public void setFirstMove(boolean firstMove) {
		this.isFirstMove = firstMove;
	}
}
