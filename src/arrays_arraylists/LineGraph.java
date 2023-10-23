/**
 * 
 */
package arrays_arraylists;
import acm.program.*;
import acm.graphics.*;
/**
 * 
 */
public class LineGraph extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		
		double[] line = {0.0, 100.0, 250.0, 300.0, 400.0, 500.0};
		double max = max(line);
		double height = getHeight();
		double width = getWidth();
		add(points(line, height, width, max), SIZE, SIZE);
		add(lines(line, height, width, max));
		
	}
	
	private GCompound points(double[] line, double height, double width, double max) {
		
		width = ((width - SIZE * 3) / (line.length - 1));
		height = height - SIZE * 3;
		GCompound gc = new GCompound();
		double y;
		for (int i = 0; i < line.length; i++) {
			GOval p = new GOval(SIZE, SIZE);
			y = line[i] / max;
			y = height * (1 - y);
			gc.add(p, i * width, y);
		}
		return gc;
		
	}
	
	private GCompound lines(double[] line, double height, double width, double max) {

		width = ((width - SIZE * 2) / (line.length - 1));
		double height_t = height - SIZE * 2;
		GCompound gc = new GCompound();
		double y1;
		double y2;
		
		for (int i = 0; i < line.length - 1; i++) {
			
			y1 = line[i] / max;
			y1 = (height_t * (1 - y1)) - (SIZE / 2.0);
			y2 = line[i + 1] / max;
			y2 = height_t * (1 - y2);
			
			GLine l = new GLine(
					i * width,
					y1,
					(i + 1) * width,
					y2);
			
			add(l, i * width + (3 * SIZE / 2.0), y1 + SIZE);
			
		}
		
		return gc;
		
	}
	
	private double max(double[] line) {
		double m = 0;
		for (int i = 0; i < line.length; i++) {
			if (m < line[i]) m = line[i];
		}
		return m;
	}
	
	public static void main(String[] args) {
		new LineGraph().start();
	}
	
	private static final double SIZE = 10;

}
