/**
 * 
 */
package object_memory_model;

/**
 * 
 */

import acm.program.*;

public class HexToDecimalConverter extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		println("This program converts hexadecimal to decimal.\nEnter 0 to stop.");
		
		while(true) {
			String hn = readLine("Enter a hexadecimal number: ");
			if (hn.equals("0")) break;
			int a = Integer.parseInt(hn, 16);
			println(hn + " hex = " + Integer.toString(a) + " decimal");
		}
		
	}
	
	public static void main(String[] args) {
		
		new HexToDecimalConverter().start();

	}

}
