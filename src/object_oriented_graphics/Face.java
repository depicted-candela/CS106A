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
	protected GOval PUPIL_L, PUPIL_R;
	protected double SIZE, PUPIL_L_X, PUPIL_L_Y, PUPIL_R_X, PUPIL_R_Y;
	protected double SCALE, SCALE_EYE_X, SCALE_EYE_Y, SCALE_PUPIL, EYE_L_X, EYE_L_Y, EYE_R_X, EYE_R_Y, RADIO, NOSE_X, NOSE_Y, MOUTH_X, MOUTH_Y;
	private double SCALE_X_N 	= 4;
	private double SCALE_X_D 	= 6;
	private double EYE			= 8;
	
	public Face(double size) {
		
		headShape(size);
		eyesPositioned();
		pupilsPositioned();
		nosePositioned();
		mouthPositioned();
		
	}
	
	private void mouthPositioned() {
		
		MOUTH_X	= 1 * SCALE / 5;
		MOUTH_Y	= 4 * SIZE / 6;
		double width	= 3 * SCALE / 5;
		double height	= 1 * SIZE / 12;
		GRect rectangle = new GRect(MOUTH_X, MOUTH_Y, width, height);
		add(rectangle);
		
	}
	
	private void nosePositioned() {
		
		NOSE_X	= 6 * SCALE / 12;
		NOSE_Y	= 3 * SIZE / 6;
		
        double baseWidth = SCALE / 6; // Width of the base of the triangle
        double triangleHeight = SIZE / 10; // Height of the triangle
        double halfBase = baseWidth / 2;

        // Calculate the coordinates of the three vertices of the triangle
        double x1 = NOSE_X - halfBase;
        double y1 = NOSE_Y + (triangleHeight / 2);
        double x2 = NOSE_X + halfBase;
        double y2 = y1;
        double x3 = NOSE_X;
        double y3 = NOSE_Y - (triangleHeight / 2);

        // Create a polygon to represent the triangle
        GPolygon triangle = new GPolygon();
        triangle.addVertex(x1, y1);
        triangle.addVertex(x2, y2);
        triangle.addVertex(x3, y3);

        // Add the triangle to the canvas
        add(triangle);

	}
	
	private void headShape(double size) {
		SIZE 		= size;
		SCALE 		= SCALE_X_N * SIZE / SCALE_X_D;
		SCALE_EYE_X = SCALE_X_N * SIZE / (SCALE_X_D * EYE);
		SCALE_EYE_Y = SIZE / EYE;
	}
	
	public void eyesPositioned() {
		EYE_L_X = 1 * SCALE / 6;
		EYE_L_Y = 2 * SCALE / 5;
		EYE_R_X = 4 * SCALE / 6;
		EYE_R_Y = 2 * SCALE / 5;
		add(new GOval(SCALE, SIZE));
		add(new GOval(SCALE_EYE_X, SCALE_EYE_Y), EYE_L_X, EYE_L_Y);
		add(new GOval(SCALE_EYE_X, SCALE_EYE_Y), EYE_R_X, EYE_R_Y);
	}
	
	public void pupilsPositioned() {
		SCALE_PUPIL	= SIZE / 30;
		PUPIL_L_X 	= EYE_L_X + SCALE_EYE_X / 2 - SCALE_PUPIL / 2;
		PUPIL_L_Y 	= EYE_L_Y + SCALE_EYE_Y / 2 - SCALE_PUPIL / 2;
		SCALE_PUPIL	= SIZE / 30;
		PUPIL_R_X 	= EYE_R_X + SCALE_EYE_X / 2 - SCALE_PUPIL / 2;
		PUPIL_R_Y 	= EYE_R_Y + SCALE_EYE_Y / 2 - SCALE_PUPIL / 2;
		PUPIL_L 	= new GOval(SCALE_PUPIL, SCALE_PUPIL);
		PUPIL_L.setFilled(true);
		add(PUPIL_L, PUPIL_L_X, PUPIL_L_Y);
		PUPIL_R 	= new GOval(SCALE_PUPIL, SCALE_PUPIL);
		PUPIL_R.setFilled(true);
		add(PUPIL_R, PUPIL_R_X, PUPIL_R_Y);
		RADIO = SCALE_EYE_X / 2 - SCALE_PUPIL / 2;
	}
	
}
