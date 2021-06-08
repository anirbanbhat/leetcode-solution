package com.leelcode.medium;

/**
 * 
 * @author Anirban
 * 
 * Given an array of non-negative integers arr, you are initially positioned at start index of the 
 * array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach 
 * to any index with value 0.
 * 
 * Notice that you can not jump outside of the array at any time.
 * 
 * Example 1:
 * 
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation: 
 * All possible ways to reach at index 3 with value 0 are: 
 * index 5 -> index 4 -> index 1 -> index 3 
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3 
 * 
 * Example 2:
 * 
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true 
 * Explanation: 
 * One possible way to reach at index 3 with value 0 is: 
 * index 0 -> index 4 -> index 1 -> index 3
 * 
 * Example 3:
 * 
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 *  
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 *
 */

public class JumpGameIII {

	public static void main(String[] args) {
		//System.out.println(canReach(new int[] {4,2,3,0,3,1,2}, 5)); // true
		//System.out.println(canReach(new int[] {4,2,3,0,3,1,2}, 0)); // true
		//System.out.println(canReach(new int[] {3,0,2,1,2}, 2)); // false
		System.out.println(canReach(new int[] {0,1}, 1)); // false
	}

	public static boolean canReach(int[] arr, int start) {
        if(arr == null || arr.length == 0 || start<0 || start>=arr.length){
            return false;
        }
        int[] isVisited = new int[arr.length];
        return helper(isVisited, arr, start);
    }
    
    public static boolean helper(int[] isVisited, int[] arr, int index){
        if(arr[index] == 0){
            return true;
        }
        boolean leftTraversal = false;
        boolean rightTraversal = false;
        if(isVisited[index] < 1){
        	isVisited[index]++;
            if(isValid(arr, index - arr[index])){
                leftTraversal = helper(isVisited, arr, index - arr[index]);
            }
        }
        if(isVisited[index] < 2){
        	isVisited[index]++;
            if(isValid(arr, index + arr[index])){
                rightTraversal = helper(isVisited, arr, index + arr[index]);
            }
        }
        return leftTraversal || rightTraversal;
    }
    
    public static boolean isValid(int[] arr, int index){
        return index>=0 && index<arr.length;
    }
}
