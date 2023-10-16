package object_oriented_graphics;

import acm.program.*;
import java.awt.Color;
import java.awt.Font;

import acm.graphics.*;
import acm.util.*;

public class SlotMachine extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	private int money = 50;
	private int win = 0;

	private void amountWon(int b1, int b2, int b3) {
		
		if (b1 == 2) {
			
			money += 2;
			win += 2;
			
			if (b2 == 2) {
				
				money += 3;
				win += 3;
				
				if (b3 == 2) {
					
					money += 2;
					win += 2;
					
				}
			
			}
			
		} else if(b1 == 4) {
			
			if(b2 == 4) {
				
				if (b3 == 4 || b3 == 0) {
					
					money += 10;
					win += 10;
					
				}
				
			}
			
		} else if(b1 == 5) {
			
			if(b2 == 5) {
				
				if (b3 == 5 || b3 == 0) {
					
					money += 14;
					win += 14;
					
				}
				
			}
			
		} else if(b1 == 1) {
			
			if(b2 == 1) {
				
				if (b3 == 1 || b3 == 0) {
					
					money += 20;
					win += 20;
					
				}
				
			}
			
		} else if(b1 == 0) {
			
			if(b2 == 0) {
				
				if (b3 == 0) {
					
					money += 250;
					win += 250;
					
				}
				
			}
			
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
		
		amountWon(b1, b2, b3);
		
		return random;
	}
	
	private GCompound machineDrawer(String s1, String s2, String s3) {
		
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
		
		GLabel l1 = new GLabel(s1, dv, hr + 3 * dv);
		l1.setFont(new Font("Serif", Font.PLAIN, 28));
		l1.setColor(Color.white);
		game.add(l1);
		
		GLabel l2 = new GLabel(s2, dv, hr + 5 * dv);
		l2.setFont(new Font("Serif", Font.PLAIN, 28));
		l2.setColor(Color.white);
		game.add(l2);
		
		GLabel l3 = new GLabel(s3, dv, hr + 7 * dv);
		l3.setFont(new Font("Serif", Font.PLAIN, 28));
		l3.setColor(Color.white);
		game.add(l3);
		
		return game;
		
	}
	
	public void run() {
		
		setBackground(Color.GRAY);
		GCompound game = machineDrawer("Welcome to the slot machine!",
				"You now have $50.",
				"Click to play.");
		add(game);
		
		while(money > 0) {
			
			waitForClick();
			money--;
			remove(game);
			GCompound lot = randomLottery();
			String s1 = "You win $" + Integer.toString(win);
			String s2 = "You now have $" + Integer.toString(money) + ".";
			game = machineDrawer(s1, s2, "Click to play.");
			add(game);
			add(lot);
			win = 0;
			
		}

		
	}
	
	public static void main(String[] args) {
		
		new SlotMachine().start();
		
	}
	
	private static RandomGenerator rg = new RandomGenerator();
	
}