/**
 * 
 */
package event_driven_programs;
import acm.program.*;

import java.awt.event.ActionEvent;

import javax.swing.*;
/**
 * 
 */
public class SpeedControlBar extends GraphicsProgram {

	private static final long serialVersionUID = -599850683386731657L;

	/**
	 * 
	 */
	public void init() {
		add(new JButton("Start"), SOUTH);
		add(new JButton("Button"), SOUTH);
		addActionListeners();
		add(new JLabel("Slow"), SOUTH);
		sizeSlider = new JSlider(0, 10, 9);
		add(new JLabel("Fast"), SOUTH);
		add(sizeSlider, SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			println("A");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SpeedControlBar().start();
	}
	
	private JSlider sizeSlider;

}
