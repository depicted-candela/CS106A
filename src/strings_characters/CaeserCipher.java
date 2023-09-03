/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class CaeserCipher extends ConsoleProgram {

	/**
	 * @param args
	 */
	
	private static final long serialVersionUID = 1L;
	
	public void run() {
		// TODO Auto-generated method stub
		println("This program encodes a message using a Caesar cipher.");
		while (true) {
			
			int shift = readInt("Enter the number of character positions to shift: ");
			String message = readLine("Enter a message: ");
			println(caeserCipher(message, shift));
			
		}

	}
	
	private String caeserCipher(String s, int shift) {
		
		String cipherword = new String();
		Character c;
		int cv;
		
		for (int i = 0; i < s.length(); i++) {
			
			c = s.charAt(i);
			cv = c.charValue();
			cipherword = cipherword + caeserConstructor(cv, shift);

		}
		
		return cipherword;
		
	}
	
	private String caeserConstructor(int cv, int shift) {
		
		int newchar;
		
		if (cv >= MINUPPERCASE && cv <= MAXUPPERCASE) {
			
			newchar = cv + shift;
			if (newchar > MAXUPPERCASE) newchar -= DIF;

		} else if (cv >= MINLOWERCASE && cv <= MAXLOWERCASE) {
			
			newchar = cv + shift;
			if (newchar > MAXLOWERCASE) newchar -= DIF;
			
		} else {
			
			newchar = cv;
			
		}
		
		return Character.toString(newchar);
		
	}
	
	
	private static int MINUPPERCASE = 65;
	private static int MAXUPPERCASE = 90;
	private static int MINLOWERCASE = 97;
	private static int MAXLOWERCASE = 122;
	private static int DIF = MAXUPPERCASE - MINUPPERCASE + 1;

}
