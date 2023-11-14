/**
 * 
 */
package collection_classes;
import acm.program.*;
import java.io.IOException;
import java.util.Iterator;

/**
 * 
 */
public class LexiconTest extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		Lexicon legalWords;
		try {
			legalWords = new Lexicon("EnglishWords.txt");
			Iterator<String> iterator = legalWords.iterator();
			while (iterator.hasNext()) {
				String word = iterator.next();
				if (word.length() == 2) {
					println(word);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new LexiconTest().start();
	}

}
