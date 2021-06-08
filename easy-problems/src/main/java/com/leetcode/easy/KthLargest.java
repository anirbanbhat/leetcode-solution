package com.leetcode.easy;

import java.util.*;

/**
 * 
 * @author Anirban
 * 
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note: 
You may assume that nums' length ≥ k-1 and k ≥ 1.

2 3 4 5 8
2 3 4 5 5 8
2 3 4 5 5 8 10
2 3 4 5 6 8 9 10
 *
 */

public class KthLargest {
	
	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[]{8, 5, 4, 2});
		System.out.println(kthLargest.add(3));   // returns 4
		System.out.println(kthLargest.add(5));   // returns 5
		System.out.println(kthLargest.add(10));  // returns 5
		System.out.println(kthLargest.add(9));   // returns 8
		System.out.println(kthLargest.add(4));   // returns 8
		
		System.out.println();
		
		kthLargest = new KthLargest(1, new int[]{});
		System.out.println(kthLargest.add(-3));   // returns -3
		System.out.println(kthLargest.add(-2));   // returns -2
		System.out.println(kthLargest.add(-4));  // returns -2
		System.out.println(kthLargest.add(0));   // returns 0
		System.out.println(kthLargest.add(4));   // returns 4
		
		System.out.println();
		
		kthLargest = new KthLargest(1, new int[]{-2});
		System.out.println(kthLargest.add(-3));   // returns -2
		System.out.println(kthLargest.add(0));   // returns 0
		System.out.println(kthLargest.add(2));  // returns 2
		System.out.println(kthLargest.add(-1));   // returns 2
		System.out.println(kthLargest.add(4));   // returns 4
		
	}

	PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
    int k;
    
    public KthLargest(int k, int[] nums) {
    	if(nums!=null || nums.length!=0) {
    		for (int i : nums) {
				q.offer(i);
			}
    	}
        this.k = k;
        printQ(q);
    }
    
    public int add(int val) {
    	int size = q.size();
    	if(q==null || size<k) {
            q.offer(val);
            //printList(l);
    		return (k<=q.size())?getKthInt(q):Integer.MIN_VALUE;
        }
        q.offer(val);
        return getKthInt(q);
    }
    
    public int getKthInt(PriorityQueue<Integer> q) {
    	Iterator<Integer> it = q.iterator();
    	int val = 0;
    	int count = 0;
        while (it.hasNext()) {
        	val = it.next();
            if (count == k-1) {
                return val;
            }
            count++;
        }
        return val;
    	
    	/*int counter = 0;
    	PriorityQueue<Integer> qCopy = new PriorityQueue<Integer>();
    	int val = 0;
    	while(counter<k) {
    		val = q.poll();
    		qCopy.offer(val);
    		counter++;
    	}
    	while(!qCopy.isEmpty())
    		q.offer(qCopy.poll());
    	return val;*/
    }
    
    public void printQ(PriorityQueue<Integer> q) {
    	String prefix = "";
    	for (Integer integer : q) {
			System.out.print(prefix + integer);
			prefix = ", ";
		}
    	System.out.println();
    }

}
