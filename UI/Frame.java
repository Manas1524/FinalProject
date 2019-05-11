package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.*;
import pieces.*;


import javax.swing.*;

import board.*;

public class Frame
{
	private final Color lbrown = new Color(245, 222, 179);
	private final Color dbrown = new Color(159, 105, 52);
	private JFrame frame = new JFrame("CHESS");
	private Panel panel = new Panel();
	private Setup game;
	private static Board cboard = Board.createStartingBoard();
	private JMenuBar menu = new JMenuBar();
	private static String piecePath = "chess java/";
	private static Piece click;
	private static Piece destination;
	private static Piece piece;
	private static Frame newFrame = new Frame();
	
	public Frame() {
		
	frame.setVisible(true);
	
    final JMenuBar settings = new JMenuBar();
    settings.add(Options());
    this.frame.setJMenuBar(settings);
    this.frame.setLayout(new BorderLayout());
    this.cboard = Board.createStartingBoard();
    this.piecePath = "/chess java/";
    this.panel = new Panel();
    this.game = new Setup(this.frame, true);
    this.frame.add(this.panel, BorderLayout.CENTER);
	
	}
	
	public void show()
	{
		Frame.getNewFrame().getPanel().draw(Frame.getNewFrame().getCboard());
	}
	
	public void updateBoard( Board board) {
        this.cboard = board;
    }
	
	public JMenu Options()
	{
		JMenu optionsMenu = new JMenu("Options");

        JMenuItem reset = new JMenuItem("New Game", KeyEvent.VK_P);
        reset.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                undoAllMoves();
            }


        });
        optionsMenu.add(reset);
        return optionsMenu;
	}
	
	private void undoAllMoves() {
        Frame.getNewFrame().getPanel().draw(cboard);
    }
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the panel
	 */
	public Panel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	/**
	 * @return the game
	 */
	public Setup getGame() {
		return game;
	}

	/**
	 * @param game the game to set
	 */
	public void setGame(Setup game) {
		this.game = game;
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
	 * @return the menu
	 */
	public JMenuBar getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(JMenuBar menu) {
		this.menu = menu;
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
	 * @return the click
	 */
	public static Piece getClick() {
		return click;
	}

	/**
	 * @param click the click to set
	 */
	public static void setClick(Piece click) {
		Frame.click = click;
	}

	/**
	 * @return the destination
	 */
	public static Piece getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public static void setDestination(Piece destination) {
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

	/**
	 * @return the newFrame
	 */
	public static Frame getNewFrame() {
		return newFrame;
	}

	/**
	 * @param newFrame the newFrame to set
	 */
	public static void setNewFrame(Frame newFrame) {
		Frame.newFrame = newFrame;
	}
	
	
	
}
