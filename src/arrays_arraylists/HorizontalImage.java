/**
 * 
 */
package arrays_arraylists;

import acm.graphics.*;
/**
 * 
 */
public class HorizontalImage extends GImage {
	public HorizontalImage(String arg0) {
		super(arg0);
	}
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public GImage horizontalFlip() {
		int[][] arr = this.getPixelArray();
		int w = arr[0].length;
		int h = arr.length;
		int i2;
		int temp;
		for (int i = 0; i < w / 2; i++) {
			i2 = w - 1 - i;
			for (int j = 0; j < h; j++) {
				temp = arr[j][i];
				arr[j][i] = arr[j][i2];
				arr[j][i2] = temp;
			}
		}
		return new GImage(arr);
	}
}
