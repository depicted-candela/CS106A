/**
 * 
 */
package objects_classes;

/**
 * @author nicalcoca
 *
 */

import acm.util.*;
import acm.program.*;

public class RadioactiveDecay extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// Atoms decaying
		timeOccured(10000);

	}
	
	private static RandomGenerator atom = new RandomGenerator();
	
	private void timeOccured(int init) {
		
		println("There are "+ init +" atoms initially");
		
		int atoms = init;
		int year = 1;
		
		while (true) {
			
			atoms = activeAtoms(atoms);
			
			println("There are " + atoms + " atoms at the end of year " + year);
			year++;
			
			if (atoms <= 0) break;
			
		}

	}
	
	private int activeAtoms(int atoms) {
		
		int active = 0;
		
		for (int i = 0; i < atoms; i++) {
			
			boolean b = atom.nextBoolean();
			
			if (b) {
				active++;
			}
			
		}
		
		return active;
	
	}

}
