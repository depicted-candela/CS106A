/**
 * 
 */
package event_driven_programs;
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
	 * 
	 */
	
	private void blocksDrawer() {
		double width_s	= getWidth();
		double height_s	= getHeight();
		HEIGHT_B 		= height_s / 60;
		SPACE			= width_s / 100;
		double width_b 	= (width_s / 10) - SPACE;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				BLOCKS.add(
						new GRect(
								SPACE * j + width_b * j,
								SPACE / 2 * (i + 1) + HEIGHT_B * i,
								width_b,
								HEIGHT_B
								)
						);
			}
		}
		add(BLOCKS, getWidth() / 200, 0);
	}
	
	private void ballDrawer() {
//		BALL 	= new GBall(
//				rg.nextDouble(0, getWidth() - BALL_SIZE),
//				rg.nextDouble(SPACE / 2 * 11 + HEIGHT_B * 11, getHeight() - getHeight() / 2),
//				BALL_SIZE,
//				BALL_SIZE,
//				rg.nextDouble(0.0, 360.0));
		BALL	= new GBall(
				getWidth() - BALL_SIZE * 11,
				SPACE / 2 * 11 + HEIGHT_B * 10,
				BALL_SIZE,
				BALL_SIZE,
				250);
		add(BALL);
	}
	
	private void checkCollision() {
		if (getElementAt(BALL.getX() + BALL_SIZE / 2, BALL.getY() + BALL_SIZE + 1) != null) {
			double angle	= BALL.getAngle();
			if (angle >= 180 && angle < 270) {
				angle 		= 270 - angle;
				angle 		= 90 + angle;
				BALL.setAngle(angle);
			} else if (angle >= 270 && angle < 360) {
				angle		= angle - 270;
				angle		= 90 - angle;
				BALL.setAngle(angle);
			}
		} else if (getElementAt(BALL.getX() + BALL_SIZE / 2, BALL.getY() - 1) != null) {
			double angle	= BALL.getAngle();
			if (angle >= 90 && angle < 180) {
				angle 		= angle - 90;
				angle 		= 270 - angle;
				BALL.setAngle(angle);
			} else if (angle >= 0 && angle < 90) {
				angle		= 90 - angle;
				angle		= 270 + angle;
				BALL.setAngle(angle);
			}
		} else if (BALL.getX() == 0) {
			double angle	= BALL.getAngle();
			if (angle < 270 && angle >= 180) {
				println(angle);
				angle		= angle - 180;
				angle		= 360 - angle;
				BALL.setAngle(angle);
				println(BALL.getAngle());
			} else if (angle < 180 && angle >= 90) {
				println('b');
				angle		= angle - 90;
				angle		= 90 - angle;
				BALL.setAngle(angle);
			}
		} else if (BALL.getX() + BALL_SIZE + 1 > 0) {
			double angle	= BALL.getAngle();
			if (angle < 360 && angle >= 270) {
				angle		= angle - 270;
				angle		= 270 - angle;
				BALL.setAngle(angle);
			}
		}
	}
	
	private void paddleDrawer() {
		PADDLE	= new GRect(
				getWidth() / 10,
				getHeight() / 60);
		add(PADDLE,
				getWidth() / 2 - PADDLE.getWidth() / 2,
				3 * getHeight() / 4);
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT: PADDLE.move(-10, 0); break;
			case KeyEvent.VK_RIGHT: PADDLE.move(10, 0); break;
		}
	}
	
	public void init() {
		blocksDrawer();
		ballDrawer();
		paddleDrawer();
		addKeyListeners();
	}

	public void run() {
		waitForClick();
		while(BALL.getX() > -1) {
			pause(5);
			println(BALL.getAngle());
			checkCollision();
			println(BALL.getAngle());
			BALL.movePolar(1, BALL.getAngle());
		}
	}
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		new Breakout().start();
	}
	
	private GCompound BLOCKS = new GCompound();
	private RandomGenerator rg = new RandomGenerator();
	private double HEIGHT_B, SPACE;
	private double BALL_SIZE = 30.0;
	private GBall BALL;
	private GRect PADDLE;

}

class GBall extends GOval {
	private static final long serialVersionUID = 809860010841560000L;
	private double angle;
	
	public GBall(double x, double y, double width, double height, double direction) {
		super(x, y, width, height);
		angle = direction;
	}
	public void setAngle(double a) {
		angle = a;
	}
	public double getAngle() {
		return angle;
	}
}

