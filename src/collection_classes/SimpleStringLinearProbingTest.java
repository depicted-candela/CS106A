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
		ssln.put("H", "HIF");
		for (int i = 0; i < ssln.N_BUCKETS; i++) {
			HashEntryLinearProbing help = ssln.bucketArray[i];
			if (help != null) {
				System.out.print(help.getKey());
				System.out.print(": ");
				System.out.println(help.getValue());	
			} else {
				System.out.println("null: ");
			}
		}
	}

}
