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
		
		int[][] square =	{{3, 9, 2, 4, 6, 5, 8, 1, 7},
							{7, 4, 1, 8, 9, 3, 6, 2, 5},
							{6, 8, 5, 2, 7, 1, 4, 3, 9},
							{2, 5, 4, 1, 3, 8, 7, 9, 6},
							{8, 3, 9, 6, 2, 7, 1, 5, 4},
							{1, 7, 6, 9, 5, 4, 2, 8, 3},
							{9, 6, 7, 5, 8, 2, 3, 4, 1},
							{4, 2, 3, 7, 1, 9, 5, 6, 8},
							{5, 1, 8, 3, 4, 6, 9, 7, 2}};
		
		if (square(square) && vertical_lines(square) && horizontal_lines(square)) {
			println("OK");
		} else {
			println("NOOK");
		}
		
	}
	
	private boolean horizontal_lines(int[][] s) {
		
		ArrayList<Integer> al;
		for (int i = 0; i < s.length; i++) {
			al = new ArrayList<Integer>();
			for (int j = 0; j < s.length; j++) {
				if (!al.contains(s[i][j])) {
					al.add(s[i][j]);
				} else {
					return false;
				}
			}
		}
		return true;
		
	}
	
	private boolean vertical_lines(int[][] s) {
		
		ArrayList<Integer> al;
		for (int i = 0; i < s.length; i++) {
			al = new ArrayList<Integer>();
			for (int j = 0; j < s.length; j++) {
				if (!al.contains(s[j][i])) {
					al.add(s[j][i]);
				} else {
					return false;
				}
			}
		}
		return true;
		
	}
	
	private boolean square(int[][] s) {
		
		int[][] subs;
		ArrayList<Integer> al;
		
		for (int i = 0; i < s.length; i += SUDOKU) {
			for (int j = 0; j < s.length; j += SUDOKU) {
				
				subs = new int[SUDOKU][SUDOKU];
				al = new ArrayList<Integer>();
				
				for (int x = 0; x < SUDOKU; x++) {
					for (int y = 0; y < SUDOKU; y++) {
						subs[x][y] = s[x + i][y + j];
					}
				}
				for (int k = 0; k < SUDOKU; k++) {
					for (int l = 0; l < SUDOKU; l++) {
						if (!al.contains(subs[k][l])) {
							al.add(subs[k][l]);
						} else {
							return false;
						}
					}
				}
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		new CheckSudokuSolution().start();
	}

	private static final int SUDOKU = 3;
	
}
