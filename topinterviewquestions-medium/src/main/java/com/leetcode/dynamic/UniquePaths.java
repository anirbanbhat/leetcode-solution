package com.leetcode.dynamic;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the 
 * bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Example 1:
 * 
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * 
 * Example 2:
 * 
 * Input: m = 7, n = 3
 * Output: 28
 *  
 * 
 * Constraints:
 * 
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
 * 
 * @author Anirban Bhattacherji
 *
 */

public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths uniquePaths = new UniquePaths();
		System.out.println(uniquePaths.uniquePaths(3, 2));
		System.out.println(uniquePaths.uniquePaths(7, 3));
	}

	public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m+1][n+1];
        return uniquePaths(m, n, 0, 0, memo);
    }
	
	public int uniquePaths(int m, int n, int x, int y, Integer[][] memo) {
        if(x == m - 1 && y == n - 1) {
        	return 1;
        }
        
        if(memo[x][y] == null) {
        	int path1 = 0, path2 = 0;
        	if(x + 1 < m) {
        		path1 = uniquePaths(m, n, x + 1, y, memo);
        	}
        	if(y + 1 < n) {
        		path2 = uniquePaths(m, n, x, y + 1, memo);
        	}
        	memo[x][y] = path1 + path2;
        }
        return memo[x][y];
    }
}
