package UI;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.*;


import pieces.*;
import Board.*;
import UI.Frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;

public class CButt extends JPanel
{
	private final Color lbrown = new Color(245, 222, 179);
	private final Color dbrown = new Color(159, 105, 52);
	private int square;
	
	public CButt(Panel panel, int square)
	{
		super(new GridBagLayout());
		this.square = square;
		setPreferredSize(new Dimension(100,100));
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//cancel move
				if(SwingUtilities.isRightMouseButton(e))
				{
					Frame.setClick(null);
					Frame.setDestination(null);
					Frame.setPiece(null);
					

				}	
				//move
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					//no selection
					if(Frame.getClick() == null)
					{
						Frame.setClick(Frame.getCboard().getSquare(square));
						Frame.setPiece(Frame.getClick().getPiece());
						if(Frame.getPiece() == null)
						{
							Frame.setClick(null);
						}
					
					}
					//move to destination
					else
					{
						Frame.setDestination(Frame.getCboard().getSquare(square));
						Move move = Move.MoveFactory.createMove(Frame.getCboard(), Frame.getClick()
								.getSquareCoordinate(), Frame.getDestination().getSquareCoordinate());
						MoveTransition transition = Frame.getCboard().currentPlayer().makeMove(move);
						if(transition.getMoveStatus().isDone())
						{
							Frame.setCboard(transition.getBoard());
						}
						Frame.setClick(null);
						Frame.setDestination(null);
						Frame.setPiece(null);
						
						
					}
					SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
						{
							Panel.draw(Frame.getCboard());
						}
					}
							
							);
				}
			
			}
		});
		
		Color();
		Icon(Frame.getCboard());
		validate();
	}
	
	public void drawSquare(Board board)
	{
		Color();
		Icon(board);
		validate();
		repaint();
	}
	
	public void Icon(Board board)
	{
		this.removeAll();
		if(board.getSquare(square).isOccupied())
		{
			
			try 
			{
			BufferedImage piece = ImageIO.read(Frame.getPiecePath() + board.getSquare(square).getPiece()
					.getTeam().toString().substring(0, 1) + board.getSquare(square).getPiece().toString() + ".png");
			add(new JLabel(new ImageIcon(piece)));
			}
			catch(Exception e)
			{
				System.out.println("error");
			}
		}
	}
	
	public void Color()
	{
		if(BoardFunctionality.rank1[square] || BoardFunctionality.rank3[square] ||
		BoardFunctionality.rank5[square] || BoardFunctionality.rank7[square])
		{
			setBackground(square % 2 == 0 ? lbrown : dbrown);
		}
		
		if(BoardFunctionality.rank2[square] || BoardFunctionality.rank4[square] ||
				BoardFunctionality.rank6[square] || BoardFunctionality.rank8[square])
		{
			setBackground(square % 2 != 0 ? lbrown : dbrown);
		}
		
	}
	
	public void showLegalMoves(Board board)
	{
		if(true)
		{
			for(Move move: legalMoves(board))
			{
				if(move.getEndCoordinate() == square)
				{
					setBackground(Color.GREEN);
				}
			}
			
			
		}
	}
	
	public Collection<Move> legalMoves(Board board)
	{
		if(Frame.getClick() != null && Frame.getClick().getTeam() == board.currentPlayer().getTeam())
		{
			return Frame.getClick().calculateLegalMoves(board);
		}
		return Collections.emptyList();
	}
	
	
}
