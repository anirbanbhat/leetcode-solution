package com.leelcode.medium;

import java.util.Arrays;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] arr1 = new char[][] {{'.','.','.','.','5','.','.','1','.'},
				 					  {'.','4','.','3','.','.','.','.','.'},
									  {'.','.','.','.','.','3','.','.','1'},
									  {'8','.','.','.','.','.','.','2','.'},
									  {'.','.','2','.','7','.','.','.','.'},
									  {'.','1','5','.','.','.','.','.','.'},
									  {'.','.','.','.','.','2','.','.','.'},
									  {'.','2','.','9','.','.','.','.','.'},
									  {'.','.','4','.','.','.','.','.','.'}};
		System.out.println(isValidSudoku(arr1));
	}
	
	public static boolean isValidSudoku(char[][] board) {
        boolean[] table = new boolean[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
            	if(board[i][j]!='.') {
            		int val = board[i][j] - '0';
            		if(table[val - 1]){
                        return false;
                    }
            		table[val - 1] = true;
            	}
            }
            Arrays.fill(table, false);
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
            	if(board[j][i]!='.') {
            		int val = board[j][i] - '0';
            		if(table[val - 1]){
                        return false;
                    }
            		table[val - 1] = true;
            	}
            }
            Arrays.fill(table, false);
        }
        
        for(int i = 0; i < 9; i++){
            for(int j = i/3*3; j <= i/3*3 + 2; j++){
                for(int k = i%3*3; k <= i%3*3 + 2; k++){
                	if(board[j][k]!='.') {
                		int val = board[j][k] - '0';
                		if(table[val - 1]){
                            return false;
                        }
                		table[val - 1] = true;
                	}
                }
            }
            Arrays.fill(table, false);
        }
        return true;
    }

}
