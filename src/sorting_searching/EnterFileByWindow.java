/**
 * 
 */

package sorting_searching;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import acm.program.*;

/**
 * 
 */

public class EnterFileByWindow extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	private BufferedReader openFileReaderUsingChooser() {
		
		BufferedReader rd = null;
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				File file = chooser.getSelectedFile();
				rd = new BufferedReader(new FileReader(file));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
		
	}
	
	public void run() {
		openFileReaderUsingChooser();
	}
	
	public static void main(String[] args) {
		new EnterFileByWindow().start();
	}

}
