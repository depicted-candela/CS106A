/**
 * 
 */
package object_oriented_graphics;

import java.awt.Color;

/**
 * 
 */

import acm.graphics.*;

public class GLens extends GPolygon {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public GLens(double width, double height) {
		
		double r		= (Math.pow(height, 2) + Math.pow(width, 2)) / (4 * width);
		double angle	= Math.toDegrees(Math.asin((height / 2.0) / r));
		addArc(r, -r, - angle, angle * 2);
		addArc(-r, r, - angle, angle * 2);
		setFillColor(Color.cyan);
		setFilled(true);
		
	}

}
