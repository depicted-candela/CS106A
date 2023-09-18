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

public class Washington extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		// TODO Auto-generated method stub
		add(hDrawer(), LOCATION, LOCATION);
		add(vDrawer(), LOCATION, LOCATION);
		add(cDrawer(), LOCATION, LOCATION);

	}
	
	private GCompound hDrawer() {
		
		GCompound h = new GCompound();
		
		GRect r1 = new GRect(SCALE_X - SCALE_X / 10.0, SCALE_Y / 7.0);
		GRect r2 = new GRect(SCALE_X, SCALE_Y / 7.0);
		GRect r3 = new GRect(SCALE_X, SCALE_Y / 7.0);
		
		h.add(r1, SCALE_X / 20.0, 0);
		h.add(r2, 0, SCALE_Y * 1 / 7.0);
		h.add(r3, 0, SCALE_Y * 6 / 7.0);
		
		return h;
		
	}
	
	private GCompound vDrawer() {
		
		GCompound v = new GCompound();
		
		for (int i = 0; i < 12; i++) {
			GRect v1 = new GRect(V1, SCALE_Y * 4 / 7.0);
			v.add(v1, V1 * i + V2 * i, SCALE_Y * 2 / 7.0);
			
		}
		
		GRect center = new GRect(V2 - (V2 - V1) * 5, SCALE_Y * 1 / 7.0);
		v.add(center, V1 * 6 + V2 * 6 + (V2 - V1) * 2, SCALE_Y * 5 / 7.0);
		
		return v;
		
	}
	
	private GCompound cDrawer() {
		
		GCompound circles = new GCompound();
		
		GOval c1 = new GOval(CIRCLES, CIRCLES);
		circles.add(c1, V1 * 6.0 + V2 * 6.0 + (V2 - V1) * 2.0, SCALE_Y * 5.0 / 7.0 - CIRCLES);
		
		for (int i = 0; i < 12; i++) {
			GOval c2 = new GOval(CIRCLES, CIRCLES);
			circles.add(c2, V2 * i + V1 * i + V1 * 1.0 / 2.0 - CIRCLES / 2.0, SCALE_Y * 3.0 / 14.0 - CIRCLES / 2.0);
		}
		
		return circles;
		
	}
	
	private static double LOCATION = 10.0;
	private static double SCALE_X = 600.0;
	private static double SCALE_Y = SCALE_X / 2;
	private static double V1 = SCALE_X / 24.0;
	private static double V2 = SCALE_X / 22.0;
	private static double CIRCLES = V2 - (V2 - V1) * 5;

}
