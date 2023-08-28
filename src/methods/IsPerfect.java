/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class IsPerfect extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		// Iterate over numbers to calculate it's perfection
		for(double i = 1; i < 10000.0; i++) {
			if (isPerfect(i)) {
				println(i);
			}
		}

	}
	
	private boolean isPerfect(double n) {
		
		int sum = 0;
		
		// Iterate along the numbers less than the parameter
		for (int i = 1; i < n; i++) {
			
			// If the parameter is divisible by the iteration
			if (n % i == 0) {
				
				sum += i;
				
				if (sum > n) {
					return false;
				}
				
			}
			
		}
		
		if (sum == n) {
			return true;
		} else {
			return false;
		}
		
	}

}
