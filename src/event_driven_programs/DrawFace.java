/**
 * 
 */
package event_driven_programs;

import acm.graphics.*;
import acm.program.*;
import object_oriented_graphics.Face;

/**
 * 
 */
public class DrawFace extends GraphicsProgram {

	/**
	 * 
	 */

	public void run() {
		Face f = new Face(SIZE);
		add(f.head, getWidth(), getHeight());
	}
	public static void main(String[] args) {
		new DrawFace().start();
	}
	
	private int SIZE = 100;

}
