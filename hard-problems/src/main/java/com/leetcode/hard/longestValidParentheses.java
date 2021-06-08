package com.leetcode.hard;

import java.util.Stack;

public class longestValidParentheses {

	public static void main(String[] args) {
//		System.out.println(longestValidParentheses("()())"));
//		System.out.println(longestValidParentheses(")()())"));
//		System.out.println(longestValidParentheses(")(((()))))"));
		System.out.println(getLongestValidParentheses(")(((()))))((()()()()()"));
		System.out.println(getLongestValidParentheses2(")(((()))))((()()()()()"));
	}
	
	public static int getLongestValidParentheses(String s) {
	    Stack<int[]> stack = new Stack<>();
	    int result = 0;
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        System.out.println(c);
	        printStack(stack);
	        if(c==')'){
	            if(!stack.isEmpty() && stack.peek()[0]==0){
	                stack.pop();
	                result = Math.max(result, i-(stack.isEmpty()?-1:stack.peek()[1]));
	            }else{
	                stack.push(new int[]{1, i});
	            }
	        }else{
	            stack.push(new int[]{0, i});
	        }
	    }
	 
	    return result;
	}
	
	public static void printStack(Stack<int[]> stack) {
		System.out.println("[");
		for(int[] arr: stack) {
			System.out.print("[");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
				if(i!=arr.length-1)
					System.out.print(", ");
			}
			System.out.println("]");
		}
		System.out.println("]");
		System.out.println("************************");
	}
	
	/*
	 * This is better approach
	 */
	public static int getLongestValidParentheses2(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
