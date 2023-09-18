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

public class GPolygonTest extends GraphicsProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		// TODO Auto-generated method stub
		
		parallelogram = createParallelogram(POST, POST);
		add(parallelogram, POST * 2, POST * 2);
		pentagon = createPentagon(POST, POST);
		add(pentagon, POST * 4, POST * 2);
		church = createChurch(POST, POST);
		add(church, POST * 6, POST * 2);

	}
	
	private GPolygon createParallelogram(double width, double height) {
		GPolygon parallelogram = new GPolygon();
		parallelogram.addVertex(0, 0);
		double b = Math.abs(POST * Math.sin(Math.toRadians(60)));
		double a = Math.abs(POST * Math.cos(Math.toRadians(60)));
		parallelogram.addVertex(a, -b);
		parallelogram.addVertex(a + width, -b);
		parallelogram.addVertex(width, 0);
		return parallelogram;
	}
	
	private GPolygon createPentagon(double width, double height) {
		GPolygon pentagon = new GPolygon();
		pentagon.addVertex(0, 0);
		double a = POST * Math.cos(Math.toRadians(PENTAGON_ANGLE));
		double b = POST * Math.sin(Math.toRadians(PENTAGON_ANGLE));
		pentagon.addVertex(a, -b);
		a += POST * Math.cos(Math.toRadians(PENTAGON_ANGLE * 2 - 180));
		b += POST * Math.sin(Math.toRadians(PENTAGON_ANGLE * 2 - 180));
		pentagon.addVertex(a, -b);
		a += POST * Math.cos(Math.toRadians((PENTAGON_ANGLE - 180) / 2));
		b += POST * Math.sin(Math.toRadians((PENTAGON_ANGLE - 180) / 2));
		pentagon.addVertex(a, -b);
		a += POST * Math.cos(Math.toRadians(PENTAGON_ANGLE));
		b -= POST * Math.sin(Math.toRadians(PENTAGON_ANGLE));
		pentagon.addVertex(a, b);
		return pentagon;
	}
	
	private GPolygon createChurch(double width, double heigth) {
		GPolygon church = new GPolygon();
		church.addVertex(0, 0);
		church.addVertex(0, - heigth / 4);
		church.addVertex(-width / 4, - heigth / 4);
		church.addVertex(-width / 4, - (heigth / 4) * 2);
		church.addVertex(0, - (heigth / 4) * 2);
		church.addVertex(0, - (heigth / 4) * 3);
		church.addVertex(width / 4, - (heigth / 4) * 3);
		church.addVertex(width / 4, - (heigth / 4) * 2);
		church.addVertex((width / 4) * 2, -(heigth / 4) * 2);
		church.addVertex((width / 4) * 2, -heigth / 4);
		church.addVertex(width / 4, -heigth / 4);
		church.addVertex(width / 4, 0);
		return church;
	}
	
	private static int POST = 40;
	private static double PENTAGON_ANGLE = 108;
	private static GPolygon parallelogram;
	private static GPolygon pentagon;
	private static GPolygon church;

}
