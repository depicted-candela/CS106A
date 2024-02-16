/**
 * 
 */
package sorting_searching;
import acm.util.RandomGenerator;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 */
public class Mode {

	/**
	 * 
	 */
	public Mode(int n) {
		fillDArray(n);
	}
	
	public Mode() {
		defaultDArray();
	}
	
	private void defaultDArray() {
		ald = new Double[] {1.5, 2.5, 1.5, 3.5, 2.5, 4.5, 1.5, 2.5};
		N = ald.length;
	}
	
	private void fillDArray(int n) {
		N = n;
		ald = new Double[n];
		for (int i = 0; i < n; i++) {
			ald[i] = rand.nextDouble(1, 200);
		}
	}
	
	/**
	 * Sorts an array of integers with radix sort
	 * @param array
	 */
	public void radixSort(int base) {
		String[] arrayS = doubleToStr(ald);
		for (int g = arrayS[0].length() - 1; g >= 0; g--) {
			bucketsDec(arrayS, g);
		}
		ald = strToDouble(arrayS);
	}
	
	/**
	 * Hashing to sort in radixSort
	 * @param array
	 * @param hierarchy
	 */
	private void bucketsDec(String[] array, int hierarchy) {
		ArrayList<ArrayList<String>> bucketsO = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			bucketsO.add(new ArrayList<>());
		}
		for (int i = 0; i < array.length; i++) {
			String s = array[i];
			bucketsO.get(Integer.parseInt(String.valueOf(s.charAt(hierarchy)))).add(s);
		}
		int c = 0;
		for (ArrayList<String> as: bucketsO) {
			for (String s: as) {
				array[c++] = s;
			}
		}
	}
	
	/**
	 * Transforms an array of integers to an array of Strings
	 * @param array
	 * @return
	 */
	private String[] doubleToStr(Double[] array) {
		String[] as = new String[array.length];
		String temp;
		String temp_r_s, temp_l_s;
		Integer[] maxDoubleLR 	= maxDoubleLeftRight(array);
		for (int i = 0; i < array.length; i++) {
			temp 	= String.valueOf(array[i]);
			String regex 	= "(\\d+)\\.(\\d+)?";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher;
			temp 	= String.valueOf(array[i]);
			matcher = pattern.matcher(temp);
			if (matcher.find()) {
				temp_l_s= matcher.group(1);
				if (temp_l_s.length() < maxDoubleLR[0]) {
					int dif = maxDoubleLR[0] - temp_l_s.length();
					String l = "";
					for (int s = 0; s < dif; s++) {
						l += "0";
					}
					temp_l_s = l + temp_l_s;
				}
				temp_r_s= matcher.group(2);
				if (temp_r_s.length() < maxDoubleLR[1]) {
					int dif = maxDoubleLR[1] - temp_r_s.length();
					String r = "";
					for (int s = 0; s < dif; s++) {
						r += "0";
					}
					temp_r_s += r;
				}
				as[i] = temp_l_s + temp_r_s;
			}
		}
		return as;
	}
	
	/**
	 * Transforms an Array of Strings to an Array of integers
	 * @param sarray
	 * @return
	 */
	private Double[] strToDouble(String[] sarray) {
		Double[] as = new Double[sarray.length];
		String string, s, e;
		for (int i = 0; i < sarray.length; i++) {
			string = sarray[i];
			s = string.substring(0, L);
			e = string.substring(L);
			as[i] = Double.parseDouble(s + "." + e);
		}
		return as;
	}
	
	/**
	 * Max number of numbers in the left and right side of all numbers in the array
	 * @param array
	 * @return
	 */
	private Integer[] maxDoubleLeftRight(Double[] array) {
		Integer m_r		= 0;
		Integer m_l		= 0;
		String regex 	= "(\\d+)\\.(\\d+)?";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		String temp, temp_l, temp_r = null;	
		for (int i = 0; i < array.length; i++) {
			temp 	= String.valueOf(array[i]);
			matcher = pattern.matcher(temp);
			if (matcher.find()) {
				temp_l = matcher.group(1);
				temp_r = matcher.group(2);
				if (temp_l.length() > m_l) m_l = temp_l.length();
				if (temp_r.length() > m_r) m_r = temp_r.length();
			}
		}
		L = m_l;
		return new Integer[] {m_l, m_r};
	}
	
	private void modesCreator() {
		Double init	= null;
		Double d;
		for (int i = 0; i < N; i++) {
			d = ald[i];
			if (init == null) {
				MODES.put(d, 1);
				init = d;
			} else if (init.doubleValue() != d.doubleValue()) {
				MODES.put(d, 1);
				init = d;
			} else if (init.doubleValue() == d.doubleValue()) {
				MODES.replace(d, MODES.get(d) + 1);
			}
		}
	}
	
	private void printModes() {
		System.out.println("");
		if (MAXMODES.size() > 1) {
			System.out.print("The modals are: ");
			for (Double d : MAXMODES) {
				System.out.print(d + " ");
			}
		} else {
			System.out.print("The modals is: " + MAXMODES.get(0));
		}

	}
	
	private void mode() {
		radixSort(10);
		modesCreator();
		Integer max_t = 0;
		Integer mm;
		for (Entry<Double, Integer> me : MODES.entrySet()) {
			mm 	= me.getValue();
			if (mm > max_t) {
				max_t = mm;
				MAXMODES.clear();
				MAXMODES.add(me.getKey());
			} else if (mm == max_t) {
				MAXMODES.add(me.getKey());
			} else {
				continue;
			}
		}
		printModes();
	}
	
	
	public void printArray() {
		System.out.println("");
		for (Double d : ald) {
			System.out.print(d + " ");
			System.out.println("");
		}
	}
	
	public void run() {
		mode();
		printArray();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Mode(10).run();
		new Mode().run();
	}
	
	private static RandomGenerator rand = new RandomGenerator();
	private Double[] ald;
	private HashMap<Double, Integer> MODES 		=  new HashMap<>();
	private ArrayList<Double> MAXMODES 	=  new ArrayList<>();
	private Integer N, L;
	
}
