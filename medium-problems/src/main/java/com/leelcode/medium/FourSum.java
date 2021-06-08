package com.leelcode.medium;

import java.util.*;

/**
 * 
 * @author Anirban
 * 
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that 
a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

 *
 */

public class FourSum {

	public static void main(String[] args) {
		
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) {
        	return result;
        }
		Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++) {
        	if(i>0 && nums[i]==nums[i-1]) {
        		continue;
        	}
        	for (int j = i+1; j < nums.length; j++) {
        		if(j>i+1 && nums[j]==nums[j-1]) {
            		continue;
            	}
        		int k=j+1;
        		int l=nums.length-1;
        		while(k<l) {
        			if(l<nums.length-1 && nums[l]==nums[l+1]) {
        				l--;
        				continue;
        			}
        			if((nums[i] + nums[j] + nums[k] + nums[l])>target) {
        				l--;
        			}else if((nums[i] + nums[j] + nums[k] + nums[l])<target) {
        				k++;
        				continue;
        			} else {
        				result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
        				k++;
        				l--;
        			}
        		}
			}
        }
        return result;
    }
}
