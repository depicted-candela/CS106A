/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;
import java.awt.Color;

public class FilledHeart extends GCompound {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	double h;
	
	FilledHeart(double w) {
		
		double s = w / (1 + Math.sqrt(2));
		double d = (w * Math.sqrt(2)) / (1 + Math.sqrt(2));
		double k = d - s;
		
		GArc arc1 = new GArc(0.0, 0.0, d, d, 45.0, 180.0);
		arc1.setColor(Color.RED);
		arc1.setFillColor(Color.RED);
		arc1.setFilled(true);
		add(arc1);
		
		GArc arc2 = new GArc(0.0 + d - k, 0.0,
				d, d, -45.0, 180.0);
		arc2.setColor(Color.RED);
		arc2.setFillColor(Color.RED);
		arc2.setFilled(true);
		add(arc2);
		
		GPolygon square = new GPolygon();
		square.addVertex(k / 2, k / 2 + s);
		square.addVertex(k / 2 + s, k / 2);
		square.addVertex(k / 2 + s * 2, k / 2 + s);
		square.addVertex(k / 2 + s, k / 2 + s * 2);
		square.setColor(Color.RED);
		square.setFilled(true);
		add(square);
		
	}
	
	public double getH() {
		return h;
	}

}
