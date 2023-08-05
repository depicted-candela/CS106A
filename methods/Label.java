/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;
import methods.CartesianDistance;
import methods.Line;
import java.util.ArrayList;


public class Label extends GLabel {
	
	private static final long serialVersionUID = 1L;
	
	private Line right_hand_wall;
	private int angle;
	private int step;
	private int dx;
	private int dy;
	
	public Label(String arg0, double arg1, double arg2) {
		super(arg0, arg1, arg2);
		this.angle = -90;
		this.step = S * 20;
		this.dx = 0;
		this.dy = step;
	}
	
	public boolean isAWallAtRight(ArrayList<Line> a_lines) {
		
		double d = this.getDirection();
		
		for (int i = 0; i < a_lines.size(); i++) {
			
			Line li = a_lines.get(i);
			
			if ((( d / 10.0 ) % 2.0 != 0.0) && (li.getType() == 1)) {
				
				if (this.getDy() >= 0 && (this.getLocation().getX() - li.getX() <= (S * 20 / 2))) {
					
					if (li.getEndPoint().getY() > this.getX() && li.getStartPoint().getY() < this.getX()) return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	
	public boolean isFacingWall(ArrayList<Line> a_lines) {
		
		double d = this.getDirection();
		
		for (int i = 0; i < a_lines.size(); i++) {
			
			Line li = a_lines.get(i);
		
		    if ((li.getType() == 0) && (( d / 10.0 ) % 2.0 != 0.0)) {
		    	
		    	if (this.getDy() > 0 && (this.getLocation().getY() - li.getY() == S * 15)) {
		    		
		    		if (li.getEndPoint().getX() > this.getX() && li.getStartPoint().getX() < this.getX()) return true;
		    		if (li.getEndPoint().getX() < this.getX() && li.getStartPoint().getX() > this.getX()) return true;
			    	
		    	}
	
		    }
		    
		}
		
		return false;
		
	}

	public void setDx() {
		this.dx = (int) Math.cos(Math.toRadians(this.angle)) * this.step;
	}
	
	public int getDx() {
		return this.dx;
	}
	
	public void setDy() {
		this.dy = (int) Math.sin(Math.toRadians(this.angle)) * this.step;
	}
	
	public int getDy() {
		return this.dy;
	}
	
	public Line getRightHand() {
		return this.right_hand_wall;
	}
	
	public void setRightHand(Line right_hand_wall) {
		this.right_hand_wall = right_hand_wall;
	}
	
	public double getDirection() {
		return this.angle;
	}
	
	public void setDirection(int angle) {
		this.angle = angle;
	}
	
	public void turnRight() {
		this.angle -= 90;
	}
	
	public void turnLeft() {
		this.angle += 90;
	}
	
	public boolean isOutside() {
		
		return this.getY() > 190 * S;

	}
	
	public double getStep() {
		return this.step;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public void moveForward() {
		
		this.setDx();
		this.setDy();
		
		if (this.getDx() != 0 && this.getDy() == 0) {
			
			double x = this.getLocation().getX();
			double y = this.getLocation().getY();
			this.setLocation(x + this.getDx(), y);
			
		} else if (this.getDy() != 0 && this.getDx() == 0) {
			
			double x = this.getLocation().getX();
			double y = this.getLocation().getY();
			this.setLocation(x, y + this.getDy());
			
		}
		
	}
	
	private static final int S = 2;
	
}
