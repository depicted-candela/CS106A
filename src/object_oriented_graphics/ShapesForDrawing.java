/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;

public class ShapesForDrawing extends GCompound {

	private static final long serialVersionUID = 1L;
	
	public int shp;
	
	public ShapesForDrawing(double width, double height, int s) {
		
		if (s == 1) {
			
			filledRectangle(width, height, s);
			
		} else if(s == 2) {
			
			notFilledRectangle(width, height, s);
			
		} else if(s == 3) {
			
			filledOval(width, height, s);
			
		} else if(s == 4) {
			
			notFilledOval(width, height, s);
			
		} else {
			
			diagonalLine(width, height, s);
			
		}
		
	}
	
	private void filledRectangle(double width, double height, int s) {
		
		this.shp = s;
		GRect r1 = new GRect(width * scale, height * scale);
		add(r1, 0.0, 0.0);
		GRect r2 = new GRect(width * scale * 3.0 / 5.0, height * scale * 1.0 / 3.0);
		r2.setFilled(true);
		add(r2, width * scale * 1.0 / 5.0, height * scale * 1.0 / 3.0);
		
	}
	
	private void notFilledRectangle(double width, double height, int s) {
		
		this.shp = s;
		GRect r1 = new GRect(width * scale, height * scale);
		add(r1, 0.0, 0.0);
		GRect r2 = new GRect(width * scale * 3.0 / 5.0, height * scale * 1.0 / 3.0);
		add(r2, width * scale * 1.0 / 5.0, height * scale * 1.0 / 3.0);
		
	}
	
	private void filledOval(double width, double height, int s) {
		
		this.shp = s;
		GRect r = new GRect(width * scale, height * scale);
		add(r, 0.0, 0.0);
		GOval o = new GOval(width * scale * 3.0 / 5.0, height * scale * 1.0 / 3.0);
		o.setFilled(true);
		add(o, width * scale * 1.0 / 5.0, height * scale * 1.0 / 3.0);
		
	}
	
	private void notFilledOval(double width, double height, int s) {
		
		this.shp = s;
		GRect r = new GRect(width * scale, height * scale);
		add(r, 0.0, 0.0);
		GOval o = new GOval(width * scale * 3.0 / 5.0, height * scale * 1.0 / 3.0);
		add(o, width * scale * 1.0 / 5.0, height * scale * 1.0 / 3.0);
		
	}
	
	private void diagonalLine(double width, double height, int s) {
		
		this.shp = s;
		GRect r = new GRect(width * scale, height * scale);
		add(r, 0.0, 0.0);
		GLine l = new GLine(width * scale * 1.0 / 5.0, height * scale * 1.0 / 3.0, width * scale * 4.0 / 5.0, height * scale * 2.0 / 3.0);
		add(l, width * scale * 1.0 / 5.0, height * scale * 1.0 / 3.0);
		
	}
	
	private static double scale = 1.0 / 15.0;
	
}
