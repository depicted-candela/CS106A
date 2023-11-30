/**
 * 
 */
package event_driven_programs;

import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.*;

/**
 * 
 */

public class MouseTracker extends GraphicsProgram {

	private static final long serialVersionUID = -7297203128643617506L;
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		C = new GLabel("(" + Integer.toString(x) + ", " + Integer.toString(y) + ")");
		add(C, x - C.getWidth(), y - C.getAscent());
	}
	
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		C.setLocation(x - C.getWidth(), y + C.getAscent() / 2);
	}
	
	public void mouseReleased(MouseEvent e) {
		remove(C);
	}
	
	public void init() {
		addMouseListeners();
	}
	
	public static void main(String[] args) {
		new MouseTracker().start();
	}
	
	private GLabel C;

}
