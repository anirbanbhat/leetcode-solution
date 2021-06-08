package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 * @author Anirban Bhattacherji
 *
 */

public class Subsets {

	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		System.out.println(subsets.subsets(new int[] {1, 2, 3}));
		System.out.println(subsets.subsets(new int[] {1, 2, 3, 4}));
	}

	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Math.pow(2, nums.length) is the number of possible subLists
        for(int i = 0; i < Math.pow(2, nums.length); i++){
            list.add(subsets(nums, i));
        }
        return list;
    }
    
    public List<Integer> subsets(int[] nums, int i) {
        List<Integer> list = new ArrayList<>();
        for(int j = 0; j < nums.length; j++){
        	// We will shift the bit of 1 with the number of length of the array.
        	// i & (bit shift of 1) gives if the possibility if we should include
        	// the value of current position of the array or not.
            if((i & (1 << j)) > 0){
                list.add(nums[j]);
            }
        }
        return list;
    }
}
