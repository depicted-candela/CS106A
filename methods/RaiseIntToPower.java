package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class RaiseIntToPower extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// takes two integers, n and k, and returns nk
		int n = 2;
		int k = 10;
		int r;
		for (int i = 0; i <= k; i++) {
			r = raiseIntToPower(n, i);
			println("El resultado de la potenciación de " + n + " a la i, es: " + r);
		}
		
	}
	
	// Recursion to multiplicate a number k times, or recursive potentiation
	private static int raiseIntToPower(int n, int k) {
		
		if (k == 0) {
			return 1;
		} else if (k == 1) {
			return n;
		} else {
			return n * raiseIntToPower(n, k - 1);
		}
			
	}
	
}