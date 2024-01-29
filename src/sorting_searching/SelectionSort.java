/**
 * 
 */
package sorting_searching;

import java.util.Comparator;

import acm.util.RandomGenerator;

import java.util.Collections;
import java.util.ArrayList;

/**
 * 
 */
public class SelectionSort {
	
	/**
	* Sorts an integer array into increasing order. The implementation uses
	* an algorithm called selection sort, which can be described informally
	* in English as follows:
	*
	*	With your left hand, point at each element in the array in turn, starting
	*	at index 0. At each step in the cycle:
	*		1. Find the smallest element in the range between your left hand and the
	*		end of the array, and point at that element with your right hand.
	*		2. Move that element into its correct index position by switching the
	*		elements indicated by your left and right hands.
	*/
	private void sort(int[] array) {
		for (int lh = 0; lh < array.length; lh++) {
			int rh = findSmallest(array, lh, array.length);
			swapElements(array, lh, rh);
		}
	}
	Comparator<Integer> comp = new Comparator<Integer> () {
		@Override
		public int compare(Integer i1, Integer i2) {
			return i2.compareTo(i1) * -1;
		}
	};
	private void sort(ArrayList<Integer> ali) {
		Collections.sort(ali, comp);
	}
	/* Returns the index of the smallest array element between p1 and p2 - 1 */
	private int findSmallest(int[] array, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (array[i] < array[smallestIndex]) smallestIndex = i;
		}
		return smallestIndex;
	}
	/* Exchanges the elements in an array at index positions p1 and p2. */
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}
	
	/**
	 * 
	 */
	public SelectionSort() {
		for (int i = 0; i < randomArray.length; i++) {
		    randomArray[i] = random.nextInt(100); // Assuming you want numbers between 0 and 99
		    randomArrayList.add(random.nextInt(100));
		}
	}
	private void printRandomArrayList() {
		System.out.println();
		for (Integer i : randomArrayList) {
			System.out.print(i + " ");
		}
	}
	private void printRandomArray() {
		System.out.println();
		for (Integer i : randomArray) {
			System.out.print(i + " ");
		}
	}
	public void run() {
		printRandomArrayList();
		sort(randomArrayList);
		printRandomArrayList();
		printRandomArray();
		sort(randomArray);
		printRandomArray();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SelectionSort().run();
	}
	
	private static int[] randomArray = new int[15];
	private static ArrayList<Integer> randomArrayList = new ArrayList<Integer>();
	private static RandomGenerator random = new RandomGenerator();

}
