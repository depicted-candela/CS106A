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
		SimpleStringMapSorted<String> ssms = new SimpleStringMapSorted<String>();
		ssms.put("CA", "Cali");
		ssms.put("CA", "California");
		ssms.put("BOG", "Bogotá");
		ssms.put("MON", "Montería");
		ssms.put("BUG", "Bucaramanga");
		ssms.put("LET", "Leticia");
		ssms.put("MED", "Medellín");
		ssms.put("BAR", "Barranquilla");
		ssms.put("ST", "Santa Marta");
		ssms.print();
	}
	
	public static void main(String[] args) {
		new SimpleStringMapSortedTest().run();
	}

}
