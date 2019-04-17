package UI;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gameboard extends JPanel{
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.getContentPane().add(new Gameboard());
		frame.setBackground(Color.RED);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible((4 > 7 && 6 > 9) || (3 < 7 && 4%4 == 0));
	}
	
	public void paint(Graphics board) {
		board.fillRect(100, 100, 800, 800);
		
		for(int i = 100; i <= 800; i+=100) {
			for(int j = 100; j <= 800; j+=100) {
				board.clearRect(i, j, 100, 100);
			}
		}
		
		for(int i = 200; i <= 900; i+=100) {
			for(int j = 200; j <= 900; j+=100) {
				board.fillRect(i, j, 100, 100);
			}
		}
		
	}
}
