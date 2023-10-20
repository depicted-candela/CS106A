/**
 * 
 */
package arrays_arraylists;

import acm.program.*;

/**
 * 
 */

public class StandardDeviation extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		double[] data = {2.0, 4.0, 1.0, 7.0, 1.0};
		double stdev = stdev(data);
		println("The standard deviation is: " + Double.toString(stdev));
		
	}
	
	private double mean(double[] j) {
		
		int total = 0;
		for(int i = 0; i < j.length; i++) {
			total += j[i];
		}
		
		return total / j.length;
		
	}
	
	private double stdev(double[] j) {
		
		double mean = mean(j);
		double squared_sum = 0;
		for (int i = 0; i < j.length; i++) {
			squared_sum += Math.pow(mean - j[i], 2);
		}
		
		return Math.sqrt(squared_sum / j.length);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StandardDeviation().start();
	}

}
