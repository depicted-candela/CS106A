/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;

public class PyramidDrawer extends GCompound {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public PyramidDrawer (int bib, int bw, int bh) {
		
		for (int i = 0; i < bib; i++) {
			
			double start = i * bw / 2;
			
			for (int j = i; j < bib; j++) {
				GRect brick = new GRect(start, bh * bib - bh * i, bw, bh);
				add(brick);
				start += bw;
			}
		
		}
		
	}

}
