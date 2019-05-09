package UI;

import java.awt.*;
import java.awt.List;
import java.util.*;

import Board.*;
import pieces.*;


import javax.swing.*;

public class Frame
{
	private static Board cboard = Board.createStartingBoard();
	private JMenuBar menu = new JMenuBar();
	private JFrame frame = new JFrame("CHESS");
	private Panel panel = new Panel();
	private static String piecePath = "chess java/";
	private static Square click;
	private static Square destination;
	private static Piece piece;
	
	public Frame() {
		
	
	frame.setSize(1200, 900);
	frame.setVisible(true);
	
	JMenu file = new JMenu("File");
	menu.add(file);
	
	frame.setLayout(new BorderLayout());
	frame.add(panel, BorderLayout.CENTER);
	frame.setJMenuBar(menu);
	
	
	}
	
	
	
	/**
	 * @return the cboard
	 */
	public static Board getCboard() {
		return cboard;
	}

	/**
	 * @param cboard the cboard to set
	 */
	public static void setCboard(Board cboard) {
		Frame.cboard = cboard;
	}

	/**
	 * @return the piecePath
	 */
	public static String getPiecePath() {
		return piecePath;
	}

	/**
	 * @param piecePath the piecePath to set
	 */
	public static void setPiecePath(String piecePath) {
		Frame.piecePath = piecePath;
	}

	/**
	 * @return the destination
	 */
	public static Square getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public static void setDestination(Square destination) {
		Frame.destination = destination;
	}

	/**
	 * @return the piece
	 */
	public static Piece getPiece() {
		return piece;
	}

	/**
	 * @param piece the piece to set
	 */
	public static void setPiece(Piece piece) {
		Frame.piece = piece;
	}

	public static Square getClick() {
		return click;
	}

	public static void setClick(Square click) {
		Frame.click = click;
	}


	
}
