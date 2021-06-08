package com.leelcode.medium;

import java.util.Arrays;

/**
 * 
 * @author Anirban
 * 
 * Given an array nums of n integers and an integer target, find three integers in nums such 
 * that the sum is closest to target. Return the sum of the three integers. You may assume 
 * that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */

public class ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] {1, 1, 1, 0}, -100)); //2
		System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1)); //2
		System.out.println(threeSumClosest(new int[] {0,2,1,-3}, 1)); //3
		System.out.println(threeSumClosest(new int[] {1,1,-1,-1,3}, -1)); //-1
		System.out.println(threeSumClosest(new int[] {1,2,4,8,16,32,64,128}, 82)); //82
	}
	
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int returnSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
			int j = i+1;
			int k = nums.length - 1;
			while(j<k) {
				int sum = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(target - sum);
				if(sum==target) {
					return sum;
				}
				returnSum = minDiff>diff?sum:returnSum;
				minDiff = Math.min(minDiff, diff);
				if(sum<target) {
					j++;
				} else{
					k--;
				}
			}
		}
        return returnSum;
    }

}
