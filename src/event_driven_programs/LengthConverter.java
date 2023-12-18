/**
 * 
 */
package event_driven_programs;
import javax.swing.*;
import java.awt.event.*;
import acm.program.*;
import acm.gui.*;
/**
 * 
 */
public class LengthConverter extends GraphicsProgram {

	private static final long serialVersionUID = 6252672614135057445L;

	/**
	 * @param args
	 */
	
	private void comboxCreator() {
		
		SIZE_COMB_W 	= getWidth() / 7;
		SIZE_COMB_H 	= getHeight() / 10;
		
		COMBOBOXLEFT 	= new JComboBox<String>(ITEMS);
		COMBOBOXLEFT.setBounds(getWidth() / 2 - SIZE_COMB_W, getHeight() / 2 - SIZE_COMB_H, SIZE_COMB_W, SIZE_COMB_H);
		COMBOBOXLEFT.setSelectedItem(ITEMS[1]);
		COMBOBOXLEFT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (COMBOBOXLEFT.getSelectedItem() != null) {
					if (COMBOBOXLEFT.getSelectedItem().equals(COMBOBOXRIGHT.getSelectedItem())) {
						updateComboBox(COMBOBOXRIGHT,
								COMBOBOXLEFT,
								(String) COMBOBOXLEFT.getSelectedItem());
					}
				}
			}
		});
		add(COMBOBOXLEFT, getWidth() / 2 - SIZE_COMB_W, getHeight() / 2 - SIZE_COMB_H);
		
		COMBOBOXRIGHT 	= new JComboBox<String>(ITEMS);
		COMBOBOXRIGHT.setBounds(getWidth() / 2, getHeight() / 2 - SIZE_COMB_H, SIZE_COMB_W, SIZE_COMB_H);
		COMBOBOXRIGHT.setSelectedItem(ITEMS[2]);
		COMBOBOXRIGHT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (COMBOBOXRIGHT.getSelectedItem() != null) {
					if (COMBOBOXRIGHT.getSelectedItem().equals(COMBOBOXLEFT.getSelectedItem())) {
						updateComboBox(COMBOBOXLEFT,
								COMBOBOXRIGHT,
								(String) COMBOBOXRIGHT.getSelectedItem());
					}
				}
			}
		});
		add(COMBOBOXRIGHT, getWidth() / 2, getHeight() / 2 - SIZE_COMB_H);
	}
	
	private void createDoubleInputField() {
		LEFT	= new DoubleField();
		LEFT.setActionCommand("<- Convert"); // Implicit
		LEFT.addActionListener(this);   // Explicit: alone needed if is not sharing behavior or listener
										// with a nother element
		LEFT.setBounds(getWidth() / 2 - SIZE_COMB_W, getHeight() / 2, SIZE_COMB_W, SIZE_COMB_H);
		RIGHT	= new DoubleField();
		LEFT.setActionCommand("Convert ->"); // Implicit
		RIGHT.addActionListener(this); // Explicit
		RIGHT.setBounds(getWidth() / 2, getHeight() / 2, SIZE_COMB_W, SIZE_COMB_H);
		add(LEFT, getWidth() / 2 - SIZE_COMB_W, getHeight() / 2);
		add(RIGHT, getWidth() / 2, getHeight() / 2);
	}
	
	private void createButtons() {
		LEFT_B 	= new JButton("Convert ->"); // Implicit
		LEFT_B.addActionListener(this); // Explicit
		RIGHT_B	= new JButton("<- Convert"); // Implicit
		RIGHT_B.addActionListener(this); // Explicit
		LEFT_B.setBounds(getWidth() / 2 - SIZE_COMB_W, getHeight() / 2 + SIZE_COMB_H, SIZE_COMB_W, SIZE_COMB_H);
		RIGHT_B.setBounds(getWidth() / 2, getHeight() / 2 + SIZE_COMB_H, SIZE_COMB_W, SIZE_COMB_H);
//		LEFT_B.addActionListener(new ActionListener() { // Implicit
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Double result	= segregateCalculator(
//						(String) COMBOBOXLEFT.getSelectedItem(), 
//						(String) COMBOBOXRIGHT.getSelectedItem(), 
//						LEFT.getValue());
//				RIGHT.setValue(result);
//			}
//		});
//		RIGHT_B.addActionListener(new ActionListener() { // Implicit
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Double result	= segregateCalculator(
//						(String) COMBOBOXRIGHT.getSelectedItem(),
//						(String) COMBOBOXLEFT.getSelectedItem(), RIGHT.getValue());
//				LEFT.setValue(result);
//			}
//		});
		add(LEFT_B, getWidth() / 2 - SIZE_COMB_W, getHeight() / 2 + SIZE_COMB_H);
		add(RIGHT_B, getWidth() / 2, getHeight() / 2 + SIZE_COMB_H);
	}
	
	public void actionPerformed(ActionEvent e) { // To save space
		if (e.getActionCommand().equals("Convert ->")) { 
			Double result	= segregateCalculator(
				(String) COMBOBOXLEFT.getSelectedItem(), 
				(String) COMBOBOXRIGHT.getSelectedItem(), 
				LEFT.getValue());
			RIGHT.setValue(result);
		} else if (e.getActionCommand().equals("<- Convert")) {
			Double result	= segregateCalculator(
				(String) COMBOBOXRIGHT.getSelectedItem(),
				(String) COMBOBOXLEFT.getSelectedItem(), RIGHT.getValue());
			LEFT.setValue(result);
		}
//		if (e.getSource() == LEFT) {			// With entire explicit calls
//			Double result	= segregateCalculator(
//					(String) COMBOBOXLEFT.getSelectedItem(), 
//					(String) COMBOBOXRIGHT.getSelectedItem(), 
//					LEFT.getValue());
//			RIGHT.setValue(result);
//		} else if (e.getSource() == RIGHT) {
//			Double result	= segregateCalculator(
//					(String) COMBOBOXRIGHT.getSelectedItem(),
//					(String) COMBOBOXLEFT.getSelectedItem(), RIGHT.getValue());
//			LEFT.setValue(result);
//		}
	}
	
	private Double segregateCalculator(String input, String output, double i) {
		if (!input.equals("feet")) {
			if (!output.equals("feet")) {
				return fromFeet(output, toFeet(input, i));
			} else {
				return toFeet(input, i);
			}
		} else {
			return fromFeet(output, i);
		}
	}
	
	private Double toFeet(String input, double i) {
		switch (input) {
		case "yards": return i * 3;
		case "fathoms": return i * 6;
		case "rods": return i * 16.5;
		case "miles": return i * 5280;
		case "inches": return i / 12;
		case "furlongs":
			return i * 220 * toFeet("yards", 1);
		default: return null;
		}
	}
	
	private Double fromFeet(String output, double i) {
		switch (output) {
		case "yards": return i / 3;
		case "fathoms": return i / 6;
		case "rods": return i / 16.5;
		case "miles": return i / 5280;
		case "inches": return i * 12;
		case "furlongs": return fromFeet("yards", i) / 220;
		default: return null;
		}
	}
	
	private void updateComboBox(JComboBox<String> com1, JComboBox<String> com2, String s) {
		com1.removeAllItems();
		for (String items : ITEMS) {
			com1.addItem(items);
		}
		com1.removeItem(s);
		com2.setSelectedItem(s);
	}
	
	private void comboxInitializer() {
		comboxCreator();
	}
	
	public void init() {
		comboxInitializer();
		createDoubleInputField();
		createButtons();
	}
	
	public void run() {
		
	}
	
	public static void main(String[] args) {
		new LengthConverter().start();
	}
	
	DoubleField JTF;
	private static String[] ITEMS = {"inches", "feet", "yards", "miles",
			"fathoms", "rods", "furlongs"};
	private JComboBox<String> COMBOBOXLEFT, COMBOBOXRIGHT;
	private int SIZE_COMB_W, SIZE_COMB_H;
	private DoubleField LEFT, RIGHT;
	private JButton LEFT_B, RIGHT_B;
}
