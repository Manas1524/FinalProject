package UI;

import javax.swing.*;
import java.awt.*;
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
		Color();
		validate();
	}
	
	public void Color()
	{
		if(BoardUtils.FIRST_ROW(tile)) || BoardUtils.THIRD_ROW(tile) ||
		BoardUtils.FIFTH_ROW(tile) || BoardUtils.SEVENTH_ROW(tile))
		{
			setBackground(lbrown);
		}
		
		if(BoardUtils.SECOND_ROW(tile)) || BoardUtils.FOURTH_ROW(tile) ||
		BoardUtils.SIXTH_ROW(tile) || BoardUtils.EIGHTH_ROW(tile))
		{
			setBackground(dbrown);
		}
		
	}
	
	
}
