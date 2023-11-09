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
		if (findKey(bucketArray[0], key) == null) {
			bucketArray[0][effective_size].add(key);
			bucketArray[1][effective_size++].add(value);
		} else {
			bucketArray[1][findKey(bucketArray[0], key)].add(value);
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
	 */
	private void mergeSort(ArrayList<String>[][] arrays, int length) {
		if (length < 2) {
			return;
		}
		int middle = length / 2;
		int[] left = new int[middle];
		int[] right = new int[length - middle];
	}
	
	
	/**
	* Retrieves the value associated with key, or null if no such value exists.
	* @param key The key used to look up the value
	* @return The value associated with key, or null if no such value exists
	*/
	public ArrayList<String> get(String key) {
		if (findKey(bucketArray[0], key) == null) {
			return null;
		} else {
			return bucketArray[1][findKey(bucketArray[0], key)];
		}
	}
	
	/*
	* Scans the key looking for an entry that matches the specified key.
	* If no such entry exists, findEntry returns null.
	*/
	private Integer findKey(ArrayList<String>[] array, String key) {
		int i = 0;
		for (ArrayList<String> arr: array) {
			if (arr.contains(key)) return i;
			i++;
		}
		return null;
	}
	
	/* Private constants */
	private static final int INI_BUCKETS = 7;
	private int capacity;
	private int effective_size = 0;
	/* Private instance variables */
	public ArrayList<String>[][] bucketArray;
	public ArrayList<String>[][] tempArray;
}
