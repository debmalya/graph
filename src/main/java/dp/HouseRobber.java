package dp;

import java.util.Arrays;

/**
 * You are planning to rob houses on a specific street, and you know that every
 * house on the street has a certain amount of money hidden. The only thing
 * stopping you from robbing all of them in one night is that adjacent houses on
 * the street have a connected security system. The system will automatically
 * trigger an alarm if two adjacent houses are broken into on the same night.
 * 
 * Given a list of non-negative integers nums representing the amount of money
 * hidden in each house, determine the maximum amount of money you can rob in
 * one night without triggering an alarm.
 * 
 * @author DJash
 *
 */
public class HouseRobber {
	private int[] memo;

	public int solution(int[] nums) {
		// Start with the smallest gap index 0 and index 2
		if (nums == null || nums.length == 0) {
			return 0;
		}

		this.memo = new int[100];
		// Fill with sentinel value representing not-calculated recursions.
		Arrays.fill(this.memo, -1);
		return robFrom(0, nums);
	}

	private int robFrom(int currentIndex, int[] nums) {
		if (currentIndex >= nums.length) {
			return 0;
		}

		// Return cached value.
		if (this.memo[currentIndex] > -1) {
			return this.memo[currentIndex];
		}

		// Recursive relation evaluation to get the optimal answer.
		int ans = Math.max(this.robFrom(currentIndex + 1, nums),
				this.robFrom(currentIndex + 2, nums) + nums[currentIndex]);

		// Cache for future use.
		this.memo[currentIndex] = ans;
		return ans;
	}

}
