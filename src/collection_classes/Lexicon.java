/**
 * 
 */
package collection_classes;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 */
public class Lexicon<K, V> {
	/**
	 * @throws IOException 
	 * 
	 */
	public Lexicon(String file) throws IOException {
		BufferedReader BR = new BufferedReader(new FileReader("EnglishWords.txt"));
		BR.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void run() {
		Lexicon legalWords = new Lexicon("EnglishWords.txt");
		Iterator<String> iterator = legalWords.iterator();
		while (iterator.hasNext()) {
			String word = iterator.next();
			if (word.length() == 2) {
				println(word);
			}
		}
	}
	
	BufferedReader BR;

}
