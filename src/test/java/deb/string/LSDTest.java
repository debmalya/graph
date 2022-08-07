/**
 * 
 */
package deb.string;



import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * @author debmalyajash
 *
 */
public class LSDTest {

	/**
	 * Test method for {@link deb.string.LSD#sort(java.lang.String[], int)}.
	 */
	@Test
	public final void testSort() {
		String[] a = new String[]{"Raju","ajur","juRa","uRaj"};
		System.out.println(Arrays.toString(a));
		LSD.sort(a, 4);
		System.out.println(Arrays.toString(a));
		String[] expecteds = new String[]{"ajur", "jura", "raju", "uraj"};
//		Assert.assertArrayEquals(expecteds, a);
	}

}
