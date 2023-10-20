/**
 * 
 */
package arrays_arraylists;

/**
 * 
 */
/*
* File: GymnasticsJudge.java
* --------------------------
* This file reads in an array of scores and computes the
* average.
*/
import acm.program.*;

public class GymnasticsJudge extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;
	
	public void run() {
		int nJudges = readInt("Enter number of judges: ");
		double[] scores = new double[nJudges];
		for (int i = 0; i < nJudges; i++) {
			scores[i] = readDouble("Score for judge " + i + ": ");
		}
		double averageScore = mean(scores);
		println("The average score is " + averageScore);
	}
	
	private double mean(double[] j) {
		
		int total = 0;
		for(int i = 0; i < j.length; i++) {
			total += j[i];
		}
		
		return total / j.length;
		
	}
	
	public static void main(String[] args) {
		new GymnasticsJudge().start();
	}
	
}
