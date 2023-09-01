/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class MyIdexOf extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		// TODO Auto-generated method stub
		
		String s = "baaa";
		println(myIndexOf(s));
		
	}
	
	public int myIndexOf(String s) {
		Character c = s.charAt(0);
		return c.charValue();
	}

}
