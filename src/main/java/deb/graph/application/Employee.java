/**
 * 
 */
package deb.graph.application;

import java.util.ArrayList;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class Employee {

	/**
	 * Each employee has identification and it is unique across organization.
	 */
	private int id;

	/**
	 * Each employee may or may not have subordnates.
	 */
	private List<Employee> subordinates;

	/**
	 * Constructor with employee id
	 * 
	 * @param employeeId
	 *            unique identification of employee;
	 */
	public Employee(int employeeId) {
		id = employeeId;
	}
	
	/**
	 * Add subordinate reporting to this employee.
	 * @param subordinate to report me.
	 * @return true if added successfully, false otherwise.
	 */
	public boolean addSubordinate(Employee subordinate) {
		if (subordinates == null) {
			subordinates = new ArrayList<Employee>();
		}
		if (subordinates.contains(subordinate)) {
			return false;
		}
		subordinates.add(subordinate);
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the subordinates
	 */
	public List<Employee> getSubordinates() {
		return subordinates;
	}
	
	

}
