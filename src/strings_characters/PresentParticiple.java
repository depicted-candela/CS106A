/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class PresentParticiple extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		// TODO Auto-generated method stub
		String s1 = "move";
		String s2 = "see";
		String s3 = "jam";
		String s4 = "walk";
		println(presentParticiple(s1));
		println(presentParticiple(s2));
		println(presentParticiple(s3));
		println(presentParticiple(s4));
		
	}
	
	private String presentParticiple(String s) {
		
		String st1 = s.substring(s.length() - 1);
		String st2 = s.substring(s.length() - 2, s.length() - 1);
		
		if (st1.compareTo("e") == 0) {
			if (isConsonant(st2)) {
				return ecException(s);
			} else {
				return s.concat("ing");
			}
		} else if (!isConsonant(st2) && isConsonant(st1)) {
			return vcException(s, st1);
		} else {
			return s.concat("ing");
		}
		
	}
	
	private String ecException(String s) {
		
		s = s.substring(0, s.length() - 1);
		return s.concat("ing");
		
	}
	
	private String vcException(String w, String c) {
		
		String r = w.concat(c);
		return r.concat("ing");
		
	}
	
	private boolean isConsonant(String s) {
		
		if (vowels.contains(s)) {
			return false;
		} else {
			return true;
		}
		
	}
	
	private static String vowels = "aeiou";

}
