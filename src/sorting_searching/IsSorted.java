/**
 * 
 */
package sorting_searching;

import acm.program.*;
import acm.util.*;

/**
 * 
 */
public class IsSorted extends ConsoleProgram {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public IsSorted() {
		for (int i = 0; i < decreasingArray.length; i++) {
		    decreasingArray[i] = decreasingArray.length - i;
		}
		for (int i = 0; i < increasingArray.length; i++) {
		    increasingArray[i] = i + 1;
		}
		RandomGenerator random = new RandomGenerator();
		for (int i = 0; i < randomArray.length; i++) {
		    randomArray[i] = random.nextInt(100); // Assuming you want numbers between 0 and 99
		}
	}
	
	public boolean isSorted(int[] array) {
		int length = array.length;
		int middle = length / 2;
		if (length > 1) {
			
		}
		return false;
	}
	
	public void run() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new IsSorted().start();
	}
	private int[] decreasingArray = new int[10];
	private int[] increasingArray = new int[10];
	private int[] randomArray = new int[10];
}
