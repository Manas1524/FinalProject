package UI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Gameboard extends JPanel{
	
	private JFrame frame = new JFrame("HuGanGal Chess");
	private CButton[][] squareButtons = new CButton[8][8];


	
	public Gameboard()
	{
		paint(null);
	}
	
	public void paint(Graphics board) {
		
		
		frame.setSize(1200, 900);
		frame.getContentPane().add(new Gameboard());
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


		JLabel title = new JLabel("TITLE");
		title.setBounds(800, 800, 500, 50);
		
		JButton newgame = new JButton("New Game");
		newgame.setBounds(825, 50, 100, 50);
		frame.add(newgame);
		
		JButton resign = new JButton("Resign");
		resign.setBounds(825, 100, 100, 50);
		frame.add(resign);

		Color lbrown = new Color(245, 222, 179);
		Color dbrown = new Color(159, 105, 52);
		
		board.setColor(Color.WHITE);
		board.fillRect(0, 0, 400*2, 400*2);
		
		for(int i = 0; i < 8; i+=2) {
			for(int j = 0; j < 8; j+=2) {

				CButton b = new CButton(i,j);
				b.addActionListener(new CListener());
				
				b.setBounds(i*100, j*100, 100, 100);
				b.setBackground(lbrown);
				b.setOpaque(true);
				b.setVisible(true);
				frame.add(b);

			}
		}
		
		for(int i = 1; i < 8; i+=2) {
			for(int j = 1; j < 8; j+=2) {
				
				CButton b = new CButton(i,j);
				
				b.addActionListener(new CListener());
				
				squareButtons[i][j] = b;
				b.setBounds(i*100, j*100, 100, 100);
				b.setBackground(lbrown);
				b.setOpaque(true);
				b.setVisible(true);
				frame.add(b);

			}
		}
		
		for(int i = 0; i < 15; i+=2) {
			for(int j = 0; j < 15; j+=2) {
				CButton b = new CButton(i,j);
				b.addActionListener(new CListener());
				
				squareButtons[j/2][i/2] = b;
				b.setBounds(j*50, i*50, 100, 100);
				b.setBackground(dbrown);
				b.setOpaque(true);
				frame.add(b);

			}
		}
		
		for(int i = 1; i < 15; i+=2) {
			for(int j = 1; j < 15; j+=2) {

				CButton b = new CButton(i,j);
				
				b.addActionListener(new CListener());
				
				squareButtons[j/2][i/2] = b;
				b.setBounds(j*50, i*50, 100, 100);
				b.setBackground(dbrown);
				b.setOpaque(true);
				frame.add(b);

			}
		}
		
		
		board.setColor(Color.BLACK);
		board.drawRect(0, 0, 400*2, 400*2);
		
		for(int i = 0; i < squareButtons.length; i++)
			for(int j = 0; j < squareButtons[0].length;j++)
				
				System.out.print(squareButtons[i][j]);
		
	}
	

	
}