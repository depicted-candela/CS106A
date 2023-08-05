/**
 * 
 */
package methods;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;
import acm.graphics.*;
import methods.Line;
import methods.Label;
import java.util.ArrayList;

public class Theseus extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		ArrayList<Line> a_lines = mazeDrawer();

		Label th = theseus();
		add(th);
		
		while (true) {
			
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
			if (th.isAWallAtRight(a_lines) && !th.isFacingWall(a_lines)) {
				
				System.out.println(th);
				th.moveForward();
				System.out.println(th);
				
			} else if (th.isFacingWall(a_lines)) {
				
				System.out.println('A');
				
			} else if (!th.isAWallAtRight(a_lines)) {
				
				System.out.println(th);
				System.out.println('B');
				
			}
			
	        if (th.isOutside()) break;
	        
		}
		
	}
	
	private Label theseus() {
		
		Label theseus = new Label("\u03B8", S * 145.0, S * 95.0);
		theseus.setFont("London-34");
		
		return theseus;
		
	}
	
	private ArrayList<Line> mazeDrawer() {
		
		ArrayList<Line> lines = new ArrayList<>();
		
		Line border_l = new Line(S * 20.0, S * 20.0, S * 20.0, S * 160.0);
		border_l.setType(1);
		add(border_l);
		lines.add(border_l);
		
		Line border_t = new Line(S * 20.0, S * 20.0, S * 280.0, S * 20.0);
		border_t.setType(0);
		add(border_t);
		lines.add(border_t);
		
		Line border_r = new Line(S * 280.0, S * 20.0, S * 280.0, S * 160.0);
		border_r.setType(1);
		add(border_r);
		lines.add(border_r);
		
		Line border_b_l = new Line(S * 20.0, S * 160.0, S * 140.0, S * 160.0);
		border_l.setType(0);
		add(border_b_l);
		lines.add(border_b_l);
		
		Line border_b_r = new Line(S * 180.0, S * 160.0, S * 280.0, S * 160.0);
		border_r.setType(0);
		add(border_b_r);
		lines.add(border_b_r);
		
		
		Line v1 = new Line(S * 40.0, S * 40.0, S * 40.0, S * 80.0);
		v1.setType(1);
		add(v1);
		lines.add(v1);
		
		Line v2 = new Line(S * 40.0, S * 120.0, S * 40.0, S * 140.0);
		v2.setType(1);
		add(v2);
		lines.add(v2);
		
		Line v3 = new Line(S * 60.0, S * 20.0, S * 60.0, S * 40.0);
		v3.setType(1);
		add(v3);
		lines.add(v3);
		
		Line v4 = new Line(S * 60.0, S * 80.0, S * 60.0, S * 120.0);
		v4.setType(1);
		add(v4);
		lines.add(v4);
		
		Line v5 = new Line(S * 80.0, S * 40.0, S * 80.0, S * 80.0);
		v5.setType(1);
		add(v5);
		lines.add(v5);
		
		Line v6 = new Line(S * 80.0, S * 120.0, S * 80.0, S * 140.0);
		v6.setType(1);
		add(v6);
		lines.add(v6);
		
		Line v7 = new Line(S * 100.0, S * 80.0, S * 100.0, S * 120.0);
		v7.setType(1);
		add(v7);
		lines.add(v7);
		
		Line v8 = new Line(S * 100.0, S * 140.0, S * 100.0, S * 160.0);
		v8.setType(1);
		add(v8);
		lines.add(v8);
		
		Line v9 = new Line(S * 120.0, S * 20.0, S * 120.0, S * 60.0);
		v9.setType(1);
		add(v9);
		lines.add(v9);
		
		Line v10 = new Line(S * 120.0, S * 120.0, S * 120.0, S * 140.0);
		v10.setType(1);
		add(v10);
		lines.add(v10);
		
		Line v11 = new Line(S * 140.0, S * 60.0, S * 140.0, S * 100.0);
		v11.setType(1);
		add(v11);
		lines.add(v11);
		
		Line v12 = new Line(S * 160.0, S * 20.0, S * 160.0, S * 40.0);
		v12.setType(1);
		add(v12);
		lines.add(v12);
		
		Line v13 = new Line(S * 160.0, S * 80.0, S * 160.0, S * 100.0);
		v13.setType(1);
		add(v13);
		lines.add(v13);
		
		Line v14 = new Line(S * 160.0, S * 140.0, S * 160.0, S * 160.0);
		v14.setType(1);
		add(v14);
		lines.add(v14);
		
		Line v15 = new Line(S * 180.0, S * 40.0, S * 180.0, S * 60.0);
		v15.setType(1);
		add(v15);
		lines.add(v15);
		
		Line v16 = new Line(S * 180.0, S * 100.0, S * 180.0, S * 160.0);
		v16.setType(1);
		add(v16);
		lines.add(v16);
		
		Line v17 = new Line(S * 200.0, S * 20.0, S * 200.0, S * 40.0);
		v17.setType(1);
		add(v17);
		lines.add(v17);
		
		Line v18 = new Line(S * 200.0, S * 60.0, S * 200.0, S * 100.0);
		v18.setType(1);
		add(v18);
		lines.add(v18);
		
		Line v19 = new Line(S * 220.0, S * 60.0, S * 220.0, S * 80.0);
		v19.setType(1);
		add(v19);
		lines.add(v19);
		
		Line v20 = new Line(S * 240.0, S * 40.0, S * 240.0, S * 60.0);
		v20.setType(1);
		add(v20);
		lines.add(v20);
		
		Line v21 = new Line(S * 240.0, S * 80.0, S * 240.0, S * 140.0);
		v21.setType(1);
		add(v21);
		lines.add(v21);
		
		Line v22 = new Line(S * 260.0, S * 60.0, S * 260.0, S * 120.0);
		v22.setType(1);
		add(v22);
		lines.add(v22);
		
		
		Line h1 = new Line(S * 40.0, S * 40.0, S * 60.0, S * 40.0);
		h1.setType(0);
		add(h1);
		lines.add(h1);
		
		Line h2 = new Line(S * 80.0, S * 40.0, S * 100.0, S * 40.0);
		h2.setType(0);
		add(h2);
		lines.add(h2);
		
		Line h3 = new Line(S * 140.0, S * 40.0, S * 160.0, S * 40.0);
		h3.setType(0);
		add(h3);
		lines.add(h3);
		
		Line h4 = new Line(S * 220.0, S * 40.0, S * 280.0, S * 40.0);
		h4.setType(0);
		add(h4);
		lines.add(h4);
		
		Line h5 = new Line(S * 60.0, S * 60.0, S * 80.0, S * 60.0);
		h5.setType(0);
		add(h5);
		lines.add(h5);
		
		Line h6 = new Line(S * 100.0, S * 60.0, S * 120.0, S * 60.0);
		h6.setType(0);
		add(h6);
		lines.add(h6);
		
		Line h7 = new Line(S * 140.0, S * 60.0, S * 200.0, S * 60.0);
		h7.setType(0);
		add(h7);
		lines.add(h7);
		
		Line h8 = new Line(S * 220.0, S * 60.0, S * 240.0, S * 60.0);
		h8.setType(0);
		add(h8);
		lines.add(h8);
		
		Line h9 = new Line(S * 40.0, S * 80.0, S * 60.0, S * 80.0);
		h9.setType(0);
		add(h9);
		lines.add(h9);
		
		Line h10 = new Line(S * 80.0, S * 80.0, S * 140.0, S * 80.0);
		h10.setType(0);
		add(h10);
		lines.add(h10);
		
		Line h11 = new Line(S * 160.0, S * 80.0, S * 180.0, S * 80.0);
		h11.setType(0);
		add(h11);
		lines.add(h11);
		
		Line h12 = new Line(S * 240.0, S * 80.0, S * 260.0, S * 80.0);
		h12.setType(0);
		add(h12);
		lines.add(h12);
		
		
		Line h13 = new Line(S * 20.0, S * 100.0, S * 40.0, S * 100.0);
		h13.setType(0);
		add(h13);
		lines.add(h13);
		
		Line h14 = new Line(S * 60.0, S * 100.0, S * 80.0, S * 100.0);
		h14.setType(0);
		add(h14);
		lines.add(h14);
		
		Line h15 = new Line(S * 120.0, S * 100.0, S * 160.0, S * 100.0);
		h15.setType(0);
		add(h15);
		lines.add(h15);
		
		Line h16 = new Line(S * 200.0, S * 100.0, S * 240.0, S * 100.0);
		h16.setType(0);
		add(h16);
		lines.add(h16);
		
		Line h17 = new Line(S * 80.0, S * 120.0, S * 120.0, S * 120.0);
		h17.setType(0);
		add(h17);
		lines.add(h17);
		
		Line h18 = new Line(S * 140.0, S * 120.0, S * 220.0, S * 120.0);
		h18.setType(0);
		add(h18);
		lines.add(h18);
		
		Line h19 = new Line(S * 40.0, S * 140.0, S * 80.0, S * 140.0);
		h19.setType(0);
		add(h19);
		lines.add(h19);
		
		Line h20 = new Line(S * 120.0, S * 140.0, S * 160.0, S * 140.0);
		h20.setType(0);
		add(h20);
		lines.add(h20);
		
		Line h21 = new Line(S * 200.0, S * 140.0, S * 260.0, S * 140.0);
		h21.setType(0);
		add(h21);
		lines.add(h21);
		
		return lines;
			
	}
	
	private static final int S = 2;

}
