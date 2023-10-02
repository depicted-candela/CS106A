/**
 * 
 */
package object_oriented_graphics;

/**
 * 
 */

import acm.graphics.*;

public class GTShape extends GPolygon {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GTShape(double height) {
		
		double dy_1 = height / 4.0;
		double dy_2 = 3.0 * height / 4.0;
		double dx_1 = 3.0 * height / 10.0;
		double dx_2 = 5.0 * height / 20.0;
		addVertex(dx_1, height / 2.0);
		addPolarEdge(dy_2, 90.0);
		addPolarEdge(dx_1, 180.0);
		addPolarEdge(dy_1, 90.0);
		addPolarEdge(17 * height / 20.0, 0.0);
		addPolarEdge(dy_1, -90.0);
		addPolarEdge(dx_1, 180.0);
		addPolarEdge(dy_2, -90.0);
		addPolarEdge(dx_2, -180.0);
	
	}

}