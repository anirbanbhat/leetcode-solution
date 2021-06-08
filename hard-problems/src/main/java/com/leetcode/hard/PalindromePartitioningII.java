package com.leetcode.hard;

/**
 * 
 * @author Anirban
 *
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 */

public class PalindromePartitioningII {

	
	public static void main(String[] args) {
		String s = "abtbl";
		// String s = "aab";
		// String s = "malayalam";
		System.out.println(getMinimumCut(s));
	}
	
	public static int getMinimumCut(String s) {
		int[][] table = new int[s.length()][s.length()];
		if(s.length()==0 || s.length()==1) {
			return 0;
		}
		for(int counter=1; counter<s.length(); counter++) {
			printTable(table);
			int i = 0;
			for(int j=counter; j<s.length(); j++) {
				if(isPalindrome(s, i, j)) {
					table[i][j] = 0;
				} else {
					table[i][j] = getMinValue(i, j, table);
				}
				i++;
			}
		}
		printTable(table);
		return table[0][s.length()-1];
	}
	
	public static int getMinValue(int start, int end, int[][] table) {
		int min = Integer.MAX_VALUE;
		for(int i = start; i < end; i++) {
			min = Math.min(min, (table[start][i] + table[i+1][end]));
		}
		return min + 1;
	}
	
	public static boolean isPalindrome(String s, int start, int end) {
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void printTable(int[][] table) {
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
