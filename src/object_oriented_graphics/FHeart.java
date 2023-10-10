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
		FilledHeart fh = new FilledHeart(100.0, 100.0);
		add(fh);

	}
	
	public static void main(String[] args) {
		
		new FHeart().start();
		
	}

}