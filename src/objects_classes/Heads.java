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
import java.util.ArrayList;

public class Heads extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		ArrayList<Boolean> coin = new ArrayList<>();
		
		// TODO Auto-generated method stub
		while(true) {
			
			boolean b1 = randGen.nextBoolean();
			coin.add(b1);
			
			if (b1) {
				println("Heads");
			} else {
				println("Tails");
			}
			
			if (coin.size() > 3) {
				
				if (coin.get(coin.size() - 1) && coin.get(coin.size() - 2) && coin.get(coin.size() - 3)) {
					println("It took 14 flips to get 3 consecutive heads.");
					break;
				}
			
			}
			
		}

	}
	
	private static RandomGenerator randGen = RandomGenerator.getInstance();
	
}