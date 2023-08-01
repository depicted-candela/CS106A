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
	
	public boolean isAWallAtRight(Line li) {
		
		CartesianDistance cartesian = new CartesianDistance();
		
		double d = this.getDirection();
		double xs = li.getStartPoint().getX();
		double ys = li.getStartPoint().getY();
		double xe = li.getEndPoint().getX();
		double ye = li.getEndPoint().getY();
		
		if ((( d / 10.0 ) % 2.0 != 0.0) && (li.getType() == 1)) {
			
			if (this.getDy() > 0 && xs > this.getX()) {
				if (cartesian.cartesianDistancePointLine(this.getX(), this.getY(), xs, xe, ys, ye)) return true;
			} else if (this.getDy() < 0 && xs < this.getX()) {
				if (cartesian.cartesianDistancePointLine(this.getX(), this.getY(), xs, xe, ys, ye)) return true;
			}
			
		} else if ((( d / 10.0 ) % 2.0 == 0.0) && (li.getType() == 0)) {
			
			if (this.getDx() > 0 && ys > this.getY()) {
				if (cartesian.cartesianDistancePointLine(this.getX(), this.getY(), xs, xe, ys, ye)) return true;
			} else if (this.getDx() < 0 && ys < this.getY()) {
				if (cartesian.cartesianDistancePointLine(this.getX(), this.getY(), xs, xe, ys, ye)) return true;
			}
		}
		
		return false;
		
	}
	
	
	public boolean isFacingWall(Line li) {
		
		CartesianDistance cartesian = new CartesianDistance();
		
		double d = this.getDirection();	
		double x;
		double y;
		
	    if ((li.getType() != 1) && (( d / 10.0 ) % 2.0 != 0.0)) {
	    	
	    	x = this.getX();
	    	y = li.getY();
	    	
	    	if (this.getDy() < 0 && (Math.abs(y - this.getY()) < (S * 20 / 2))) {
	    		
	    		System.out.println(y - this.getY());
	    		
		    	if (cartesian.cartesianDistance(this.getX(), x, this.getY(), y)) return true;
	    	} else if (this.getDy() > 0 && (Math.abs(this.getY() - y) < (S * 20 / 2))) {
	    		
	    		System.out.println(this.getY() - y);
	    		
	    		if (cartesian.cartesianDistance(this.getX(), x, this.getY(), y)) return true;
	    	}

	    } else {
	    	
	    	x = li.getX();
	    	y = this.getY();
	    	
	    	if (this.getDx() < 0 && (Math.abs(this.getX() - x) < (S * 20 / 2))) {
	    		System.out.println(this.getX() - x);
		    	if (cartesian.cartesianDistance(this.getX(), x, this.getY(), y)) return true;
	    	} else if (this.getDx() > 0 && (Math.abs(x - this.getX()) < (S * 20 / 2))) {
	    		System.out.println(x - this.getX());
	    		if (cartesian.cartesianDistance(this.getX(), x, this.getY(), y)) return true;
	    	}

	    }
		
		return false;
		
	}
	
	public double getDx() {
		return Math.cos(Math.toRadians(this.angle));
	}
	
	public double getDy() {
		return Math.sin(Math.toRadians(this.angle));
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
			
			double x = this.getLocation().getX();
			double y = this.getLocation().getY();
			this.setLocation(x + dx, y);
			
		} else if (dy != 0 && dx == 0) {
			
			double x = this.getLocation().getX();
			double y = this.getLocation().getY();
			this.setLocation(x, y + dy);
			
		}
		
	}
	
	private static final int S = 2;
	
}
