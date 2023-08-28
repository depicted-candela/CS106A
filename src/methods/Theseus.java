/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;

import java.awt.Color;
import java.util.ArrayList;

public class Theseus extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		ArrayList<Line> a_lines = Line.mazeDrawer();
		
		for (int i = 0; i < a_lines.size(); i++) {
			add(a_lines.get(i));
		}

		Label th = Label.theseus();
		add(th);
		
		int c = 0;
		while (true) {
			
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        if (th.isOutside()) {
	        	Label theseus = new Label("WIN", S * 15, S * 9);
	        	theseus.setFont("Helvetica-24");
	        	theseus.setColor(Color.green);
	        	add(theseus);
	        	break;
	        }
	        
	        if (th.isFacingWall(a_lines) && th.isAWallAtRight(a_lines)) {
	        	
	        	th.turnLeft();
				th.setDx();
				th.setDy();
	        	
	        } else if (!th.isFacingWall(a_lines) && th.isAWallAtRight(a_lines)) {
				
				if (c == 17) {
					System.out.println('y');
					System.out.println(c);
					System.out.println(th.getDirection());
					System.out.println(th.getDx());
					System.out.println(th.getDy());
					System.out.println(th.isFacingWall(a_lines));
					System.out.println(th.isAWallAtRight(a_lines));
				}
	        	
				th.setDx();
				th.setDy();
				th.moveForward();
				
			} else if (th.isFacingWall(a_lines) && !th.isAWallAtRight(a_lines)) {
				
				th.turnRight();
				th.setDx();
				th.setDy();
				th.moveForward();
				
			} else if (!th.isFacingWall(a_lines) && !th.isAWallAtRight(a_lines)) {
				
				th.turnRight();
				th.setDx();
				th.setDy();
				th.moveForward();
				
			} else {
				
				break;
			}
			
	        c++;
	        
		}
		
	}

	private static final int S = 20;

}
