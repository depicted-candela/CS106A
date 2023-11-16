/**
 * 
 */
package collection_classes;

import java.io.*;

/**
 * 
 */
public class SortMoviesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		SortMovies sm = new SortMovies("Movies.txt");
		sm.print();
		System.out.println(" ");
		sm.sortMovies();
		sm.print();
//		
//		System.out.println("");
//		sm.compare(sm.LS.get(0), sm.LS.get(1));
//		sm.compare(sm.LS.get(1), sm.LS.get(2));
	}

}
