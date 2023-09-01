/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class Capitalize extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// Capitalizing a word
		while (true) {
			
			String st = readLine("Enter an string to capitalize: ");
			if (st.compareTo(sentinel) == 0) break;
			st = st.toLowerCase();
			st = capitalizeString(st);
			println(st);
			
		}

	}
	
/**
 * Creates a capitalized string from a string
 * @param s The given string
 * @return The capitalized string
 */
	private String capitalizeString(String s) {
		
		String cap = new String();
		String cha = new String();
		
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (i == 0 && Character.isAlphabetic(c)) {
				
				cha = s.substring(i, i+1);
				cha = cha.toUpperCase();
				
			} else if ((i > 0) && (i < s.length() - 1)) {
				
				cha = s.substring(i, i+1);
				
			} else {
				
				cha = s.substring(i);
				
			}
			cap += cha;
		}
		
		return cap;
		
	}
	
	private static String sentinel = "0";

}
