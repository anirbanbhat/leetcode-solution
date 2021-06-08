package com.leetcode.easy;

/**
 * 
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
 * representing the number of elements in nums1 and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should 
 * be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * 
 * Example 2:
 * 
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * 
 * Example 3:
 * 
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *  
 * 
 * Constraints:
 * 
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *  
 * 
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * 
 * @author Anirban Bhattacherji
 *
 */

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] arr1 = new int[] {0};
		int[] arr2 = new int[] {1};
		printArray(arr1);
		printArray(arr2);
		merge(arr1, 0, arr2, 1);
		printArray(arr1);
		printArray(arr2);
		arr1 = new int[] {1,2,3,0,0,0};
		arr2 = new int[] {2,5,6};
		printArray(arr1);
		printArray(arr2);
		merge(arr1, 3, arr2, 3);
		printArray(arr1);
		printArray(arr2);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length - m > 0){
            mergeHelper(nums1, m - 1, nums2, n - 1);
        } else {
            mergeHelper(nums2, n - 1, nums1, m - 1);
        }
    }
    
    public static void mergeHelper(int[] large, int l, int[] small, int s) {
        int index = large.length - 1;
        while(index >= 0 && l >= 0 && s >= 0) {
            if(large[l] > small[s]) {
                large[index--]= large[l--];
            } else {
                large[index--]= small[s--];
            }
        }
        while(index >= 0 && s >= 0) {
            large[index--]= small[s--];
        }
        while(index >= 0 && l >= 0) {
            large[index--]= large[l--];
        }       
    }
    
    public static void printArray(int[] arr) {
    	String prefix = "[ ";
    	for(int val: arr) {
    		System.out.print(prefix + val);
    		prefix = ",\t";
    	}
    	System.out.println("]");
    }
}
