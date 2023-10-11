package object_oriented_graphics;

import acm.program.*;
import java.awt.Color;
import acm.graphics.*;
import acm.util.*;

public class SlotMachine extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	private int money = 50;

	private void amountWon(int b1, int b2, int b3) {
		
		if (b == 0) {
			random.add(new GImage("Bar.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 1) {
			random.add(new GImage("Bell.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 2) {
			random.add(new GImage("Cherry.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 3) {
			random.add(new GImage("Lemon.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 4) {
			random.add(new GImage("Orange.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 5) {
			random.add(new GImage("Plum.jpeg"), hr * i + dv * (i + 1), dv);
		}
		
	}
	
	private void assignImage(int b, GCompound random, int i, double hr, double dv) {
		
		if (b == 0) {
			random.add(new GImage("Bar.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 1) {
			random.add(new GImage("Bell.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 2) {
			random.add(new GImage("Cherry.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 3) {
			random.add(new GImage("Lemon.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 4) {
			random.add(new GImage("Orange.jpeg"), hr * i + dv * (i + 1), dv);
		} else if(b == 5) {
			random.add(new GImage("Plum.jpeg"), hr * i + dv * (i + 1), dv);
		}
		
	}
	
	private GCompound randomLottery() {
		
		double h = getHeight();
		double w = getWidth();
		double hr = h / 2.0;
		double dv = (w - 3.0 * hr) / 4.0;
		
		GCompound random = new GCompound();
			
		int b1 = rg.nextInt(0, 5);
		int b2 = rg.nextInt(0, 5);
		int b3 = rg.nextInt(0, 5);
		
		assignImage(b1, random, 0, hr, dv);
		assignImage(b2, random, 1, hr, dv);
		assignImage(b3, random, 2, hr, dv);

		for (int i = 0; i < random.getElementCount(); i++) {
			
			GImage g = (GImage) random.getElement(i);
			g.setSize(hr, hr);
			
		}
		
		return random;
	}
	
	private GCompound machineDrawer() {
		
		double h = getHeight();
		double w = getWidth();
		double hr = h / 2.0;
		double dv = (w - 3.0 * hr) / 4.0;
		
		GCompound game = new GCompound();
		GRect r1 = new GRect(dv, dv, hr, hr);
		r1.setFillColor(Color.white);
		r1.setFilled(true);
		game.add(r1);
		
		GRect r2 = new GRect(hr + dv * 2.0, dv, hr, hr);
		r2.setFillColor(Color.white);
		r2.setFilled(true);
		game.add(r2);
		
		GRect r3 = new GRect(2.0 * hr + dv * 3.0, dv, hr, hr);
		r3.setFillColor(Color.white);
		r3.setFilled(true);
		game.add(r3);
		
		return game;
		
	}
	
	public void run() {
		
		setBackground(Color.GRAY);
		GCompound game = machineDrawer();
		add(game);
		
		while(money > 0) {
			
			waitForClick();
			GCompound lot = randomLottery();
			add(lot);
			money--;
			
		}

		
	}
	
	public static void main(String[] args) {
		
		new SlotMachine().start();
		
	}
	
	private static RandomGenerator rg = new RandomGenerator();
	
}