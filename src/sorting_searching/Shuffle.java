/**
 * 
 */
package sorting_searching;

import acm.util.*;

/**
 * 
 */
public class Shuffle {

	/**
	 * Displays randomly the integers between 1 and 52
	 */
	public Shuffle() {
		fillsInteger();
	}
	
	/**
	 * Fills an array with all the numbers between 1 and 52
	 */
	private void fillsInteger() {
		for (int i = 0; i < N; i++) {
			I[i] = i + 1;
		}
	}
	
	/**
	 * Displays the I array of Integers
	 */
	public void displayArray() {
		System.out.println(" ");
		for (Integer i: I) {
			System.out.print(i + " ");
		}
	}
	
	/**
	 * Sorts randomly an array of Integers comparing with a random value
	 */
	public void shuffleSelectionSort() {
		for (int i = 0; i < N; i++) {
			swapElements(i, shuffleSelector(i));
		}
	}
	
	/**
	 * Starting from a given item, selects randomly a value to compare with
	 * @param i
	 * @return
	 */
	public Integer shuffleSelector(int i) {
		return rand.nextInt(i, N - 1);
	}
	
	/**
	 * Swaps two elements of the given array I
	 * @param i
	 * @param s
	 */
	public void swapElements(int i, int s) {
		Integer temp = I[i];
		I[i] = I[s];
		I[s] = temp;
	}
	
	public void run() {
		displayArray();
		shuffleSelectionSort();
		displayArray();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Shuffle().run();
	}
	
	private static Integer[] I = new Integer[52];
	private static final Integer N = 52;
	private static RandomGenerator rand = new RandomGenerator();

}
