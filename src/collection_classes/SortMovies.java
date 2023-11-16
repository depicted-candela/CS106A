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
public class SortMovies {

	/**
	 * @throws IOException 
	 * @throws  
	 * 
	 */
	public SortMovies(String file) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(file));
		String line = bf.readLine();
		while(true) {
			line = bf.readLine();
			if (line == null) break;
			LS.add(line);
		}
		bf.close();
	}
	
	Comparator<String> customComp = new Comparator<String> () {
		@Override
		public int compare(String o1, String o2) {
			
			o1 = deleteArticle(o1);
			o2 = deleteArticle(o2);
			
			return o2.compareTo(o1) * -1;
			
		}
	};
	
	public void sortMovies() {
		Collections.sort(LS, customComp);
	}
	
	private Integer articles(String s) {
		String ts = s.toLowerCase();
		if (ts.startsWith("the ")) return 4;
		if (ts.startsWith("a ")) return 2;
		if (ts.startsWith("an ")) return 3;
		return null;
	}
	
	private String deleteArticle(String s) {
		if (s == null) return s;
		Integer idx = articles(s);
		if (idx == null) return s;
		return s.substring(idx);
	}
	
	public void print() {
		for (int i = 0; i < LS.size(); i++) System.out.println(LS.get(i));
	}
	
	public List<String> LS = new ArrayList<String>();

}
