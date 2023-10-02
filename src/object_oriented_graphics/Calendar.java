/**
 * 
 */
package object_oriented_graphics;

/**
 * 
 */

import acm.graphics.*;
import acm.program.*;

public class Calendar extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	/* The number of days in the month */
	private static final int DAYS_IN_MONTH = 28;
	private static final int DAYS_IN_WEEK = 7;
	/* The day of the week on which the month starts */
	/* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) */
	private static int DAY_MONTH_STARTS = 3;
	private double START_Y;
	private double SIZE_X;
	private static final double SCALE_Y = (DAYS_IN_MONTH + DAY_MONTH_STARTS - 1.0) / ((double) DAYS_IN_WEEK);
	private double SIZE_Y;
	private static final double SCALE_DAYS = 1.0 / 4.0;

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {

		new Calendar().start();

	}
	
	public void run() {
		
		if ((DAYS_IN_MONTH + DAY_MONTH_STARTS + 1) % DAYS_IN_WEEK == 0.0) {
			SIZE_Y = getHeight() / (SCALE_Y + SCALE_DAYS);
		} else {
			SIZE_Y = getHeight() / ((double) ((int) SCALE_Y + 1.0) + SCALE_DAYS);
		}
		
		START_Y = SIZE_Y * SCALE_DAYS;
		SIZE_X = getWidth() / ((double) DAYS_IN_WEEK);
		
		GLabel sun = new GLabel("SUN", SIZE_X / 4.0, 0.0);
		sun.move(0.0, sun.getAscent());
		add(sun);
		GLabel mon = new GLabel("MON", 5.0 * SIZE_X / 4.0, 0.0);
		mon.move(0.0, mon.getAscent());
		add(mon);
		GLabel tue = new GLabel("TUE", 9.0 * SIZE_X / 4.0, 0.0);
		tue.move(0.0, tue.getAscent());
		add(tue);
		GLabel wed = new GLabel("WED", 13.0 * SIZE_X / 4.0, 0.0);
		wed.move(0.0, wed.getAscent());
		add(wed);
		GLabel thu = new GLabel("THU", 17.0 * SIZE_X / 4.0, 0.0);
		thu.move(0.0, thu.getAscent());
		add(thu);
		GLabel fri = new GLabel("FRI", 21.0 * SIZE_X / 4.0, 0.0);
		fri.move(0.0, fri.getAscent());
		add(fri);
		GLabel sat = new GLabel("SAT", 25.0 * SIZE_X / 4.0, 0.0);
		sat.move(0.0, sat.getAscent());
		add(sat);
		add(CalendarConstructor(), 0.0, START_Y);
		
	}
	
	private GCompound CalendarConstructor() {
		
		GCompound gc = new GCompound();
		
		for (int i = DAYS_IN_WEEK; i < (DAYS_IN_MONTH + DAY_MONTH_STARTS + DAYS_IN_WEEK) + (DAYS_IN_WEEK - (DAYS_IN_MONTH + DAY_MONTH_STARTS) % DAYS_IN_WEEK); i++) {
			
			if (i > DAY_MONTH_STARTS + DAYS_IN_WEEK - 2 && i < (DAYS_IN_MONTH + DAY_MONTH_STARTS + DAYS_IN_WEEK - 1)) {
				gc.add(new GLabel(Integer.toString(i - DAY_MONTH_STARTS - DAYS_IN_WEEK + 2),
						(i % DAYS_IN_WEEK) * SIZE_X + SIZE_X / 2.0,
						((i - DAYS_IN_WEEK) / DAYS_IN_WEEK) * SIZE_Y + SIZE_Y / 2.0));
			}
			
			gc.add(new GRect(i % DAYS_IN_WEEK * SIZE_X, (i / DAYS_IN_WEEK - 1.0) * SIZE_Y, SIZE_X, SIZE_Y));
			
		}
		
		return gc;
	
	}

}
