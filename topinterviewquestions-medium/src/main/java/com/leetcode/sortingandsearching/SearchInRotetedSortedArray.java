package com.leetcode.sortingandsearching;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 * @author Anirban Bhattacherji
 *
 */

public class SearchInRotetedSortedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 10, 15, 1, 3, 8 }, 15));
	    System.out.println(search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
	    System.out.println(search(new int[] { 5, 1, 3 }, 3));
	}

	public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[start] <= nums[mid]){ // left side is sorted in ascending order
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else { //key > nums[mid]
                    start = mid + 1;
                }
            } else { // right side is sorted in ascending order
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else { //target < nums[mid]
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
