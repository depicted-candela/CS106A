/**
 * 
 */
package object_oriented_graphics;

import java.awt.Color;

/**
 * 
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class FilledSquare extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		r.setFillColor(Color.BLACK);
		r.setFilled(true);
		add(r, getWidth() / 2 - r.getWidth() / 2, getHeight() / 2 - r.getHeight() / 2);
		
		while(true) {
			
			pause(1000);
			r.setFillColor(randgen.nextColor());
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new FilledSquare().start();

	}
	
	private static final RandomGenerator randgen = new RandomGenerator();
	private GRect r = new GRect(100.0, 100.0);
	
}
