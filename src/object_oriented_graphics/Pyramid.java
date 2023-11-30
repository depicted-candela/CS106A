/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class Pyramid extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		PyramidDrawer pyramid = new PyramidDrawer(BRICKS_IN_BASE, BRICK_WIDTH, BRICK_HEIGHT);
		add(pyramid, (getWidth() - BRICK_WIDTH * BRICKS_IN_BASE) / 2, getHeight() - (BRICK_HEIGHT * BRICKS_IN_BASE) + (2 * BRICK_HEIGHT));
		
	}
	
	public static void main(String[] args) {
		new Pyramid().start();
	}
	
	private static int BRICK_WIDTH = 14;
	private static int BRICK_HEIGHT = 8;
	private static int BRICKS_IN_BASE = 40;

}
