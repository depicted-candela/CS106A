/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class RegularPluralForm extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public void run() {
		// TODO Auto-generated method stub
		String a = "car";
		String b = "bus";
		String c = "match";
		String d = "dish";
		String e = "box";
		String f = "quiz";
		String g = "city";
		
		println(regularPluralForm(a));
		println(regularPluralForm(b));
		println(regularPluralForm(c));
		println(regularPluralForm(d));
		println(regularPluralForm(e));
		println(regularPluralForm(f));
		println(regularPluralForm(g));
		
	}
	
	private static String regularPluralForm(String s) {
		
		String c = s.substring(s.length() - 1);
		
		if ((c.compareTo("h") == 0)) {
			
			String c1 = s.substring(s.length() - 2);
			
			if (cond.contains(c1)) {
				return s.concat("es");
			} else {
				return s.concat("s");
			}

		} else if (cond.contains(c)) {
			
			return s.concat("es");
			
		} else if (c.compareTo("y") == 0) {
			
			return s.substring(0, s.length() - 1).concat("ies");
			
		} else {
			
			return s.concat("s");
			
		}
		
	}
	
	private static String cond = "xzshch";

}
