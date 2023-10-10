package object_oriented_graphics;

import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

public class DrawTrain extends GraphicsProgram {
	
	/* Dimensions of the frame of a train car */
	private static final double CAR_WIDTH = 75;
	private static final double CAR_HEIGHT = 36;
	/* Distance from the bottom of a train car to the track below it */
	private static final double CAR_BASELINE = 10;
	/* Width of the connector, which overlaps between successive cars */
	private static final double CONNECTOR = 6;
	/* Radius of the wheels on each car */
	private static final double WHEEL_RADIUS = 8;
	/* Distance from the edge of the frame to the center of the wheel */
	private static final double WHEEL_INSET = 16;
	/* Dimensions of the cab on the engine */
	private static final double CAB_WIDTH = 35;
	private static final double CAB_HEIGHT = 8;
	/* Dimensions of the smokestack and its distance from the front */
	private static final double SMOKESTACK_WIDTH = 8;
	private static final double SMOKESTACK_HEIGHT = 8;
	private static final double SMOKESTACK_INSET = 8;
	/* Dimensions of the door panels on the boxcar */
	private static final double DOOR_WIDTH = 18;
	private static final double DOOR_HEIGHT = 32;
	/* Dimensions of the cupola on the caboose */
	private static final double CUPOLA_WIDTH = 35;
	private static final double CUPOLA_HEIGHT = 8;
	
	private void drawCarFrame(double x, double y, Color color) {
		double x0 = x + CONNECTOR;
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		add(new GLine(x, y0, x + CAR_WIDTH + 2 * CONNECTOR, y0));
		drawWheel(x0 + WHEEL_INSET, y - WHEEL_RADIUS);
		drawWheel(x0 + CAR_WIDTH - WHEEL_INSET, y - WHEEL_RADIUS);
		GRect r = new GRect(x0, top, CAR_WIDTH, CAR_HEIGHT);
		r.setFilled(true);
		r.setFillColor(color);
		add(r);
	}
	
	private void drawWheel(double x, double y) {
		double r = WHEEL_RADIUS;
		GOval wheel = new GOval(x - r, y - r, 2 * r, 2 * r);
		wheel.setFilled(true);
		wheel.setFillColor(Color.GRAY);
		add(wheel);
	}
	
	private void drawCaboose(double x, double y, Color color) {
		double x0 = x + CONNECTOR;
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		add(new GLine(x, y0, x + CAR_WIDTH + 2 * CONNECTOR, y0));
		drawWheel(x0 + WHEEL_INSET, y - WHEEL_RADIUS);
		drawWheel(x0 + CAR_WIDTH - WHEEL_INSET, y - WHEEL_RADIUS);
		GRect r = new GRect(x0, top, CAR_WIDTH, CAR_HEIGHT);
		GRect r2 = new GRect(x0 + 1.0 * CAR_WIDTH / 4.0, top - CAR_HEIGHT / 5.0,
				CAR_WIDTH / 2.0, CAR_HEIGHT / 5.0);
		r.setFilled(true);
		r.setFillColor(color);
		r2.setFilled(true);
		r2.setFillColor(color);
		add(r);
		add(r2);
	}
	
	private void drawBoxcar(double x, double y, Color color) {
		double x0 = x + CONNECTOR;
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		add(new GLine(x, y0, x + CAR_WIDTH + 2 * CONNECTOR, y0));
		drawWheel(x0 + WHEEL_INSET, y - WHEEL_RADIUS);
		drawWheel(x0 + CAR_WIDTH - WHEEL_INSET, y - WHEEL_RADIUS);
		GRect r = new GRect(x0, top, CAR_WIDTH, CAR_HEIGHT);
		GRect r2 = new GRect(x0 + CAR_WIDTH / 4.0, top + 2.0 * CAR_HEIGHT / 7.0, CAR_WIDTH / 4.0, 5.0 * CAR_HEIGHT / 7.0);
		GRect r3 = new GRect(x0 + CAR_WIDTH / 2.0, top + 2.0 * CAR_HEIGHT / 7.0, CAR_WIDTH / 4.0, 5.0 * CAR_HEIGHT / 7.0);
		r.setFilled(true);
		r.setFillColor(color);
		add(r);
		add(r2);
		add(r3);
	}
	
	private void drawEngine(double x, double y) {
		double x0 = x + CONNECTOR;
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		add(new GLine(x, y0, x + CAR_WIDTH + 2 * CONNECTOR, y0));
		drawWheel(x0 + WHEEL_INSET, y - WHEEL_RADIUS);
		drawWheel(x0 + CAR_WIDTH - WHEEL_INSET, y - WHEEL_RADIUS);
		GRect r = new GRect(x0, top, CAR_WIDTH, CAR_HEIGHT);
		GRect r2 = new GRect(x0 + CAR_WIDTH / 10.0, top - CAR_HEIGHT / 5.0,
				CAR_WIDTH / 10.0, CAR_HEIGHT / 5.0);
		GRect r3 = new GRect(x0 + CAR_WIDTH / 2.0, top - CAR_HEIGHT / 5.0,
				CAR_WIDTH / 2.0, CAR_HEIGHT / 5.0);
		r.setFilled(true);
		r2.setFilled(true);
		r3.setFilled(true);
		add(r);
		add(r2);
		add(r3);
	}
	
	public void run() {
		double trainWidth = 3 * CAR_WIDTH + 4 * CONNECTOR;
		double x = (getWidth() - trainWidth) / 2;
		double y = getHeight();
		double dx = CAR_WIDTH + CONNECTOR;
		
		drawEngine(x, y);
		drawBoxcar(x + dx, y, Color.GREEN);
		drawCaboose(x + 2 * dx, y, Color.RED);
		
	}
	public static void main (String[] args) {
		
		new DrawTrain().start();
		
	}
	
}
