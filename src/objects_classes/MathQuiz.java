/**
 * 
 */
package objects_classes;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;
import acm.util.RandomGenerator;
import java.util.ArrayList;

public class MathQuiz extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		println("Welcome to Math Quiz");
		
		// Software to add and substract
		while (true) {
			simpleOperation(sign_numbers.nextBoolean());
		}
		
	}
	
	private void simpleOperation(boolean op) {
		
		ArrayList<Integer> ints = Ints();
		int n1 = ints.get(0);
		int n2 = ints.get(1);
		int n3 = n2;
		String sign = " + ";
		int tries = 0;
		
		if (!op) {
			
			n3 = -n2;
			sign = " - ";
			
		}
			
		int result;
		
		while (tries < 3) {
			
			if (tries == 0) {
				result = readInt("What is " + n1 + sign + n2 + "?: ", MIN, MAX);
			} else {
				result = readInt("That's incorrect - try a different answer: ", MIN, MAX);
			}
			
			if (result == n1 + n3) {
				println("That's the answer!");
				break;
			}
			
			tries++;
			
			if (tries == 3) {
				println("No, the answer is " + n1 + n3);
			}
				
		}
	
	}
	
	private ArrayList<Integer> Ints() {
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		while (true) {
			
			int n1 = sign_numbers.nextInt(MIN, MAX);
			int n2 = sign_numbers.nextInt(MIN, MAX);
			int sum = n1 + n2;
			int subs = n1 - n2;
			
			if (sum >= MIN && sum <= MAX && subs >= 0) {
				
				ints.add(n1);
				ints.add(n2);
				break;
				
			}
			
		}
		
		return ints;
		
	}
	
	private RandomGenerator sign_numbers = new RandomGenerator();
	private static final int MAX = 20;
	private static final int MIN = 0;
	
}
