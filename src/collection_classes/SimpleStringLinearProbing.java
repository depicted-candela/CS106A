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
		for (int i = 0; i < N_BUCKETS; i++) {
			FILL[i] = false;
		}
	}
	
	/**
	 * Sets the value associated with the key in a bucket of entries.
	 * @param key The key
	 * @param value The value
	 */
	public void put(String key, String value) {
														// Dynamic expansion
		bucketArray[findEntry(false, key)] = new HashEntryLinearProbing(key, value);
		if (isFilled(findEntry(true, key))) dynamicExp();
		
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
		int tempn_buckets = N_BUCKETS;
		N_BUCKETS *= 2;
		HashEntryLinearProbing[] tempArray = bucketArray;
		bucketArray = new HashEntryLinearProbing[N_BUCKETS];
		FILL = new boolean[N_BUCKETS];
		for (int i = 0; i < N_BUCKETS; i++) {
			FILL[i] = false;
		}
		for (int i = 0; i < tempn_buckets; i++) {
			String key = tempArray[i].getKey();
			String value = tempArray[i].getValue();
			put(key, value);
		}
	}
	
	/**
	 * Deletes a key if exists.
	 * @param key The key to delete*/
	public void delete(String key) {
		if (findEntry(true, key) == null) {
			System.out.println("The key " + key + "does not exists.");
		}
		bucketArray[findEntry(true, key)] = null;
	}
	
	/**
	* Retrieves the value associated with key, or null if no such value exists.
	* @param key The key used to look up the value
	* @return The value associated with key, or null if no such value exists
	*/
	public String get(String key) {
		
		if (findEntry(true, key) == null) return null;
		return bucketArray[findEntry(true, key)].getValue();
		
	}
	
	/**
	 * Constructor to divide by need the find algorithm (Space or Search).
	 * @param search true if the need is to search where a key is, false
	 * if the need is to find a free space to save the new entry
	 * @param key The key to search or save
	 * @return A integer of the number where is or will be stored the new
	 * entry
	 */
	private Integer findEntry(boolean search, String key) {
		
		if (!search) {
			return linearProbingSpace(key);
		} else {
			return linearProbingSearch(key);
		}
		
	}
	
	/**
	 * Searchs a given key.
	 * @param key The key to search in the array of buckets.
	 * @return An integer of the bucket where was hashed the entry
	 * or a null value if the key does not appears in the array
	 * of buckets
	 */
	private Integer linearProbingSearch(String key) {
		
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		
		if (bucketArray[bucket].getKey() == key) {
			return bucket;
		} else if (bucketArray[bucket] == null) {
			return null;
		} else if (bucketArray[bucket] != null) {
			while (bucketArray[bucket] != null) {
				if (bucket == N_BUCKETS - 1) {
					bucket = 0;
				} else {
					bucket++;
				}
				if (bucketArray[bucket].getKey() == key) {
					return bucket;
				}
			}
		} else {
			return null;
		}
		
		return null;
		
	}
	
	/**
	 * Searchs for an empty space to save the new entry.
	 * @param key The key of the new entry to be hashed
	 * in order to be saved orderly
	 * @return integer of the space to save the entry
	 */
	private Integer linearProbingSpace(String key) {
		
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		
		if (bucketArray[bucket] == null) {
			return bucket;
		} else if (bucketArray[bucket] != null) {
			while (bucketArray[bucket] != null) {
				if (bucket == N_BUCKETS - 1) {
					bucket = 0;
				} else {
					bucket++;
				}
			}
		}
		return bucket;
	}
	
	/* Private constants */
	public int N_BUCKETS = 7;
	private boolean[] FILL;
	/* Private instance variables */
	public HashEntryLinearProbing[] bucketArray;
}
