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
	 * @param sx: RationalPrinceton to the horizontal size
	 * @param sy: RationalPrinceton to the vertical size
	 * @param s: RationalPrinceton to the amount of bars per direction
	 * @return GC: GCompound to draw on the Canvas
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
		
		double odd = 90.0;					// angles to iterate over horizontal bars with even numbers
		double even = 90.0;					// angles to iterate over horizontal bars with odd numbers
		
		
		/* The loop that ends when the height of vertical bars
		 * based in the length of y axis is higher than the 
		 * width of vertical bars based in the length of x axis*/
		
		while (height_y_v.toInt() > width_x_v.toInt()) {
			
			for (int i = 2; i < 6; i++) {
				
				// Vertical bars
				if (i % 2 != 0) {
					
					GC.add(new GRect(width_x_v.toInt(), height_y_v.toInt()),
							width_x_h.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(odd))),
									1)).plus(pos.times(width_x_v)).toInt(),
							height_y_h.times(new RationalPrinceton((int) Math.abs(Math.sin(Math.toRadians(odd))),
									1)).plus(pos.times(height_y_h)).toInt());
					odd+=90.0;
					
				}
				
				// Horizontal bars
				if (i % 2 == 0) {
					
					GC.add(new GRect(width_x_h.toInt(), height_y_h.toInt()),
							width_x_v.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))),
									1)).plus(pos.times(width_x_v)).toInt(),
							height_y_v.times(new RationalPrinceton((int) Math.abs(Math.cos(Math.toRadians(even))),
									1)).plus(pos.times(height_y_h)).toInt());
					even+=90.0;
					
				}
				
			}
			
			// To add the one position to the bars
			pos = pos.plus(new RationalPrinceton(1, 1));
			/* Subtracts the height of x-based horizontal bars 
			 * to the height of y-based vertical bars */
			height_y_v = height_y_v.minus(height_y_h).minus(height_y_h);
			/* Subtracts the width of x-based vertical bars 
			 * to the width of x-based horizontal bars */
			width_x_h = width_x_h.minus(width_x_v).minus(width_x_v);
			
		}
		
		// To add colors to the Objects
		for (int i = 0; i < GC.getElementCount(); i++) {
			GRect gr = (GRect) GC.getElement(i);
			gr.setFillColor(Color.GREEN);
			gr.setFilled(true);
		}
		
		return GC;
		
	}
	
	
	/**
	 * @param sx: size of x axis
	 * @param sy: size of y axis
	 * @param initialx: initial x axis to compare with iteration to graph
	 * @param initialy: initial y axis to compare with iteration to graph
	 * @return GC: GCompound to draw on the Canvas
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
			sy = new RationalPrinceton((int) r.getHeight(), 1);
												// to calculate the inclination angle
			RationalPrinceton sx2 = sx.divides(two);
			RationalPrinceton sy2 = sy.divides(two);
			RationalPrinceton totan_even =  sy2.divides(sx2);
			double angle = Math.toDegrees(Math.atan(totan_even.toDouble()));
			double angle_even = angle;
			double angle_odd = 90.0 - angle_even;
			
			GPolygon p = new GPolygon(0.0, 0.0);// to create an inclinate rectangle
			RationalPrinceton radius_x = sx.divides(two);
			radius_x = radius_x.times(radius_x);
			RationalPrinceton radius_y = sy.divides(two);
			radius_y = radius_y.times(radius_y);
			double radius = radius_x.plus(radius_y).toDouble();
			double sqrt = Math.sqrt(radius);
			
			for (int i = 0; i < 4; i++) {		// to draw the inclinate rectangle
				
				p.addPolarEdge(sqrt, angle);
				
				if (i % 2 == 0) {
					angle -= angle_even * 2;
				} else {
					angle -= angle_odd * 2;
				}
				
			}
			
			GC.add(p,							// to add the inclinate rectangle to the GCompound
					initialx.minus(sx).divides(two).toInt(),
					initialy.divides(two).toInt());
			
			sx = sx.divides(two);				// to vary the size of figures
			sy = sy.divides(two);
			
		}
		
		// To add colors to the objects
		for (int i = 0; i < GC.getElementCount(); i++) {
			GPolygon p = (GPolygon) GC.getElement(i);
			if (i % 2 == 0) p.setFillColor(Color.GRAY);
			if (i % 2 != 0) p.setFillColor(Color.magenta);
			p.setFilled(true);	
		}
		
		return GC;
		
	}
	
	
	/**
	 * @param sx: size of x axis
	 * @param sy: size of y axis
	 * @return GC: GCompound to draw on the Canvas
	 */
	
	private GCompound Hearts(RationalPrinceton sx, RationalPrinceton sy) {
		
		GCompound GC;		// to create the Compound
		GC = new FilledHeart(sx.toDouble(), sy.toDouble());
		
		return GC;
		
	}
	
	public void run() {
		
		// Define the amount of graphs per row in screen
		RationalPrinceton SIZE_X = new RationalPrinceton(getWidth(), 5);
		// Define the amount of graphs per column in screen
		RationalPrinceton SIZE_Y = new RationalPrinceton(getHeight(), 3);
		
//		// Green graphs
//		GCompound gc1 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
//		add(gc1, 0, 0);
//		GCompound gc2 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
//		add(gc2, SIZE_X.times(new RationalPrinceton(1, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(2, 1)).toInt());
//		GCompound gc3 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
//		add(gc3, SIZE_X.times(new RationalPrinceton(2, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(1, 1)).toInt());
//		GCompound gc4 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
//		add(gc4, SIZE_X.times(new RationalPrinceton(3, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(0, 1)).toInt());
//		GCompound gc5 = LogCabinBlock(SIZE_X, SIZE_Y, new RationalPrinceton(9, 1));
//		add(gc5, SIZE_X.times(new RationalPrinceton(4, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(2, 1)).toInt());
//		
//		// Squares
//		GCompound s1 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
//		add(s1, SIZE_Y.times(new RationalPrinceton(0, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(1, 1)).toInt());
//		GCompound s2 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
//		add(s2, SIZE_X.times(new RationalPrinceton(1, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(0, 1)).toInt());
		GCompound s3 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
		add(s3, SIZE_X.times(new RationalPrinceton(2, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(2, 1)).toInt());
		GCompound s4 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
		add(s4, SIZE_X.times(new RationalPrinceton(3, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(1, 1)).toInt());
		GCompound s5 = Polygons(SIZE_X, SIZE_Y, SIZE_X, SIZE_Y);
		add(s5, SIZE_X.times(new RationalPrinceton(4, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(0, 1)).toInt());
		
		// I Love Java
		GCompound h1 = Hearts(SIZE_X.divides(new RationalPrinceton(2, 1)), SIZE_Y.divides(new RationalPrinceton(2, 1)));
		add(h1, SIZE_Y.times(new RationalPrinceton(0, 1)).toInt(), SIZE_Y.times(new RationalPrinceton(0, 1)).toInt());
		
	}
	
	public static void main(String[] args) {
		
		new PQ().start();
		
	}

}