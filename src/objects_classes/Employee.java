/**
 * 
 */
package objects_classes;

/**
 * @author nicalcoca
 *
 */


public class Employee {
	
	/**
	 * @param args
	 */
	
	private String name;
	private String supervisor;
	private double salary;
	
	public Employee (String n, String s, double sa) {
		
		setName(n);
		setSupervisor(s);
		setSalary(sa);
		
	}
	
	public void setName(String n) {
		
		this.name = n;
		
	}
	
	public void setSupervisor(String n) {
		
		this.supervisor = n;
		
	}
	
	public void setSalary(double s) {
		
		this.salary = s;
		
	}
	
	public double getSalary() {
		
		return this.salary;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public String getSupervisor() {
		
		return this.supervisor;
		
	}
	

}
