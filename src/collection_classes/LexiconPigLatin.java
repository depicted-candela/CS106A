package collection_classes;

import java.io.IOException;
import java.util.Iterator;

import acm.program.*;

public class LexiconPigLatin extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		try {
			PigLatin pl = new PigLatin();
			Lexicon toTranslate = new Lexicon("PigLatin.txt");
			Iterator<String> iterator = toTranslate.iterator();
			while (iterator.hasNext()) {
				String word = iterator.next();
				if (word != "") println(pl.translateLine(word));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new LexiconPigLatin().start();
	}
	
}
