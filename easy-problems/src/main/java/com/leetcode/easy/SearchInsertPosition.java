package com.leetcode.easy;

public class SearchInsertPosition {

	public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
	}

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int middle = 0;
        while(start<end) {
        	middle = (start+end)/2;
        	if(nums[middle]==target)
        		return middle;
        	if(nums[middle]<target) {
        		start = middle+1;
        	} else {
        		end = middle-1;
        	}
        }
        
        if(nums[start]>target)
        	return start;
        else if(nums[end]<target)
        	return end+1;
        else 
        	return start;
    }
}
