/**
 * 
 */
package objects_classes;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;
import acm.util.*;

public class RandomDesk extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		// To print a random card of a poker desk
		int rank = randNumber.nextInt(13);
		int suit = randNumber.nextInt(4);
		String rs = deskOrdered(suit, rank);
		println("The random card is: " + rs);
		
	}
	
	private String deskOrdered(int suit, int rank) {
		
		String r = deskRank(rank);
		
		switch(suit) {
		
			case 0:
				return r + " of Clubs";
			case 1:
				return r + " of Diamonds";
			case 2:
				return r + " of Hears";
			case 3:
				return r + " of Spades";
			default:
				return "Error in Suit";
			
		}
		
	}
	
	private String deskRank(int rank) {
		
		switch(rank) {
		
			case 0:
				return "Ace";
			case 1:
				return "1";
			case 2:
				return "2";
			case 3:
				return "3";
			case 4:
				return "4";
			case 5:
				return "5";
			case 6:
				return "6";
			case 7:
				return "7";
			case 8:
				return "8";
			case 9:
				return "9";
			case 10:
				return "10";
			case 11:
				return "Jack";
			case 12:
				return "Queen";
			case 13:
				return "King";
			default:
				return "Error in rank";
		
		}
		
	}
	
	private static RandomGenerator randNumber = RandomGenerator.getInstance();

}
