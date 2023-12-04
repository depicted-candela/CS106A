/**
 * 
 */
package event_driven_programs;
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
	}
	
	public void init() {
		blocksDrawer();
		add(BLOCKS, getWidth() / 200, 0);
		BALL = new GBall(
				rg.nextDouble(0, getWidth() - BALL_SIZE),
				rg.nextDouble(SPACE / 2 * 11 + HEIGHT_B * 11, getHeight() - getHeight() / 2),
				BALL_SIZE,
				BALL_SIZE,
				rg.nextDouble(0.0, 360.0));
		add(BALL);
	}
	
	public void run() {
		System.out.println(BALL.getX() > 0);
		while(BALL.getX() > 0) {
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

