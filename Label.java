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
	
	public Label(String arg0, double arg1, double arg2) {
		super(arg0, arg1, arg2);
		this.angle = -90;
		this.step = S * 20;
	}
	
	public boolean isAWallAtRight(ArrayList<Line> l) {
		
		CartesianDistance cartesian = new CartesianDistance();
		double d = this.getDirection();
		
		for (int i = 0; i < l.size(); i++) {
			
			Line li = l.get(i);
			
			double xs = li.getStartPoint().getX();
			double ys = li.getStartPoint().getY();
			double xe = li.getEndPoint().getX();
			double ye = li.getEndPoint().getY();
			
			boolean b1 = cartesian.cartesianDistancePointLine(this.getX(), this.getY(), xs, xe, ys, ye);
			
			if (li.getType() == 1 && ( d / 10.0 ) % 2.0 != 0.0 && b1) {
				return true;
			} else if (li.getType() == 0 && ( d / 10.0 ) % 2.0 == 0.0 && b1) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	
	public boolean isFacingWall(ArrayList<Line> l) {
		
		CartesianDistance cartesian = new CartesianDistance();
		double d = this.getDirection();
		
		for (int i = 0; i < l.size(); i++) {
			
			Line li = l.get(i);
			
			double x;
			double y;
			
		    if (li.getType() == 1 && ( d / 10.0 ) % 2.0 != 0.0) {
		    	x = li.getX();
		    	y = this.getY();
		    } else {
		    	x = this.getX();
		    	y = li.getY();
		    }
			
	    	if (cartesian.cartesianDistance(this.getX(), x, this.getY(), y)) {
	    		return true;
	    	}
		    
		}
		
		return false;
		
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
		
		int dx = (int) (Math.cos(Math.toRadians(this.angle)) * this.step);
		int dy = (int) (Math.sin(Math.toRadians(this.angle)) * this.step);
		
		if (dx != 0 && dy == 0) {
			
			System.out.println(dx);
			double x = this.getLocation().getX();
			double y = this.getLocation().getY();
			this.setLocation(x + dx, y);
			
		} else if (dy != 0 && dx == 0) {
			
			System.out.println(dx);
			double x = this.getLocation().getX();
			double y = this.getLocation().getY();
			this.setLocation(x, y + dy);
			
		}
		
	}
	
	private static final int S = 2;
	
}
