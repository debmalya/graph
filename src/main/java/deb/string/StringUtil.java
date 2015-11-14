/**
 * 
 */
package deb.string;

/**
 * @author debmalyajash
 *
 */
public class StringUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns longest common prefix of the two string.
	 * 
	 * @param first
	 *            String.
	 * @param second
	 *            Sting.
	 * @return Longest common prefix.
	 */
	public static String longestCommonPrefix(String first, String second) {
		int m = Math.min(first.length(), second.length());
		for (int i = 0; i < m; i++) {
			if (first.charAt(i) != second.charAt(i)) {
				return first.substring(0, i);
			}

		}
		return first.substring(0, m);
	}

}
