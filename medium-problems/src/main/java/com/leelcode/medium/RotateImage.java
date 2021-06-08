package com.leelcode.medium;

public class RotateImage {

	public static void main(String[] args) {
		int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
		printMatrix(arr1);
		rotate(arr1);
		printMatrix(arr1);
		
		int[][] arr2 = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 0, 11, 12}, {13, 14, 15, 16}};
		printMatrix(arr2);
		rotate(arr2);
		printMatrix(arr2);
	}

	public static void rotate(int[][] matrix) {
		int length = matrix.length - 1;
	    int itr = length/2;
	    for(int i=0; i<=itr; i++){
	        for(int j = i; j<length-i; j++){
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[length-j][i];
	            matrix[length-j][i] = matrix[length-i][length-j];
	            matrix[length-i][length-j] = matrix[j][length-i];
	            matrix[j][length-i] = temp;
	            //printImage(a);
	        }
	    }        
    }
    
    public static void printMatrix(int[][] matrix) {
    	for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
    	System.out.println("-------------------------");
    }
}
