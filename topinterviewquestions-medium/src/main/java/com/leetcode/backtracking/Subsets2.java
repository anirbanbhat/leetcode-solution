package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		System.out.println(subsets(nums));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int elements = (int) Math.pow(2, nums.length);
		for (int i = 0; i < elements; i++) {
			List<Integer> currentList = new ArrayList<>();
			for (int j = 0; j < nums.length; j++) {
				if((i & (1 << j)) > 0) {
					currentList.add(nums[j]);
				}
			}
			result.add(currentList);
		}
		return result;
	}
}
