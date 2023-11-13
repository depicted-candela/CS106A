/**
 * 
 */
package collection_classes;

/**
 * 
 */
public class SimpleStringMapRehashedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SimpleStringMapRehashedTest().run();
	}
	public void run() {
		SimpleStringMapRehased ssmr = new SimpleStringMapRehased();
		ssmr.put("A", "ABC");
		ssmr.put("B", "BCD");
		ssmr.put("C", "CDE");
		ssmr.put("D", "DEF");
		ssmr.put("E", "EFG");
		ssmr.put("F", "FGH");
		ssmr.put("G", "GHI");
		ssmr.put("H", "HIF");
		System.out.println(ssmr.get("H"));
	}

}