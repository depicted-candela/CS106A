/**
 * 
 */
package collection_classes;

/**
 * 
 */
public class SimpleStringLinearProbingTest {

	/**
	 * The main.
	 * @param args
	 */
	public static void main(String[] args) {
		new SimpleStringLinearProbingTest().run();
	}
	
	public void run() {
		SimpleStringLinearProbing ssln = new SimpleStringLinearProbing();
		ssln.put("A", "ABC");
		ssln.put("C", "CDE");
		ssln.put("D", "DEF");
		ssln.put("E", "EFG");
		ssln.put("F", "FGH");
		ssln.put("G", "GHI");
		System.out.println(ssln.N_BUCKETS);
		ssln.put("H", "HIF");
		System.out.println(ssln.N_BUCKETS);
		ssln.put("H", "HIF");
		System.out.println(ssln.N_BUCKETS);
		ssln.put("H", "HIF");
		ssln.put("H", "HIF");
		ssln.put("H", "HIF");
		for (int i = 0; i < ssln.N_BUCKETS; i++) {
			if (ssln.bucketArray[i] == null) {
				System.out.println("null: ");
			} else {
				System.out.println(ssln.bucketArray[i].getKey());
			}
		}
		ssln.delete("A");
		System.out.println("Nuevo");
		for (int i = 0; i < ssln.N_BUCKETS; i++) {
			if (ssln.bucketArray[i] == null) {
				System.out.println("null: ");
			} else {
				System.out.println(ssln.bucketArray[i].getKey());
			}
		}
	}

}
