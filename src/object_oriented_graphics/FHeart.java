/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

public class FHeart extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		// TODO Auto-generated method stub
		FilledHeart fh = new FilledHeart(SQUARE_SIZE);
		System.out.println(fh.getH());
		add(fh);

	}
	
	public static void main(String[] args) {
		
		new FHeart().start();
		
	}
	
	static double POS_X = 0.0;
	static double POS_Y = 0.0;
	static double SQUARE_SIZE = 300.0;
	static double DIAM = Math.sqrt(2) * SQUARE_SIZE;

}
