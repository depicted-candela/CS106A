/**
 * 
 */
package object_oriented_graphics;

/**
 * 
 */

import acm.graphics.*;
import acm.program.*;

public class PascalTriangle extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	private static final int LEVELS = 10;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		double item_size_x = getWidth() / LEVELS;
		double item_size_y = getHeight() / LEVELS;
		double circle_diam = item_size_y * 7.0 / 8.0;
		
		while (true) {
			
			for (int i = 1; i < LEVELS; i++) {
				for (int j = 1; j <= i; j++) {
					pause(50);
					if ((double) j * item_size_x + ((double) ((LEVELS - i - 1.0) / 2.0) * item_size_x) > getWidth() || (double) i * item_size_y > getHeight()) {
						break;
					}
					add(new GLabel(Integer.toString(PascalAdds(i, j))), (double) j * item_size_x + ((double) ((LEVELS - i - 1.0) / 2.0) * item_size_x), (double) i * item_size_y);
					add(new GOval(circle_diam, circle_diam), (double) j * item_size_x + ((double) ((LEVELS - i - 1.0) / 2.0) * item_size_x) - circle_diam / 2.0, (double) i * item_size_y - circle_diam / 2.0);
				}
			}
			
		}
	}
	
	private int PascalAdds(int i, int j) {
		
		if (i == 1 && j == 1) {
			return 1;
		} else if (j == 0 || j > i) {
			return 0;
		} else {
			return PascalAdds(i - 1, j - 1) + PascalAdds(i - 1, j);
		}
		
	}
	
	public static void main(String[] args) {
		
		new PascalTriangle().start();

	}

}
