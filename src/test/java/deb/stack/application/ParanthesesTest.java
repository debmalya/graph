/**
 * 
 */
package deb.stack.application;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

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
		Assert.assertTrue(Parantheses.isProperlyBalanced("[()]{}{[()()]()}"));
		Assert.assertFalse(Parantheses.isProperlyBalanced("[(]"));
		Assert.assertFalse(Parantheses.isProperlyBalanced("[("));
		Assert.assertTrue(Parantheses.isProperlyBalanced("[()]"));
	}

}
