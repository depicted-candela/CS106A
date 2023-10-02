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

public class PumpkinPie extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	private static final int N_PIECES = 6;
	private static final double SIZE = 200.0;
	private static final double SWEEP = 360.0 / ((double) N_PIECES);
	/**
	 * @param args
	 */
	
	public void run() {
		
		for (int i = 0; i < N_PIECES; i++) {
			
			GArc ga = new GArc(SIZE, SIZE, SWEEP * i, SWEEP);
			ga.setFillColor(Color.orange);
			ga.setFilled(true);
			add(ga, getWidth() / 2 - SIZE / 2.0, getHeight() / 2 - SIZE / 2.0);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new PumpkinPie().start();

	}

}
