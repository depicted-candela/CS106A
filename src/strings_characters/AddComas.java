/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class AddComas extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// TODO Auto-generated method stub
		while (true) {
			
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
			
		}

	}
	
	private String addCommasToNumericString(String s) {
		
		int string_len = s.length();
		int first = string_len % 3;
		int three = string_len / 3;
		
		String w = addCommasConstructor(s, first, three, string_len);
		return w;
		
	}
	
	private String addCommasConstructor(String s, int first, int three, int len) {
		
		String total = new String();
		
		if (len > 2) {
			
			if (first == 0) {
				return multipleOfThree(s, three);
			} else {
				return notMultipleOfThree(s, first, three);
			}
			
		} else {
			
			total = s;
			
		}

		return total;
		
	}
	
	private String notMultipleOfThree(String s, int first, int three) {
		
		String total = new String();
		String first_s = s.substring(0, first);
		String second_s = s.substring(first);
		
		total = first_s.concat(",");
		total = total.concat(multipleOfThree(second_s, three));
		
		return total;
		
	}
	
	private String multipleOfThree(String s, int three) {
		
		String total = new String();
		String sub = new String();
		
		for (int t = 0; t < three; t++) {
			
			sub = s.substring(3*t, 3*t+3);
			if (three - 1 != t) sub = sub.concat(",");
			total = total.concat(sub);
			
		}
		
		return total;
		
	}

}
