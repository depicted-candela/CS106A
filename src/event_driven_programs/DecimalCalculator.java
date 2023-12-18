/**
 * 
 */
package event_driven_programs;

import java.awt.event.ActionEvent;
import acm.gui.DoubleField;
import acm.gui.TableLayout;
import javax.swing.*;
import java.awt.*;

/**
 * 
 */
public class DecimalCalculator extends Calculator {
	private static final long serialVersionUID = 1343148358052844437L;

	/* Initializes the user interface */
	@Override
	public void init() {
		setLayout(new TableLayout(5, 4));
		display = new CalculatorDisplayDouble();
		add(display, "gridwidth=4 height=" + BUTTON_SIZE);
		addButtons();
		addActionListeners();
	}
	/* Called on each action event; the response is determined by the button */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof CalculatorButtonDouble) {
			((CalculatorButtonDouble) source).action(display);
		}
	}
	/* Adds the buttons to the calculator */
	private void addButtons() {
	    String constraint = "width=" + BUTTON_SIZE * 2 + " height=" + BUTTON_SIZE;
	    add(new DigitButtonDouble(7), constraint);
	    add(new DigitButtonDouble(8), constraint);
	    add(new DigitButtonDouble(9), constraint);
	    add(new AddButtonDouble(), constraint);
	    add(new DigitButtonDouble(4), constraint);
	    add(new DigitButtonDouble(5), constraint);
	    add(new DigitButtonDouble(6), constraint);
	    add(new SubtractButtonDouble(), constraint);
	    add(new DigitButtonDouble(1), constraint);
	    add(new DigitButtonDouble(2), constraint);
	    add(new DigitButtonDouble(3), constraint);
	    add(new MultiplyButtonDouble(), constraint);
	    add(new ClearButtonDouble(), constraint);
	    add(new DigitButtonDouble(0), constraint);

	    // Add the three buttons to the sub-panel
	    // GridLayout to fill the remaining space
	    JPanel threeButtons = new JPanel(new GridLayout(1, 3));
	    threeButtons.add(new EqualsButtonDouble());
	    threeButtons.add(new DotButton());
	    threeButtons.add(new DivideButtonDouble());

	    // Add the sub-panel to the main layout
	    add(threeButtons, "gridwidth=3 height=" + BUTTON_SIZE);
	}
	/* The main */
	public static void main(String[] args) {
		new DecimalCalculator().start();
	}
	/* Private constants and instance variables */
	protected CalculatorDisplayDouble display;
}

/*
* This class defines the display for the calculator.
*
* Implementation notes:
* This class does most of the work for the calculator application and keeps
* track not only of the number currently in the display but also the previous
* operator button (op) and the previous value from the display (memory), which
* will become the left operand of the operator. When a new operator button is
* pressed, this class calculates the new value of the display by applying
* that operator to the value in memory and the current value in the display.
* 
* It is also important to note that the behavior of digit buttons depends on
* whether an operator button is clicked. If the last click was an operator
* button, the digit buttons must clear the display to start a new value. If
* not, the digit is added to the end of the existing value. The code uses the
* boolean variable startNewValue to record this state.
*/
class CalculatorDisplayDouble extends DoubleField {
	private static final long serialVersionUID = 2806148420523915334L;
	/* Creates a new calculator display that is not directly editable by the user */
	public CalculatorDisplayDouble() {
		setEditable(false);
		setFont(new Font("SansSerif", Font.PLAIN, 24));
		setValue(0);
		startNewValue = false;
		op = null;
	}
	/* Adds a digit to the display, clearing the old value if startNewValue is set */
	public void addDigit(double digit) {
		double value = (startNewValue) ? 0 : getValue();
		String s = String.valueOf(value);
		if (s.length() < 16) {
			if (!dec) {
				setValue(10 * value + digit);
				startNewValue = false;	
			} else {
				double newvalue = digit / Math.pow(10, dec_pos);
				newvalue = value + newvalue;
				double scalingFactor = Math.pow(10, dec_pos++);
				newvalue = Math.round(newvalue * scalingFactor) / scalingFactor;
				setValue(newvalue);
				startNewValue = false;	
			}
		}
	}
	/* Sets a new operator, applying the previous one if one exists */
	public void setOperator(OperatorButtonDouble button) {
		if (op == null) {
			memory = getValue();
		} else {
			memory = op.apply(memory, getValue());
			setValue(memory);
		}
		op = button;
		startNewValue = true;
	}
	public void setDecimal(boolean decimal) {
		dec = decimal;
	}
	public void setPosDecimal() {
		dec_pos = 1;
	}
	/* Private instance variables */
	private OperatorButtonDouble op;			/* The last operator button pressed */
	private double memory;					/* The value to which the operator is applied */
	private boolean startNewValue;		/* Set after an operator to start a new value */
	private boolean dec = false;
	private int dec_pos = 1;
}

/*
* This abstract class is the superclass for every calculator button. Every button
* must define an action method, which is called whenever the button is clicked.
*/
abstract class CalculatorButtonDouble extends JButton {
	private static final long serialVersionUID = -7880262003508807956L;
	/* Creates a new CalculatorButton with the specified name */
	public CalculatorButtonDouble(String name) {
		super(name);
		setFont(new Font("SansSerif", Font.PLAIN, 10));
	}
	/* Called when the button is clicked (every subclass must implement this method) */
	public abstract void action(CalculatorDisplayDouble display);
}

/*
* This class is used for each of the digit buttons. The action consists of
* adding the digit used as a label on the button, which is returned by getText.
*/
class DigitButtonDouble extends CalculatorButtonDouble {
	private static final long serialVersionUID = 3781977749673981517L;
	/* Creates a new DigitButton for the digit n */
	public DigitButtonDouble(int n) {
		super("" + Integer.toString(n));
	}
	/* Adds this digit to the display */
	public void action(CalculatorDisplayDouble display) {
		display.addDigit(Double.parseDouble(getText()));
	}
}

/*
* This abstract class is the superclass of the various operator buttons.
* Each concrete subclass must override the apply method.
*/
abstract class OperatorButtonDouble extends CalculatorButtonDouble {
	private static final long serialVersionUID = -6532768644213867998L;
	/* Creates a new OperatorButton with the specified name */
	public OperatorButtonDouble(String name) {
		super(name);
	}
	/* Informs the display that this operator button has been clicked */
	public void action(CalculatorDisplayDouble display) {
		display.setOperator(this);
		display.setDecimal(false);
		display.setPosDecimal();
	}
	/* Applies this operator (every subclass must implement this method) */
	public abstract double apply(int lhs, int rhs);
	public abstract double apply(double lhs, double rhs);
}

/*
* The classes AddButton, SubtractButton, MultiplyButton, and DivideButton
* are the same except for their label and the implementation of apply.
*/
class AddButtonDouble extends OperatorButtonDouble {
	private static final long serialVersionUID = -667013076041252195L;
	public AddButtonDouble() { super("+"); }
	public double apply(double lhs, double rhs) { return lhs + rhs; }
	@Override
	public double apply(int lhs, int rhs) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class SubtractButtonDouble extends OperatorButtonDouble {
	private static final long serialVersionUID = -2956327432040089206L;
	public SubtractButtonDouble() { super("-"); }
	public double apply(double lhs, double rhs) { return lhs - rhs; }
	@Override
	public double apply(int lhs, int rhs) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class MultiplyButtonDouble extends OperatorButtonDouble {
	private static final long serialVersionUID = -3113624517240451051L;
	public MultiplyButtonDouble() { super("x"); }
	public double apply(double lhs, double rhs) { return lhs * rhs; }
	@Override
	public double apply(int lhs, int rhs) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class DivideButtonDouble extends OperatorButtonDouble {
	private static final long serialVersionUID = -6024627528996083129L;
	public DivideButtonDouble() { super("/"); }
	public double apply(double lhs, double rhs) { return lhs / rhs; }
	@Override
	public double apply(int lhs, int rhs) {
		// TODO Auto-generated method stub
		return 0;
	}
}

/*
* The EqualsButton class displays the current value. As it happens, this
* operation can be implemented simply by setting the operator to null.
*/
class EqualsButtonDouble extends CalculatorButtonDouble {
	private static final long serialVersionUID = 648191335049060453L;
	public EqualsButtonDouble() {
		super("=");
	}
	public void action(CalculatorDisplayDouble display) {
		display.setOperator(null);
	}
}

class DotButton extends CalculatorButtonDouble {
	private static final long serialVersionUID = 6124272237570080717L;
	public DotButton() {
		super(".");
	}
	public void action(CalculatorDisplayDouble display) {
		display.setDecimal(true);
	}
}

/*
* The ClearButton class resets the calculator by setting the operator to
* null and the display value to 0.
*/
class ClearButtonDouble extends CalculatorButtonDouble {
	private static final long serialVersionUID = -8178231965416391176L;
	public ClearButtonDouble() {
		super("C");
	}
	public void action(CalculatorDisplayDouble display) {
		display.setOperator(null);
		display.setValue(0);
		display.setPosDecimal();
	}
}
