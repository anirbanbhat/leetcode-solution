package com.leelcode.medium;

/**
 * 
 * @author Anirban
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water 
 * (blue section) the container can contain is 49.
 * 
 * Example:
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 */

public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxAreaTopDown(new int[] {1,8,6,2,5,4,8,3,7}));
		
		System.out.println(maxAreabottomUp(new int[] {1,8,6,2,5,4,8,3,7}));
		
		System.out.println(maxAreaIterative(new int[] {1,8,6,2,5,4,8,3,7}));
		
		System.out.println(maxAreaIterative(new int[] {1,1}));
		
		System.out.println(maxAreaBestApproach(new int[] {1,8,6,2,5,4,8,3,7}));
		
		System.out.println(maxAreaBestApproach(new int[] {1,1}));
	}
	
	public static int maxAreaBestApproach(int[] height) {
        int maxArea = 0, left = 0, right = height.length-1;
        while(left<right) {
        	int currentArea = Math.min(height[left], height[right])*(right-left);
        	maxArea = Math.max(maxArea, currentArea);
        	if(height[left]<height[right]) {
        		left++;
        	} else {
        		right--;
        	}
        }
        return maxArea;
    }

	public static int maxAreaTopDown(int[] height) {
        Integer[][] dp = new Integer[height.length][height.length];
        return maxAreaTopDown(0, height.length - 1, height, dp);
    }
    
    public static int maxAreaTopDown(int startIndex, int endIndex, int[] height, Integer[][] dp){
        if(startIndex>endIndex || startIndex==endIndex){
            return 0;
        }
        if(dp[startIndex][endIndex] == null){
            int max1 = Math.min(height[startIndex], height[endIndex]) * (endIndex - startIndex);
            int max2 = Math.max(maxAreaTopDown(startIndex+1, endIndex, height, dp), 
                                maxAreaTopDown(startIndex, endIndex-1, height, dp));
            dp[startIndex][endIndex] = Math.max(max1, max2);
        }
        return dp[startIndex][endIndex];
    }
    
    public static int maxAreabottomUp(int[] height) {
        int[][] dp = new int[height.length][height.length];
        for (int col = 1; col < height.length; col++) {
        	for (int row = col-1; row >= 0; row--) {
        		int max1 = Math.min(height[col], height[row]) * Math.abs(row - col);
        		int max2 = Math.max(dp[row+1][col], dp[row][col-1]);
        		dp[row][col] = Math.max(max1, max2);
			}
        	display(dp);
		}
        return dp[0][height.length-1];
    }
    
    public static void display(int[][] array) {
    	for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
    	System.out.println("---------------------------");
    }
    
    public static int maxAreaIterative(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
			for (int j = height.length-1; j > i ; j--) {
				max = Math.max(max, Math.min(height[i], height[j])*(j-i));
			}
		}
        return max;
    }
}
