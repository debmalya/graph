/**
 * 
 */
package deb.graph;

import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class GoldMine {

	/**
	 * There are lot of teams. They will hunt for gold. Team with highest gold
	 * coins will be the winner.
	 * 
	 * Given there are N miners in the kingdom. Each miner who wants to team up
	 * with another miner has to perform a ritual. Given total M rituals are
	 * performed. Each ritual teams up two miners. If miner A and B teamed up
	 * and miner B and C teamed up, then miner A and C are also in the same
	 * team. You are given an array A where Ai is the number of gold i'th miner
	 * gathers.
	 * 
	 * Find out the highest number of gold coins.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			// First line contains an integer T. T test cases follow.
			int T = scanner.nextInt();
			scanner.nextLine();

			// T test cases follow. First line of each test case contains two
			// space-separated N and M
			int[] result = new int[T];
			for (int i = 0; i < T; i++) {
				String[] nm = scanner.nextLine().split(" ");
				int N = Integer.parseInt(nm[0]);
				int M = Integer.parseInt(nm[1]);

				// Each of the M lines contains two integers Xi and Yi, the
				// indexes of miner that perform the i'th ritual.
				int[] team = new int[N + 1];
				for (int j = 0; j < M; j++) {
					String[] mj = scanner.nextLine().split(" ");

					int f = Integer.parseInt(mj[0]);
					int s = Integer.parseInt(mj[1]);

					team[f] = s;
					// team[s] = f;

				}

				// Last line contains N space-separated integer constituting the
				// array A.
				String[] lastLine = scanner.nextLine().split(" ");
				int[] A = new int[N + 1];
				for (int j = 0; j < N; j++) {
					A[j + 1] = Integer.parseInt(lastLine[j]);
				}

				result[i] = getMax(N, team, A);

			}
			
			for (int i = 0; i < T; i++) {
				System.out.println(result[i]);
			}
		}

	}

	public static int getMax(int N, int[] team, int[] A) {
		boolean[] v = new boolean[N + 1];
		int c = 0;
		for (int j = 0; j < N; j++) {
			if (!v[j+1]) {
				int d = A[j + 1];
				v[j + 1] = true;
				int k = team[j+1];
				while (!v[k]) {
					v[k] = true;
					d += A[k];
					k = team[k];
				}
				c = Math.max(d, c);
			}
			
		}
		return c;
	}

}
