/**
 * 
 */
package deb.string;

import java.util.Arrays;

/**
 * Least Significant Digit (LSD) sorting
 * 
 * @author debmalyajash
 *
 */
public class LSD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			String[] a = new String[args[0].length()];

			for (int i = 0; i < args[0].length(); i++) {
				a[i] = args[0].substring(i) + args[0].substring(0, i);
			}
			System.out.println(Arrays.toString(a));
			sort(a, args[0].length());
			System.out.println(Arrays.toString(a));

		} else {
			System.err.println("Usage : LSD <<String>>");
		}

	}

	/**
	 * Sort an array a[] of Strings that each have exactly W characters.
	 * 
	 * @param a
	 *            array a[] of Strings
	 * @param W
	 *            each word in the array is exactly of W characters. Sorts: one
	 *            for each character position, proceeding from right to left.
	 */
	public static void sort(String[] a, int W) {
		int N = a.length;
		// Possible number of characters (Radix)
		int radix = 256;
		String aux[] = new String[N];

		for (int d = W - 1; d > -1; d--) {
			int[] count = new int[radix + 1];

			// Compute frequency count
			for (int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}

			// Transform count into indices (looks like prefix sum)
			for (int r = 0; r < radix; r++) {
				count[r + 1] += count[r];
			}

			// Distribute
			for (int i = 0; i < N; i++) {
				int index = count[a[i].charAt(d)]++;
				aux[index] = a[i];
			}

			// Copy
			for (int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}

	}

}
