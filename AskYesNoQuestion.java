/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class AskYesNoQuestion extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		while (true) {
		
			// Scanner object to read input from the user
			String answer = readLine("Would you like instructions?: ");
			
			if (answer.equals("yes")) break;
		
		}
		
		println("Finished");

	}

}
