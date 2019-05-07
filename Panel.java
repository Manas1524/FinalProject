package UI;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Panel extends JPanel
{
	private ArrayList<CButt> board;
	
	public Panel()
	{
		super(new GridLayout(8,8));
		board = new ArrayList<>();
		
		for(int i = 0; i < 8; i++)
		{
			CButt b = new CButt(this, i);
			board.add(b);
			add(b);
			
		}
		validate();
			
	}
	
	
	
	
	
}
