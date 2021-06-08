package com.leetcode.hard;

public class longestValidParentheses2 {

	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")()())")); // 4
	}
	
	public static int longestValidParentheses(String s) {
        int max = 0;
        int right = 0;
        int left = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
            } else {
                right++;
            }
            if(right > left){
                right = 0;
                left = 0;
                count = 0;
            } else if(left == right) {
                count = 2*right;
                max = Math.max(max, count);
            }
        }
        right = 0;
        left = 0;
        count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
            } else {
                right++;
            }
            if(right < left){
                right = 0;
                left = 0;
                count = 0;
            } else if(left == right) {
                count += 2*right;
                max = Math.max(max, count);
            }
        }
        return max;
    }

}
