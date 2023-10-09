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
	 * @param sx: it's the horizontal size
	 * @param sy: it's the vertical size
	 * @param s: it's the amount of bars per direction
	 * @return GC: it'ts the GCompound to draw on the Canvas
	 */
	
	private GCompound LogCabinBlock(RationalPrinceton sx, RationalPrinceton sy, RationalPrinceton s) {
		
		GCompound GC = new GCompound();		// to create the Compound
											
											// to initialize vars
		RationalPrinceton width_x_h, height_y_h, width_x_v, height_y_v;
											// to vary the position
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
			
		while (height_y_v.toInt() > width_x_v.toInt()) {
			
			for (int i = 2; i < 6; i++) {
				
				if (i % 2 != 0) {
					
					GC.add(new GRect(width_x_v.toInt(), height_y_v.toInt()),
							width_x_h.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(odd))), 1)).plus(pos.times(width_x_v)).toInt(),
							height_y_h.times(new RationalPrinceton((int) Math.abs(Math.sin(Math.toRadians(odd))), 1)).plus(pos.times(height_y_h)).toInt());
					odd+=90.0;
					
				}
				
				if (i % 2 == 0) {
					
					GC.add(new GRect(width_x_h.toInt(), height_y_h.toInt()),
							width_x_v.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))), 1)).plus(pos.times(width_x_v)).toInt(),
							height_y_v.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))), 1)).plus(pos.times(height_y_h)).toInt());
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
	
	private GCompound Polygons(RationalPrinceton sx, RationalPrinceton sy, RationalPrinceton initialx, RationalPrinceton initialy) {
		
		GCompound GC = new GCompound();		// to create the Compound
		RationalPrinceton two = new RationalPrinceton(2, 1);
		
		while (sx.toInt() * 4 > initialx.toInt()) {
			
			// Rect polygon
			double angle_r = 0.0;				// to iterate with trigonometry to vary the inclination
			GPolygon r = new GPolygon();		// to create a polygon with the form a rectangle
			
			for (int i = 0; i < 4; i++) {		// to draw the rectangle
				if (i % 2 == 0) {
					r.addPolarEdge(sx.toInt(), angle_r);
				} else {
					r.addPolarEdge(sy.toInt(), angle_r);
				}
				angle_r -= 90;
			}
			
			GC.add(r,
					initialx.minus(sx).divides(two).toInt(),
					initialy.minus(sy).divides(two).toInt());
			
			// Inclinate polygon
			sx = new RationalPrinceton((int) r.getWidth(), 1);
			sy = new RationalPrinceton((int) r.getWidth(), 1);
			double angle_p = Math.toDegrees(Math.atan(sy.toInt() / sx.toInt()));
			double angle_p_v = Math.toDegrees(Math.atan(sy.toInt() / sx.toInt()));
			
			GPolygon p = new GPolygon();		// to create an inclinate rectangle
			
			RationalPrinceton radius_x = sx.divides(two);
			radius_x = radius_x.times(radius_x);
			RationalPrinceton radius_y = sy.divides(two);
			radius_y = radius_y.times(radius_y);
			double radius = radius_x.plus(radius_y).toDouble();
			double sqrt = Math.sqrt(radius);
			
			for (int i = 0; i < 4; i++) {		// to draw the inclinate rectangle
				p.addPolarEdge(sqrt, angle_p);
				angle_p -= angle_p_v * 2;
			}
			
			GC.add(p,							// to add the inclinate rectangle to the GCompound
					initialx.minus(sx).divides(two).toInt(),
					initialy.divides(two).toInt());
			
			sx = sx.divides(two);				// to vary the size of figures
			sy = sy.divides(two);
			
		}
		
		for (int i = 0; i < GC.getElementCount(); i++) {
			
			GPolygon p = (GPolygon) GC.getElement(i);
			
			if (i % 2 == 0) {
				
				p.setFillColor(Color.GRAY);
				
			} else {
				
				p.setFillColor(Color.magenta);
				
			}
			
			p.setFilled(true);
			
		}
		
		return GC;
		
	}
	
	public void run() {
		
		// Define the amount of graphs per row in screen
		RationalPrinceton SIZE_X = new RationalPrinceton(getWidth(), 5);
		// Define the amount of graphs per column in screen
		RationalPrinceton SIZE_Y = new RationalPrinceton(getHeight(), 3);
		
		// Green graphs
		GCompound gc1 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
		add(gc1, 0, 0);
		GCompound gc2 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
		add(gc2, SIZE_X.times(new RationalPrinceton(1, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(2, 1)).toInt());
		GCompound gc3 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
		add(gc3, SIZE_X.times(new RationalPrinceton(2, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(1, 1)).toInt());
		GCompound gc4 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
		add(gc4, SIZE_X.times(new RationalPrinceton(3, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(0, 1)).toInt());
		GCompound gc5 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
		add(gc5, SIZE_X.times(new RationalPrinceton(4, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(2, 1)).toInt());
		
		// Squares
		GCompound s1 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
		add(s1, SIZE_Y.times(new RationalPrinceton(0, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(1, 1)).toInt());
		GCompound s2 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
		add(s2, SIZE_X.times(new RationalPrinceton(1, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(0, 1)).toInt());
		GCompound s3 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
		add(s3, SIZE_X.times(new RationalPrinceton(2, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(2, 1)).toInt());
		GCompound s4 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
		add(s4, SIZE_X.times(new RationalPrinceton(3, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(1, 1)).toInt());
		GCompound s5 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
		add(s5, SIZE_X.times(new RationalPrinceton(4, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(0, 1)).toInt());
		
	}
	
	public static void main(String[] args) {
		
		new PQ().start();
		
	}

}