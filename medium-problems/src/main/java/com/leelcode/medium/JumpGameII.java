package com.leelcode.medium;

/**
 * 
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Example 2:
 * 
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *  
 * Constraints:
 * 
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 * 
 * @author Anirban Bhattacherji
 *
 */

public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII aj = new JumpGameII();
	    int[] jumps = {2, 1, 1, 1, 4};
	    System.out.println(aj.jumpTopDown(jumps));
	    jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
	    System.out.println(aj.jump(jumps));
	}

	public int jump(int[] nums) {
		int[] dp = new int[nums.length];

		// initialize with infinity, except the first index which should be zero as we
		// start from there
		for (int i = 1; i < nums.length; i++)
			dp[i] = Integer.MAX_VALUE;

		for (int start = 0; start < nums.length - 1; start++) {
			for (int end = start + 1; end <= start + nums[start] && end < nums.length; end++)
				dp[end] = Math.min(dp[end], dp[start] + 1);
		}

		return dp[nums.length - 1];
	}
	
	public int jumpTopDown(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return jumpTopDown(nums, memo, 0);
    }
    
    private int jumpTopDown(int[] nums, Integer[] memo, int index){
        if(index == nums.length - 1){
            return 0;
        }
        if(nums[index] == 0){
            memo[index] = Integer.MAX_VALUE;
        }
        if(memo[index] == null){
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= nums[index] && i < nums.length - index; i++){
                int current = jumpTopDown(nums, memo, index + i);
                if(current != Integer.MAX_VALUE){
                    min = Math.min(min, current + 1);
                }
            }
            memo[index] = min;
        }
        return memo[index];
    }
}
