/**
 * 
 */
package collection_classes;
/**
 * 
 */
public class SparseMatrixTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SparseMatrix sm = new SparseMatrix(2);
		sm.put(0, 1, "HOls");
		sm.put(1, 1, "Hls");
		System.out.println(sm.get(0, 1));
		System.out.println(sm.get(1, 1));
		System.out.println(sm.get(1, 2));
		
	}

}
