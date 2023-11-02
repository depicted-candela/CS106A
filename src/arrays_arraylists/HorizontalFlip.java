/**
 * 
 */
package arrays_arraylists;
import acm.graphics.*;
import acm.program.*;
/**
 * 
 */
public class HorizontalFlip extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public void run() {
		HorizontalImage raw = new HorizontalImage("milk_maid.png");
		raw.setSize(getWidth() / 2.0, getHeight());
		add(raw);
		GImage hor = raw.horizontalFlip();
		hor.setSize(getWidth() / 2.0, getHeight());
		add(hor, getWidth() / 2.0, 0.0);
	}
	public static void main(String[] args) {
		new HorizontalFlip().start();
	}

}
