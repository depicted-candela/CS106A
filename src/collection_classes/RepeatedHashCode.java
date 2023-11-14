/**
 * 
 */
package collection_classes;

import java.util.*;
import acm.program.*;

/**
 * 
 */
public class RepeatedHashCode extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RepeatedHashCode().start();
	}
	
	public void run() {
		
		addKeys();
		
	}
	
	private void addKeys() {
		
		String[] ls = {"buzzards", "righto", "crinolines", "hierarch"};
		
		for (String s : ls) {
			int hash = s.hashCode();
			if (hm.containsKey(hash)) {
				println("The word " + s + " has the same hashcode that " + hm.get(hash));
			}
			hm.put(hash, s);
		}
		
	}
	HashMap<Integer, String> hm = new HashMap<Integer, String>(10);
}
