/**
 * 
 */
package object_oriented_graphics;

/**
 * 
 */

import acm.graphics.*;
import acm.program.*;
import objects_classes.Rational;

public class PatchworkQuilt extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	private static final Rational DX = new Rational(1, 9);
	private int LOGCABINBLOCK = 0;
	
	/**
	 * @param args
	 */
	
	private GCompound LogCabinBlock(Rational sx, Rational sy, Rational s) {
		
		GCompound gc = new GCompound();
		
		Rational width;
		Rational height;
		int odd = 0;
		double even = 90.0;
		
		Rational element_size = new Rational(getWidth(), 5);
		element_size.multiply(DX).multiply(new Rational(5, 1));
		if (sx.toDouble() < element_size.multiply(DX).multiply(new Rational(5, 1)).toDouble()) {
			
			return gc;
			
		} else {
			
			for (int i = 1; i < 5; i++) {
				if (i % 2 != 0) {
					width = sx.multiply(DX).multiply(new Rational(8));
					height = sy.multiply(DX);
					gc.add(new GRect(width.toDouble(), height.toDouble()),
							height.multiply(new Rational(odd)).add(s).toDouble(),
							width.multiply(new Rational(odd)).add(s).toDouble());
					odd++;
				} else {
					width = sy.multiply(DX);
					height = sx.multiply(DX).multiply(new Rational(8));
					gc.add(new GRect(width.toDouble(), height.toDouble()),
							height.multiply(new Rational((int) Math.cos(Math.toRadians(even)))).add(s).toDouble(),
							width.multiply(new Rational((int) Math.sin(Math.toRadians(even)))).add(s).toDouble());
					
					even += 90.0;
				}
			}
			
			LOGCABINBLOCK++;
			System.out.println(DX.multiply(new Rational(LOGCABINBLOCK)).multiply(new Rational(getWidth(), 5)).toDouble());
			
			sx.subtract(DX.multiply(new Rational(2)).multiply(new Rational(getWidth(), 5)));
			
			gc.add(LogCabinBlock(sx.subtract(DX.multiply(new Rational(2)).multiply(new Rational(getWidth(), 5))),
					sy, DX.multiply(new Rational(LOGCABINBLOCK)).multiply(new Rational(getWidth(), 5))));
			
			
			return gc;
			
		}
		
	}
	
	public void run() {
		
		System.out.println(getWidth());
		System.out.println(getHeight());
		Rational size_x = new Rational(getWidth(), 5);
		Rational size_y = new Rational(getHeight(), 3);
		GCompound lcb = LogCabinBlock(size_x, size_y, new Rational(0));
		add(lcb);
	}
	
	public static void main(String[] args) {
		
		new PatchworkQuilt().start();
	}

}
