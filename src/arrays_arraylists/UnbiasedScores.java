/**
 * 
 */
package arrays_arraylists;

import acm.program.*;
import java.util.*;

/**
 * 
 */
public class UnbiasedScores extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		ArrayList<Integer> scores = new ArrayList<Integer>();
		scores.add(0);
		
		for (int i = 1; i < 8; i++) {
			scores.add(readInt("? " + Integer.toString(i) + ": "));
		}
		
		println(average(scores));
		
	}
	
	public int average(ArrayList<Integer> s) {
		
		minusMax(s);
		minusMin(s);
		
		int sum = 0;
		
		for (int i = 1; i < s.size(); i++) {
			sum += s.get(i);
		}
		
		int average = sum / (s.size() - 1);
		
		return average;
		
	}
	
	public void minusMax(ArrayList<Integer> s) {
		
		System.out.println("A");
		int max = 0;
		int index = 0;
		for (int i = 1; i < s.size(); i++) {
			if (max < s.get(i)) {
				max = s.get(i);
				index = i;
			}
		}
		s.remove(index);
	
	}
	
	public void minusMin(ArrayList<Integer> s) {
		
		int min = 11;
		int index = 0;
		for (int i = 1; i < s.size(); i++) {
			if (min > s.get(i)) {
				min = s.get(i);
				index = i;
			}
		}
		s.remove(index);
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UnbiasedScores().start();

	}

}
