package UI;

import java.awt.BorderLayout;

import javax.swing.*;

public class Frame
{
	JMenuBar menu = new JMenuBar();
	private JFrame frame = new JFrame("CHESS");
	private Panel panel = new Panel();
	
	public Frame() {
		
	
	frame.setSize(1200, 900);
	frame.setVisible(true);
	
	JMenu file = new JMenu("File");
menu.add(file);
	
	frame.setLayout(new BorderLayout());
	frame.add(panel, BorderLayout.CENTER);
	frame.setJMenuBar(menu);
	
	
	}
}
