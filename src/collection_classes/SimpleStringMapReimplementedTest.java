/**
 * 
 */
package collection_classes;
/**
 * 
 */
public class SimpleStringMapReimplementedTest {
	/**
	 * @param args
	 */
	public void run() {
		SimpleStringMapReimplemented objects = new SimpleStringMapReimplemented();
		objects.put("BTA", "Bogotá");
		objects.put("CLI", "Cali");
		objects.put("DAB", "Dabeiba");
		objects.put("BTA", "Bogotá");
		objects.put("CLI", "Cali");
		objects.put("DAB", "Dabeiba");
		objects.put("CAC", "Cáceres");
		objects.put("PBE", "Puerto Berrío");
		objects.put("YON", "Yondó");
		System.out.println(objects.get("BTA"));
		System.out.println(objects.get("CLI"));
	}
	public static void main(String[] args) {
		new SimpleStringMapReimplementedTest().run();
	}

}
