/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;
import acm.graphics.*;

public class Combinations extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		int size = getHeight();
		int cells = 8;
		int cell_size = size / cells;
		int mid_cell = cell_size / 2;
		
		pyramid(size, mid_cell, cells, cell_size);
		
	}
	
	// Creates the graphical representation of the Pascal's pyramid
	private void pyramid(int size, int mid_cell, int cells, int cell_size) {
	
		int C = 1;
		int C2 = 1;
		
		for (int i = size / 2; i >= mid_cell; i -= mid_cell ) {
			
			int C3 = 0;
			for (int c = 1; c <= C; c++) {
				
				double x = i + C3 * cell_size;
				double y = C2 * (size / cells) / 2;
				GLabel point = new GLabel(String.valueOf(number_pyramid(c, C)), x, y);
				add(point);
				C3++;
				
			}
			
			System.out.println();
			
			C++;
			C2 += 2;
			
		}
		
	}
	
	// Recursively calculates the i, j number for the Pascal's pyramid
	private int number_pyramid(int i, int j) {
		if ( i == j || i == 1 ) {
			return 1;
		} else {
			return number_pyramid(i - 1, j - 1) + number_pyramid(i, j - 1);
		}
	}

}
