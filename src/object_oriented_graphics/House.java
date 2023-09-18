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

public class House extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		// TODO Auto-generated method stub
		add(wholeHouse(), XY, XY);

	}
	
	private GCompound wholeHouse() {
		
		GCompound house = new GCompound();
		house.add(houseWallsRoof());
		house.add(window1(), HOUSE_SCALE_X * 1 / 6, HOUSE_SCALE_Y / 9);
		house.add(window1(), HOUSE_SCALE_X - HOUSE_SCALE_X * 1 / 6 - PORTION_W_1_H * 2, HOUSE_SCALE_Y / 9);
		house.add(window2(), HOUSE_SCALE_X * 1 / 6 + PORTION_W_1_H / 2 - PORTION_W_2_H, HOUSE_SCALE_Y * 5 / 9);
		house.add(window2(), HOUSE_SCALE_X - PORTION_W_2_H * 2 - PORTION_W_1_H - HOUSE_SCALE_X * 1 / 6 - PORTION_W_1_H / 2 + PORTION_W_2_H,  HOUSE_SCALE_Y * 5 / 9);
		house.add(door(), HOUSE_SCALE_X * 1 / 2 - H_DOOR / 2, HOUSE_SCALE_Y - V_DOOR);
		return house;
		
	}

	private GCompound houseWallsRoof() {
		
		GCompound wf = new GCompound();
		wf.add(new GRect(HOUSE_SCALE_X, HOUSE_SCALE_Y));
		GPoint[] roof_p = new GPoint[3];
		roof_p[0] = new GPoint(0, 0);
		roof_p[1] = new GPoint(HOUSE_SCALE_X / 2, -ROOF);
		roof_p[2] = new GPoint(HOUSE_SCALE_X, 0);
		GPolygon roof = new GPolygon(roof_p);
		wf.add(roof);
		
		return wf;
		
	}
	
	private GCompound window1() {
		
		GCompound w1 = new GCompound();
		GRect pw1_1 = new GRect(PORTION_W_1_H, PORTION_W_V);
		GRect pw1_2 = new GRect(PORTION_W_1_H, PORTION_W_V);
		GRect pw1_3 = new GRect(PORTION_W_1_H, PORTION_W_V);
		GRect pw1_4 = new GRect(PORTION_W_1_H, PORTION_W_V);
		w1.add(pw1_1, 0, 0);
		w1.add(pw1_2, PORTION_W_1_H, 0);
		w1.add(pw1_3, 0, PORTION_W_V);
		w1.add(pw1_4, PORTION_W_1_H, PORTION_W_V);
		
		return w1;
		
	}
	
	private GCompound window2() {
		
		GCompound w1 = new GCompound();
		GRect pw1_1 = new GRect(PORTION_W_2_H, PORTION_W_V);
		GRect pw1_2 = new GRect(PORTION_W_2_H, PORTION_W_V);
		GRect pw1_3 = new GRect(PORTION_W_1_H, PORTION_W_V);
		GRect pw1_4 = new GRect(PORTION_W_1_H, PORTION_W_V);
		GRect pw1_5 = new GRect(PORTION_W_2_H, PORTION_W_V);
		GRect pw1_6 = new GRect(PORTION_W_2_H, PORTION_W_V);
		w1.add(pw1_1, 0, 0);
		w1.add(pw1_2, 0, PORTION_W_V);
		w1.add(pw1_3, PORTION_W_2_H, 0);
		w1.add(pw1_4, PORTION_W_2_H, PORTION_W_V);
		w1.add(pw1_5, PORTION_W_2_H + PORTION_W_1_H, 0);
		w1.add(pw1_6, PORTION_W_2_H + PORTION_W_1_H, PORTION_W_V);
		
		return w1;
		
	}
	
	private GCompound door() {
		
		GCompound door = new GCompound();
		GRect wood = new GRect(H_DOOR, V_DOOR);
		GOval crank = new GOval(CRANK, CRANK);
		door.add(wood, 0, 0);
		door.add(crank, H_DOOR - CRANK * 2, V_DOOR / 2);
		
		return door;
		
	}
	
	private static double HOUSE_SCALE = 400;
	private static double HOUSE_SCALE_X = HOUSE_SCALE * 3 / 2;
	private static double HOUSE_SCALE_Y = HOUSE_SCALE;
	private static double XY = HOUSE_SCALE / 2.0;
	private static double PORTION_W_1_H = HOUSE_SCALE / 10.0;
	private static double PORTION_W_V = HOUSE_SCALE / 8.0;
	private static double PORTION_W_2_H = HOUSE_SCALE / 9.0;
	private static double H_DOOR = HOUSE_SCALE / 6.0;
	private static double V_DOOR = HOUSE_SCALE / 3.0;
	private static double CRANK = HOUSE_SCALE / 50.0;
	private static double ROOF = HOUSE_SCALE / 3.0; 
	
}
