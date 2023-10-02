/**
 * 
 */
package object_oriented_graphics;

/**
 * 
 */

import acm.graphics.*;

public class GDiamond extends GPolygon {
	private static final long serialVersionUID = 1L;
	/**
	* Creates a new GDiamond centered at the origin with the specified
	* horizontal width.
	* @param width The width of the star
	*/
	public GDiamond(double width, double height) {
		
		double x = width / 2.0;
		double y = height / 2.0;
		double l = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double a = Math.toDegrees(Math.asin(y / l));
		
		addVertex(-x, 0.0);
		addPolarEdge(l, a);
		addPolarEdge(l, 270.0 + (90 - a));
		addPolarEdge(l, 180.0 + a);
		
	}

}
