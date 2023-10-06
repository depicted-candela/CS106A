/**
 * 
 */
package object_oriented_graphics;

/**
 * 
 */

import acm.graphics.*;
import acm.program.*;
import objects_classes.RationalPrinceton;

public class PQ extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	private GCompound LogCabinBlock(RationalPrinceton sx, RationalPrinceton sy, RationalPrinceton s) {
		
		GCompound GC = new GCompound();
		RationalPrinceton width_x_h, height_y_h, width_x_v, height_y_v;
		RationalPrinceton pos = new RationalPrinceton(0, 1);
		
		
		
		width_x_h = sx.times(s.minus(new RationalPrinceton(1, 1)).divides(s));
											// width for x base in horizontal bars (even)
		height_y_h = sy.divides(s);
											// height for y base in horizontal bars (even)
		width_x_v = sx.divides(s);
											// width for y base in 
		height_y_v = sy.times(s.minus(new RationalPrinceton(1, 1)).divides(s));
											// height for x base in
		double odd = 90.0;
		double even = 90.0;
			
		while (height_y_v.toDouble() > width_x_v.toDouble()) {
			
			for (int i = 2; i < 6; i++) {
				
				if (i % 2 != 0) {
					
					GC.add(new GRect(width_x_v.toDouble(), height_y_v.toDouble()),
							width_x_h.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(odd))), 1)).plus(pos.times(width_x_v)).toDouble(),
							height_y_h.times(new RationalPrinceton((int) Math.abs(Math.sin(Math.toRadians(odd))), 1)).plus(pos.times(height_y_h)).toDouble());
					odd+=90.0;
					
				}
				
				if (i % 2 == 0) {
					
					GC.add(new GRect(width_x_h.toDouble(), height_y_h.toDouble()),
							width_x_v.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))), 1)).plus(pos.times(width_x_v)).toDouble(),
							height_y_v.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))), 1)).plus(pos.times(height_y_h)).toDouble());
					even+=90.0;
					
				}
				
			}
			
			pos = pos.plus(new RationalPrinceton(1, 1));
			height_y_v = height_y_v.minus(height_y_h).minus(height_y_h);
			width_x_h = width_x_h.minus(width_x_v).minus(width_x_v);
			
		}
		
		return GC;
		
	}
	
	public void run() {
		
		RationalPrinceton SIZE_X = new RationalPrinceton(getWidth(), 5);
		RationalPrinceton SIZE_Y = new RationalPrinceton(getHeight(), 3);
		GCompound gc = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
		add(gc);
		
	}
	
	public static void main(String[] args) {
		
		new PQ().start();
		
	}

}