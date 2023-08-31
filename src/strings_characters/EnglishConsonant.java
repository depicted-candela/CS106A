/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class EnglishConsonant extends ConsoleProgram {

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		// Infinite loop
		while (true) {
			
			// Input
			String c = readLine("Enter a single character: ");
			
			if(c.length() != 1) {
				println("Please provide a single character");
			} else {
				Character ch = c.charAt(0);
				if (isEnglishConsonant(ch)) {
					println("Consonant");
				} else {
					println("Not consonant");
				}
			}
			
		}
		
	}
	
	private boolean isEnglishConsonant(Character ch) {
		
		if(Character.isAlphabetic(ch)) if (!isNotVowel(Character.toLowerCase(ch))) return true;

		return false;
	}

	private boolean isNotVowel(Character ch) {
		
		if (Character.isUpperCase(ch)) {
			ch = Character.toLowerCase(ch);
		}
		
		boolean b1 = ch.compareTo('a') == 0;
		boolean b2 = ch.compareTo('e') == 0;
		boolean b3 = ch.compareTo('i') == 0;
		boolean b4 = ch.compareTo('o') == 0;
		boolean b5 = ch.compareTo('u') == 0;
		
		if (b1 || b2 || b3 || b4 || b5 ) {

			return true;
		} else {
			return false;
		}
		
	}

}
