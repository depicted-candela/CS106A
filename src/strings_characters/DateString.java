/**
 * 
 */
package strings_characters;

/**
 * @author nicalcoca
 *
 */

import acm.program.*;
import acm.util.*;

public class DateString extends ConsoleProgram {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	public void run() {
		// TODO Auto-generated method stub
		int day = readInt("day: ");
		int month = readInt("month: ");
		int year = readInt("year: ");
		println(dateString(day, month, year));

	}
	
	private String dateString(int d, int m, int y) {
		String s_day = day(d);
		String s_month = month(d);
		String s_year =  year(y);
		return s_day+"-"+s_month+"-"+s_year;
	}
	
	private String day(int d) {
		if (d > 0 && d < 32) {
			return String.valueOf(d);
		} else {
			throw new ErrorException("Day must be between 1 and 31");
		}
	}
	
	private String month(int m) {
		switch(m) {
			case 1: return "jan";
			case 2: return "feb";
			case 3: return "march";
			case 4: return "april";
			case 5: return "may";
			case 6: return "june";
			case 7: return "july";
			case 8: return "augst";
			case 9: return "sept";
			case 10: return "oct";
			case 11: return "nov";
			case 12: return "dec";
			default: throw new ErrorException("Month must be between 1 and 12");
		}
	}
	
	private String year(int y) {
		if (y < 0) throw new ErrorException("Year must be positive");
		String s_y = String.valueOf(y);
		if (s_y.length() <= 2) {
			return s_y;
		} else {
			return s_y.substring(s_y.length() - 2);
		}
	}

}
