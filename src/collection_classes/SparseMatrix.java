/**
 * 
 */
package collection_classes;
import java.util.*;
/**
 * 
 */
public class SparseMatrix {
	/**
	 * 
	 */
	public SparseMatrix(Integer i) {
		HM = new HashMap<String, String>(i);
	}
	public void put(Integer x, Integer y, String s) {
		HM.put(coordsString(x, y), s);
	}
	public String get(Integer x, Integer y) {
		return HM.get(coordsString(x, y));
	}
	
	private String coordsString(Integer x, Integer y) {
		return x.toString() + "," + y.toString();
	}
	
	private HashMap<String, String> HM;
	
}
