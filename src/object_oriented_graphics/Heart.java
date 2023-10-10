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

public class Heart extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		// TODO Auto-generated method stub
		double x = HEARTSCALE * (1 - Math.sin(Math.toRadians(45.0)));
		double y = HEARTSCALE * Math.sin(Math.toRadians(45.0));
		
		heartDrawer(x, y);

	}
	
	private void heartDrawer(double x, double y) {
		
		GArc arc1 = new GArc(SCALE, SCALE, HEARTSCALE, HEARTSCALE, 45.0, 180.0);
		add(arc1);
		
		GArc arc2 = new GArc(HEARTSCALE + SCALE - x, SCALE, HEARTSCALE, HEARTSCALE, -45.0, 180.0);
		add(arc2);
		
		GLine line1 = new GLine(SCALE + (x / 2), SCALE + (x / 2) + y, SCALE + (x / 2) + y, SCALE + (x / 2) + y * 2);
		add(line1);
		
		GLine line2 = new GLine(SCALE + (x / 2) + y, SCALE + (x / 2) + y * 2, SCALE + (x / 2) + y * 2, SCALE + (x / 2) + y);
		add(line2);
		
	}
	
	public static void main(String[] args) {
		
		new Heart().start();
		
	}
	
	private static double HEARTSCALE = 100;
	private static double SCALE = 100;

}
