/**
 * 
 */
package arrays_arraylists;
import acm.graphics.*;
import acm.program.*;
/**
 * 
 */
public class MakeColorNegative extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public void run() {
		GImage im = new GImage("van_gogh_starry_night.jpeg");
		int[][] arr = im.getPixelArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = makeColorNegative(arr, i, j);
			}
		}
		GImage negim = new GImage(arr);
		add(negim);
	}
	
	//*Use bit operators to create a negative scene*/
	private int makeColorNegative(int[][] arr, int i, int j) {
		int pixel 	= arr[i][j];
		int red 	= (pixel >> 16) & 0xFF;
		red 		= 255 - red;
		int green 	= (pixel >> 8) & 0xFF;
		green 		= 255 - green;
		int blue 	= pixel & 0xFF;
		blue 		= 255 - blue;
		return (0xFF << 24) | (red << 16) | (green << 8) | (blue);
	}
	
	public static void main(String[] args) {
		new MakeColorNegative().start();
	}

}
