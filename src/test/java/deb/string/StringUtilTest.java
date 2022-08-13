/**
 * 
 */
package deb.string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author debmalyajash
 *
 */
public class StringUtilTest {

	/**
	 * Test method for
	 * {@link deb.string.StringUtil#longestCommonPrefix(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testLongestCommonPrefix() {
		String actual = StringUtil.longestCommonPrefix("prefetch", "prefix");
		assertEquals("pref", actual);
	}

	@Test
	void composeRanges() {
		StringUtil stringUtil = new StringUtil();
		int[] nums = new int[] { -1, 0, 1, 2, 6, 7, 9 };
		String[] ranges = stringUtil.composeRanges(nums);
		assertAll(() -> assertEquals(3, ranges.length), () -> assertEquals("-1->2", ranges[0]),
				() -> assertEquals("6->7", ranges[1]), () -> assertEquals("9", ranges[2]));
	}

	@Test
	void composeRanges1() {
		StringUtil stringUtil = new StringUtil();
		int[] nums = new int[] { -1, 0, 1, 2, 6, 7, 9 };
		String[] ranges = stringUtil.composeRanges(nums);
		assertAll(() -> assertEquals(3, ranges.length), () -> assertEquals("-1->2", ranges[0]),
				() -> assertEquals("6->7", ranges[1]), () -> assertEquals("9", ranges[2]));

		nums = new int[] { 1, 2 };
		String[] ranges1 = stringUtil.composeRanges(nums);
		assertAll(() -> assertEquals(1, ranges1.length), () -> assertEquals("1->2", ranges1[0]));
		
		nums = new int[] { 5, 8 };
		String[] ranges2 = stringUtil.composeRanges(nums);
		assertAll(() -> assertEquals(2, ranges2.length), () -> assertEquals("5", ranges2[0]),() -> assertEquals("8", ranges2[1]));
		
		String[] ranges3 = stringUtil.composeRanges(null);
		assertAll(() -> assertEquals(0, ranges3.length));
		
		nums = new int[] { -2147483647, -2147483646, 2147483647};
		String[] ranges4 = stringUtil.composeRanges(nums);
		assertAll(() -> assertEquals(2, ranges4.length), () -> assertEquals("-2147483647->-2147483646", ranges4[0]),() -> assertEquals("2147483647", ranges4[1]));
	}

}
