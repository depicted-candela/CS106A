package collection_classes;

/** This class implements a simplified version of a Map class for strings
 * capable of dynamically expansion. */
public class SimpleStringMapRehased {
	/** Creates a new SimpleStringMap with no key/value pairs */
	public SimpleStringMapRehased() {
		bucketArray = new HashEntry[N_BUCKETS];
		FILL = new boolean[N_BUCKETS];
	}
	/**
	* Sets the value associated with key. Any previous value for key is lost.
	* @param key The key used to refer to this value
	* @param value The new value to be associated with key
	*/
	public void put(String key, String value) {
		if (isFilled(Math.abs(key.hashCode()) % N_BUCKETS)) dynamicExp();
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if (entry == null) {
			entry = new HashEntry(key, value);
			entry.setLink(bucketArray[bucket]);
			bucketArray[bucket] = entry;
		} else {
			entry.setValue(value);
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
		for (boolean b : FILL) if (!b) return false;
		return true;
	}
	
	/**
	 * Dynamically expands the array when is completely filled
	 */
	private void dynamicExp() {
		N_BUCKETS *= 2;
		HashEntry[] tempArray = bucketArray;
		bucketArray = new HashEntry[N_BUCKETS];
		FILL = new boolean[N_BUCKETS];
		for (int i = 0; i < tempArray.length; i++) {
			HashEntry he = tempArray[i];
			while(he != null) {
				put(he.getKey(), he.getValue());
				he = he.getLink();
			}
		}
	}
	
	/**
	* Retrieves the value associated with key, or null if no such value exists.
	* @param key The key used to look up the value
	* @return The value associated with key, or null if no such value exists
	*/
	public String get(String key) {
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if (entry == null) {
			return null;
		} else {
			return entry.getValue();
		}
	}
	/*
	* Scans the entry chain looking for an entry that matches the specified key.
	* If no such entry exists, findEntry returns null.
	*/
	private HashEntry findEntry(HashEntry entry, String key) {
		while (entry != null) {
			if (entry.getKey().equals(key)) return entry;
			entry = entry.getLink();
		}
		return null;
	}
	/* Private constants */
	private int N_BUCKETS = 7;
	private boolean[] FILL;
	/* Private instance variables */
	private HashEntry[] bucketArray;
}
