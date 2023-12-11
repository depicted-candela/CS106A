/**
 * File Breakout.java: simulates the breakout game by Wozniak
 */
package event_driven_programs;
import java.awt.Color;
import java.awt.event.KeyEvent;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
/**
 * 
 */
public class Breakout extends GraphicsProgram {
	private static final long serialVersionUID = -8682226811126233687L;
	/**
	 * The drawer for blocks that given the screen shape
	 * automatically draws blocks in an array of 10 * 10
	 * blocks
	 */
	private void blocksDrawer() {
		double width_s	= getWidth();
		double height_s	= getHeight();
		HEIGHT_B 		= height_s / 60;
		SPACE			= width_s / 100;
		double width_b 	= (width_s / 10) - SPACE;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				GRect r	= new GRect(
						SPACE * j + width_b * j,
						SPACE / 2 * (i + 1) + HEIGHT_B * i,
						width_b,
						HEIGHT_B
						);
				r.setColor(Color.WHITE);
				r.setFillColor(colorant(i));
				r.setFilled(true);
				add(r);
			}
		}
	}
	
	/**
	 * Creates colors based on the row number
	 * @param r : integer that is the row of the array of blocks
	 * @return Color based in the row number
	 */
	private Color colorant(int r) {
		if (r < 5) {
			return Color.RED;
		} else if (r < 7) {
			return Color.YELLOW;
		} else if (r < 9) {
			return Color.GREEN;
		} else {
			return new Color(0, 128, 128);
		}
	}
	
	/**
	 * Draw and position the ball
	 */
	private void ballDrawer() {
		BALL 	= new GBall(
				rg.nextDouble(0, getWidth() - BALL_SIZE),
				rg.nextDouble(SPACE / 2 * 11 + HEIGHT_B * 11, getHeight() - getHeight() / 2),
				BALL_SIZE,
				BALL_SIZE,
				rg.nextDouble(0.0, 360.0));
		BALL.setFilled(true);
		add(BALL);
	}
	
	/**
	 * Determines if the ball collides a block, the paddle or limits
	 */
	private void checkCollision() {
		// Bloque hacia abajo con elemento
		if (getElementAt(BALL.getX() + BALL_SIZE / 2, BALL.getY() + BALL_SIZE + 1) != null) {
			double angle	= BALL.getAngle();
			if (angle >= 180 && angle < 270) {
				angle 		= 270 - angle;
				angle 		= 90 + angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() + BALL_SIZE / 2, BALL.getY() + BALL_SIZE + 1);
			} else if (angle >= 270 && angle < 360) {
				angle		= angle - 270;
				angle		= 90 - angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() + BALL_SIZE / 2, BALL.getY() + BALL_SIZE + 1);
			} else if (angle <= 0 && angle > -90) {
				angle 		= -angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() + BALL_SIZE / 2, BALL.getY() + BALL_SIZE + 1);
			}
		// Bloque hacia arriba con objeto
		} else if (getElementAt(BALL.getX() + BALL_SIZE / 2, BALL.getY() - 1) != null) {
			double angle	= BALL.getAngle();
			// Hacia la izquierda
			if (angle >= 90 && angle < 180) {
				angle 		= angle - 90;
				angle 		= 270 - angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() + BALL_SIZE / 2, BALL.getY() - 1);
			// Hacia la derecha
			} else if (angle >= 0 && angle < 90) {
				angle		= -angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() + BALL_SIZE / 2, BALL.getY() - 1);
			}
		// Bloque hacia arriba con límite
		} else if (BALL.getY() - 1 < 1) {
			double angle	= BALL.getAngle();
			// Hacia la izquierda
			if (angle >= 90 && angle < 180) {
				angle 		= angle - 90;
				angle 		= 270 - angle;
				BALL.setAngle(angle);
			// Hacia la derecha
			} else if (angle >= 0 && angle < 90) {
				angle		= -angle;
				BALL.setAngle(angle);
			}
		// At the left with element
		} else if (getElementAt(BALL.getX() - 1, BALL.getY() + BALL_SIZE / 2) != null) { 
			double angle	= BALL.getAngle();
			// Hacia arriba
			if (angle >= 90 && angle < 180) {
				angle 		= 180 - angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() - 1, BALL.getY() + BALL_SIZE / 2);
			// Hacia abajo
			} else if (angle >= 180 && angle < 270) {
				angle		= angle - 180;
				angle		= -angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() - 1, BALL.getY() + BALL_SIZE / 2);
			}
		// At the right with element
		} else if (getElementAt(BALL.getX() + BALL_SIZE + 1, BALL.getY() + BALL_SIZE / 2) != null) {
			double angle	= BALL.getAngle();
			// Hacia arriba
			if (angle >= 0 && angle < 90) {
				angle 		= 180 - angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() + BALL_SIZE + 1, BALL.getY() + BALL_SIZE / 2);
			// Hacia abajo
			} else if (angle >= 360 && angle < 270) {
				angle		= 360 - angle;
				angle 		= 180 + angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() + BALL_SIZE + 1, BALL.getY() + BALL_SIZE / 2);
			} else if (angle >= -90 && angle < 0) {
				angle 		= 180 - angle;
				BALL.setAngle(angle);
				selectElement(BALL.getX() + BALL_SIZE + 1, BALL.getY() + BALL_SIZE / 2);
			}
		// Upward with limit
		} else if (BALL.getX() < 1) {
			double angle	= BALL.getAngle();
			if (angle >= 180 && angle < 270) {
				angle		= angle - 180;
				angle		= 360 - angle;
				BALL.setAngle(angle);
			} else if (angle >= 90 && angle < 180) {
				angle		= angle - 90;
				angle		= 90 - angle;
				BALL.setAngle(angle);
			}
		// At the right with limits
		} else if (BALL.getX() + BALL_SIZE + 1 > getWidth()) {
			double angle	= BALL.getAngle();
			if (angle >= 270 && angle < 360) {
				angle		= angle - 270;
				angle		= 270 - angle;
				BALL.setAngle(angle);
			} else if (angle >= 0 && angle < 90) {
				angle		= 90 - angle;
				angle		= 90 + angle;
				BALL.setAngle(angle);
			} else if (angle >= -90 && angle < 0) {
				angle		= -angle;
				angle		+= 180;
				BALL.setAngle(angle);
			}
		}
	}
	
	/**
	 * With x and y positions determines if the collided
	 * element is an element to delete from the canvas
	 * @param x
	 * @param y
	 */
	private void selectElement(double x, double y) {
		if (y < getHeight() / 2) {
			if (getElementAt(x, y) != null) {
				ELEMENT 	= (GRect) getElementAt(x, y);
				remove(ELEMENT);
			}
		}
	}
	
	/**
	 * Draws the paddle
	 */
	private void paddleDrawer() {
		PADDLE	= new GPaddle(
				getWidth() / 10,
				getHeight() / 60);
		PADDLE.setFilled(true);
		add(PADDLE,
				getWidth() / 2 - PADDLE.getWidth() / 2,
				3 * getHeight() / 4);
	}
	
	/**
	 * When a directional key in the horizontal plane is pressed
	 */
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT: PADDLE.move(-10, 0); break;
			case KeyEvent.VK_RIGHT: PADDLE.move(10, 0); break;
		}
	}
	
	/**
	 * When a directional key in the horizontal plane is clicked
	 */
	public void keyClicked(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT: PADDLE.move(-10, 0); break;
			case KeyEvent.VK_RIGHT: PADDLE.move(10, 0); break;
		}
	}
	
	/**
	 * Initialize the program
	 */
	public void init() {
		blocksDrawer();
		ballDrawer();
		paddleDrawer();
		addKeyListeners();
	}
	
	/**
	 * To run the logic of the game
	 */
	public void run() {
		waitForClick();
		while (getElementCount() > 2) {
			pause(4);
			checkCollision();
			BALL.movePolar(1, BALL.getAngle());
		}
		GLabel w = new GLabel("You win");
		add(w,
				getWidth() / 2 - w.getWidth() / 2,
				getHeight() / 2 - w.getAscent() / 2);
	}
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		new Breakout().start();
	}
	
	private RandomGenerator rg = new RandomGenerator();
	private double HEIGHT_B, SPACE;
	private double BALL_SIZE = 30.0;
	private GRect ELEMENT;
	private GBall BALL;
	private GPaddle PADDLE;

}

/**
 * An extension of GOval with angle or direction for the Ball
 */
class GBall extends GOval {
	private static final long serialVersionUID = 809860010841560000L;
	private double angle;
	/**
	 * Constructor for GBall
	 * @param x 		: horizontal position
	 * @param y			: vertical position
	 * @param width		: horizontal size
	 * @param height	: vertical size
	 * @param direction	: direction of the ball
	 */
	public GBall(double x, double y, double width, double height, double direction) {
		super(x, y, width, height);
		angle = direction;
	}
	/**
	 * Setter to the direction of the ball
	 * @param a			: angle or direction
	 */
	public void setAngle(double a) {
		angle = a;
	}
	/**
	 * Getter of the direction of the ball
	 * @return
	 */
	public double getAngle() {
		return angle;
	}
}

/**
 * An extension of GOval to the Paddle
 */
class GPaddle extends GRect {
	private static final long serialVersionUID = -3763524116834357750L;
	public GPaddle(double width, double height) {
		super(width, height);
	}
}

