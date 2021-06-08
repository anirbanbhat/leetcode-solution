package com.leetcode.hard;

/**
 * 
 * @author Anirban
 *
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 *
 */

public class EditDistance {

	public static void main(String[] args) {
		String s1 = "intention";
		String s2 = "execution";
        System.out.println(minDistance(s1, s2));
	}
	
	public static int minDistance(String word1, String word2) {
        int[][] table = new int[word2.length()+1][word1.length()+1];
        for (int i = 0; i <= word2.length(); i++) {
			for (int j = 0; j <= word1.length(); j++) {
				if(i==0 || j==0) {
					table[i][j] = i+j;
					continue;
				}
				if(word2.charAt(i-1)==word1.charAt(j-1)) {
					table[i][j] = table[i-1][j-1];
				} else {
					table[i][j] = Math.min(table[i-1][j-1], Math.min(table[i-1][j], table[i][j-1])) + 1;
				}
			}
		}
        return table[table.length-1][table[0].length-1];
    }

}
