/**
 * 
 */
package arrays_arraylists;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.stream.Collectors;
import acm.graphics.*;
import acm.program.*;
/**
 * 
 */
public class Dim extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;
	private static final double SIZE = 45.0;
	private static final int[] MOVEMENTS = {1, 2, 3};
	private GCompound cs;
	private int state;
	private int[] comp_move;
	private boolean player = true;

	/**
	 * @param args
	 */
	
	public void run() {
		
		addMouseListeners();
		add(circles());
		while(cs.getElementCount() > 1) {		// If elements are higher than
			// Pause 1 milisecond to not break	   1, then the game is playing	
			// the program
			pause(1);							
			if (!player) {						// If its the computer turn (being
				if (cs.getElementCount() > 1) { // player false), do this
					
					remove(cs);
					drawComputer();
					add(cs);					// Add to the canvas the painted cs
					pause(500);
					remove(cs);
					deleteComputer();
					add(cs);					// Add to the canvas the cleaned cs
					pause(500);
				}
				player = true;					// Change the turn
			}
		}

	}
	
	// If its the player turn, paint the cs circles
	public void mousePressed(MouseEvent e) {
		
		if (player) {
			double x = e.getX();
			double y = e.getY();
			GCompound gc = (GCompound) this.getElementAt(x, y);
			GOval go = (GOval) gc.getElementAt(x, y);
			if (validator(go)) {
				painter(go, Color.red);
			}
		}
		
	}
	
	// If its the player turn, paint the cs circles delete the
	// painted circles
	public void mouseReleased(MouseEvent e) {
		
		for (int i = cs.getElementCount() - 1; i > -1; i--) {
			GOval go = (GOval) cs.getElement(i);
			if (go.getFillColor() == Color.red) {
				cs.remove(go);
			}
		}
		
		player = false;							// Set the turn to the computer
		
	}
	
	// Draw the circles with the best move
	private void drawComputer() {
		comp_move = bestMove(cs.getElementCount());
		state = cs.getElementCount();
		for (int i = 0; i < comp_move[0]; i++) {
			GOval go = (GOval) cs.getElement(state - 1 - i);
			go.setFillColor(Color.yellow);
		}
	}
	
	// Delete the circles with the best move
	private void deleteComputer() {
		for (int i = 0; i < comp_move[0]; i++) {
			GOval go = (GOval) cs.getElement(state - 1 - i);
			cs.remove(go);
		}
	}
	
	// To determine if the computer has opportunities to win
	private int miniMax(int state, boolean computer) {
		
		if (state == 0) {				// If the state comes to 0
			return computer ? 1 : -1;	// then depending on the tree
		}								// send a 1 or a -1
		
										// Creates an array of integers
										// from the state minus a possible
										// movement
		ArrayList<Integer> new_statements = new ArrayList<>(Arrays.stream(MOVEMENTS)
				.filter(take -> take <= state)
				.map(take -> state - take)
				.boxed()
				.collect(Collectors.toList()));
		
		// Recursion
		return computer ?
				new_statements.stream().map(newState -> miniMax(newState, false))
				.max(Comparator.naturalOrder()).get() :		// If it's the computer turn
				new_statements.stream().map(newState -> miniMax(newState, true))
				.min(Comparator.naturalOrder()).get();		// If it's the player turn
		
	}
	
	// To determine the best move conditioned by the next players move and the possible paths
	private int[] bestMove(int state) {
		int movement, new_state, score;
		for (int mov: MOVEMENTS) {
			movement = mov;
			new_state = state - mov;
			score = miniMax(new_state, false);
			if (score > 0) {
				int[] result = {movement, score};
				return result;
			}
		}
		int[] result = {1, -1};
		return result;
	}
	
	// The player's painter
	private void painter(GOval go, Color color) {
		
		int index = 0;
		
		for (int i = 0; i < cs.getElementCount(); i++) {
			if (go == cs.getElement(i)) {
				index = i;
				break;
			}
		}
		
		for (int i = index; i < cs.getElementCount(); i++) {
			GOval gov = (GOval) cs.getElement(i);
			gov.setFillColor(color);
			gov.setFilled(true);
		}
		
	}
	
	// The validator of the possible movements
	private boolean validator(GOval go) {
		for (int i = cs.getElementCount() - 1; i > -1; i--) {
			if (go == cs.getElement(i)) {
				if (i + 3 >= cs.getElementCount()) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Create the circles
	private GCompound circles() {
		cs = new GCompound();
		for (int i = 0; i < 11; i++) {
			cs.add(circle(), SIZE * (i * (3.0 / 2.0) + 1.0 / 2.0)
					, SIZE / 2.0);
		}
		return cs;
	}
	
	// Create one circle
	private GOval circle() {
		GOval go = new GOval(SIZE, SIZE);
		go.setFillColor(Color.gray);
		go.setFilled(true);
		return go;
	}
	
	public static void main(String[] args) {
		new Dim().start();
	}
	
}
