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
	
	FilledHeart(double sx, double sy, double hsx, double hsy) {
		
		double x = hs * (1 - Math.sin(Math.toRadians(45.0)));
		
		GArc arc1 = new GArc(s, s, hs, hs, 45.0, 180.0);
		arc1.setColor(Color.RED);
		arc1.setFillColor(Color.RED);
		arc1.setFilled(true);
		add(arc1);
		
		GArc arc2 = new GArc(hs + s - x, s, hs, hs, -45.0, 180.0);
		arc2.setColor(Color.RED);
		arc2.setFillColor(Color.RED);
		arc2.setFilled(true);
		add(arc2);
		
//		GPolygon square = new GPolygon();
//		double sy = (hs / 2) * Math.cos(Math.toRadians(45.0));
//		double sx = (hs / 2) * Math.sin(45.0);
//		double ssx = s - sx;
//		double ssy = s + sy;
//		square.addVertex(ssx, ssy);
//		square.addVertex(ssx * 2, ssy * 2);
//		square.addVertex(s * 2 - (x / 2), s + (x / 2));
//		square.addVertex(s + (x / 2), s * 2 - (x / 2));
//		square.addVertex(s * 2 - (x / 2), s * 3 - (3 * x / 2));
//		square.addVertex(s * 3 - (3 * x / 2), s * 2 - (x / 2));
//		square.setColor(Color.BLACK);
//		square.setFilled(true);
//		add(square);
		
	}
	
	public static void main(String[] args) {
		
		new FilledHeart(WIDTH, HEIGHT, POS_X, POS_Y).start();
		
	}
	
	static double WIDTH = 100.0;
	static double HEIGHT = 150.0;
	static double POS_X = 100.0;
	static double POS_Y = 100.0;

}
