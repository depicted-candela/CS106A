/**
 * 
 */
package object_oriented_graphics;

import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import objects_classes.RationalPrinceton;

public class PQ extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	private GCompound LogCabinBlock(RationalPrinceton sx, RationalPrinceton sy, RationalPrinceton s) {
		
		GCompound GC = new GCompound();		// to create the Compound
											
											// to initialize vars
		RationalPrinceton width_x_h, height_y_h, width_x_v, height_y_v;
											// to vary the positio
		RationalPrinceton pos = new RationalPrinceton(0, 1);
											// to vary the position over the repetitive graph
		width_x_h = sx.times(s.minus(new RationalPrinceton(1, 1)).divides(s));
											// width for x base in horizontal bars (even)
		height_y_h = sy.divides(s);
											// height for y base in horizontal bars (even)
		width_x_v = sx.divides(s);
											// width for y base in vertical bars (odd)
		height_y_v = sy.times(s.minus(new RationalPrinceton(1, 1)).divides(s));
											// height for x base in vertical bars (odd)
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
		
		for (int i = 0; i < GC.getElementCount(); i++) {
			GRect gr = (GRect) GC.getElement(i);
			gr.setFillColor(Color.GREEN);
			gr.setFilled(true);
		}
		
		return GC;
		
	}
	
	/**
	 * @param args
	 */
	
	private GCompound Squares(RationalPrinceton sx, RationalPrinceton sy) {
		
		GCompound GC = new GCompound();		// to create the Compound
		RationalPrinceton width_x_h, height_y_h, width_x_v, height_y_v;
											// to vary the position over the repetitive graph
		RationalPrinceton posx = new RationalPrinceton(0, 1);
											// x position of the square
		RationalPrinceton posy = new RationalPrinceton(0, 1);
											// y position of the square
											
		double angle = 45.0;				// to iterate with trigonometry to vary the inclination
		
//		GC.add(new GRect(sx.toDouble(), sy.toDouble()), posx.toDouble(), posy.toDouble());
		GRect r1 = new GRect(sx.toDouble(), sy.toDouble());
		GPolygon p1 = new GPolygon();
		for (int i = 1; i < 4; i++) {
			if (i != 0) {
				p1.addPolarEdge(angle, sx.toDouble());
			}
		}
		GC.add(r1, posx.toDouble(), posy.toDouble());
		
		return GC;
		
	}
	
	public void run() {
		// Define the amount of graphs per row in screen
		RationalPrinceton SIZE_X = new RationalPrinceton(getWidth(), 5);
		// Define the amount of graphs per column in screen
		RationalPrinceton SIZE_Y = new RationalPrinceton(getHeight(), 3);
		
		// Green graphs
		GCompound gc1 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(7, 1));
		add(gc1, 0.0, 0.0);
		GCompound gc2 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(7, 1));
		add(gc2, SIZE_X.times(new RationalPrinceton(1, 1)).toDouble(), SIZE_Y.times(new RationalPrinceton(2, 1)).toDouble());
		
		// Squares
		GCompound s1 = Squares(SIZE_X, SIZE_Y);
		add(s1, 0.0, SIZE_Y.times(new RationalPrinceton(1, 1)).toDouble());
	}
	
	public static void main(String[] args) {
		
		new PQ().start();
		
	}

}