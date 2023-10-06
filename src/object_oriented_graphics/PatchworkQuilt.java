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

public class PatchworkQuilt extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	private final RationalPrinceton DX = new RationalPrinceton(1, 9);
	private int LOGCABINBLOCK = 0;
	
	/**
	 * @param args
	 */
	
	private GCompound LogCabinBlock(RationalPrinceton sx, RationalPrinceton sy, RationalPrinceton s) {
		
		GCompound GC = new GCompound();
		RationalPrinceton width_x, height_y;
		width_x = sx.divides(new RationalPrinceton(8, 1));
		height_y = sy;
		
		System.out.println(width_x.toDouble());
		System.out.println(height_y.divides(new RationalPrinceton(8, 1)).toDouble());
		
		double odd = 90.0;
		double even = 90.0;
		RationalPrinceton pos = new RationalPrinceton(0, 1);
			
		while (height_y.toDouble() >= width_x.toDouble()) {
			
			for (int i = 1; i < 5; i++) {
				
				if (i % 2 != 0) {
					
					GC.add(new GRect(width_x.toDouble(), height_y.toDouble()),
							height_y.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(odd))), 1)).plus(pos.times(width_x)).toDouble(),
							width_x.times(new RationalPrinceton((int) Math.abs(Math.sin(Math.toRadians(odd))), 1)).plus(pos.times(width_x)).toDouble());
					odd+=90.0;
					
				} else {
					
					GC.add(new GRect(height_y.toDouble(), width_x.toDouble()),
							width_x.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))), 1)).plus(pos.times(width_x)).toDouble(),
							height_y.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))), 1)).plus(pos.times(width_x)).toDouble());
					even+=90.0;
					
				}
				
			}
			
			pos = pos.plus(new RationalPrinceton(1, 1));
			height_y = height_y.minus(width_x).minus(width_x);
			
		}
		
		return GC;
		
	}
	
	public void run() {
		
		RationalPrinceton SIZE_X = new RationalPrinceton(getWidth(), 5);
		RationalPrinceton SIZE_Y = new RationalPrinceton(getHeight(), 3);
		GCompound gc = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(0, 1));
		add(gc);
		
	}
	
	public static void main(String[] args) {
		
		new PatchworkQuilt().start();
	}

}