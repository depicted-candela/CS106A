/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class Palindrome extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		// TODO Auto-generated method stub
		String w = readLine("Enter a work to know if its a palindrome: ");
		w = stringCleaner(w);
		if (isPalindromeConstructor(w)) {
			println("It's a palindrome");
		} else {
			println("It's not a palindrome");
		}
	}

	private boolean isPalindromeConstructor(String s) {
		
		int s_len = s.length();
		String first = s.substring(0, s_len/2);
		String second;
		
		if (s_len % 2 == 0) {
			
			second = s.substring(s_len/2);
			 
		} else {
			
			second = s.substring(s_len/2 + 1);
			 
		}
		
		return isPalindrome(first, second);
		
	}
	
	private boolean isPalindrome(String first, String second) {
		
		int fl = first.length();
		
		for (int i = 0; i < fl; i++) {
			
			Character c1 = first.charAt(i);
			Character c2 = second.charAt(fl - 1 - i);
			if(!c1.equals(c2)) return false;
			
		}
		
		return true;
		
	}
	
	private String stringCleaner(String s) {
		
		String cleaned = new String();
		
		for (int i = 0; i < s.length(); i++) {
			
			Character c = s.charAt(i);
			
			if(Character.isAlphabetic(c)) {
				
				cleaned = cleaned + c.toString();
				
			}
			
		}
		
		return cleaned.toLowerCase();
		
	}
	
}
