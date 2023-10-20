/**
 * 
 */
package sorting_searching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import acm.program.*;

/**
 * 
 */

public class EnterFile extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	private BufferedReader openFileReader(String prompt) {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				String name = readLine(prompt);
				rd = new BufferedReader(new FileReader(name));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
	}
	
	public void run() {
		openFileReader("Enter the name of a file: ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EnterFile().start();
		
	}

}
