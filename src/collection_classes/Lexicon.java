/**
 * 
 */
package collection_classes;
import acm.util.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 */
public class Lexicon implements Iterable<String> {
	/**
	 * Constructor that reads the provided string of the file path.
	 * @param file String of the path file
	 * @throws IOException 
	 * 
	 */
	public Lexicon(String file) throws IOException {
		BufferedReader BR = new BufferedReader(new FileReader(file));
		String line = BR.readLine();
		int k = 0;
		hm.put(k, line);
		while((line = BR.readLine()) != null) {
			hm.put(k, line);
			k++;
		}
		BR.close();
	}
	
	/**
	 * Searchs for a specific word in the the set of words.
	 * @param s Word to search
	 * @return true if the word is in the set, false if not
	 */
	public boolean isWord(String s) {
		return hm.containsValue(s);
	}
	
	/**
	 * Provides the number of words stored in the set of words.
	 * @return The amount of wors stored in the set of words
	 */
	public int getWordCount() {
		return hm.keySet().size();
	}
	
	/**
	 * Provides a random word of the set.
	 * @return A random string of the set.
	 */
	public String getRandomWord() {
		int rand = rg.nextInt(0, hm.keySet().size());
		return hm.get(rand);
	}
	
	/**
	 * Implements the Iterator methods of the Iterable interface
	 */
	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>() {
			
			@Override
			/**
			 * To know if the set of words has at least one word.
			 * @return true if there is at least one word in the set,
			 * false otherwise
			 */
			public boolean hasNext() {
				if (hm.keySet().size() == 1) return false;
				return true;
			}

			@Override
			/**
			 * Provides randomly a word.
			 * @return If the word is null, return "", otherwise the random word
			 */
			public String next() {
				String next = getRandomWord();
				if (next == null) return "";
				return next;
			}
			
		};
		
	}
	
	private RandomGenerator rg = new RandomGenerator();
	private HashMap<Integer, String> hm = new HashMap<Integer, String>(7);
	
}
