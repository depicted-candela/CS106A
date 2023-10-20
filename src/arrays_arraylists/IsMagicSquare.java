/**
 * 
 */
package arrays_arraylists;
import acm.program.*;
/**
 * 
 */
public class IsMagicSquare extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		int[][] square = {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
		if (isMagicSquare(square)) {
			println("The square is perfect");
		} else {
			println("The square is not perfect");
		}
		
	}
	
	public boolean isMagicSquare(int[][] s) {
		int sum = s[0][0] + s[0][1] + s[0][2];
		boolean h = horizontalSum(s, sum);
		boolean v = verticalSum(s, sum);
		boolean d = diagonalSum(s, sum);
		return (h & v & d);
	}
	
	private boolean horizontalSum(int[][] s, int sum) {

		for (int i = 0; i < s.length; i++) {	
			int tempsum = 0;
			for (int j = 0; j < s.length; j++) {
				tempsum += s[i][j];
			}
			if (tempsum != sum) return false;
		}
		return true;
	}
	
	private boolean verticalSum(int[][] s, int sum) {
		
		for (int i = 0; i < s.length; i++) {
			int tempsum = 0;
			for (int j = 0; j < s.length; j++) {
				tempsum += s[j][i];
			}
			if (tempsum != sum) return false;
		}
		return true;
	}
	
	private boolean diagonalSum(int[][] s, int sum) {
		
		int tempsum = 0;
		for (int i = 0; i < s.length; i++) {
			tempsum += s[i][i];
		}
		if (tempsum != sum) return false;
		tempsum = 0;
		for (int i = s.length - 1; i > -1; i--) {
			tempsum += s[i][i];
		}
		if (tempsum != sum) return false;
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IsMagicSquare().start();
	}

}
