/**
 * 
 */
package deb.string;



import org.junit.Assert;
import org.junit.Test;

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
		Assert.assertEquals("pref", actual);
	}

}
