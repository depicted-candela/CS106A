/**
 * 
 */
package sorting_searching;

import java.util.*;
import acm.util.RandomGenerator;

/**
 * 
 */
public class Median {

	/**
	 * 
	 */
	public Median() {
		for (int i = 0; i < randomArray.length; i++) {
			int in 		= random.nextInt(1, 120);
		    randomArray[i] 	= in; // Assuming you want numbers between 0 and 99
		}
	}
	
	/**
	 * Sorts an array of integers with selection sort
	 * @param array
	 */
	public void sort(int[] array) {
		for (int lh = 0; lh < array.length; lh++) {
			int rh = findSmallest(array, lh, array.length);
			swapElements(array, lh, rh);
		}
	}
	
	/**
	 * Sorts an array of integers with radix sort
	 * @param array
	 */
	public void radixSort(int base) {
		String[] arrayS = intToStr(randomArray);
		for (int g = arrayS[0].length() - 1; g >= 0; g--) {
			bucketsDec(arrayS, g);
		}
		randomArray = strToInt(arrayS);
	}
	
	/**
	 * Prints a desired array os Strings
	 * @param rs
	 */
	public void printArrayS(String[] rs) {
		for (int i = 0; i < rs.length; i++) {
			System.out.print(rs[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * Prints the Median's main array of String
	 */
	public void printRandomArrayS() {
		for (int i = 0; i < randomArray.length; i++) {
			System.out.print(randomArray[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * Hashing to sort in radixSort
	 * @param array
	 * @param hierarchy
	 */
	private void bucketsDec(String[] array, int hierarchy) {
		ArrayList<ArrayList<String>> bucketsO = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			bucketsO.add(new ArrayList<>());
		}
		for (int i = 0; i < array.length; i++) {
			String s = array[i];
			bucketsO.get(Integer.parseInt(String.valueOf(s.charAt(hierarchy)))).add(s);
		}
		int c = 0;
		for (ArrayList<String> as: bucketsO) {
			for (String s: as) {
				array[c++] = s;
			}
		}
	}
	
	/**
	 * Transforms an array of integers to an array of Strings
	 * @param array
	 * @return
	 */
	private String[] intToStr(int[] array) {
		String[] as = new String[array.length];
		String temp;
		int maxL 	= maxL(array);
		for (int i = 0; i < array.length; i++) {
			temp = String.valueOf(array[i]);
			if (temp.length() < maxL) {
				int dif = maxL - temp.length();
				String l = "";
				for (int s = 0; s < dif; s++) {
					l += "0";
				}
				temp = l + temp;
			}
			as[i] = temp;
		}
		return as;
	}
	
	/**
	 * Transforms an Array of Strings to an Array of integers
	 * @param sarray
	 * @return
	 */
	private int[] strToInt(String[] sarray) {
		int[] as = new int[sarray.length];
		for (int i = 0; i < sarray.length; i++) {
			as[i] = Integer.parseInt(sarray[i]);
		}
		return as;
	}
	
	/**
	 * Max number in the array
	 * @param array
	 * @return
	 */
	private int maxL(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) max = array[i];
		}
		return String.valueOf(max).length();
	}
	
	/**
	 * Find the smallest integer in an array from a starting and a ending point
	 * @param array
	 * @param p1
	 * @param p2
	 * @return
	 */
	private int findSmallest(int[] array, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (array[i] < array[smallestIndex]) smallestIndex = i;
		}
		return smallestIndex;
	}
	
	/**
	 * Exchanges the elements in an array at index positions p1 and p2.
	 * @param array
	 * @param p1
	 * @param p2
	 */
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}
	
	/**
	 * Searchs the median value of the array of integers
	 * @param arr
	 * @return
	 */
	private int median() {
		if (randomArray.length % 2.0 == 0) {
			return (randomArray[randomArray.length / 2 - 1] + randomArray[randomArray.length / 2]) / 2;
		} else {
			return randomArray[(int) (randomArray.length / 2.0 + 1 / 2.0)];
		}
	}
	/**
	 * Prints an array
	 */
	public void printRandomArray() {
		for (Integer i : randomArray) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void run() {
		System.out.println("La mediana es: " + median());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Median().run();
	}
	
	private static RandomGenerator random = new RandomGenerator();
	private static int[] randomArray = new int[100];

}
