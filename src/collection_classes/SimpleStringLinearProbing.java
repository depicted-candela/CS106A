/**
 * 
 */
package collection_classes;

/** This class implements a simplified version of a Map class for strings,
 *  uses LinearProbing, is capable of dynamically expansion and deletion. */
public class SimpleStringLinearProbing {
	/** Creates a new SimpleStringMap with no key/value pairs */
	public SimpleStringLinearProbing() {
		bucketArray = new HashEntryLinearProbing[N_BUCKETS];
		FILL = new boolean[N_BUCKETS];
	}
	
	/**
	 * Sets the value associated with the key in a bucket of entries.
	 * @param key The key
	 * @param value The value
	 */
	public void put(String key, String value) {
		if (isFilled(Math.abs(key.hashCode()) % N_BUCKETS)) dynamicExp();
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntryLinearProbing help = new HashEntryLinearProbing(key, value);
		if (bucketArray[bucket] == null) {
			bucketArray[bucket] = help;
		} else {
			while (bucketArray[bucket] != null) {
				if (bucket == N_BUCKETS - 1) {
					bucket = 0;
				} else {
					bucket++;
				}
			}
			bucketArray[bucket] = help;
		}
	}
	
	/**
	 * Fills per bucket an auxiliary array used to know when is needed
	 * dynamic expansion
	 * @param bucket The bucket to save as true in the FILL array
	 */
	private void toFill(int bucket) {
		FILL[bucket] = true;
	}
	
	/**
	 * Determines if the array of buckets is totally filled with an
	 * auxiliary array
	 * @param bucket A new bucket used that could filled the array of
	 * buckets
	 * @return True if the array of buckets is filled, false otherwise
	 */
	private boolean isFilled(int bucket) {
		toFill(bucket);
		for (int i = 0; i < N_BUCKETS; i++) {
			if (!FILL[i]) return false;
		}
		return true;
	}
	
	/**
	 * Dynamically expands the array when is completely filled
	 */
	private void dynamicExp() {
		N_BUCKETS *= 2;
		HashEntryLinearProbing[] tempArray = bucketArray;
		bucketArray = new HashEntryLinearProbing[N_BUCKETS];
		for (int i = 0; i < N_BUCKETS; i++) {
			String key = tempArray[i].getKey();
			String value = tempArray[i].getValue();
			put(key, value);
		}
	}
	
	/**
	* Retrieves the value associated with key, or null if no such value exists.
	* @param key The key used to look up the value
	* @return The value associated with key, or null if no such value exists
	*/
	public String get(String key) {
		
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		
		if (bucketArray[bucket] == null) {
			return null;
		} else if (bucketArray[bucket] != null) {
			while (bucketArray[bucket] != null) {
				if (bucket == N_BUCKETS - 1) {
					bucket = 0;
				} else {
					bucket++;
				}
			}
		}
		
		if (bucketArray[bucket].getKey() == key) {
			return bucketArray[bucket].getValue();
		} else {
			return null;
		}
		
	}
	
	/* Private constants */
	public int N_BUCKETS = 7;
	private boolean[] FILL;
	/* Private instance variables */
	public HashEntryLinearProbing[] bucketArray;
}
