package com.leetcode.dynamic;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * 
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes 
 * it impossible to reach the last index.
 *  
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 * 
 * 
 * @author Anirban Bhattacherji
 *
 */

public class JumpGame {

	public static void main(String[] args) {
		JumpGame game = new JumpGame();
		System.out.println(game.canJump(new int[] {2,3,1,1,4})); // true
		System.out.println(game.canJump(new int[] {3,2,1,0,4})); // false
	}

	public boolean canJump(int[] nums) {
		if(nums.length == 0 || (nums.length > 1 && nums[0] == 0)) {
			return false;
		}
		Boolean[] dp = new Boolean[nums.length + 1];
        return canJump(nums, 0, dp);
    }
	
	public boolean canJump(int[] nums, int index, Boolean[] dp) {
		if(index >= nums.length) {
			return false;
		}
		if(index == nums.length - 1) {
			return true;
		}
		if(nums[index] == 0) {
			return false;
		}
		if(dp[index] == null) {
			int maxCount = nums[index] + index;
			int count = index;
			Boolean canJump = false;
			while(count < maxCount && count < nums.length) {
				canJump = canJump || canJump(nums, ++count, dp);
				if(canJump) {
					break;
				}
			}
			dp[index] = canJump;
		}
		return dp[index];
	}
}
