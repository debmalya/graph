/**
 * 
 */
package deb.string;

import java.util.ArrayList;
import java.util.List;

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
	 * @param first  String.
	 * @param second Sting.
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

	String[] composeRanges(int[] nums) {
		List<String> ranges = new ArrayList<>();

		if (nums != null && nums.length > 0) {
			StringBuilder sb = new StringBuilder("" + nums[0]);
			long prev = nums[0];
			String arrow = "->";
			boolean arrowAdded = false;
			boolean inComplete = false;
			for (int i = 1; i < nums.length; i++) {
				long first = nums[i];
				long second = prev;
				long diff = Math.abs(first - second);
				if (diff > 1) {
					if (arrowAdded) {
						sb.append(prev);
					}
					ranges.add(sb.toString());
					sb.delete(0, sb.length());
					arrowAdded = false;
					inComplete = false;
					sb.append(nums[i]);
				} else {
					if (!arrowAdded) {
						sb.append(arrow);
						arrowAdded = true;
						inComplete = true;
					}
				}
				prev = nums[i];
			}

			if (inComplete) {
				sb.append(prev);
				ranges.add(sb.toString());
				sb.delete(0, sb.length());
			}

			if (sb.length() > 0) {
				ranges.add(sb.toString());
			}

		}

		return ranges.toArray(new String[0]);
	}

}
