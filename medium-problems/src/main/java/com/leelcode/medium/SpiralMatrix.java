package com.leelcode.medium;

import java.util.*;

/**
 * 
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * Example 1:
 *  1  2  3
 *  
 *  4  5  6
 *  
 *  7  8  9
 *  
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * Example 2:
 * 1  2  3  4 
 * 
 * 5  6  7  8
 * 
 * 9 10 11 12
 * 
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * @author Anirban Bhattacherji
 *
 */

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(arr));
		arr = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(spiralOrder(arr));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        int elementCount = matrix.length * matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int[] x = new int[]{0, 1, 0, -1};
        int[] y = new int[]{1, 0, -1, 0};
        int dir = 0;
        int rowMin = 0, rowMax = matrix.length, colMin = 0, colMax = matrix[0].length;
        int row = 0, col = 0;
        for(int i = 0; i < elementCount; i++){
            
            if(row >= rowMin && row < rowMax && col >= colMin && col < colMax){
                list.add(matrix[row][col]);
                row = row + x[dir%4];
                col = col + y[dir%4];
            } else {
                row = row - x[dir%4];
                col = col - y[dir%4];
                dir++;
                if(dir%4 == 1){
                    rowMin++;
                } else if(dir%4 == 2){
                    colMax--;
                } else if(dir%4 == 3){
                    rowMax--;
                } else {
                    colMin++;
                }
                row = row + x[dir%4];
                col = col + y[dir%4];
                i--;
            }
        }
        return list;
    }

}
