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

import java.awt.Color;

public class Halloween extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// TODO Auto-generated method stub
		GCompound result = pumpkinHead();
		result.getElement(result.getElementCount() - 1).sendToBack();
		add(result);
		
	}
	
	private GCompound pumpkinHead() {
		
		GCompound comp = new GCompound();
		GOval oval = new GOval(0, 0, OVAL, OVAL);
		oval.setColor(Color.ORANGE);
		oval.setFillColor(Color.ORANGE);
		oval.setFilled(true);
		comp.add(oval, ORIGIN_X, ORIGIN_Y);
		
		GPoint[] eye1 = new GPoint[3];
		eye1[0] = new GPoint(0, 0);
		eye1[1] = new GPoint(TRIANGLE_SIZE / 2, TRIANGLE_SIZE);
		eye1[2] = new GPoint(TRIANGLE_SIZE, 0);
		GPolygon pol_eye1 = new GPolygon(eye1);
		pol_eye1.setColor(Color.orange);
		pol_eye1.setFillColor(Color.black);
		pol_eye1.setFilled(true);
		comp.add(pol_eye1, OVAL * 1 / 3, OVAL * 1 / 3);
		
		GPoint[] eye2 = new GPoint[3];
		eye2[0] = new GPoint(0, 0);
		eye2[1] = new GPoint(TRIANGLE_SIZE / 2, TRIANGLE_SIZE);
		eye2[2] = new GPoint(TRIANGLE_SIZE, 0);
		GPolygon pol_eye2 = new GPolygon(eye2);
		pol_eye2.setColor(Color.orange);
		pol_eye2.setFillColor(Color.black);
		pol_eye2.setFilled(true);
		comp.add(pol_eye2, OVAL * 2 / 3, OVAL * 1 / 3);
		
		GPoint[] nose = new GPoint[3];
		nose[0] = new GPoint(0, 0);
		nose[1] = new GPoint(TRIANGLE_SIZE / 2, -TRIANGLE_SIZE);
		nose[2] = new GPoint(TRIANGLE_SIZE, 0);
		GPolygon pol_nose = new GPolygon(nose);
		pol_nose.setColor(Color.orange);
		pol_nose.setFillColor(Color.black);
		pol_nose.setFilled(true);
		comp.add(pol_nose, OVAL / 2, OVAL / 2 + TRIANGLE_SIZE);
		
		GPoint[] mouth = new GPoint[18];
		mouth[0] = new GPoint(0, 0);
		mouth[1] = new GPoint(MOUTH_SPACE, -MOUTH_SPACE);
		mouth[2] = new GPoint(MOUTH_SPACE * 2, 0);
		mouth[3] = new GPoint(MOUTH_SPACE * 3, -MOUTH_SPACE);
		mouth[4] = new GPoint(MOUTH_SPACE * 4, 0);
		mouth[5] = new GPoint(MOUTH_SPACE * 5, -MOUTH_SPACE);
		mouth[6] = new GPoint(MOUTH_SPACE * 6, 0);
		mouth[7] = new GPoint(MOUTH_SPACE * 7, -MOUTH_SPACE);
		mouth[8] = new GPoint(MOUTH_SPACE * 8, 0);
		mouth[9] = new GPoint(MOUTH_SPACE * 9, -MOUTH_SPACE);
		mouth[10] = new GPoint(MOUTH_SPACE * 10, 0);
		mouth[11] = new GPoint(MOUTH_SPACE * 8, MOUTH_SPACE * 2);
		mouth[12] = new GPoint(MOUTH_SPACE * 7, MOUTH_SPACE * 1);
		mouth[13] = new GPoint(MOUTH_SPACE * 6, MOUTH_SPACE * 2);
		mouth[14] = new GPoint(MOUTH_SPACE * 5, MOUTH_SPACE * 1);
		mouth[15] = new GPoint(MOUTH_SPACE * 4, MOUTH_SPACE * 2);
		mouth[16] = new GPoint(MOUTH_SPACE * 3, MOUTH_SPACE * 1);
		mouth[17] = new GPoint(MOUTH_SPACE * 2, MOUTH_SPACE * 2);
		GPolygon pol_mouth = new GPolygon(mouth);
		pol_mouth.setColor(Color.orange);
		pol_mouth.setFillColor(Color.black);
		pol_mouth.setFilled(true);
		comp.add(pol_mouth,  OVAL * 1 / 3, OVAL * 5 / 7 + ORIGIN_Y);
		
		GRect hat = new GRect(0, 0, HAT, HAT * 2);
		hat.setFilled(true);
		comp.add(hat, ORIGIN_X + OVAL / 2 - HAT / 2, HAT / 2);
		
		return comp;
		
	}
	
	private static double ORIGIN_X = 20;
	private static double ORIGIN_Y = 20;
	private static double TRIANGLE_SIZE = 30;
	private static double MOUTH_SPACE = 9.6;
	private static double OVAL = 200;
	private static double HAT = 10;

}
