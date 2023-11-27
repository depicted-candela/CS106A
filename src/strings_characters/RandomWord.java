/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;
import acm.util.*;

public class RandomWord extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public void run() {
		// TODO Auto-generated method stub
		String word = randomWord();
		println(word);

	}
	
	private String randomWord() {
		
		int letters = rand.nextInt(MIN_LETTERS, MAX_LETTERS);
		String word = new String();
		
		for (int i = 0; i < letters; i++) {
			int letter = rand.nextInt(65, 90);
			String l = Character.toString((char) letter);
			word += l;
		}
		
		return word;
	}
	
	private static RandomGenerator rand = new RandomGenerator();
	private static int MIN_LETTERS = 1;
	private static int MAX_LETTERS = 10;

}
