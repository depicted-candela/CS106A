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
	
	public FilledHeart() {
		
		double x = HEARTSCALE * (1 - Math.sin(Math.toRadians(45.0)));
		
		GArc arc1 = new GArc(SCALE, SCALE, HEARTSCALE, HEARTSCALE, 45.0, 180.0);
		arc1.setColor(Color.RED);
		arc1.setFillColor(Color.RED);
		arc1.setFilled(true);
		add(arc1);
		
		GArc arc2 = new GArc(HEARTSCALE + SCALE - x, SCALE, HEARTSCALE, HEARTSCALE, -45.0, 180.0);
		arc2.setColor(Color.RED);
		arc2.setFillColor(Color.RED);
		arc2.setFilled(true);
		add(arc2);
		
		GPolygon square = new GPolygon();
		square.addVertex(SCALE * 2 - (x / 2), SCALE + (x / 2));
		square.addVertex(SCALE + (x / 2), SCALE * 2 - (x / 2));
		square.addVertex(SCALE * 2 - (x / 2), SCALE * 3 - (3 * x / 2));
		square.addVertex(SCALE * 3 - (3 * x / 2), SCALE * 2 - (x / 2));
		square.setColor(Color.RED);
		square.setFilled(true);
		add(square);
		
	}
	
	private static double HEARTSCALE = 100;
	private static double SCALE = 100;

}
