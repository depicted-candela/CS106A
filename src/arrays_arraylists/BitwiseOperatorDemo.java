/**
 * 
 */
package arrays_arraylists;
import acm.program.*;
import acm.graphics.*;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;
/**
 * 
 */

public class BitwiseOperatorDemo extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	private static JComboBox<Character> jcb = new JComboBox<>();
	private GCompound gc = new GCompound();
	private ArrayList<ArrayList<BitwiseButton>> albb = new ArrayList<>();
	
	/**
	 * @param args
	 */
	
	public void mouseClicked(MouseEvent e) {
		BitwiseButton obj = (BitwiseButton) gc.getElementAt(e.getX(), e.getY());
		if (obj.getRow() != 2) obj.setState();
		update();
	}
	
	private void update() {
		operands();
		remove(gc);
		add(gc);
	}
	
	private void operands() {
		boolean ampersant = jcb.getSelectedItem().equals('&');
		boolean or = jcb.getSelectedItem().equals('|');
		if (ampersant) {
			ampersant();
		} else if (or){
			disjunction();
		} else {
			not();
		}
	}
	
	private void ampersant() {
		ArrayList<BitwiseButton> r;
		BitwiseButton b1;
		BitwiseButton b2;
		BitwiseButton b3;
		for (int i = 0; i < 8; i++) {
			r	= albb.get(i);
			b1	= r.get(0);
			b2	= r.get(1);
			b3	= r.get(2);
			if (b1.getState() && b2.getState()) {
				if (!b3.getState()) b3.setState();
			} else {
				if (b3.getState()) b3.setState();
			}
		}
	}
	
	private void disjunction() {
		ArrayList<BitwiseButton> r;
		BitwiseButton b1;
		BitwiseButton b2;
		BitwiseButton b3;
		for (int i = 0; i < 8; i++) {
			r	= albb.get(i);
			b1	= r.get(0);
			b2	= r.get(1);
			b3	= r.get(2);
			if (b1.getState() || b2.getState()) {
				if (!b3.getState()) b3.setState();
			} else {
				if (b3.getState()) b3.setState();
			}
		}
	}
	
	private void not() {
		ArrayList<BitwiseButton> r;
		BitwiseButton b1;
		BitwiseButton b2;
		BitwiseButton b3;
		for (int i = 0; i < 8; i++) {
			r	= albb.get(i);
			b1	= r.get(0);
			b2	= r.get(1);
			b3	= r.get(2);
			if (!b1.getState() == b2.getState()) {
				if (!b3.getState()) b3.setState();
			} else {
				if (b3.getState()) b3.setState();
			}
		}
	}
	
	private void containers(double gw) {
		for (int i = 0; i < 8; i++) {
			ArrayList<BitwiseButton> tempbb = new ArrayList<BitwiseButton>();
			for (int j = 0; j < 3; j++) {
				BitwiseButton bb = new BitwiseButton(getWidth() / 16, j, i);
				tempbb.add(bb);
			}
			albb.add(tempbb);
		}
	}
	
	private void addContainers(double gw) {
		int r 	= 0;
		for (ArrayList<BitwiseButton> cols : albb) {
			int c = 0;
			for (BitwiseButton cs : cols) {
				gc.add(cs, r * gw + 5 * gw,
						c * gw + getHeight() / 2 - gw * 1.5);
				c++;
			}
			r++;
		}
		add(gc);
	}
	
	public void init() {
		double gw = (getWidth() - 30) / 16.0;
		addMouseListeners();
		containers(gw);
		jcb.setBounds(0, 0, 30, 30);
		add(jcb, WEST);
		jcb.addItem('&');
		jcb.addItem('|');
		jcb.addItem('^');
		jcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		addContainers(gw);
	}
	
	public static void main(String[] args) {
		new BitwiseOperatorDemo().start();
	}

}
