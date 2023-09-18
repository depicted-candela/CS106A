/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;
import acm.program.*;

public class PeaceAndLove extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		drawPeaceSymbol(SCALE, SCALE, SCALE / 2);
		
	}
	
	public void drawPeaceSymbol(double x, double y, double r) {
		
		// TODO Auto-generated method stub
		double a = (r) * (1 - Math.cos(Math.toRadians(45.0)));
		
		GOval c = new GOval(x, y, r * 2, r * 2);
		add(c);
		
		GLine l1 = new GLine(x * 3 / 2, y, x * 3 / 2, y * 2);
		add(l1);
		
		GLine l2 = new GLine(x + a, 2 * y - a, x + x / 2 , x + x / 2);
		add(l2);
		
		GLine l3 = new GLine(x + x / 2 , x + x / 2, 2 * x - a, 2 * x - a);
		add(l3);
		
	}

	private static double SCALE = 500;
	
}
