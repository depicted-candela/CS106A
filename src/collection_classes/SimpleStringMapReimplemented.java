package collection_classes;
import java.util.*;

public class SimpleStringMapReimplemented {

	/** Creates a new SimpleStringMap with no key/value pairs */
	@SuppressWarnings("unchecked")
	public SimpleStringMapReimplemented() {
		bucketArray = new ArrayList[2][INI_BUCKETS];
		N_BUCKETS = INI_BUCKETS;
		for (int i = 0; i < N_BUCKETS; i++) {
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
		int bucket = Math.abs(key.hashCode());
		if (bucket > N_BUCKETS) rearranging(bucket * 2);
		bucketArray[0][bucket].add(key);
		bucketArray[1][bucket].add(value);
	}
	
	/*
	* Scans the entry chain looking for an entry that matches the specified key.
	* If no such entry exists, findEntry returns null.
	*/
	private String[] findEntry(ArrayList<String>[][] array, String key) {
		String[] re = new String[2];
		int bucket = Math.abs(key.hashCode());
		if (array[0][bucket].contains(key)) {
			int i = array[0][bucket].indexOf(key);
			re[0] = array[0][bucket].get(i);
			re[1] = array[1][bucket].get(i);
			return re;
		}
		return null;
	}
	
	/**
	* Rearrange the array of values and keys to make possible to store more values given a new highest hashcode.
	* @param bucket The new highest bucket to iterate
	* @return The value associated with key, or null if no such value exists
	*/
	@SuppressWarnings("unchecked")
	private void rearranging(int bucket) {
		N_BUCKETS = bucket;
		tempArray = bucketArray;
		bucketArray = new ArrayList[2][bucket];
		for (int i = 0; i < bucketArray[0].length; i++) {
			if (i < tempArray.length) {
				bucketArray[0][i] = tempArray[0][i];
				bucketArray[1][i] = tempArray[1][i];
			} else {
				bucketArray[0][i] = new ArrayList<>();
				bucketArray[1][i] = new ArrayList<>();
			}
		}
	}
	
	/**
	* Retrieves the value associated with key, or null if no such value exists.
	* @param key The key used to look up the value
	* @return The value associated with key, or null if no such value exists
	*/
	public String get(String key) {
		String[] entry = findEntry(bucketArray, key);
		if (entry == null) {
			return null;
		} else {
			return entry[1];
		}
	}
	
	/* Private constants */
	private static final int INI_BUCKETS = 7;
	private int N_BUCKETS;
	/* Private instance variables */
	public ArrayList<String>[][] bucketArray;
	public ArrayList<String>[][] tempArray;
}
