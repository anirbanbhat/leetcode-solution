package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author Anirban Bhattacherji
 * 
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 * 
 */

public class Permutations {

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		System.out.println(permute(nums));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<List<Integer>> permutations = new LinkedList<>();
		permutations.add(new ArrayList<>());
		
		for (int currentNum : nums) {
			int n = permutations.size();
			for(int i = 0; i < n; i++) {
				List<Integer> oldPermutation = permutations.poll();
				for (int j = 0; j <= oldPermutation.size(); j++) {
					List<Integer> newPermutation = new ArrayList<>(oldPermutation);
					newPermutation.add(j, currentNum);
					if(newPermutation.size() == nums.length) {
						result.add(newPermutation);
					} else {
						permutations.add(newPermutation);
					}
				}
			}
		}
		return result;
	}
}
