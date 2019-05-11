package UI;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import board.*;
import pieces.*;

public class Panel extends JPanel
{
	private ArrayList<CButt> squares = new ArrayList<>();;
	
	public Panel()
	{
		super(new GridLayout(8,8));

		for(int i = 0; i < 8; i++)
		{
			CButt b = new CButt(this, i);
			squares.add(b);
			add(b);
			
		}
		setPreferredSize(new Dimension(400, 350));
		validate();
		
			
	}
	
	public void draw(Board board)
	{
		removeAll();
		for(CButt c : squares)
		{
			c.drawSquare(board);
			add(c);
		}
		validate();
		repaint();
	}
	
	
	
	
	
}
