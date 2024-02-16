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
	 * 
	 */
	public DijkstraOnNetherlands() {
		flagFiller();
	}
	
	private void flagFiller() {
		Integer r = 0, b = 0, w = 0, i, c = 0;
		while (true) {
			i = RAND.nextInt(0, 2);
			if (i == 0 & r < 6) {
				FLAG[c++] = 'R';
				r++;
			} else if (i == 1 & w < 7) {
				FLAG[c++] = 'W';
				w++;
			} else if (i == 2 & b < 5) {
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
	}
	
	private void clusteringDijkstra() {
		
	}
	
	public void run() {
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
