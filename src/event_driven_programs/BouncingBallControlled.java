package event_driven_programs;

/*
* File: BouncingBall.java
* -----------------------
* This program graphically simulates a bouncing ball.
*/
import acm.program.*;

import java.awt.event.ActionEvent;
import javax.swing.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;

import acm.graphics.*;

public class BouncingBallControlled extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	/** Size (diameter) of the ball */
	private static final int DIAM_BALL = 30;
	
	/** Amount Y velocity is increased each cycle as a
	* result of gravity */
	private double GRAVITY;
	
	/** Animation delay or pause time between ball moves */
	private static final int DELAY = 50;
	
	/** Initial X and Y location of ball */
	private static final double X_START = DIAM_BALL / 2;
	private static final double Y_START = 100;
	
	/** X Velocity */
	private static final double X_VEL = 5;
	
	/** Amount Y Velocity is reduced when it bounces */
	private static final double BOUNCE_REDUCE = 0.7;
	
	/** Starting X and Y Velocities */
	private double xVel = X_VEL;
	private double yVel = 0.0;
	
	/* private instance variable */
	private GOval ball;
	private JSlider sizeSlider;
	private boolean isRunning = false;
	
	public void init() {
		setup();
		add(new JButton("Start"), SOUTH);
		add(new JButton("Stop"), SOUTH);
		add(new JLabel("Slow"), SOUTH);
		sizeSlider = new JSlider(1, 10, 1);
		sizeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				GRAVITY = sizeSlider.getValue();
			}
		});
		GRAVITY = sizeSlider.getValue();
		add(sizeSlider, SOUTH);
		add(new JLabel("Fast"), SOUTH);
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			isRunning = true;
		} else if (e.getActionCommand().equals("Stop")) {
			isRunning = false;
		}
	}
	
	public void run() {
		// Simulation ends when ball goes off right hand
		// end of screen
		while (ball.getX() < getWidth()) {
			if (isRunning) {
				moveBall();
				checkForCollision();
				pause(DELAY);
			}
		}
	}
		
	/** Create and place ball. */
	private void setup() {
		
		ball = new GOval(X_START, Y_START, DIAM_BALL, DIAM_BALL);
		ball.setFilled(true);
		add(ball);
		
	}
	
	/** Update and move ball */
	private void moveBall() {
		
		// increase yVelocity due to gravity on each cycle
		yVel += GRAVITY;
		ball.move(xVel,yVel);
		
	}
	
	/** Determine if collision with floor, update velocities
	* and location as appropriate. */
	private void checkForCollision() {
		
		// determine if ball has dropped below the floor
		if (ball.getY() > getHeight() - DIAM_BALL) {
			// change ball's Y velocity to now bounce upwards
			yVel = -yVel * BOUNCE_REDUCE;
			// assume bounce will move ball an amount above the
			// floor equal to the amount it would have dropped
			// below the floor.
			double diff = ball.getY() - (getHeight() - DIAM_BALL);
			ball.move(0, -2 * diff);
			
		}
	}
	
	public static void main(String[] args) {
		new BouncingBallControlled().start();
	}
	
}