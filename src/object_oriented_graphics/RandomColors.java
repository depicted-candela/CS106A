/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.Color;
import java.awt.event.*;

public class RandomColors extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void mousePressed(MouseEvent e) {
		
		double x = e.getX();
		double y = e.getY();
		
		GCompound lab = (GCompound) getElementAt(x, y);
		GLabel w = (GLabel) lab.getElementAt(x, y);
		w.setColor(givenColor(w.getLabel()));
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
		double x = e.getX();
		double y = e.getY();
		
		GCompound lab = (GCompound) getElementAt(x, y);
		GLabel w = (GLabel) lab.getElementAt(x, y);
		w.setColor(randomCol(w));
		
	}
	
	private Color givenColor (String s) {
		
		if (s.equals("RED")) {
			return Color.RED;
		} else if (s.equals("ORANGE")) {
			return Color.ORANGE;
		} else if (s.equals("YELLOW")) {
			return Color.YELLOW;
		} else if (s.equals("GREEN")) {
			return Color.GREEN;
		} else if (s.equals("CYAN")) {
			return Color.CYAN;
		} else if (s.equals("MAGENTA")) {
			return Color.MAGENTA;
		} else {
			return Color.BLUE;
		}
		
	}
	
	private GCompound labDrawer () {
		
		GCompound cir = new GCompound();
		double x, y;
		
		for (int i = 0; i < 7; i++) {
			GLabel w = randomLab();
			w.setColor(randomCol(w));
			x = randg.nextDouble(0.0, 200.0);
			y = randg.nextDouble(0.0, 200.0);
			cir.add(w, x, y);
		}
		
		return cir;
		
	}
	
	private GLabel randomLab () {
		
		int l = randg.nextInt(0, 6);
		GLabel w = new GLabel("");
		
		if (l == 0) {
			w.setLabel("RED");
		} else if (l == 1) {
			w.setLabel("ORANGE");
		} else if (l == 2) {
			w.setLabel("YELLOW");
		} else if (l == 3) {
			w.setLabel("GREEN");
		} else if (l == 4) {
			w.setLabel("CYAN");
		} else if (l == 5) {
			w.setLabel("MAGENTA");
		} else {
			w.setLabel("BLUE");
		}
		
		return w;
	}
	
	private Color randomCol (GLabel l) {
		
		int c;
		Color col;
		
		while (true) {
			
			c = randg.nextInt(0, 6);
			
			if (c == 0 && !l.getLabel().equals("RED")) {
				col = Color.RED;
				break;
			} else if (c == 1 && !l.getLabel().equals("ORANGE")) {
				col = Color.ORANGE;
				break;
			} else if (c == 2 && !l.getLabel().equals("YELLOW")) {
				col = Color.YELLOW;
				break;
			} else if (c == 3 && !l.getLabel().equals("GREEN")) {
				col = Color.GREEN;
				break;
			} else if (c == 4 && !l.getLabel().equals("CYAN")) {
				col = Color.CYAN;
				break;
			} else if (c == 5 && !l.getLabel().equals("MAGENTA")) {
				col = Color.MAGENTA;
				break;
			} else {
				col = Color.BLUE;
				break;
			}
		}
		
		return col;

	}
	
	public void run() {
		add(labDrawer(), 10.0, 10.0);
		addMouseListeners();
	}
	
	public static void main(String[] args) {
		
		new RandomColors().start();
		
	}
	
	private static RandomGenerator randg = new RandomGenerator();

}
