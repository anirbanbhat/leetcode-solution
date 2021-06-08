package com.leetcode.sortingandsearching;

/**
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following 
 * properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * 
 * Given target = 20, return false.
 * 
 * @author Anirban Bhattacherji
 *
 */

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		
	}

	public boolean searchMatrix(int[][] matrix, int target) {
        int x1 = 0, y1 = 0, x2 = matrix.length - 1, y2 = matrix[0].length - 1;
        return searchMatrix(matrix, x1, y1, x2, y2, target);
    }

	private boolean searchMatrix(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
		// TODO Auto-generated method stub
		if(x1 > x2 || y1 > y2) {
			return false;
		}
		for(int y = y1; y < y2; y++) {
			if(target < matrix[x1][y]) {
				searchMatrix(matrix, x1, y1, x2, y - 1, target);
			}
		}
		return false;
	}
}
