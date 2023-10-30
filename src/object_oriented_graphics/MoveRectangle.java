/**
 * 
 */
package object_oriented_graphics;

import java.awt.event.MouseEvent;
import acm.graphics.GRect;

/**
 * @author nicalcoca
 *
 */

public class MoveRectangle extends DrawRectangle {
	
	private static final long serialVersionUID = 1L;
	
	/** Called on mouse press to record the starting coordinates */
	public void mousePressed(MouseEvent e) {
		
		startX = e.getX();
		startY = e.getY();
		if (this.getElementAt(startX, startY) == null) {
			currentRect = new GRect(startX, startY, 0, 0);
			currentRect.setFilled(true);
			add(currentRect);
		} else {
			currentRect = (GRect) this.getElementAt(startX, startY);
		}

	}
	
	/** Called on mouse drag to reshape the current rectangle */
	public void mouseDragged(MouseEvent e) {
		
		double width;
		double height;
		double x;
		double y;
		
		if (!currentRect.contains(e.getX(), e.getY())) {
			width = Math.abs(e.getX() - startX);
			height = Math.abs(e.getY() - startY);
			x = Math.min(e.getX(), startX);
			y = Math.min(e.getY(), startY);
			currentRect.setBounds(x, y, width, height);
		} else {
			width = currentRect.getWidth();
			height = currentRect.getHeight();
			currentRect.setLocation(e.getX() - width / 2, e.getY() - height / 2);
		}
		
	}
	
	/* Private state */
	private GRect currentRect;
	private double startX;
	private double startY;

}
