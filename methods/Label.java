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
		this.angle = 90;
		this.step = S * 2;
		this.dx = (int) Math.cos(Math.toRadians(this.angle)) * this.step;;
		this.dy = (int) Math.sin(Math.toRadians(this.angle)) * -this.step;
	}
	
	public static Label theseus() {
		
		Label theseus = new Label("\u03B8", S * 15, S * 9);
		theseus.setFont("London-34");
		
		return theseus;
		
	}
	
	public boolean isAWallAtRight(ArrayList<Line> a_lines) {
		
		double d = this.getDirection();
		
		for (int i = 0; i < a_lines.size(); i++) {
			
			Line li = a_lines.get(i);
			
			// Para detectar verticalmente
			if ((d % 20.0 != 0.0) && (li.getType() == 1)) {
				
				double lix = li.getX();
				double tx = this.getLocation().getX();
				double tdy = this.getDy();
				
				// De abajo hacia arriba
				if (tdy < 0 && (lix > tx) && ((lix - tx) <= (S * 1))) {
					
					if (li.getEndPoint().getY() > this.getY() && li.getStartPoint().getY() < this.getY()) return true;
			
				}
				
			// Para detectar horizontalmente
			} else if ((d % 20.0 == 0.0) && (li.getType() == 0)) {
				
				double tdx = this.getDx();
				double ty = this.getLocation().getY();
				double liy = li.getY();
				
				// De izquierda a derecha
				if (tdx > 0 && (ty < liy) && ((liy - ty) <= (S * 1))) {
					
//					if (li.getEndPoint().getX() < this.getX() && li.getStartPoint().getX() > this.getX()) return true;
					if (li.getEndPoint().getX() > this.getX() && li.getStartPoint().getX() < this.getX()) return true;
				
				// De derecha a izquierda
				} else if (tdx < 0 && (ty > liy) && (ty - liy) <= (S * 1)) {
					
					if (li.getEndPoint().getX() > this.getX() && li.getStartPoint().getX() < this.getX()) return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	public boolean isFacingWall(ArrayList<Line> a_lines) {
		
		double d = this.getDirection();
		
		for (int i = 0; i < a_lines.size(); i++) {
			
			Line li = a_lines.get(i);
			
			// Para detectar muros verticalmente
		    if ((li.getType() == 0) && (d % 20.0 != 0.0)) {
		    	
		    	double ly = li.getY();
		    	double ty = this.getLocation().getY();
		    	double tdy = this.getDy();
		    	
		    	// De abajo hacia arriba
		    	if (tdy < 0 && (ty - ly <= S * 1) && (ty > ly)) {
		    		
			    	double lsx = li.getStartPoint().getX();
			    	double lex = li.getEndPoint().getX();
			    	double tx = this.getLocation().getX();
		    		
			    	if (lsx < tx && lex > tx) return true;
			    
		    	// De arriba hacia abajo
		    	} else if (tdy > 0 && (ly - ty <= S * 1) && (ly > ty)) {
		    		
			    	double lsx = li.getStartPoint().getX();
			    	double lex = li.getEndPoint().getX();
			    	double tx = this.getLocation().getX();
		    	
		    		if (lex < tx && lsx > tx) return true;
		    		
		    	}
	
		    }
		    
		    // Para detectar muros horizontalmente
		    if ((li.getType() == 1) && (d % 20.0 == 0.0)) {
		    	
		    	double lx = li.getX();
		    	double tx = this.getLocation().getX();
		    	double tdx = this.getDx();
		    	
		    	// Para horizontalidad de izquierda a derecha
		    	if (tdx > 0 && (lx - tx <= S * 1) && (lx > tx)) {
		    		
		    		if (li.getEndPoint().getY() > this.getY() && li.getStartPoint().getY() < this.getY()) return true;
//		    		if (li.getEndPoint().getY() < this.getY() && li.getStartPoint().getY() > this.getY()) return true;
			    	
		    	// Para horizontalidad de derecha a izquierda
		    	} else  if (tdx < 0 && (tx - lx <= S) && (tx > lx)) {
		    		
		    		if (li.getEndPoint().getY() > this.getY() && li.getStartPoint().getY() < this.getY()) return true;
		    		
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
		this.dy = (int) Math.sin(Math.toRadians(this.angle)) * -this.step;
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
		
		return this.getY() > 19 * S;

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
	
	private static final int S = 20;
	
}
