/**
 * 
 */
package arrays_arraylists;
import java.awt.Color;
import acm.graphics.*;
/**
 * 
 */
public class BitwiseButton extends GCompound {
	private static final long serialVersionUID = 1L;
	public boolean state = false;
	private int row;
	private int col;
	private GOval go;
	private GLabel gl = new GLabel("");
	/**
	 * 
	 */
	public BitwiseButton(int s, int r, int c) {
		row = r;
		col = c;
		changeLabel();
		add(gl, s / 2.0 - gl.getWidth() / 2.0,
				s / 2.0 + gl.getAscent() / 2.0);
		go = new GOval(s, s);
		go.setFillColor(Color.cyan);
		go.setFilled(true);
		add(go, 0.0, 0.0);
		gl.sendToFront();
	}
	private void changeLabel() {
		if (state) {
			gl.setLabel("1");
		} else {
			gl.setLabel("0");
		}
	}
	public void setState() {
		state = !state;
		changeLabel();
	}
	public boolean getState() {
		return state;
	}
	public int getCol() {
		return col;
	}
	public int getRow() {
		return row;
	}
}
