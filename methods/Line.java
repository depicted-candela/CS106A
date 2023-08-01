/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;

public class Line extends GLine {
	
	private static final long serialVersionUID = 1L;
	
	private int type;
	
	public Line(double arg0, double arg1, double arg2, double arg3) {
		super(arg0, arg1, arg2, arg3);
		type = 1;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	
}
