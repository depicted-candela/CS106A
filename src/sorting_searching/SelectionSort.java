/**
 * 
 */
package sorting_searching;

//import java.util.Comparator;

import acm.util.RandomGenerator;

//import java.util.Collections;
//import java.lang.reflect.Array;
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
	/**
	 * Alphabetize an array of strings in lexicographic order
	 * @param ali an ArrayList of Strings
	 */
	private void alphabetize(String[] array) {
		for (int lh = 0; lh < array.length; lh++) {
			int rh = findSmallest(array, lh, array.length);
			swapElements(array, lh, rh);
		}
	}
	/**
	 * Sort an ArrayList of Integers into increasing order
	 * @param ali an ArrayList of Integers
	 */
	private void sort(ArrayList<Integer> ali) {
		for (int lh = 0; lh < ali.size(); lh++) {
			int rh = findSmallest(ali, lh, ali.size());
			swapElements(ali, lh, rh);
		}
	}
	/* Returns the index of the smallest array element between p1 and p2 - 1 */
	private int findSmallest(int[] array, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (array[i] < array[smallestIndex]) smallestIndex = i;
		}
		return smallestIndex;
	}
	/* Returns the index of the smallest arrayList element between p1 and p2 - 1 */
	private int findSmallest(ArrayList<Integer> ali, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (ali.get(i) < ali.get(smallestIndex)) smallestIndex = i;
		}
		return smallestIndex;
	}
	/* Returns the index of the smallest array element between p1 and p2 - 1 */
	private int findSmallest(String[] array, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (array[i].compareTo(array[smallestIndex]) < 0) smallestIndex = i;
		}
		return smallestIndex;
	}
	/* Exchanges the elements in an array at index positions p1 and p2. */
	private void swapElements(String[] array, int p1, int p2) {
		String temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}
	/* Exchanges the elements in an array at index positions p1 and p2. */
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}
	/* Exchanges the elements in an arrayList at index positions p1 and p2. */
	private void swapElements(ArrayList<Integer> ali, int p1, int p2) {
		int temp = ali.get(p1);
		ali.set(p1, ali.get(p2));
		ali.set(p2, temp);
	}
	
	/**
	 * Initializes the SelectionSort class
	 */
	public SelectionSort() {
		for (int i = 0; i < randomArray.length; i++) {
			int in 		= random.nextInt(1000);
			String s = "";
			Integer ins = null;
			for (int j = 0; j < 3; j++) {
				ins		= random.nextInt(80, 85);
				s += Character.toString((char) ins.intValue());
				s += Character.toString((char) ins.intValue());
			}
			s += Character.toString((char) ins.intValue());
		    randomArray[i] 	= in; // Assuming you want numbers between 0 and 99
		    randomArrayList.add(in);
		    randomArrayString[i] = s;
		}
	}
	private void printRandomArrayString() {
		System.out.println();
		for (String i : randomArrayString) {
			System.out.print(i + " ");
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
		printRandomArrayString();
		alphabetize(randomArrayString);
		printRandomArrayString();
		System.out.println();
		printRandomArrayList();
		sort(randomArrayList);
		printRandomArrayList();
		System.out.println();
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
	private static String[] randomArrayString = new String[15];
	private static RandomGenerator random = new RandomGenerator();

}
