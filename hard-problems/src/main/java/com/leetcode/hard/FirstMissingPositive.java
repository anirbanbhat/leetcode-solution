package com.leetcode.hard;

public class FirstMissingPositive {

	public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1, 3, 6, 4, 1, 2}));
        System.out.println(firstMissingPositive(new int[] {1, 2, 3}));
        System.out.println(firstMissingPositive(new int[] {-1, -2}));
	}
	
	public static int firstMissingPositive(int[] nums) {
		if(nums==null || nums.length == 0) {
			return 1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			while(num>0 && num<nums.length && num != nums[num-1]) {
				int temp = nums[num-1];
				nums[num-1] = num;
				nums[i] = temp;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != i+1) {
				return i+1;
			}
		}
		return nums[nums.length-1] + 1;
	}

}
