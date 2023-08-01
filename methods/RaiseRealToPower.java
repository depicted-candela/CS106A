/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class RaiseRealToPower extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// takes two integers, n and k, and returns nk
		float n = (float) 3.14159;
		int k = -4;
		int l = 4;
		float r;
		
		for (int i = k; i <= l; i++) {

			r = raiseRealToPower(n, i);
			println(r);
			
		}

	}
	
	// Recursion to multiplicate a number k times, or recursive potentiation
	private float raiseRealToPower(float n, int k) {
		
		if (k == 0) {
			return (float) 1;
		} else if (k == -1) {
			return 1 / n;
		} else if (k == 1) {
			return n;
		} else if (k < -1) {
			return raiseRealToPower(n, k + 1) / n;
		} else {
			return raiseRealToPower(n, k - 1) * n;
		}
		
	}
	
}
