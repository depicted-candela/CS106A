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

public class PacMan extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param size: the size of PacMan
	 * @return pac: GArc to draw in the GGraphics Canvas
	 */
	
	private void Drawer() {
		
		PACMAN = new GArc(SIZE / 2.0, SIZE, SIZE, SIZE, 45.0, 270.0);
		PACMAN.setFillColor(Color.yellow);
		PACMAN.setFilled(true);
		
	}
	
	private void Morder() {
		
		double sa = PACMAN.getStartAngle();
		if (sa == 45.0) B1 = true;
		if (sa == 0.0) B1 = false;
		if (B1) {
			PACMAN.setStartAngle(sa - 15.0);
			PACMAN.setSweepAngle(PACMAN.getSweepAngle() + 30.0);
		} else {
			PACMAN.setStartAngle(sa + 15.0);
			PACMAN.setSweepAngle(PACMAN.getSweepAngle() - 30.0);
		}
		
	}
	
	private void Mover() {
		
		PACMAN.setLocation(PACMAN.getX() + SIZE / 2.0, PACMAN.getY());
		
	}
	
	public void run() {
		
		Drawer();
		add(PACMAN, 0.0, getHeight() - SIZE);
		while (PACMAN.getX() < getWidth()) {
			pause(500);
			Mover();
			Morder();
		}
		
	}
	
	public static void main(String[] args) {
		new PacMan().start();
	}
	
	boolean B1 = true;
	private GArc PACMAN;
	private static double SIZE = 100.0;

}
