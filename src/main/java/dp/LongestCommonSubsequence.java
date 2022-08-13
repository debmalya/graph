package dp;

public class LongestCommonSubsequence {

	public int longestCommonSubsequence(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (X[m - 1] == Y[n - 1])
			return 1 + longestCommonSubsequence(X, Y, m - 1, n - 1);
		else
			return Math.max(longestCommonSubsequence(X, Y, m, n - 1), longestCommonSubsequence(X, Y, m - 1, n));
	}
}
