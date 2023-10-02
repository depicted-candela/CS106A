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
//	private int LOGCABINBLOCK = 0;
	
	/**
	 * @param args
	 */
	
	private GCompound LogCabinBlock(RationalPrinceton sx, RationalPrinceton sy, RationalPrinceton s) {
		
		pause(100);
		
		GCompound GC = new GCompound();
		RationalPrinceton width_x, height_y;
		width_x = sx.divides(new RationalPrinceton(8, 1));
		height_y = sy;
		double odd = 90.0;
		double even = 90.0;
		
		System.out.println(sx.toDouble());
		System.out.println(DX.times(new RationalPrinceton(getWidth(), 1)).toDouble());
		
		if (sx.toDouble() < DX.times(new RationalPrinceton(getWidth(), 1)).toDouble()) {
			
			return GC;
			
		} else {
			
			for (int i = 1; i < 5; i++) {
				
				if (i % 2 != 0) {
					
					GC.add(new GRect(width_x.toDouble(), height_y.toDouble()),
							height_y.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(odd))), 1)).toDouble(),
							width_x.times(new RationalPrinceton((int) Math.abs(Math.sin(Math.toRadians(odd))), 1)).toDouble());
					odd+=90.0;
					
				} else {
					
					GC.add(new GRect(height_y.toDouble(), width_x.toDouble()),
							width_x.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))), 1)).toDouble(),
							height_y.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))), 1)).toDouble());
					even+=90.0;
					
				}
				
			}
			
			GC.add(LogCabinBlock(
					sx.minus(new RationalPrinceton(getWidth(), 1).times(DX)),
					sy.minus(new RationalPrinceton(getWidth(), 1).times(DX)),
					s.plus(new RationalPrinceton(1, 1))));
			
			return GC;
			
		}
		
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
