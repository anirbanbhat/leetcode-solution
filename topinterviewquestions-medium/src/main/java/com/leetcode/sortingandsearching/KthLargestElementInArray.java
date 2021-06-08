package com.leetcode.sortingandsearching;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted 
 * order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author Anirban Bhattacherji
 *
 */

public class KthLargestElementInArray {

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2)); // 5
		System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4)); // 4
		System.out.println(findKthLargest(new int[] {-1, -1}, 2)); // 4
	}

	public static int findKthLargest(int[] nums, int k) {
        if(nums.length == 0 || k == 0){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        while(pq.size() < k){
            pq.offer(nums[count++]);
        }
        while(count < nums.length){
            if(nums[count] >= pq.peek()){
            	pq.poll();
                pq.offer(nums[count]);
            }
            count++;
        }
        return pq.peek();
    }
}
