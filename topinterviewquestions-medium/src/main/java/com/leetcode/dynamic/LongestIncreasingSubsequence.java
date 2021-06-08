package com.leetcode.dynamic;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example:
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * Note:
 * 
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author Anirban Bhattacherji
 *
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));

	}

	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
        Integer[][] memo = new Integer[nums.length][nums.length + 1];
        return lengthOfLIS(nums, memo, -1, 0);
    }

	private int lengthOfLIS(int[] nums, Integer[][] memo, int prevIndex, int index) {
		if(index == nums.length) {
			return 0;
		}
		if(memo[prevIndex + 1][index + 1] == null) {
			memo[prevIndex + 1][index + 1] = 0;
			if(prevIndex == -1 || (prevIndex >= 0 && nums[prevIndex] < nums[index])) {
				memo[prevIndex + 1][index + 1] = 1 + lengthOfLIS(nums, memo, index, index + 1);
			}
			memo[prevIndex + 1][index + 1] = Math.max(memo[prevIndex + 1][index + 1], lengthOfLIS(nums, memo, prevIndex, index + 1));
		}
		return memo[prevIndex + 1][index + 1];
	}
}
