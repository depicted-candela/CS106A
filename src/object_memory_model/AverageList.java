/**
 * 
 */
package object_memory_model;

/**
 * 
 */

import acm.program.*;

public class AverageList extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	private static final String SENTINEL = " ";
	/**
	 * @param args
	 */
	
	public void run() {
		println("This program calculates the average a list of integers.");
		println("Enter values, one per line, using the space key");
		println("to signal the end of the list.");
		int total = 0;
		int count = 0;
		String value = readLine(" ? ");
		while (!value.equals(SENTINEL)) {
			total += Integer.parseInt(value);
			count ++;
			value = readLine(" ? ");
		}
		println("The average is " + total / count + ".");
	}
		
	public static void main(String[] args) {
		new AverageList().start();
	}

}