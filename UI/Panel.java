package UI;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import Board.*;
import pieces.*;

public class Panel extends JPanel
{
	private ArrayList<CButt> squares;
	
	public Panel()
	{
		super(new GridLayout(8,8));
		squares = new ArrayList<>();
		
		for(int i = 0; i < 8; i++)
		{
			CButt b = new CButt(this, i);
			squares.add(b);
			add(b);
			
		}
		validate();
		
			
	}
	
	public void draw(Board board)
	{
		removeAll();
		for(CButt c : squares)
		{
			board.drawSquare(board);
			add(c);
		}
		validate();
		repaint();
	}
	
	
	
	
	
}
