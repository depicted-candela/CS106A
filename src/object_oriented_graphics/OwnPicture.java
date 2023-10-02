package object_oriented_graphics;

import acm.program.*;
import acm.graphics.*;

public class OwnPicture extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	
	public void run() {
		
		GImage im = new GImage("img.jpeg");
		im.setSize(getWidth(), getHeight());
		add(im);
		
	}
	
	public static void main(String[] args) {
		
		new OwnPicture().start();
		
	}
	
}
