/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

public class CartesianDistance {
	
	/**
	 * @param args
	 */
	
	public boolean cartesianDistance(double x1, double x2, double y1, double y2) {
		
		double dx = Math.abs((double) x1 - (double) x2);
		double dy = Math.abs((double) y1 - (double) y2);
		
		return (Math.sqrt(dx * dx + dy * dy) < S * 20 / 2);
		
	}
	
	public boolean cartesianDistancePointLine(double xl, double yl, double x1, double x2, double y1, double y2) {
		
		double dx1 = Math.abs((double) xl - (double) x1);
		double dy1 = Math.abs((double) yl - (double) y1);
		
		double dx2 = Math.abs((double) xl - (double) x2);
		double dy2 = Math.abs((double) yl - (double) y2);
		
		double d1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);
		double d2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
		
		double min;
		
		if (d1 < d2) {
			min = d1;
		} else {
			min = d2;
		}
		
		return ((min) < (S * 20 / 2));
		
	}
	
	private static final int S = 2;

}
