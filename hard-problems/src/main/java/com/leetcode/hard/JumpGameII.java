package com.leetcode.hard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
 * @author Anirban
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * 
 * You can assume that you can always reach the last index.
 *
 */

public class JumpGameII {

	public static void main(String[] args) throws IOException {
		//System.out.println(jump(new int[] {2,3,1,1,4}));
		//System.out.println(jump(new int[] {2,3,0,1,4}));
		BufferedReader brTest = new BufferedReader(new FileReader("src/main/resources/com/leetcode/hard/JumpGameII-testcase1.txt"));
		String[] str = brTest.readLine().split(",");
		int[] array = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		System.out.println(bottomUp(array));
		brTest.close();
	}

	public static int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Integer[] topDown = new Integer[nums.length];
        return helper(topDown, nums, 0);
    }
    public static int helper(Integer[] topDown, int[] nums, int index){
        if(index == nums.length-1){
            return 0;
        }
        if(nums[index]==0){
            return Integer.MAX_VALUE;
        }else if(topDown[index] == null){
            int totalJumps = Integer.MAX_VALUE;
            int start = index + 1;
            int end = index + nums[index];
            while(start < nums.length && start <= end) {
            	int minJumps = helper(topDown, nums, start++);
                if(minJumps != Integer.MAX_VALUE) {
                	totalJumps = Math.min(totalJumps, minJumps + 1);
                }
            }
            topDown[index] = totalJumps;
        }
        return topDown[index];
    }
    
	public static int bottomUp(int[] jumps) {
		int[] dp = new int[jumps.length];

		// initialize with infinity, except the first index which should be zero as we
		// start from there
		for (int i = 1; i < jumps.length; i++)
			dp[i] = Integer.MAX_VALUE;

		for (int start = 0; start < jumps.length - 1; start++) {
			for (int end = start + 1; end <= start + jumps[start] && end < jumps.length; end++)
				dp[end] = Math.min(dp[end], dp[start] + 1);
		}

		return dp[jumps.length - 1];
	}
}
