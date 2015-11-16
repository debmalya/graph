/**
 * 
 */
package deb.graph.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author debmalyajash
 *
 */
public class HR {
	
	/**
	 * This will maintain a map employee id as key
	 * employee id of that person's boss as value.
	 */
	private Map<Integer,Integer> employeeMap = new ConcurrentHashMap<>();
	/**
	 * All employees in the organization.
	 */
	private List<Employee> employeeList = new ArrayList<>();

	/**
	 * Introduce a new employee.
	 * 
	 * @param id
	 *            employee id.
	 */
	public void createEmployee(int id) {

		if (!existingEmployee(id)) {
			employeeList.add(new Employee(id));
		}
	}

	/**
	 * 
	 * @param employeeId
	 * @param bossId
	 */
	public void assignBoss(int employeeId, int bossId) {

	}

	/**
	 * Whether employee exists or not ?
	 * 
	 * @param id
	 *            - employee id.
	 * @return true if exists, false otherwise.
	 */
	public boolean existingEmployee(int id) {
		return employeeList.parallelStream()
				.filter(employee -> employee.getId() == id).count() > 0;
	}

	public Employee getEmployee(int id) {
		try {
			return employeeList.parallelStream()
					.filter(employee -> employee.getId() == id).findFirst()
					.get();
		} catch (NoSuchElementException th) {
			th.printStackTrace();
			return null;
		}
	}

}
