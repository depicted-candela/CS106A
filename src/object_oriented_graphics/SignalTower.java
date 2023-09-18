package object_oriented_graphics;

/* Class: SignalTower */
/**
* This class defines a signal tower object that passes a message
* to the next tower in a line.
*/

import acm.graphics.*;
import java.awt.Color;

public class SignalTower extends GCompound {
	
	private static final long serialVersionUID = 1L;
	
	/* Constructor: SignalTower(name, link) */
	/**
	* Constructs a new signal tower with the following parameters:
	*
	* @param name The name of the tower
	* @param link A link to the next tower, or null if none exists
	*/
	
	public SignalTower(String name, SignalTower link, double t_width, double t_height, double t_pos, double width_box) {
		
		tower = new GRect(t_width, t_height);
		tower.setFillColor(Color.RED);
		add(tower, (1 / 2.0) * (width_box - t_width), t_pos);
		towerName = name;
		nextTower = link;
		tower_name = new GLabel(towerName);
		add(tower_name, (1 / 2.0) * (width_box - tower_name.getWidth()), t_pos * 5.1);
		
	}
	
	/* Method: signal() */
	/**
	* This method represents sending a signal to this tower. The effect
	* is to light the signal fire here and to send an additional signal
	* message to the next tower in the chain, if any.
	*/
	
	public void signal() {
			
		lightCurrentTower();
		if (nextTower != null) nextTower.signal();
			
	}
	
	/* Method: lightCurrentTower() */
	/**
	* This method lights the signal fire for this tower. This version
	* supplies a temporary implementation (typically called a "stub")
	* that simply prints the name of the tower to the standard output
	* channel. If you wanted to redesign this class to be part of a
	* graphical application, for example, you could override this
	* method to draw an indication of the signal fire on the display.
	*/
	
	public void lightCurrentTower() {
		
		if (!tower.isFilled()) {
			
			pause();
			tower.setFilled(true);
			repaint();
			
		}
		
	}
	
	private void pause() {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}
	
	/* Private instance variables */
	private String towerName;
	private SignalTower nextTower;
	GRect tower;
	GLabel tower_name;
	
}
