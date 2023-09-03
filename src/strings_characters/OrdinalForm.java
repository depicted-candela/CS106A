/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class OrdinalForm extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public void run() {
		// TODO Auto-generated method stub
		
		println(ordinalForm(1));
		println(ordinalForm(2));
		println(ordinalForm(3));
		println(ordinalForm(10));
		println(ordinalForm(11));
		println(ordinalForm(12));
		println(ordinalForm(21));
		println(ordinalForm(42));
		println(ordinalForm(101));
		println(ordinalForm(111));
		
	}
	
	private String ordinalForm(int i) {
		
		String cardinal = Integer.toString(i);
		return cardinal + rulesConstructor(cardinal);
		
	}
	
	private String rulesConstructor(String upu) {
		
		int l = upu.length();
		String u = upu.substring(l - 1);
		
		if (l != 1) {
			String pu = upu.substring(l - 2, l - 1);
			return notOneDigit(pu, u);
		} else {
			return oneDigit(u);
		}
		
	}
	
	private String oneDigit(String s) {
		
		if (s.compareTo("1") == 0) {
			return "st";
		} else if (s.compareTo("2") == 0) {
			return "nd";
		} else {
			return "rd";
		}
		
	}
	
	private String notOneDigit(String pu, String u) {
		
		if (pu.compareTo("1") == 0 && rule1.contains(u)) {
			return "th";
		} else if (rule1.contains(u)) {
			return oneDigit(u);
		} else {
			return "th";
		}
		
	}
	
	
	private static String rule1 = "123";

}
