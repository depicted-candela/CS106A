/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class NDigitsN extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// returns the number of digits in the integer n
		int r = digits(I);
		println(r);
		
	}
	
	private int digits(int i) {

		while(true) {
			if (i/10 < 10) {
				return 2;
			} else {
				return 1 + digits(i/10);
			}
		}
	}
	
	private static final int I = 11021111;
	
}
