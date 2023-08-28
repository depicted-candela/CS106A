/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import java.util.ArrayList;
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
	
	public static ArrayList<Line> mazeDrawer() {
		
		ArrayList<Line> lines = new ArrayList<>();
		
		Line border_l = new Line(S * 2.0, S * 2.0, S * 2.0, S * 16.0);
		border_l.setType(1);
		lines.add(border_l);
		
		Line border_t = new Line(S * 2.0, S * 2.0, S * 28.0, S * 2.0);
		border_t.setType(0);
		lines.add(border_t);
		
		Line border_r = new Line(S * 28.0, S * 2.0, S * 28.0, S * 16.0);
		border_r.setType(1);
		lines.add(border_r);
		
		Line border_b_l = new Line(S * 2.0, S * 16.0, S * 14.0, S * 16.0);
		border_l.setType(0);
		lines.add(border_b_l);
		
		Line border_b_r = new Line(S * 18.0, S * 16.0, S * 28.0, S * 16.0);
		border_r.setType(0);
		lines.add(border_b_r);
		
		
		Line v1 = new Line(S * 4.0, S * 4.0, S * 4.0, S * 8.0);
		v1.setType(1);
		lines.add(v1);
		
		Line v2 = new Line(S * 4.0, S * 12.0, S * 4.0, S * 14.0);
		v2.setType(1);
		lines.add(v2);
		
		Line v3 = new Line(S * 6.0, S * 2.0, S * 6.0, S * 4.0);
		v3.setType(1);
		lines.add(v3);
		
		Line v4 = new Line(S * 6.0, S * 8.0, S * 6.0, S * 12.0);
		v4.setType(1);
		lines.add(v4);
		
		Line v5 = new Line(S * 8.0, S * 4.0, S * 8.0, S * 8.0);
		v5.setType(1);
		lines.add(v5);
		
		Line v6 = new Line(S * 8.0, S * 12.0, S * 8.0, S * 14.0);
		v6.setType(1);
		lines.add(v6);
		
		Line v7 = new Line(S * 10.0, S * 8.0, S * 10.0, S * 12.0);
		v7.setType(1);
		lines.add(v7);
		
		Line v8 = new Line(S * 10.0, S * 14.0, S * 10.0, S * 16.0);
		v8.setType(1);
		lines.add(v8);
		
		Line v9 = new Line(S * 12.0, S * 2.0, S * 12.0, S * 6.0);
		v9.setType(1);
		lines.add(v9);
		
		Line v10 = new Line(S * 12.0, S * 12.0, S * 12.0, S * 14.0);
		v10.setType(1);
		lines.add(v10);
		
		Line v11 = new Line(S * 14.0, S * 6.0, S * 14.0, S * 10.0);
		v11.setType(1);
		lines.add(v11);
		
		Line v12 = new Line(S * 16.0, S * 2.0, S * 16.0, S * 4.0);
		v12.setType(1);
		lines.add(v12);
		
		Line v13 = new Line(S * 16.0, S * 8.0, S * 16.0, S * 10.0);
		v13.setType(1);
		lines.add(v13);
		
		Line v14 = new Line(S * 16.0, S * 14.0, S * 16.0, S * 16.0);
		v14.setType(1);
		lines.add(v14);
		
		Line v15 = new Line(S * 18.0, S * 4.0, S * 18.0, S * 6.0);
		v15.setType(1);
		lines.add(v15);
		
		Line v16 = new Line(S * 18.0, S * 10.0, S * 18.0, S * 16.0);
		v16.setType(1);
		lines.add(v16);
		
		Line v17 = new Line(S * 20.0, S * 2.0, S * 20.0, S * 4.0);
		v17.setType(1);
		lines.add(v17);
		
		Line v18 = new Line(S * 20.0, S * 6.0, S * 20.0, S * 10.0);
		v18.setType(1);
		lines.add(v18);
		
		Line v19 = new Line(S * 22.0, S * 6.0, S * 22.0, S * 8.0);
		v19.setType(1);
		lines.add(v19);
		
		Line v20 = new Line(S * 24.0, S * 4.0, S * 24.0, S * 6.0);
		v20.setType(1);
		lines.add(v20);
		
		Line v21 = new Line(S * 24.0, S * 8.0, S * 24.0, S * 14.0);
		v21.setType(1);
		lines.add(v21);
		
		Line v22 = new Line(S * 26.0, S * 6.0, S * 26.0, S * 12.0);
		v22.setType(1);
		lines.add(v22);
		
		
		Line h1 = new Line(S * 4.0, S * 4.0, S * 6.0, S * 4.0);
		h1.setType(0);
		lines.add(h1);
		
		Line h2 = new Line(S * 8.0, S * 4.0, S * 10.0, S * 4.0);
		h2.setType(0);
		lines.add(h2);
		
		Line h3 = new Line(S * 14.0, S * 4.0, S * 16.0, S * 4.0);
		h3.setType(0);
		lines.add(h3);
		
		Line h4 = new Line(S * 22.0, S * 4.0, S * 28.0, S * 4.0);
		h4.setType(0);
		lines.add(h4);
		
		Line h5 = new Line(S * 6.0, S * 6.0, S * 8.0, S * 6.0);
		h5.setType(0);
		lines.add(h5);
		
		Line h6 = new Line(S * 10.0, S * 6.0, S * 12.0, S * 6.0);
		h6.setType(0);
		lines.add(h6);
		
		Line h7 = new Line(S * 14.0, S * 6.0, S * 20.0, S * 6.0);
		h7.setType(0);
		lines.add(h7);
		
		Line h8 = new Line(S * 22.0, S * 6.0, S * 24.0, S * 6.0);
		h8.setType(0);
		lines.add(h8);
		
		Line h9 = new Line(S * 4.0, S * 8.0, S * 6.0, S * 8.0);
		h9.setType(0);
		lines.add(h9);
		
		Line h10 = new Line(S * 8.0, S * 8.0, S * 14.0, S * 8.0);
		h10.setType(0);
		lines.add(h10);
		
		Line h11 = new Line(S * 16.0, S * 8.0, S * 18.0, S * 8.0);
		h11.setType(0);
		lines.add(h11);
		
		Line h12 = new Line(S * 24.0, S * 8.0, S * 26.0, S * 8.0);
		h12.setType(0);
		lines.add(h12);
		
		
		Line h13 = new Line(S * 2.0, S * 10.0, S * 4.0, S * 10.0);
		h13.setType(0);
		lines.add(h13);
		
		Line h14 = new Line(S * 6.0, S * 10.0, S * 8.0, S * 10.0);
		h14.setType(0);
		lines.add(h14);
		
		Line h15 = new Line(S * 12.0, S * 10.0, S * 16.0, S * 10.0);
		h15.setType(0);
		lines.add(h15);
		
		Line h16 = new Line(S * 20.0, S * 10.0, S * 24.0, S * 10.0);
		h16.setType(0);
		lines.add(h16);
		
		Line h17 = new Line(S * 8.0, S * 12.0, S * 12.0, S * 12.0);
		h17.setType(0);
		lines.add(h17);
		
		Line h18 = new Line(S * 14.0, S * 12.0, S * 22.0, S * 12.0);
		h18.setType(0);
		lines.add(h18);
		
		Line h19 = new Line(S * 4.0, S * 14.0, S * 8.0, S * 14.0);
		h19.setType(0);
		lines.add(h19);
		
		Line h20 = new Line(S * 12.0, S * 14.0, S * 16.0, S * 14.0);
		h20.setType(0);
		lines.add(h20);
		
		Line h21 = new Line(S * 20.0, S * 14.0, S * 26.0, S * 14.0);
		h21.setType(0);
		lines.add(h21);
		
		return lines;
			
	}
	
	private static final int S = 20;
	
}
