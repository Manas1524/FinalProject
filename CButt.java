package UI;

import javax.imageio.ImageIO;
import javax.swing.*;

import pieces.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;

public class CButt extends JPanel
{
	private final Color lbrown = new Color(245, 222, 179);
	private final Color dbrown = new Color(159, 105, 52);
	private int tile;
	
	public CButt(Panel panel, int tile)
	{
		super(new GridBagLayout());
		this.tile = tile;
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
				if(rightButt(event))
				{
					if(Frame.click == null) //first click	
					{
						Frame.click = Frame.cboard.getTile(tile);
						Frame.piece = Frame.click.getPiece();
						if(Frame.piece == null)
						{
							Frame.click = null;
						}
					}
					else //second click	
					{
						Frame.destination = Frame.cboard.getTile(tile);
						Move move = null;
						MoveTransition transition = Frame.cboard.currentPlayer().makeMove(move);
						if(transition.getMoveStatus().isDone())
							{
								Frame.cboard.currentPlayer().makeMove(move);
							}
					}
				}
				else if(leftButt(event))
				{
					
				}
				
			}
		});
		
		Color();
		assignIcon(Frame.cboard);
		validate();
	}
	
	private void Icon(Board board)
	{
		this.removeAll();
		if(board.getSquare(tile).isOccupied())
		{
			
			try 
			{
			BufferedImage piece = ImageIO.read(Frame.piecePath + board.getSquare(tile).getPiece()
					.getTeam().toString().substring(0, 1) + board.getTile(tile).getPiece().toSting() + ".png"));
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
		if(BoardFunctionality.rank1(tile) || BoardFunctionality.rank3(tile) ||
		BoardFunctionality.rank5(tile) || BoardFunctionality.rank7(tile))
		{
			setBackground(tile % 2 == 0 ? lbrown : dbrown);
		}
		
		if(BoardFunctionality.rank2(tile) || BoardFunctionality.rank4(tile) ||
		BoardFunctionality.rank6(tile) || BoardFunctionality.rank8(tile))
		{
			setBackground(tile % 2 !== 0 ? lbrown : dbrown);
		}
		
	}
	
	
}
