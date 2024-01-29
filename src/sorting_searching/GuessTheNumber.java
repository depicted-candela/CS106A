/**
 * 
 */
package sorting_searching;

import acm.program.*;

/**
 * 
 */
public class GuessTheNumber extends ConsoleProgram {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Initializes the properties of the class
	 */
	public GuessTheNumber() {
        for (int i = 1; i < 101; i++) {
            INTS[i - 1] = i;
        }
	}
	
	/**
	 * The logic of the program when running
	 */
	public void run() {
		println("Think of a number between 1 and 100.");
		while (true) {
			String is = readLine("Is it " + Integer.toString(START) + "?: ");
			if (is.equals("no") || is.equals("No") || is.equals("NO")) {
				String less = readLine("Is it less than " + Integer.toString(START) + "?: ");
				if (less.equals("yes") || less.equals("Yes") || less.equals("YES")) {
					END = START;
					START = BEGINNING + (END - BEGINNING) / 2;
				} else {
					BEGINNING = START;
					START = BEGINNING + (END - BEGINNING) / 2;
				}
			} else {
				break;
			}
		}
		println("I guessed the number!");
	}

	/**
	 * The class invokation
	 */
	public static void main(String[] args) {
		new GuessTheNumber().start();
	}
	
	private int[] INTS 		= new int[100];
	private int BEGINNING 	= 0;
	private int END 		= 100;
	private int START 		= 50;
	
}
