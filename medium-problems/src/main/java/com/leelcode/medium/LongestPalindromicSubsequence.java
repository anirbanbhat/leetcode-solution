package com.leelcode.medium;

import java.util.Arrays;

/**
 * 
 * @author Anirban
 *
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 *
 */

public class LongestPalindromicSubsequence {

	static int[][] table;
	public static void main(String[] args) {
		String s = "agbdba";
		// String s = "bbbab";
        table = new int[s.length()][s.length()];
        System.out.println(getPalindromicSubsequence(s));
        System.out.println(calculateRecursive(s.toCharArray(), 0, s.length()));
	}

	// Better solution...Complexity n*log(n)
	public static int getPalindromicSubsequence(String s) {
		//String result = "";
		for (int i = 0; i < table.length; i++) {
			table[i][i] = 1;
		}
		for (int counter = 1; counter < s.length(); counter++) {
			printTable();
			int i = 0;
			for (int j = counter; j < s.length(); j++) {
				if(s.charAt(i)==s.charAt(j)) {
					table[i][j]=table[i+1][j-1] + 2;
				} else {
					table[i][j]=Math.max(table[i][j-1], table[i+1][j]);
				}
				i++;
			}
		}
		printTable();
		return table[0][s.length()-1];
	}
	
	// Complexity 2^n
	public static int calculateRecursive(char arr[],int start,int len){
		if(len==0) {
			return 0;
		}
		if(len==1) {
			return 1;
		}
		if(arr[start]==arr[start + len-1]) {
			return 2 + calculateRecursive(arr, start + 1, len-2);
		} else {
			return Math.max(calculateRecursive(arr, start, len-1), calculateRecursive(arr, start + 1, len-1));
		}
	}
	
	public static void printTable() {
		for (int i = 0; i < table.length; i++) {
			String prefix = "";
			for (int j = 0; j < table.length; j++) {
				System.out.print(prefix + table[i][j]);
				prefix = ", ";
			}
			System.out.println();
		}
		System.out.println("*******************");
	}
}
