package board;

import java.util.*;
import player.*;
import pieces.*;

public class Board {
	
	private ArrayList<Square> gameBoard;
	//Keep track of all the pieces
	private ArrayList<Piece> whitePieces;
	private ArrayList<Piece> blackPieces;
	
	private WhitePlayer whitePlayer;
	private BlackPlayer blackPlayer;
	private Player currentPlayer;
	
	public Board(Builder builder) {
		this.gameBoard = makeBoard(builder);
		this.whitePieces = findAlivePieces(this.gameBoard, Team.WHITE);
		this.blackPieces = findAlivePieces(this.gameBoard, Team.BLACK);
		
		ArrayList<Move> standardWhiteMoves = findLegalMoves(this.whitePieces);
		ArrayList<Move> standardBlackMoves = findLegalMoves(this.blackPieces);
		
		this.whitePlayer =  new WhitePlayer(this, standardWhiteMoves, standardBlackMoves);
		this.blackPlayer =  new BlackPlayer(this, standardWhiteMoves, standardBlackMoves);
		this.currentPlayer = builder.nextMove.choosePlayerByTeam(this.whitePlayer, this.blackPlayer);;
	}
	
	
	/**
	 * This methods give each square an id in ASCII text
	 */
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < BoardFunctionality.SQUARE_AMOUNT; i++) {
			String squareString = this.gameBoard.get(i).toString();
			output.append(String.format("%3s", squareString));
			
			if((i + 1) % BoardFunctionality.SQUARES_PER_ROW == 0) {
				output.append("\n");
			}
		}
		return output.toString();
	}

	public Player whitePlayer() {
		return this.whitePlayer;
	}
	
	public Player blackPlayer() {
		return this.blackPlayer;
	}
	
	public Player currentPlayer() {
		return this.currentPlayer;
	}
	
	public ArrayList<Piece> getWhitePieces() {
		return this.whitePieces;
	}
	
	public ArrayList<Piece> getBlackPieces() {
		return this.blackPieces;
	}
	
	private ArrayList<Move> findLegalMoves(ArrayList<Piece> pieces) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		for(Piece piece: pieces) {
			legalMoves.addAll(piece.legalMoves(this));
		}
		
		return legalMoves;
	}

	public ArrayList<Move> findAllLegalMoves() {
        ArrayList<Move> allMoves = this.whitePlayer.getLegalMoves();
        allMoves.addAll(this.blackPlayer.getLegalMoves());
        return allMoves;
    }
	
	private ArrayList<Piece> findAlivePieces(ArrayList<Square> gameBoard, Team team) {
		ArrayList<Piece> alivePieces = new ArrayList<Piece>();
		
		for(Square square: gameBoard) {
			if(square.isOccupied()) {
				Piece piece = square.getPiece();
				if(piece.getPieceTeam() == team) {
					alivePieces.add(piece);
				}
			}
		}
		return alivePieces;
	}

	public Square getSquare(int squareCoordinate) {
		return gameBoard.get(squareCoordinate);
	}
	
	public static ArrayList<Square> makeBoard(Builder builder) {

		ArrayList<Square> boardSquares = new ArrayList<Square>();
		
		for(int i = 0; i < BoardFunctionality.SQUARE_AMOUNT; i++) {
			//boardConfig - maps a piece to a square - gives the tile an id.
			//When we create the square, we associate the square id to the piece
			if(i < 16 || i > 47) {
				boardSquares.add(new Occupied_Square(i, builder.boardConfig.get(i)));	
			}
			else {
				boardSquares.add(new Unoccupied_Square(i));
			}
			
		}
		return boardSquares;
	}
	
	public static Board createStartingBoard() {
		Builder builder = new Builder();
		
		builder.setPieceAtSquare(new Rook(Team.BLACK, 0));
		builder.setPieceAtSquare(new Knight(Team.BLACK, 1));
		builder.setPieceAtSquare(new Bishop(Team.BLACK, 2));
		builder.setPieceAtSquare(new Queen(Team.BLACK, 3));
		builder.setPieceAtSquare(new King(Team.BLACK, 4));
		builder.setPieceAtSquare(new Bishop(Team.BLACK, 5));
		builder.setPieceAtSquare(new Knight(Team.BLACK, 6));
		builder.setPieceAtSquare(new Rook(Team.BLACK, 7));
		builder.setPieceAtSquare(new Pawn(Team.BLACK, 8));
		builder.setPieceAtSquare(new Pawn(Team.BLACK, 9));
		builder.setPieceAtSquare(new Pawn(Team.BLACK, 10));
		builder.setPieceAtSquare(new Pawn(Team.BLACK, 11));
		builder.setPieceAtSquare(new Pawn(Team.BLACK, 12));
		builder.setPieceAtSquare(new Pawn(Team.BLACK, 13));
		builder.setPieceAtSquare(new Pawn(Team.BLACK, 14));
		builder.setPieceAtSquare(new Pawn(Team.BLACK, 15));
		
		builder.setPieceAtSquare(new Rook(Team.WHITE, 48));
		builder.setPieceAtSquare(new Knight(Team.WHITE, 49));
		builder.setPieceAtSquare(new Bishop(Team.WHITE, 50));
		builder.setPieceAtSquare(new Queen(Team.WHITE, 51));
		builder.setPieceAtSquare(new King(Team.WHITE, 52));
		builder.setPieceAtSquare(new Bishop(Team.WHITE, 53));
		builder.setPieceAtSquare(new Knight(Team.WHITE, 54));
		builder.setPieceAtSquare(new Rook(Team.WHITE, 55));
		builder.setPieceAtSquare(new Pawn(Team.WHITE, 56));
		builder.setPieceAtSquare(new Pawn(Team.WHITE, 57));
		builder.setPieceAtSquare(new Pawn(Team.WHITE, 58));
		builder.setPieceAtSquare(new Pawn(Team.WHITE, 59));
		builder.setPieceAtSquare(new Pawn(Team.WHITE, 60));
		builder.setPieceAtSquare(new Pawn(Team.WHITE, 61));
		builder.setPieceAtSquare(new Pawn(Team.WHITE, 62));
		builder.setPieceAtSquare(new Pawn(Team.WHITE, 63));
		
		builder.setMove(Team.WHITE);
		
		return builder.build();
	}
	
	public static class Builder{
		
		//Maps the tile ID (Integer) to the Piece
		Map<Integer, Piece> boardConfig;
		//Makes the next move (this is the team of the next move)
		Team nextMove;
		Pawn enPassantPawn;
		
		public Builder() {
			this.boardConfig = new HashMap<>();
		}
		
		public Builder setPieceAtSquare(Piece pieceOnSquare) {
			boardConfig.put(pieceOnSquare.getPosition(), pieceOnSquare);
			return this;
		}
		
		public Builder setMove(Team nextMove) {
			this.nextMove = nextMove;
			return this;
		}
		public Board build() {
			Board b = new Board(this);
			return b;
		}

		public void setEnPassantPawn(Pawn movedPawn) {
			// TODO Auto-generated method stub
			this.enPassantPawn = movedPawn;
		}
	}
}
