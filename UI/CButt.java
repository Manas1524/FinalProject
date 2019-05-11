package UI;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.*;


import pieces.*;
import UI.Frame;
import board.*;

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
		setPreferredSize(new Dimension(10,10));
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
				
				if(BoardFunctionality.isEndGame(Frame.getNewFrame().getCboard())) {
	                        return;
				
				//cancel move
				if(SwingUtilities.isRightMouseButton(e))
				{
					Frame.setClick(null);
					Frame.setPiece(null);

				}	
				//move
				else if(SwingUtilities.isLeftMouseButton(e))
				{
					//no selection
					if(Frame.getClick() == null)
					{
						Frame.setClick(Frame.getCboard().getPiece(square));
						Frame.setPiece(Frame.getClick());
						if(Frame.getPiece() == null)
						{
							Frame.setClick(null);
						}
					
					}
					//move to destination
					else
					{
						Move move = MoveFunctionality.createMove(Frame.getCboard(), Frame.getClick().getPosition());
						MoveTransition transition = Frame.getCboard().currentPlayer().makeMove(move);
						if(transition.getMoveStatus().isDone())
						{
							Frame.setCboard(transition.getToBoard());
						}
						Frame.setClick(null);
						Frame.setPiece(null);
						
						
					}
					SwingUtilities.invokeLater(new Runnable()
					{
						public void run()
						{
							Panel.draw(Frame.getCboard());
						}
					});
				}
			}
			
		}
	});
		
		validate();
	}
	
	public void drawSquare(Board board)
	{
		color();
		icon(board);
		highlight(board);
		validate();
		repaint();
	}
	
	public void icon(Board board)
	{
		this.removeAll();
		if(board.getSquare(square).isOccupied())
		{
			
			try 
			{
			BufferedImage piece = ImageIO.read(Frame.getPiecePath() + board.getPiece(square).Team()
				.toString().substring(0, 1) + "" + board.getPiece(square).toString() + ".png");
			add(new JLabel(new ImageIcon(piece)));
			}
			catch(Exception e)
			{
				System.out.println("error");
			}
		}
	}
	
	public void color()
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
	
	private void highlight(final Board board) 
	{
            for (Move move : legalMoves(board)) {
                if (move.getEndCoordinate() == this.square) {
                    setBackground(Color.GREEN);
                }
            }
        
    }
	
	private Collection<Move> pieceLegalMoves(final Board board) {
        if(Frame.getPiece() != null && Frame.getPiece().getTeam() == board.currentPlayer().getTeam()) 
        {
            return Frame.getPiece().legalMoves(board);
        }
        return Collections.emptyList();
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
			return Frame.getClick().legalMoves(board);
		}
		return Collections.emptyList();
	}
	
	
}
