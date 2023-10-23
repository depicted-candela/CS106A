/**
 * 
 */
package arrays_arraylists;
import acm.program.*;
import java.util.*;
/**
 * 
 */
public class Eratosthenes extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	ArrayList<Integer> primes = new ArrayList<Integer>();
	ArrayList<Integer> composites = new ArrayList<Integer>();
	
	public void run() {
		
		for (int i = 2; i < 1001; i++) {
			
			if (!composites.contains(i) && !primes.contains(i)) {
				primes.add(i);
				for (int j = i + 1; j < 1001; j++) {
					if (j % i == 0) {
						composites.add(j);
					}
				}
			}
		}
		
		println("The prime numbers within 1 and 1000 are");
		println(primes);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Eratosthenes().start();
	}

}
