/**
 * 
 */
package arrays_arraylists;
import acm.program.*;
import java.util.*;
/**
 * 
 */
public class CheckSudokuSolution extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		int[][] sq_v0_h0 =	{{3, 9, 2},
							{7, 4, 1},
							{6, 8, 5}};
		int[][] sq_v0_h1 =	{{4, 6, 5},
							{8, 9, 3},
							{2, 7, 1}};
		int[][] sq_v0_h2 =	{{8, 1, 7},
							{6, 2, 5},
							{4, 9, 3}};
		int[][] sq_v1_h0 =	{{2, 5, 4},
							{8, 3, 9},
							{1, 7, 6}};
		int[][] sq_v1_h1 =	{{1, 3, 8},
							{6, 2, 7},
							{9, 5, 4}};
		int[][] sq_v1_h2 =	{{7, 9, 6},
							{1, 5, 4},
							{2, 8, 3}};
		int[][] sq_v2_h0 =	{{9, 6, 7},
							{4, 2, 3},
							{5, 1, 8}};
		int[][] sq_v2_h1 =	{{5, 8, 2},
							{7, 1, 9},
							{3, 4, 6}};
		int[][] sq_v2_h2 =	{{3, 4, 1},
							{5, 6, 8},
							{9, 7, 2}};
		int[][][][] data = {{sq_v0_h0, sq_v0_h1, sq_v0_h2},
							{sq_v0_h0, sq_v0_h1, sq_v0_h2},
							{sq_v0_h0, sq_v0_h1, sq_v0_h2}};
		
		if (square(sq_v2_h2)) {
			println("OK");
		} else {
			println("NOOK");
		}
		
	}
	
	private boolean square(int[][] s) {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!al.contains(s[i][j])) {
					al.add(s[i][j]);
				} else {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckSudokuSolution().start();
	}

}
