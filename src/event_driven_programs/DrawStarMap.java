/**
 * 
 */
package event_driven_programs;

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import object_oriented_graphics.GStar;
/**
* This program creates a five-pointed star every time the
* user clicks the mouse on the canvas. This version includes
* a JButton to clear the screen, a JSlider to choose the size,
* and a JComboBox to choose the color.
*/
public class DrawStarMap extends GraphicsProgram {
	private static final long serialVersionUID = -2024500195885217904L;
	/* Initializes the graphical user interface */
	public void init() {
		setBackground(Color.GRAY);
		add(new JButton("Clear"), SOUTH);
		sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, INITIAL_SIZE);
		add(new JLabel(" Small"), SOUTH);
		add(sizeSlider, SOUTH);
		add(new JLabel("Large "), SOUTH);
		initColorChooser();
		add(colorChooser, SOUTH);
		JTF = new JTextField("Star name", 20);
		JTF.addActionListener(this);
		add(JTF, SOUTH);
		addMouseListeners();
		addActionListeners();
		addKeyListeners();
	}
	
	/* Called to move or delete the current star with keyboard */
	public void keyPressed(KeyEvent e) {
		if (star != null) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:	star.move(0, -1); break;
				case KeyEvent.VK_DOWN:	star.move(0, 1); break;
				case KeyEvent.VK_LEFT:	star.move(-1, 0); break;
				case KeyEvent.VK_RIGHT:	star.move(1, 0); break;
			}
		}
	}
	
	/* Called to move or delete the current star with keyboard */
	public void keyClicked(KeyEvent e) {
		if (star != null) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:	star.move(0, -1); break;
				case KeyEvent.VK_DOWN:	star.move(0, 1); break;
				case KeyEvent.VK_LEFT:	star.move(-1, 0); break;
				case KeyEvent.VK_RIGHT:	star.move(1, 0); break;
			}
		}
	}
	
	/* Initializes the color chooser */
	private void initColorChooser() {
		colorChooser = new JComboBox<LabeledColor>();
		colorChooser.addItem(new LabeledColor());
		colorChooser.addItem(new LabeledColor("Red", Color.RED));
		colorChooser.addItem(new LabeledColor("Yellow", Color.YELLOW));
		colorChooser.addItem(new LabeledColor("Orange", Color.ORANGE));
		colorChooser.addItem(new LabeledColor("Green", Color.GREEN));
		colorChooser.addItem(new LabeledColor("Blue", Color.BLUE));
		colorChooser.addItem(new LabeledColor("Red", Color.RED));
		colorChooser.setEditable(false);
		colorChooser.setSelectedItem("White");
	}
	/* Get current color to draw */
	private LabeledColor getCurrentColor() {
		LabeledColor name = (LabeledColor) colorChooser.getSelectedItem();
		return name;
	}
	/* Returns the current size */
	private double getCurrentSize() {
		return sizeSlider.getValue();
	}
	/* Called whenever the user clicks the mouse */
	public void mouseClicked(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		drawStar(x, y);
	}
	/* Called whenever the user press the mouse */
	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		if (getElementAt(x, y) == null) {
			SELECTED = false;
		/* If the selected object is an star */
		} else if (getElementAt(x, y) instanceof GStarName) {
			star = (GStarName) getElementAt(x, y);
			SELECTED = true;
		/* If the selected object is a GLabel */
		} else if (getElementAt(x, y) instanceof GLabel) {
			for (int i = 0; i < getElementCount(); i++) {
				/* Searchs the GStar of the GLabel */
				if (getElement(i) instanceof GStarName && getElement(i).contains(x, y)) {
					star = (GStarName) getElement(i);
					SELECTED = true;
					break;
				}
			}
		}
	}
	/* Called whenever the user drag the mouse */
	public void mouseDragged(MouseEvent e) {
		if (SELECTED) {
			star.setLocation(e.getX(), e.getY());
			if (star.name != null) star.name.setLocation(e.getX(), e.getY());
		}
	}
	/* To draw a star */
	private void drawStar(double x, double y) {
		star = new GStarName(getCurrentSize());
		star.setFilled(true);
		star.setColor(getCurrentColor().color);
		add(star, x, y);
	}
	/* Called whenever an action event occurs */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Clear")) {
			removeAll();
		} else if (e.getSource() == JTF) {
			if (star != null) {
				star.name = new GLabel(JTF.getText());
				star.name.setColor(star.getColor());
				add(star.name, star.getX(), star.getY());
			}
		}
	}
	/* The main */
	public static void main(String[] args) {
		new DrawStarMap().start();
	}
	/* Private constants */
	private static final int MIN_SIZE = 1;
	private static final int MAX_SIZE = 50;
	private static final int INITIAL_SIZE = 16;
	/* Private instance variables */
	private JSlider sizeSlider;
	private JComboBox<LabeledColor> colorChooser;
	private GStarName star;
	private boolean SELECTED;
	private JTextField JTF;

}

class LabeledColor {
	public Color color;
	public String label;
	public LabeledColor(String c, Color col) {
		color = col;
		label = c;
	}
	public LabeledColor() {
		color = Color.WHITE;
		label = "White";
	}
	@Override
	public String toString() {
		return label;
	}
}

class GStarName extends GStar {
	private static final long serialVersionUID = -4689099415987959511L;
	public GStarName(double width) {
		super(width);
	}
	GLabel name;
}

