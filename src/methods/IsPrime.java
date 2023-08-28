/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class IsPrime extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		println(isPrime(168492));
		long endTime = System.currentTimeMillis();
		long executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " milliseconds");
	}
	
	private boolean isPrime(int n) {
		
		for (int i = 2; i < 10; i++) {
			
			if (n % i == 0) {
				return false;
			}
			
		}
		
		return true;
	}

}
