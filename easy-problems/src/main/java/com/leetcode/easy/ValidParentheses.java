package com.leetcode.easy;

import java.util.Stack;


public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
	}
    
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()) {
        	if(stack.isEmpty()) {
        		stack.add(c);
        		continue;
        	}		
        	Character last = stack.peek();
        	switch(c) {
	        	case ']':{
	        		if(last=='[') {
	        			stack.pop();
	        			break;
	        		} else {
	        			return false;
	        		}	
	        	}
	        	case '}':{
	        		if(last=='{') {
	        			stack.pop();
	        			break;
	        		} else {
	        			return false;
	        		}	
	        	}
	        	case ')':{
	        		if(last=='(') {
	 	    			stack.pop();
	 	    			break;
	 	    		} else {
	 	    			return false;
	 	    		}
	        	}
	        	default:{
	        		stack.add(c);
	        		break;
	        	}
        	}
    	}
        return (stack.isEmpty())?true:false;
    }
}
