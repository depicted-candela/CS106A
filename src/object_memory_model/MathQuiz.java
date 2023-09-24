/**
 * 
 */
package object_memory_model;

import java.util.ArrayList;

/**
 * 
 */

import acm.program.*;
import acm.util.RandomGenerator;

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
		String s_result;
		
		while (tries < 3) {
			
			if (tries == 0) {
				result = readInt("What is " + n1 + sign + n2 + "?: ", MIN, MAX);
			} else {
				result = readInt("That's incorrect - try a different answer: ", MIN, MAX);
			}
			
			s_result = Integer.toString(result);
			
			if (s_result.equals(OctalOperations(n1, n3))) {
				okMessage();
				break;
			}
			
			tries++;
			
			if (tries == 3) {
				println("No, the answer is " + OctalOperations(n1, n3));
			}
				
		}
	
	}
	
	private String OctalOperations(int n1, int n2) {
		
		if (n2 == 0) return Integer.toString(n1);
		int sum_d = FromOctalToString(n1) + FromOctalToString(n2);
		return Integer.toOctalString(sum_d);
		
	}
	
	public int FromOctalToString(int ii) {
		
		String s = Integer.toString(ii);
		if (ii < 0) s = Integer.toString(-ii);
		int integer = 0;
		int sub;
		for (int i = s.length(); i > 0; i--) {
			sub = Character.digit(s.charAt(i - 1), 8);
			integer += sub * Math.pow(8, s.length() - i);
		}
		
		if (ii < 0) return -integer;
		return integer;
		
	}
	
	private ArrayList<Integer> Ints() {
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		while (true) {
			
			int n1_1 = sign_numbers.nextInt(MIN, 7);
			int n1_2 = sign_numbers.nextInt(MIN, 7);
			int n1 = Integer.parseInt(Integer.toString(n1_1) + Integer.toString(n1_2));
			int n2_1 = sign_numbers.nextInt(MIN, 7);
			int n2_2 = sign_numbers.nextInt(MIN, 7);
			int n2 = Integer.parseInt(Integer.toString(n2_1) + Integer.toString(n2_2));
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
	
	private void okMessage() {
		
		int m = sign_numbers.nextInt(0, 2);
		
		switch(m) {
			case 0:
				println("Correct!");
				break;
			case 1:
				println("You got it!");
				break;
			case 2:
				println("That's the answer!");
				break;
			default: break;
		}
		
	}
	
	private RandomGenerator sign_numbers = new RandomGenerator();
	private static final int MAX = 176;
	private static final int MIN = 0;
	
	public static void main(String[] args) {
		
		new MathQuiz().start();

	}

}
