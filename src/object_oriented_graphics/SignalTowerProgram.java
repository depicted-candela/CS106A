/**
 * 
 */
package object_oriented_graphics;

/**
 * @author nicalcoca
 *
 */

import java.awt.event.*;
import acm.graphics.GCanvas;
import acm.program.*;

public class SignalTowerProgram extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		GCanvas cg = getGCanvas();
		cg.setAutoRepaintFlag(true);
		
		addMouseListeners();
		
		double HEIGHT = this.getHeight();
		double T_HEIGHT = HEIGHT * 2.0 / 5.0;
		double T_POS = HEIGHT * 1.0 / 9.0;
		double WIDTH = getWidth();
		double WIDTH_BOX = WIDTH / 9.0;
		double T_WIDTH = WIDTH / 34.0;
		
		SignalTower[] towers = new SignalTower[9];
		
		// TODO Auto-generated method stub
		SignalTower rohan = new SignalTower("Rohan", null, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[0] = rohan;
		towers[0].addMouseListener(new TowerClickListener(towers, 0));
		add(rohan, WIDTH_BOX * 8.0, 0.0);
		SignalTower halifirien = new SignalTower("Halifirien", rohan, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[1] = halifirien;
		towers[1].addMouseListener(new TowerClickListener(towers, 1));
		add(halifirien, WIDTH_BOX * 7.0, 0.0);
		SignalTower calenhad = new SignalTower("Calenhad", halifirien, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[2] = calenhad;
		towers[2].addMouseListener(new TowerClickListener(towers, 2));
		add(calenhad, WIDTH_BOX * 6.0, 0.0);
		SignalTower minRimmon = new SignalTower("Min-Rimmon", calenhad, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[3] = minRimmon;
		towers[3].addMouseListener(new TowerClickListener(towers, 3));
		add(minRimmon, WIDTH_BOX * 5.0, 0.0);
		SignalTower erelas = new SignalTower("Erelas", minRimmon, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[4] = erelas;
		towers[4].addMouseListener(new TowerClickListener(towers, 4));
		add(erelas, WIDTH_BOX * 4.0, 0.0);
		SignalTower nardol = new SignalTower("Nardol", erelas, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[5] = nardol;
		towers[5].addMouseListener(new TowerClickListener(towers, 5));
		add(nardol, WIDTH_BOX * 3.0, 0.0);
		SignalTower eilenach = new SignalTower("Eilenach", nardol, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[6] = eilenach;
		towers[6].addMouseListener(new TowerClickListener(towers, 6));
		add(eilenach, WIDTH_BOX * 2.0, 0.0);
		SignalTower amonDin = new SignalTower("Amon Din", eilenach, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[7] = amonDin;
		towers[7].addMouseListener(new TowerClickListener(towers, 7));
		add(amonDin, WIDTH_BOX * 1.0, 0.0);
		SignalTower minasTirith = new SignalTower("Minas Tirith", amonDin, T_WIDTH, T_HEIGHT, T_POS, WIDTH_BOX);
		towers[8] = minasTirith;
		towers[8].addMouseListener(new TowerClickListener(towers, 8));
		add(minasTirith, WIDTH_BOX * 0.0, 0.0);
		
	} 
	
	private class TowerClickListener extends MouseAdapter {
		
		private SignalTower[] towers;
		private int index;
		
		public TowerClickListener(SignalTower[] towers, int index) {
			this.index = index;
			this.towers = towers;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			SignalTower clickedTower = towers[index];
			clickedTower.signal();
		}
		
	}
	
	public static void main(String[] args) {
		
		new SignalTowerProgram().start();
		
	}

}
