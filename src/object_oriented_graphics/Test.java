/*
* File: FancyHello.java
* ---------------------
* This program displays a fancier "hello, world" message.
*/

package object_oriented_graphics;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Test extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	public void run() {
		
		GLabel label = new GLabel("hello, world");
		label.setFont("C059-12");
		label.setColor(Color.MAGENTA);
		double x = (getWidth() - label.getWidth()) / 2;
		double y = (getHeight() + label.getAscent()) / 2;
		add(label, x, y);
	}
	
	public static void main(String[] args) {
		new Test().start();
	}
	
}