/**
 * 
 */
package object_oriented_graphics;
import acm.graphics.*;
/**
 * 
 */
public class Face {

	/**
	 * 
	 */
	public Face(double size) {
		
		head.add(new GOval(size, 5 * size / 6));
		eye_l.add(new GOval(size / 8, (5 * size / 6) / 8));
		head.add(eye_l, size / 8 * 2, ((5 * size / 6) / 8) * 2);
		
	}
	public GCompound head, eyes, eye_l, eye_r;
	
}
