/**
 * 
 */
package sorting_searching;
import acm.util.*;
/**
 * 
 */
public class DijkstraOnNetherlands {

	/**
	 * Initializes the DijkstraOnNetherlands class
	 */
	public DijkstraOnNetherlands() {
		flagFiller();
	}
	
	/**
	 * Randomly positioning the necessary colors for the Netherlands' flag
	 */
	private void flagFiller() {
		Integer r = 0, b = 0, w = 0, i, c = 0;
		while (true) {
			i = RAND.nextInt(0, 2);
			if (i == 0 & r < 5) {
				FLAG[c++] = 'R';
				r++;
			} else if (i == 1 & w < 6) {
				FLAG[c++] = 'W';
				w++;
			} else if (i == 2 & b < 4) {
				FLAG[c++] = 'B';
				b++;
			}
			if (c == SIZE) break;
		}
	}
	
	public void printFlag() {
		System.out.println("");
		for (Character c: FLAG) {
			System.out.print(c + " ");
		}
		System.out.println("");
	}
	
	/**
	 * The Dijkstra algorithm to cluster symbols of a same system with. It uses a simple comparison criteria. Algorithm complexity is O(N)
	 */
	private void proceduresDijkstra() {
		// Starting the indices, where i is the exchanging leftmost-side item, j the tracer item from left to right, and k the rightmost-side item
		int i = 0, j = 0, k = SIZE - 1;
		// Since there are three categories with almost the same number of elements. The j tracer must not trace all the numbers without touch elements of the first
		// and second categories, and because j runs from left to right, j should be always less than or equals to k whilst the algorithm is alive.
		while(j <= k) {
			// Print the flag to see the algorithm state
			printFlag();
			// The comparison between the element got by the tracer j
			int comp 	= FLAG[j].compareTo('W');
			// To swap with the first from left to right desired category (-5 because there are 5 positions in the alphabetic order to go from R to W)
			if (comp == -5) {
				swap(i++, j++); // Swaping augmenting all left to right counters
			// To swap with the second from left to right desired category (less than -5 because there are less than 5 positions in the alphabetic order to go from R to B)
			} else if (comp < -5) {
				// If j reaches an item of the last category, change it with an item where should be (k), but don't advance in j because the changed rightmost item could be not R
				swap(j, k--);
			// If none previous condition is met, then i and j must be the same
			} else {
				// Then advance in j
				j++;
			}
		}
	}
	
	/**
	 * Swap elements of the FLAG array using given indices, the first and second can be right or left side depending of the comparison done in proceduresDijkstra
	 * @param i
	 * @param j
	 */
	private void swap(int i, int j) {
		char temp	= FLAG[j];
		FLAG[j] 	= FLAG[i];
		FLAG[i]		= temp;
	}
	
	/**
	 * Shows the first step, the intermediate ones and the final to see all the procedures
	 */
	public void run() {
		System.out.println("First");
		printFlag();
		proceduresDijkstra();
		System.out.println("\nFinal");
		printFlag();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DijkstraOnNetherlands().run();
	}
	
	private static final RandomGenerator RAND = new RandomGenerator();
	private Integer SIZE = 15;
	private Character[] FLAG = new Character[SIZE];

}
