/**
 * 
 */
package object_oriented_graphics;
import acm.graphics.*;
/**
 * 
 */
public class Face extends GCompound {
	private static final long serialVersionUID = -1073946827061972497L;
	/**
	 * 
	 */
	private GOval PUPIL_L;
	private double SIZE, PUPIL_L_X, PUPIL_L_Y;
	private double SCALE, SCALE_EYE_X, SCALE_EYE_Y, SCALE_PUPIL, EYE_L_X, EYE_L_Y, RADIO;
	private double SCALE_X_N 	= 4;
	private double SCALE_X_D 	= 6;
	private double EYE			= 8;
	
	public Face(double size) {
		
		headShape(size);
		eyesPosition();
		add(new GOval(SCALE, SIZE));
		add(new GOval(SCALE_EYE_X, SCALE_EYE_Y), EYE_L_X, EYE_L_Y);
		
		pupilsPosition();
		PUPIL_L 	= new GOval(SCALE_PUPIL, SCALE_PUPIL);
		PUPIL_L.setFilled(true);
		add(PUPIL_L, PUPIL_L_X, PUPIL_L_Y);
		
		RADIO = SCALE_EYE_X / 2 - SCALE_PUPIL / 2;
		
	}
	
	private void headShape(double size) {
		SIZE 		= size;
		SCALE 		= SCALE_X_N * SIZE / SCALE_X_D;
		SCALE_EYE_X = SCALE_X_N * SIZE / (SCALE_X_D * EYE);
		SCALE_EYE_Y = SIZE / EYE;
	}
	
	public void eyesPosition() {
		EYE_L_X = 1 * SCALE / 6;
		EYE_L_Y = 2 * SCALE / 5;
	}
	
	public void pupilsPosition() {
		SCALE_PUPIL	= SIZE / 30;
		PUPIL_L_X 	= EYE_L_X + SCALE_EYE_X / 2 - SCALE_PUPIL / 2;
		PUPIL_L_Y 	= EYE_L_Y + SCALE_EYE_Y / 2 - SCALE_PUPIL / 2;
	}
	
	public void defaultPupilsPosition() {
		getElement(2).setLocation(PUPIL_L_X, PUPIL_L_Y);;
	}
	
	public void see(double xm, double ym, double ex, double ey) {
		double Delta_x 	= xm - ex;
		double Delta_y 	= ym - ey;
		double theta	= Math.atan(Delta_y / Delta_x);
		if (Delta_x > 0) {
			double delta_x	= RADIO * Math.cos(theta);
			double delta_y	= RADIO * Math.sin(theta);
			PUPIL_L.setLocation(
					PUPIL_L_X + delta_x,
					PUPIL_L_Y + delta_y);	
		} else {
			double delta_x	= RADIO * Math.cos(theta);
			double delta_y	= RADIO * Math.sin(theta);
			PUPIL_L.setLocation(
					PUPIL_L_X - delta_x,
					PUPIL_L_Y - delta_y);	
		}
	}
	
}
