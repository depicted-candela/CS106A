/**
 * 
 */
package arrays_arraylists;
import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.util.*;
/**
 * 
 */
public class ClipImage extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	private static GImage IM = new GImage("last_supper_full.jpeg");
	private double start_x, start_y, x, y, width, height;
	private GRect r;
	
	/**
	 * @param args
	 */
	
	/** Called on mouse press to create the rectangle*/
	public void mousePressed(MouseEvent e) {
		start_x = e.getX();
		start_y = e.getY();
		r = new GRect(start_x, start_y, 0.0, 0.0);
		add(r);
	}
	
	/** Called on mouse drag to reshape the current rectangle */
	public void mouseDragged(MouseEvent e) {
		x = Math.min(e.getX(), start_x);
		y = Math.min(e.getY(), start_y);
		width = Math.abs(e.getX() - start_x);
		height = Math.abs(e.getY() - start_y);
		r.setBounds(x, y, width, height);
		r.setBounds(x, y, width, height);
	}
	
	/** Called on mouse release to select the array to the selected
	 * zone of the image*/
	public void mouseReleased(MouseEvent e) {
		remove(IM);
		remove(r);
		add(new GImage(arraySelector()));
	}
	
	/** Selects the array given coordinates and width and height of
	 * the rectangle created by the mouse */
	private int[][] arraySelector() {
		int[][] arr = IM.getPixelArray();
		ArrayList<ArrayList<Integer>> newarr = new ArrayList<>();
		ArrayList<Integer> temparr;
		double s_x = IM.getWidth() / arr[0].length;
		double s_y = IM.getHeight() / arr.length;
		
		for (int j = (int) (y / s_y); j < (int) ((height + y) / s_y); j++) {
			temparr = new ArrayList<Integer>();
			int x_s = (int) (x / s_x);
			for (int i = x_s; i < (int) ((width + x) / s_x); i++) {
				temparr.add(arr[j][i]);
			}
			newarr.add(temparr);
		}
		return arrayOrganizer(newarr);
	}
	
	/** Organizes the array selected by arraySelector */
	private int[][] arrayOrganizer(ArrayList<ArrayList<Integer>> newarr) {
		int[][] new_array = new int[newarr.size()][newarr.get(0).size()];
		int r = 0;
		for (ArrayList<Integer> na : newarr) {
			int c = 0;
			for (int n : na) {
				new_array[r][c] = n;
				c++;
			}
			r++;
		}
		return new_array;
	}
	
	public void run() {
		addMouseListeners();
		IM.setSize(getWidth(), getHeight());
		int[][] raw = IM.getPixelArray();
		x = raw.length / getWidth();
		y = raw[0].length / getHeight();
		add(IM);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClipImage().start();
	}

}
