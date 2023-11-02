/**
 * 
 */
package object_oriented_graphics;

/**
 * 
 */

import acm.program.*;
import acm.graphics.*;

public class LensImaging extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	private GCompound candleInverter(double height) {
		
		GCompound gc = new GCompound();
		
		GImage im	= new GImage("Candle.png");
												// top base-line
		double h = getHeight() / 2.0 - im.getHeight() / 2.0;
		
		double cd = im.getHeight() / 6.0;		// spaces between
												// lines
		
		double w = getWidth() / 4.0;			// horizontal space between
												// elements
		gc.add(im, 3.0 * getWidth() / 4.0, h);
		
		GLine li1	= new GLine(0.0, 0.0, w, 0.0);
		gc.add(li1, getWidth() / 2.0, h + cd * 0);
		
		GLine li2	= new GLine(0.0, 0.0, w, 0.0);
		gc.add(li2, getWidth() / 2.0, h + cd * 1);
		
		GLine li3	= new GLine(0.0, 0.0, w, 0.0);
		gc.add(li3, getWidth() / 2.0, h + cd * 2);
		
		GLine li4	= new GLine(0.0, 0.0, w, 0.0);
		gc.add(li4, getWidth() / 2.0, h + cd * 3);
		
		GLine li5	= new GLine(0.0, 0.0, w, 0.0);
		gc.add(li5, getWidth() / 2.0, h + cd * 4);
		
		GLine li6	= new GLine(0.0, 0.0, w, 0.0);
		gc.add(li6, getWidth() / 2.0, h + cd * 5);
		
		GLine li7	= new GLine(0.0, 0.0, w, 0.0);
		gc.add(li7, getWidth() / 2.0, h + cd * 6);
		
		GLine vli	= new GLine(w, 0.0, 0.0, 0.0);
		gc.add(vli, getWidth() / 2.0, h + cd * 3);
		
		double x = w / 3;
		double delta_y = cd;
		double a = w - x;
		double angle = Math.atan(delta_y / a);
		double sigma_y = x * Math.tan(angle);
		
		GLine vli1	= new GLine(0.0, 0.0, -w, delta_y + sigma_y);
		gc.add(vli1, getWidth() / 2.0, h + cd * 2);
		
		GLine vli2	= new GLine(0.0, 0.0, -w, delta_y * 2 + sigma_y * 2);
		gc.add(vli2, getWidth() / 2.0, h + cd * 1);
		
		GLine vli3	= new GLine(0.0, 0.0, -w, delta_y * 3 + sigma_y * 3);
		gc.add(vli3, getWidth() / 2.0, h);
		
		GLine vli_1	= new GLine(0.0, 0.0, -w, - delta_y - sigma_y);
		gc.add(vli_1, getWidth() / 2.0, h + cd * 4);
		
		GLine vli_2	= new GLine(0.0, 0.0, -w, - delta_y * 2 - sigma_y * 2);
		gc.add(vli_2, getWidth() / 2.0, h + cd * 5);
		
		GLine vli_3	= new GLine(0.0, 0.0, -w, - delta_y * 3 - sigma_y * 3);
		gc.add(vli_3, getWidth() / 2.0, h + cd * 6);
		
		double dh = sigma_y * 6.0;
		double scale = dh / im.getHeight();
		GImage ii	= new GImage("Candle.png");
		ii.scale(scale, -scale);
		double hii = getHeight() / 2.0 - ii.getHeight() / 2.0;
		gc.add(ii, getWidth() / 4.0 - ii.getWidth(), hii);
		
		return gc;
		
	}
	
	public void run() {
		
		GLens gl		= new GLens(WIDTH, HEIGHT);
		GCompound ci 	= candleInverter(gl.getHeight());
		add(gl, getWidth() / 2.0, getHeight() / 4.0);
		add(ci, 0.0, 0.0);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LensImaging().start();
	}
	
	private static double WIDTH = 100.0;
	private static double HEIGHT = 500.0;


}
