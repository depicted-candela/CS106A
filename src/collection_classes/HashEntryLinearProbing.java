/**
 * 
 */
package collection_classes;

/* Package-private class: HashEntryLinearProbing */
/*
* This class represents a pair of a key and a value. The methods
* exported by the class consist only of getters and setters.
*/

public class HashEntryLinearProbing {
	/* Creates a new HashEntry for the specified key/value pair */
	public HashEntryLinearProbing(String key, String value) {
		entryKey = key;
		entryValue = value;
	}
	/* Returns the key component of a HashEntry */
	public String getKey() {
		return entryKey;
	}
	/* Returns the value component of a HashEntry */
	public String getValue() {
		return entryValue;
	}
	/* Sets the value component of a HashEntry to a new value */
	public void setValue(String value) {
		entryValue = value;
	}
	
	private String entryKey;
	private String entryValue;
	
}
