package object_oriented_graphics;

/*
* File: DrawRectangle.java
* ------------------------
* This program allows users to create rectangles on the canvas
* by clicking and dragging with the mouse.
*/

import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;

/** This class allows users to drag rectangles on the canvas */
public class DrawRectangle extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	public int shape;
	
	/** Runs the program */
	public void run() {
		addMouseListeners();
	}
	
	public static void main(String[] args) {
		new DrawRectangle().start();
	}
	
	/** Called on mouse press to record the starting coordinates */
	public void mousePressed(MouseEvent e) {
		
		startX = e.getX();
		startY = e.getY();
		
		if (getElementAt(startX, startY) == null) {
			
			if (shape == 1 || shape == 2) {
				
				currentRect = new GRect(startX, startY, 0, 0);
				currentRect.setFilled(true);
				add(currentRect);
				
			} else if (shape == 3 || shape == 4) {
				
				currentOval = new GOval(startX, startY, 0, 0);
				currentOval.setFilled(true);
				add(currentOval);
				
			} 

		}

	}
	
	/** Called on mouse drag to reshape the current rectangle */
	public void mouseDragged(MouseEvent e) {
		
		double x = Math.min(e.getX(), startX);
		double y = Math.min(e.getY(), startY);
		
		if (shape == 1 || shape == 2 || shape == 3 || shape == 4) {
			
			double width = Math.abs(e.getX() - startX);
			double height = Math.abs(e.getY() - startY);
			
			if (shape == 1 || shape == 2) {
				
				currentRect.setBounds(x, y, width, height);
				
			} else {
				
				currentRect.setBounds(x, y, width, height);
				
			}

		}

	}
	
	/* Private state */
	private GRect currentRect;
	private GOval currentOval;
	private double startX;
	private double startY;
	
}
