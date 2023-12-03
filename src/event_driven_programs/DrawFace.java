/**
 * 
 */
package event_driven_programs;

import java.awt.event.*;
import acm.program.*;
import acm.graphics.*;

/**
 * 
 */
public class DrawFace extends GraphicsProgram {

	private static final long serialVersionUID = 6631039572178869164L;

	/**
	 * 
	 */

	public void init() {
		F = new SeeingFace(SIZE);
		POS_X = getWidth() / 2 - ((5 * SIZE) / 12);
		POS_Y = getHeight() / 2 - SIZE / 2;
		add(F, POS_X, POS_Y);
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		GOval pup_l = (GOval) F.getElement(3);
		GOval pup_r = (GOval) F.getElement(4);
		F.see(x, y,
				pup_l.getX() + POS_X,
				pup_l.getY() + POS_Y,
				pup_r.getX() + POS_X,
				pup_r.getY() + POS_Y);
	}
	
	public void mouseDragged(MouseEvent e) {
		double x 	= e.getX();
		double y 	= e.getY();
		GOval pup_l = (GOval) F.getElement(3);
		GOval pup_r = (GOval) F.getElement(4);
		F.see(x, y,
				pup_l.getX() + POS_X,
				pup_l.getY() + POS_Y,
				pup_r.getX() + POS_X,
				pup_r.getY() + POS_Y);
	}
	
	public void mouseReleased(MouseEvent e) {
		F.defaultPupilsPosition();
	}
	
	public static void main(String[] args) {
		new DrawFace().start();
	}
	
	private double POS_X, POS_Y;
	private int SIZE = 400;
	private SeeingFace F;
	
}
