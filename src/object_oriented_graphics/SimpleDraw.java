/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import java.awt.event.*;
import acm.graphics.*;

public class SimpleDraw extends DrawRectangle {
	
	private static final long serialVersionUID = 1L;
	private static double scale = 1.0 / 15.0;
	public int shape = 1;

	/**
	 * @param args
	 */
	
	public void run() {
		
		addMouseListeners();
		DrawPalette();
		
	}
	
	private void DrawPalette() {
		
		ShapesForDrawing shape1 = new ShapesForDrawing(getWidth(), getHeight(), 1);
		shape1.addMouseListener(new ShapeClickListener(shape1));
		add(shape1, getWidth() / 100.0, getWidth() / 100.0 + getHeight() * scale);
		
		ShapesForDrawing shape2 = new ShapesForDrawing(getWidth(), getHeight(), 2);
		shape2.addMouseListener(new ShapeClickListener(shape2));
		add(shape2, getWidth() / 100.0, getWidth() / 100.0 + getHeight() * scale * 2);
		
		ShapesForDrawing shape3 = new ShapesForDrawing(getWidth(), getHeight(), 3);
		shape3.addMouseListener(new ShapeClickListener(shape3));
		add(shape3, getWidth() / 100.0, getWidth() / 100.0 + getHeight() * scale * 3);
		
		ShapesForDrawing shape4 = new ShapesForDrawing(getWidth(), getHeight(), 4);
		shape4.addMouseListener(new ShapeClickListener(shape4));
		add(shape4, getWidth() / 100.0, getWidth() / 100.0 + getHeight() * scale * 4);
		
		ShapesForDrawing shape5 = new ShapesForDrawing(getWidth(), getHeight(), 5);
		shape5.addMouseListener(new ShapeClickListener(shape5));
		add(shape5, getWidth() / 100.0, getWidth() / 100.0 + getHeight() * scale * 5);
	
	}
	
	/** Called on mouse press to record the starting coordinates */
	public void mousePressed(MouseEvent e) {
		
		startX = e.getX();
		startY = e.getY();
		System.out.println(shape);
		
		if (getElementAt(startX, startY) == null) {
			
			if (shape == 1) {
				
				currentRect = new GRect(startX, startY, 0.0, 0.0);
				currentRect.setFilled(true);
				add(currentRect);
			
			} else if (shape == 2) {
				
				currentRect = new GRect(startX, startY, 0.0, 0.0);
				currentRect.setFilled(false);
				add(currentRect);
				
			} else if (shape == 3) {
				
				currentOval = new GOval(startX, startY, 0.0, 0.0);
				currentOval.setFilled(true);
				add(currentOval);
				
			} else if (shape == 4) {
				
				currentOval = new GOval(startX, startY, 0.0, 0.0);
				currentOval.setFilled(false);
				add(currentOval);
				
			} else {
				
				currentLine = new GLine(startX, startY, startX, startY);
				add(currentLine);
				
			}

		}
	
	}
	
	/** Called on mouse drag to reshape the current rectangle */
	public void mouseDragged(MouseEvent e) {
		
		if (!ShapesForDrawing.class.isInstance(getElementAt(startX, startY))) {
			
			if (shape == 1 || shape == 2 || shape == 3 || shape == 4) {
				
				double width = Math.abs(e.getX() - startX);
				double height = Math.abs(e.getY() - startY);
				double x = Math.min(e.getX(), startX);
				double y = Math.min(e.getY(), startY);
				
				if (shape == 1 || shape == 2) {
					
					currentRect.setBounds(x, y, width, height);
					
				} else if (shape == 3 || shape == 4) {
					
					currentOval.setBounds(x, y, width, height);
					
				}

			} else {
				
				double x = e.getX();
				double y = e.getY();
				
				currentLine.setEndPoint(x, y);
				
			}
			
		}

	}
	
	private class ShapeClickListener extends MouseAdapter {
		
		int ss;
		
		public ShapeClickListener(ShapesForDrawing shps) {
			this.ss = shps.shp;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			shape = ss;
		}
		
	}
	
	public static void main(String[] args) {
		
		new SimpleDraw().start();

	}
	
	/* Private state */
	private GRect currentRect;
	private GOval currentOval;
	private GLine currentLine;
	private double startX;
	private double startY;

}
