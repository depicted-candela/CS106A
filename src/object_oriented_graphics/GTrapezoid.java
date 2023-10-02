/**
 * 
 */
package object_oriented_graphics;

/**
 * 
 */

import acm.graphics.*;

public class GTrapezoid extends GPolygon {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GTrapezoid(double width, double height) {
		
		double x = width / 3.0;
		double l = Math.sqrt(Math.pow(height, 2) + Math.pow(x, 2));
		double a = Math.toDegrees(Math.asin(height / l));
		addVertex(-width / 2.0, height / 2);
		addPolarEdge(l, a);
		addPolarEdge(x, 0.0);
		addPolarEdge(l, -a);
		
	}

}
