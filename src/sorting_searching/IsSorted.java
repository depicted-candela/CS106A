/**
 * 
 */
package sorting_searching;

import java.util.Arrays;

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
	
	public Boolean isSorted(int[] array) {
		
		int last 	= array.length - 1;
		
		if (last <= 0) return true;
		
		int middle 	= last / 2 + 1;
		
		if (array[0] > array[last]) return false; 
		
		int[] arrayl = Arrays.copyOfRange(array, 0, middle);
		int[] arrayr = Arrays.copyOfRange(array, middle, last);
		
		boolean lis = isSorted(arrayl);
		boolean ris = isSorted(arrayr);

		return lis & ris;
		
	}
	
	public void run() {
		if (isSorted(decreasingArray)) println("Decreasing order");
		if (isSorted(increasingArray)) println("Nondecreasing order");
		if (isSorted(randomArray)) println("Random order");
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
