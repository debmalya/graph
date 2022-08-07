/**
 * 
 */
package deb.string;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author debmalyajash
 *
 */
public class StringUtilTest {

	/**
	 * Test method for {@link deb.string.StringUtil#longestCommonPrefix(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testLongestCommonPrefix() {
		String actual = StringUtil.longestCommonPrefix("prefetch", "prefix");
		assertEquals("pref", actual);
	}

}
