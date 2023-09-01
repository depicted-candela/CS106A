/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class Scrabble extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		// TODO Auto-generated method stub
		String s = readLine("Enter your scrabble word: ");
		String cha = new String();
		int p = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			if (i >= 0 && (i < s.length() - 1)) {
				
				cha = s.substring(i, i+1);
				
			} else {
				
				cha = s.substring(i);
				
			}
			
			p += uppercaseLetter(cha);
			
		}
		
		println("The points: " + p);
		
	}
	
	private int uppercaseLetter(String s) {
		
		Character c = s.charAt(0);
		if (Character.isUpperCase(c)) {
			return toPoints(s);
		} else {
			return 0;
		}
		
	}
	
	private int toPoints(String s) {
		
		if (point_1.contains(s)) {
			return 1;
		} else if (point_2.contains(s)) {
			return 2;
		} else if (point_3.contains(s)) {
			return 3;
		} else if (point_4.contains(s)) {
			return 4;
		} else if (point_5.contains(s)) {
			return 5;
		} else if (point_8.contains(s)) {
			return 8;
		} else {
			return 10;
		}
		
	}
	
	private static String point_1 = "AEILNORSTU";
	private static String point_2 = "DG";
	private static String point_3 = "BCMP";
	private static String point_4 = "FHVWY";
	private static String point_5 = "K";
	private static String point_8 = "JX";

}
