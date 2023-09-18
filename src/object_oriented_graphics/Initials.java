/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import acm.graphics.*;
import acm.program.*;
import java.util.*;

public class Initials extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your initials: ");
		String initials = scanner.nextLine();
		scanner.close();
		
		GCompound initials_d = initialsConstructor(initials);
		
		add(initials_d);

	}
	
	private GCompound initialsConstructor(String s) {
		
		char chars[] = s.toCharArray();
		GCompound letter_l = new GCompound();
		GCompound initials_d = new GCompound();
		
		double x = L;
		
		for (char c: chars) {
			
			switch (c) {
			
				case 'n':
				case 'N':
					letter_l = nDrawer();
					break;
				case 'a':
				case 'A':
					letter_l = aDrawer();
					break;
				case 'c':
				case 'C':
					letter_l = cDrawer();
					break;
				default:
					System.out.println("Not supported initials, supported initials are: n, N, a, A, c and C");
					break;
					
			}
			
			initials_d.add(letter_l, x, L);
			x += L + 15;
			
		}
		
		return initials_d;
		
	}
	
	private GCompound nDrawer() {
		
		GCompound letter = new GCompound();
		
		GLine l1 = new GLine(0, 0, 0, L);
		letter.add(l1, 0, 0);
		GLine l2 = new GLine(0, 0, 0, L);
		letter.add(l2, L, 0);
		GLine l3 = new GLine(0, 0, L, L);
		letter.add(l3, 0, 0);
		return letter;
		
	}
	
	private GCompound aDrawer() {
		
		GCompound letter = new GCompound();
		
		GLine l1 = new GLine(0, L, L / 2, 0);
		letter.add(l1, 0, L);
		GLine l2 = new GLine(0, 0, L / 2, L);
		letter.add(l2, L / 2, 0);
		GLine l3 = new GLine(0, 0, L / 2, 0);
		letter.add(l3, L / 4, L * 2 / 5);
		
		return letter;
		
	}
	
	private GCompound cDrawer() {
		
		GCompound letter = new GCompound();
		
		GArc arc = new GArc(L, L, 45, 270);
		letter.add(arc, 0, 0);
		
		return letter;
		
	}
	
	private static final double L = 40;

}
