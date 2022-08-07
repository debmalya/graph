/**
 * 
 */
package deb.stack.application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author debmalyajash
 *
 */
public class ParanthesesTest {

	/**
	 * Test method for {@link deb.stack.application.Parantheses#isProperlyBalanced(java.lang.String)}.
	 */
	@Test
	public final void testIsProperlyBalanced() {
		assertTrue(Parantheses.isProperlyBalanced("[()]{}{[()()]()}"));
		assertFalse(Parantheses.isProperlyBalanced("[(]"));
		assertFalse(Parantheses.isProperlyBalanced("[("));
		assertTrue(Parantheses.isProperlyBalanced("[()]"));
	}

}
