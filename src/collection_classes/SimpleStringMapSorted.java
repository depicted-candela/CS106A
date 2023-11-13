/**
 * 
 */
package collection_classes;
import java.util.*;
import java.util.Iterator;

/**
 * 
 */
public class SimpleStringMapSorted<E> implements Iterator<E> {

	/** Creates a new SimpleStringMap with no key/value pairs */
	@SuppressWarnings("unchecked")
	public SimpleStringMapSorted() {
		BUCKETARRAY = new ArrayList[2][INI_BUCKETS];
		capacity = INI_BUCKETS;
		actual = 0;
		for (int i = 0; i < capacity; i++) {
			BUCKETARRAY[0][i] = new ArrayList<String>();
			BUCKETARRAY[1][i] = new ArrayList<String>();
		}
	}
	/**
	* Sets the value associated with key. Any previous value for key is lost.
	* @param key The key used to refer to this value
	* @param value The new value to be associated with key
	*/
	public void put(String key, String value) {
		
		if (effective_size == capacity) {
			capacity *= 2;
			rearranging();
			mergeSort(BUCKETARRAY, effective_size);
		}
		if (findKey(key) == null) {
			BUCKETARRAY[0][effective_size].add(key);
			BUCKETARRAY[1][effective_size++].add(value);
		} else {
			BUCKETARRAY[1][findKey(key)].add(value);
		}
		
	}
	
	/**
	* Rearrange the array of values and keys to make possible to store more
	* values given a new highest hashcode.
	*/
	@SuppressWarnings("unchecked")
	private void rearranging() {
		tempArray = BUCKETARRAY;
		BUCKETARRAY = new ArrayList[2][capacity];
		for (int i = 0; i < capacity; i++) {
			if (i < effective_size) {
				BUCKETARRAY[0][i] = tempArray[0][i];
				BUCKETARRAY[1][i] = tempArray[1][i];
			} else {
				BUCKETARRAY[0][i] = new ArrayList<String>();
				BUCKETARRAY[1][i] = new ArrayList<String>();
			}
		}
	}
	
	/**
	 * Reorder the array of values and keys with mergeSort by keys
	 * to make possible the implementation of the SortedMap interface.
	 * @param arrays Array to sort with the merge method
	 * @param length The length to save lines of code
	 * @return Nothing but the sentinel condition to end each branch of
	 * the recursive algorithm
	 */
	@SuppressWarnings("unchecked")
	private void mergeSort(ArrayList<String>[][] arrays, int length) {
		
		if (length < 2) return;			// The sentinel condition to end the
										// recursion
		int middle = length / 2;		// To segment the parent array into
										// discret sub arrays
		int fin = length - middle;
		
		ArrayList<String>[][] left = new ArrayList[2][length];
		ArrayList<String>[][] right = new ArrayList[2][length];
		
		for (int i = 0; i < length; i++) {
			if (i < middle) {
				left[0][i] = arrays[0][i];
				left[1][i] = arrays[1][i];
			} else {
				left[0][i] = new ArrayList<String>();
				left[1][i] = new ArrayList<String>();
			}
		}
		
		for (int i = 0; i < length; i++) {
			if (i >= middle) {
				right[0][i - middle] = arrays[0][i];
				right[1][i - middle] = arrays[1][i];
			} else {
				right[0][i] = new ArrayList<String>();
				right[1][i] = new ArrayList<String>();
			}
		}
		
		mergeSort(left, middle);		// Left recursion
		mergeSort(right, fin);
										// Right recursion
		merge(arrays, left, right, middle, fin);
										// Recursively merges each step
	}
	
	/**
	 * To merge the arrays of the mergeSort method
	 * @param arrays The array to put the merge result
	 * @param array_left The array at the left to merge
	 * @param array_right The array at the right to merge
	 * @param left The size of the left array
	 * @param right The size of the right array
	 */
	private void merge(
			ArrayList<String>[][] arrays,
			ArrayList<String>[][] array_left,
			ArrayList<String>[][] array_right, int left, int right) {
		
		int i = 0, j = 0, k = 0;
		
		while(i < left && j < right) {	// Iterates along both parts
			
			if (array_left[0][i].get(0).compareTo(array_right[0][j].get(0)) <= 0) {
				arrays[0][k] = array_left[0][i];
				arrays[1][k++] = array_left[1][i++];
			} else {
				arrays[0][k] = array_right[0][j];
				arrays[1][k++] = array_right[1][j++];
			}
			
		}
		
		while(i < left) {				// Iterates along the left part
			arrays[0][k] = array_left[0][i];
			arrays[1][k++] = array_left[1][i++];
		}
		
		while(j < right) {				// Iterates along the right part
			arrays[0][k] = array_right[0][j];
			arrays[1][k++] = array_right[1][j++];
		}
		
	}
	
	/**
	* Retrieves the value associated with key, or null if no such value exists.
	* @param key The key used to look up the value
	* @return The value associated with key, or null if no such value exists
	*/
	public ArrayList<String> get(String key) {
		if (findKey(key) == null) {
			return null;
		} else {
			return BUCKETARRAY[1][findKey(key)];
		}
	}
	
	/*
	* Scans the key looking for an entry that matches the specified key.
	* If no such entry exists, findEntry returns null.
	*/
	private Integer findKey(String key) {
		int i = 0;
		ArrayList<String>[] als = BUCKETARRAY[0];
		for (ArrayList<String> arr: als) {
			if (arr.contains(key)) return i;
			i++;
		}
		return null;
	}
	
	/**
	 * Print all the values in the object aggregated by key
	 */
	public void print() {
		for (int i = 0; i < effective_size; i++) {
			System.out.print(BUCKETARRAY[0][i]);
			System.out.print(": ");
			System.out.println(BUCKETARRAY[1][i]);
		}
	}
	
	@Override
	public boolean hasNext() {
		boolean b1 = BUCKETARRAY[0][actual + 1] == null;
		boolean b2 = BUCKETARRAY[0][actual + 1].size() == 0;
		if (b1 || b2) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		if (hasNext()) {
			
			int vals = BUCKETARRAY[1][actual + 1].size();
			String[] key = {BUCKETARRAY[0][actual + 1].get(0)};
			String[] values = new String[vals];
			
			for (int i = 0; i < vals; i++) {
				values[i] = BUCKETARRAY[1][actual + 1].get(i);
			}
			
			String[][] total = {key, values};
			
			return (E) total;
		}
		return null;
	}
	
	/* Private constants */
	private static final int INI_BUCKETS = 7;
	private int actual;
	private int capacity;
	private int effective_size = 0;
	/* Private instance variables */
	public ArrayList<String>[][] BUCKETARRAY;
	public ArrayList<String>[][] tempArray;
	
}
