/**
 * 
 */
package arrays_arraylists;
import acm.program.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * 
 */
public class Morse extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	ArrayList<String> als;
	private JTextField inputField;
	private JButton button;
	private JTextArea area;
	
	/**
	 * @param args
	 */
	
	// Translate strings to Morse code in an ArrayList
	private ArrayList<String> stringToMorse(String s) {
		ArrayList<String> as = new ArrayList<String>();
		String tempas = new String();
		char c;
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			
			// If neither is not alphabetic nor white space
			if (!validator(c) && !space(c)) continue;
			
			// If space save the string and  open another one
			if (space(c)) {
				as.add(tempas);
				tempas = new String();
				
			// If not space and alphabetic, concatenate
			} else {
				tempas = tempas + selector(c) + " ";
			}
			
		}
		
		// Adds the last String to the ArrayList
		as.add(tempas);
		return as;
		
	}
	
	// To select from the MORSE array the indicate code
	private String selector(char c) {
		char tempc = Character.toLowerCase(c);
		int unicodevalue = (int) tempc - 97;
		return MORSE[unicodevalue];
	}
	
	// To detect if the character is not alphabetic
	private boolean validator(char c) {
		return Character.isAlphabetic(c);
	}
	
	// To detect spaces
	private boolean space(char c) {
		return Character.isSpaceChar(c);
	}
	
	public void init() {
		
		inputField 	= new JTextField(20);		// To allocate the string
		button		= new JButton("Translate");
										 		// The button
		area 		= new JTextArea(15, 30);	// The area to allocate the Morse
												// code
		area.setEditable(false);				// To block edition of users
		
		add(new JLabel("Input: "), SOUTH);
		add(inputField, SOUTH);
		add(button, SOUTH);
		add(area);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { // is actionPerformed the keyword
					
				translateMorse();
				
			}
			
		});
		
	}
	
	public void translateMorse() {
		
		String s = inputField.getText();
		
		// Translate the message to Morse code
		als = stringToMorse(s);
		area.setText("");
		
		// Iterate over all the resulted array of strings
		if (als != null) {
			for (int i = 0; i < als.size(); i++) {
				area.append(als.get(i) + "\n");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Morse().start();
	}

	private static final String[] MORSE = {".-", "-...", "-.-.",
			"-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
			"-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
	
}
