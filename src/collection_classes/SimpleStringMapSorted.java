/**
 * 
 */
package collection_classes;
import java.util.*;

/**
 * 
 */
public class SimpleStringMapSorted {

	/** Creates a new SimpleStringMap with no key/value pairs */
	@SuppressWarnings("unchecked")
	public SimpleStringMapSorted() {
		bucketArray = new ArrayList[2][INI_BUCKETS];
		capacity = INI_BUCKETS;
		for (int i = 0; i < capacity; i++) {
			bucketArray[0][i] = new ArrayList<>();
			bucketArray[1][i] = new ArrayList<>();
		}
	}
	/**
	* Sets the value associated with key. Any previous value for key is lost.
	* @param key The key used to refer to this value
	* @param value The new value to be associated with key
	*/
	public void put(String key, String value) {
		if (effective_size == capacity) rearranging();
		if (findKey(key) == null) {
			bucketArray[0][effective_size].add(key);
			bucketArray[1][effective_size++].add(value);
			mergeSort(bucketArray, bucketArray.length);
		} else {
			bucketArray[1][findKey(key)].add(value);
		}
	}
	
	/**
	* Rearrange the array of values and keys to make possible to store more
	* values given a new highest hashcode.
	*/
	@SuppressWarnings("unchecked")
	private void rearranging() {
		tempArray = bucketArray;
		bucketArray = new ArrayList[2][capacity];
		for (int i = 0; i < bucketArray[0].length; i++) {
			if (i < tempArray.length) {
				bucketArray[0][i] = tempArray[0][i];
				bucketArray[1][i] = tempArray[1][i];
				mergeSort(bucketArray, bucketArray[0].length);
			} else {
				bucketArray[0][i] = new ArrayList<>();
				bucketArray[1][i] = new ArrayList<>();
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
		ArrayList<String>[][] left = new ArrayList[2][middle];
		ArrayList<String>[][] right = new ArrayList[2][length - middle];
		
		for (int i = 0; i < middle; i++) {
			left[0][i] = arrays[0][i];
			left[1][i] = arrays[1][i];
		}
		
		for (int i = 0; i < length - middle; i++) {
			right[0][i] = arrays[0][i];
			right[0][i] = arrays[1][i];
		}
		
		mergeSort(left, middle);		// The recursion in the left
		mergeSort(right, length - middle);
										// The recursion in the right
		
		merge(arrays, left, right, middle, length - middle);
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
	private void merge(ArrayList<String>[][] arrays, ArrayList<String>[][] array_left,
			ArrayList<String>[][] array_right, int left, int right) {
		
		int i = 0, j = 0, k = 0;
		
		while(i < left && j < right) {	// Iterates along both parts
			
			if (array_left[0][i].get(0).compareTo(array_right[0][j].get(0)) <= 0) {
				arrays[0][k].set(0, array_left[0][i].get(0));
				arrays[1][k++] = array_left[1][i++];
			} else {
				arrays[0][k].set(0, array_right[0][j].get(0));
				arrays[1][k++] = array_right[1][j++];
			}
			
		}
										// Iterates along the left part
		while(i < left && arrays[0].length != 0) {
			arrays[0][k].set(0, array_left[0][i].get(0));
			arrays[1][k++] = array_left[1][i++];
		}
										// Iterates along the right part
		while(j < right && arrays[0].length != 0) {
			System.out.println(arrays[0][k]);
			System.out.println(array_right[0][j].get(0));
			arrays[0][k].set(0, array_right[0][j].get(0));
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
			return bucketArray[1][findKey(key)];
		}
	}
	
	/*
	* Scans the key looking for an entry that matches the specified key.
	* If no such entry exists, findEntry returns null.
	*/
	private Integer findKey(String key) {
		int i = 0;
		ArrayList<String>[] als = bucketArray[0];
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
		for (ArrayList<String>[] suba : bucketArray) {
			System.out.println(suba[0]);
		}
	}
	
	/* Private constants */
	private static final int INI_BUCKETS = 7;
	private int capacity;
	private int effective_size = 0;
	/* Private instance variables */
	public ArrayList<String>[][] bucketArray;
	public ArrayList<String>[][] tempArray;
}
