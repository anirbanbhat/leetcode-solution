package com.leetcode.easy;

/**
 * 
 * @author Anirban
 * Given an array nums, write a function to move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = new int[] {0,1,0,3,12};
		moveZeroes(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		moveZeroes2(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
		nums = new int[] {1, 0, 1};
		System.out.println();
		moveZeroes2(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
		nums = new int[] {0, 0, 1};
		System.out.println();
		moveZeroes2(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
		nums = new int[] {};
		System.out.println();
		moveZeroes2(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
		nums = new int[] {1, 3, 8};
		System.out.println();
		moveZeroes2(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
	}

	public static void moveZeroes(int[] nums) {
        int lastIndex = nums.length - 1;
        for(int start = lastIndex - 1; start >= 0; start--){
            int i = start;
            if(nums[i] == 0){
                while(i < lastIndex){
                    nums[i + 1] = nums[i] + nums[i + 1];
                    nums[i] = nums[i + 1]  - nums[i];
                    nums[i + 1] = nums[i + 1]  - nums[i];
                    i++;
                }
                lastIndex--;
            }
        }
    }
	public static void moveZeroes2(int[] nums) {
		int start = 0;
        while(start < nums.length && nums[start] != 0){
            start++;
        }
        int end = start;
        while(end < nums.length && nums[end] == 0){
            end++;
        }
        while(end < nums.length) {
        	if(nums[start] == 0 && nums[end] != 0) {
        		nums[start] = nums[start] + nums[end];
                nums[end] = nums[start]  - nums[end];
                nums[start] = nums[start]  - nums[end];
                while(start<nums.length && nums[start]!=0){
                    start++;
                }
                while(end<nums.length && nums[end]==0){
                    end++;
                }
        	} else {
        		end++;
        	} 
        }
    }
}
