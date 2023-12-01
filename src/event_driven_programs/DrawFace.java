/**
 * 
 */
package event_driven_programs;

import java.awt.event.*;
import acm.program.*;
import acm.graphics.*;
import object_oriented_graphics.Face;

/**
 * 
 */
public class DrawFace extends GraphicsProgram {

	private static final long serialVersionUID = 6631039572178869164L;

	/**
	 * 
	 */

	public void init() {
		F = new Face(SIZE);
		POS_X = getWidth() / 2 - ((5 * SIZE) / 12);
		POS_Y = getHeight() / 2 - SIZE / 2;
		add(F, POS_X, POS_Y);
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		GOval eye = (GOval) F.getElement(2);
		F.see(x, y, eye.getX() + POS_X, eye.getY() + POS_Y);
	}
	
	public void mouseDragged(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		GOval eye = (GOval) F.getElement(2);
		F.see(x, y, eye.getX() + POS_X, eye.getY() + POS_Y);
	}
	
	public void mouseReleased(MouseEvent e) {
		F.defaultPupilsPosition();
	}
	
	public static void main(String[] args) {
		new DrawFace().start();
	}
	
	private double POS_X, POS_Y;
	private int SIZE = 300;
	private Face F;
	
}
