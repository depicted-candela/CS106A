/**
 * 
 */
package collection_classes;

/**
 * 
 */
public class SimpleStringMapSortedTest {
	/**
	 * @param args
	 */
	
	public void run() {
		SimpleStringMapSorted ssms = new SimpleStringMapSorted();
		ssms.put("CA", "Cali");
		ssms.put("CA", "California");
		ssms.put("BOG", "Bogotá");
		ssms.put("MON", "Montería");
		ssms.put("BUG", "Bucaramanga");
		ssms.put("LET", "Leticia");
		ssms.put("MED", "Medellín");
		
		ssms.print();
		
		ssms.get("MED");
		
	}
	public static void main(String[] args) {
		new SimpleStringMapSortedTest().run();
	}

}