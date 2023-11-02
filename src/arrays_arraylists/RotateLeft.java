/**
 * 
 */
package arrays_arraylists;
import acm.graphics.*;
import acm.program.*;
/**
 * 
 */
public class RotateLeft extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	private GImage rotateLeft(int[][] im) {
		int[][] newim = new int[im[0].length][im.length];
		for (int i = 0; i < newim[0].length; i++) {
			for (int j = 0; j < newim.length; j++) {
				newim[newim.length - 1 - j][i] = im[i][j];
			}
		}
		return new GImage(newim);
	}
	public void run() {
		GImage im = new GImage("Candle.png");
		add(rotateLeft(im.getPixelArray()));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RotateLeft().start();
	}

}
