/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;
import acm.program.*;

public class ILoveJava extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	
	/** Size (diameter) of the label */
	private int DIAM_LABEL;
	
	/** Amount Y velocity is increased each cycle as a
	* result of gravity */
	private static final double GRAVITY = 3;
	
	/** Animation delay or pause time between ball moves */
	private static final int DELAY = 50;
	
	/** Initial X and Y location of label */
	private final double X_START = DIAM_LABEL / 2;
	private static final double Y_START = 100;
	
	/** X Velocity */
	private static final double X_VEL = 5;
	
	/** Amount Y Velocity is reduced when it bounces */
	private static final double BOUNCE_REDUCE = 0.7;
	
	/** Starting X and Y Velocities */
	private double xVel = X_VEL;
	private double yVel = 0.0;
	
	/* private instance variable */
	private GLabel label;
	
	public void run() {
		
		setup();
		// Simulation ends when ball goes off right hand
		// end of screen
		while (label.getX() < getWidth()) {
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
		
	}
	
	public static void main(String[] args) {
		
		new ILoveJava().start();
		
	}
	
	/** Create and place ball. */
	private void setup() {
		
		label = new GLabel("I Love Java");
		DIAM_LABEL = (int) label.getWidth();
		label.setFont("Z003-bold-18");
		add(label, X_START, Y_START);
		
	}
	
	/** Update and move ball */
	private void moveBall() {
		
		// increase yVelocity due to gravity on each cycle
		yVel += GRAVITY;
		label.move(xVel,yVel);
		
	}
	
	/** Determine if collision with floor, update velocities
	* and location as appropriate. */
	private void checkForCollision() {
		
		// determine if ball has dropped below the floor
		if (label.getY() > getHeight()) {
			// change ball's Y velocity to now bounce upwards
			yVel = -yVel * BOUNCE_REDUCE;
			// assume bounce will move ball an amount above the
			// floor equal to the amount it would have dropped
			// below the floor.
			double diff = label.getY() - (getHeight());
			label.move(0, -2 * diff);
			
		}
	}

}
