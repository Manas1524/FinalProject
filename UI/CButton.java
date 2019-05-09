package UI;

import javax.swing.JButton;

public class CButton extends JButton
{

	int letter;
	int number;
	
	public CButton(int letter, int number)
	{
		this.letter = letter;
		this.number = number;
	}

	/**
	 * @return the letter
	 */
	public int getLetter() {
		return letter;
	}

	/**
	 * @param letter the letter to set
	 */
	public void setLetter(int letter) {
		this.letter = letter;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
