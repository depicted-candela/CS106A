/**
 * 
 */
package object_memory_model;

/**
 * 
 */

import acm.program.*;
import objects_classes.Rational;

public class GCTest extends ConsoleProgram {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param args
	 */
	
	public void run() {
		
		Runtime myRuntime = Runtime.getRuntime();
		int i = (int) myRuntime.freeMemory();
		Rationals();
		int j = (int) myRuntime.freeMemory();
		println("Garbage collection freed " + (i - j) + " bytes");
		myRuntime.gc();
		
	}
	
	public void Rationals() {
		println("Allocating 10000 Rational objects");
		for (int i = 0; i < 10000; i++) {
			new Rational(4, 5);
		}
	}
	
	public static void main(String[] args) {
		new GCTest().start();
	}

}
