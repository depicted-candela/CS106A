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
		COMBOBOXLEFT 	= new JComboBox<String>(ITEMS);
		left_sel 		= (String) COMBOBOXLEFT.getSelectedItem();
		COMBOBOXRIGHT 	= new JComboBox<String>(ITEMS);
		COMBOBOXLEFT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateComboBox(COMBOBOXRIGHT, COMBOBOXLEFT, (String) COMBOBOXLEFT.getSelectedItem());
			}
		});
		SIZE_COMB_W 	= getWidth() / 7;
		SIZE_COMB_H 	= getHeight() / 10;
		COMBOBOXLEFT.setBounds(getWidth() / 2 - SIZE_COMB_W, getHeight() / 2 - SIZE_COMB_H, SIZE_COMB_W, SIZE_COMB_H);
		add(COMBOBOXLEFT, getWidth() / 2 - SIZE_COMB_W, getHeight() / 2 - SIZE_COMB_H);
		COMBOBOXRIGHT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateComboBox(COMBOBOXLEFT, COMBOBOXRIGHT, (String) COMBOBOXRIGHT.getSelectedItem());
			}
		});
		COMBOBOXRIGHT.setBounds(getWidth() / 2, getHeight() / 2 - SIZE_COMB_H, SIZE_COMB_W, SIZE_COMB_H);
		COMBOBOXRIGHT.setSelectedItem(ITEMS[2]);
		right_sel		= (String) COMBOBOXRIGHT.getSelectedItem();
		add(COMBOBOXRIGHT, getWidth() / 2, getHeight() / 2 - SIZE_COMB_H);
	}
	
	private void createDoubleInputField() {
		LEFT	= new DoubleField();
		LEFT.setBounds(getWidth() / 2 - SIZE_COMB_W, getHeight() / 2, SIZE_COMB_W, SIZE_COMB_H);
		RIGHT	= new DoubleField();
		RIGHT.setBounds(getWidth() / 2, getHeight() / 2, SIZE_COMB_W, SIZE_COMB_H);
		add(LEFT, getWidth() / 2 - SIZE_COMB_W, getHeight() / 2);
		add(RIGHT, getWidth() / 2, getHeight() / 2);
	}
	
	private void createButtons() {
		LEFT_B 	= new JButton("Convert ->");
		RIGHT_B	= new JButton("<- Convert");
		LEFT_B.setBounds(getWidth() / 2 - SIZE_COMB_W, getHeight() / 2 + SIZE_COMB_H, SIZE_COMB_W, SIZE_COMB_H);
		RIGHT_B.setBounds(getWidth() / 2, getHeight() / 2 + SIZE_COMB_H, SIZE_COMB_W, SIZE_COMB_H);
		LEFT_B.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				println(right_sel);
				println(RIGHT.getValue());
			}
		});
		RIGHT_B.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				println(left_sel);
				println(LEFT.getValue());
			}
		});
		add(LEFT_B, getWidth() / 2 - SIZE_COMB_W, getHeight() / 2 + SIZE_COMB_H);
		add(RIGHT_B, getWidth() / 2, getHeight() / 2 + SIZE_COMB_H);
	}
	
	private void segregateCalculator(String input, String output) {
		
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
	private String left_sel, right_sel;
	private int SIZE_COMB_W, SIZE_COMB_H;
	private DoubleField LEFT, RIGHT;
	private JButton LEFT_B, RIGHT_B;
}
