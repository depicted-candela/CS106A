/**
 * 
 */
package objects_classes;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class TestCard extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	public void run() {
		// TODO Auto-generated method stub
		
		println(card.getRank());
		println(card.getSuit());
		card = new Card(1, 2);
		println(card.getRank());
		println(card.getSuit());
		println(card.getString());

	}
	
	private static Card card = new Card();

}
