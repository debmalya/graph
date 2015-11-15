/**
 * 
 */
package deb.graph.application;

import org.junit.Assert;
import org.junit.Test;

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
		Assert.assertTrue(
				"Just now created employee id 1,It should be existing",
				hr.existingEmployee(1));
		Assert.assertFalse("Employee id 0 does not exist",hr.existingEmployee(0));
	}

	/**
	 * Test method for {@link deb.graph.application.HR#assignBoss(int, int)}.
	 */
	@Test
	public final void testAssignBoss() {
		
	}

	

}
