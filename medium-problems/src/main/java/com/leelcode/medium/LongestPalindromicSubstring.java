package com.leelcode.medium;

/**
 * 
 * @author Anirban Bhattacherji
 *
 */

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		
		System.out.println(longestPalindromeExpandAroundCentre("aacabdkacaa"));
		System.out.println(longestPalindromeExpandAroundCentre("babad"));
		System.out.println(longestPalindromeExpandAroundCentre("cbbd"));
		System.out.println(longestPalindromeExpandAroundCentre("a"));
		System.out.println(longestPalindromeExpandAroundCentre("ac"));
		System.out.println(longestPalindromeExpandAroundCentre("abbcccbbbcaaccbababcbcabca")); // this test case fails
	}
	
	public static String longestPalindrome(String s) {
        StringBuilder[][] dp = new StringBuilder[s.length()][s.length()];
        return longestPalindrome(s, dp, 0, s.length() - 1).toString();
    }
    
    public static StringBuilder longestPalindrome(String s, StringBuilder[][] dp, int start, int end) {
    	//System.out.println(start + ", " + end);
        if(start > end){
            return new StringBuilder("");
        }
        if(start == end){
            return new StringBuilder(Character. toString(s.charAt(start)));
        }
        if(dp[start][end] == null){
            if(s.charAt(start) == s.charAt(end)){
                int remainingLength = end - start - 1;
                StringBuilder sb = longestPalindrome(s, dp, start + 1, end - 1);
                if(sb.length() == remainingLength){
                    sb.insert(0, s.charAt(start)).append(s.charAt(end));
                    dp[start][end] = sb;
                    return dp[start][end];
                }
            }
            StringBuilder sb1 = longestPalindrome(s, dp, start, end - 1);
            StringBuilder sb2 = longestPalindrome(s, dp, start + 1, end);
            if(sb1.length() > sb2.length()){
                dp[start][end] = sb1;
            } else {
                dp[start][end] = sb2;
            }     
        }
        return dp[start][end];
    }
    
    /**
     * We could solve it in O(n^2) time using only constant space.
     *  
     * We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from 
     * its center, and there are only 2n - 1 such centers.
     *  
     * You might be asking why there are 2n - 1 but not nn centers? The reason is the center of a 
     * palindrome can be in between two letters. Such palindromes have even number of letters (such as 
     * "abba") and its center are between the two 'b's.
     * 
     * @param s
     * @return
     */
    
    public static String longestPalindromeExpandAroundCentre(String s) {
        int start = 0, end = 0;
        if(s == null || s.length() == 0) {
        	return "";
        }
        for(int i = 0; i <s.length(); i++) {
        	int len1 = expandAroundCentre(s, i, i);
        	int len2 = expandAroundCentre(s, i, i+1);
        	int len = Math.max(len1, len2);
        	if(len > end - start) {
        		start = i - (len - 1)/2;
        		end = i + len/2;
        	}
        }
        return s.substring(start, end + 1);
    }

	private static int expandAroundCentre(String s, int left, int right) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
