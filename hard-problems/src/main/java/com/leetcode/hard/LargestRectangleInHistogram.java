package com.leetcode.hard;

import java.util.Stack;

/**
 * 
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 
 * 1, return the area of the largest rectangle in the histogram.
 * 
 * Example 1:
 *        _                _ 
 *      _| |             _| |
 *     | | |            |///|
 *     | | |  _         |///|  _
 *  _  | | |_| | =>  _  |10 |_| |
 * | |_| | | | |    | |_|///| | |
 * |2|1|5|6|2|3|    |2|1|///|2|3|
 * 
 * @author Anirban Bhattacherji
 *
 */

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] arr = new int[] {2, 1, 5, 6, 2, 3};
		printArray(arr);
		System.out.println(largestRectangleArea(arr));
	}
	
    public static int largestRectangleArea(int[] heights) {
    	Stack<Integer> stack = new Stack<>();
    	int max = 0;
    	for(int i = 0; i <= heights.length; i++) {
    		int h = (i == heights.length? 0 : heights[i]);
    		if(stack.isEmpty() || h >= heights[stack.peek()]) {
    			stack.push(i);
    		} else {
    			int top = stack.pop();
    			max = Math.max(max, heights[top] * (stack.isEmpty()? i : i - 1 - stack.peek()));
    			i--;
    		}
    	}
        return max;
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
