/**
 * 
 */
package deb.graph.application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author debmalyajash
 *
 */
public class HRTest {
	private HR hr = new HR();

	/**
	 * Test method for {@link deb.graph.application.HR#createEmployee(int)}.
	 */
	@Test
	public final void testCreateEmployee() {
		hr.createEmployee(1);
		assertTrue(

				hr.existingEmployee(1), "Just now created employee id 1,It should be existing");
		assertFalse(hr.existingEmployee(0), "Employee id 0 does not exist");
		assertNotNull(hr.getEmployee(1));
		assertNull(hr.getEmployee(0));
	}

	/**
	 * Test method for {@link deb.graph.application.HR#assignBoss(int, int)}.
	 */
	@Test
	public final void testAssignBoss() {

	}

}
