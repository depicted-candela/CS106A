/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class IsPerfectSquare extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// if the integer n is a perfect square
		
		double n = 1000000000.0;
		long begin = System.currentTimeMillis();
		double root = isPerfectSquare(n);
		long end = System.currentTimeMillis();
		long time = end-begin;
		System.out.println("Elapsed Time: "+ time +" milli seconds");
		
		if (root == 0) {
			println(n + " tiene raíz decimal; no es potencia perfecta");
		} else {
			println("La raíz " + root + " no tiene parte decimal; el entero " + n + " es potencia perfecta");
		}
		
	}
	
	private double isPerfectSquare(double n) {
		
		double root = 2;
		
		while(true) {
			
			if ((root == n / root) && (root * root == n)) {
				return root;
			} else if (root > n / 2.0) {
				return 0.0;
			} else {
				root++;
			}
			
		}
		
	}

}
