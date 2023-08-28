/**
 * 
 */
package objects_classes;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;

import java.awt.Color;

public class Pi extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// To calculate an approximation of PI
		add(circle);
		add(square);
		int x, y;
		
		double circle_area = 0;
		double square_area = 0;
		
		for (int i = 0; i < 1000; i++) {
			
			x = coord.nextInt((int) S, (int) (S + CI));
			y = coord.nextInt((int) S, (int) (S + CI));
			
			if (circle.contains(x, y)) {
				
				GOval oval = new GOval(x, y, RADIUS, RADIUS);
				oval.setColor(Color.RED);
				add(oval);
				
		        try {
		            Thread.sleep(10);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        
				circle_area++;
				square_area++;
				
			} else if (square.contains(x, y)) {
				
				GOval oval = new GOval(x, y, RADIUS, RADIUS);
				oval.setColor(Color.GREEN);
				add(oval);
				square_area++;
				
			}
			
		}
		
		GLabel string = new GLabel("PI is: " + (circle_area / square_area) * 4, (S + CI), (S + CI) / 2);

		add(string);
		
	}
	
	private static final double S = 10.0;
	private static final int CI = 400;
	private static final int RADIUS = 3;
	private static GOval circle = new GOval(S, S, CI, CI);
	private static GRect square = new GRect(S, S, CI, CI);
	private static RandomGenerator coord = new RandomGenerator();

}
