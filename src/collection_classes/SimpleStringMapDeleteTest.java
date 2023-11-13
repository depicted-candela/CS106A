/**
 * 
 */
package collection_classes;

/**
 * 
 */
public class SimpleStringMapDeleteTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SimpleStringMapDeleteTest().run();
	}
	public void run() {
		SimpleStringMapDelete ssmp = new SimpleStringMapDelete();
		ssmp.put("A", "ABC");
		ssmp.put("B", "BCD");
		ssmp.put("C", "CDE");
		ssmp.put("D", "DEF");
		ssmp.put("E", "EFG");
		ssmp.put("F", "FGH");
		ssmp.put("G", "GHI");
		ssmp.put("H", "HIF");
		System.out.println(ssmp.get("H"));
	}
}
