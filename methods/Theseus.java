/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;
import acm.graphics.*;
import methods.Line;
import methods.Label;
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
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        if (th.isOutside()) break;
	        
	        if (th.isFacingWall(a_lines) && th.isAWallAtRight(a_lines)) {
	        	
	        	System.out.println(c);
//	        	System.out.println(th.getDirection());
//	        	System.out.println(th.getDx());
//	        	System.out.println(th.getDy());
	        	th.turnLeft();
//				th.setDx();
//				th.setDy();
//				System.out.println(th.getDirection());
//	        	System.out.println(th.getDx());
//	        	System.out.println(th.getDy());
	        	
	        } else if (!th.isFacingWall(a_lines) && th.isAWallAtRight(a_lines)) {
				
//	        	System.out.println(c);
//	        	System.out.println('b');
				th.setDx();
				th.setDy();
				th.moveForward();
				
			} else if (th.isFacingWall(a_lines) && !th.isAWallAtRight(a_lines)) {
				
//	        	System.out.println(c);
//	        	System.out.println('c');
				th.turnRight();
				th.setDx();
				th.setDy();
				th.moveForward();
				
			} else if (!th.isFacingWall(a_lines) && !th.isAWallAtRight(a_lines)) {
				
//	        	System.out.println(c);
//	        	System.out.println('d');
				th.turnRight();
				th.setDx();
				th.setDy();
				th.moveForward();
				
			} else {
				
				System.out.println('F');
				
				System.out.println(th.isFacingWall(a_lines));
				System.out.println(th.isAWallAtRight(a_lines));
				System.out.println(th.getDirection());
				System.out.println(th.getDy());
				System.out.println(th.getDx());
				
				break;
			}
			
	        c++;
	        
		}
		
	}

}
