package com.leetcode.sortingandsearching;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 * 
 * @author Anirban Bhattacherji
 *
 */

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] result = topKFrequent(new int[] {1,1,1,2,2,3}, 2);
		String prefix = "[";
		for (int i : result) {
			System.out.print(prefix + i);
			prefix = ", ";
		}
		System.out.println("]");
	}

	public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[k];
        // initialize map
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
                                (e1, e2) -> e2.getValue() - e1.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            q.offer(entry);
        }
        for(int i = 0; i < k; i++){
            arr[i] = q.poll().getKey();
            if(q.isEmpty()){
                break;
            }
        }
        return arr;
    }
}
