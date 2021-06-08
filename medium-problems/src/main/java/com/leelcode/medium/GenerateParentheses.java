package com.leelcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Anirban
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed 
 * parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */

public class GenerateParentheses {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(5));
	}

	public static List<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder("");
		List<String> list = new ArrayList<String>();
        generateParenthesis(list, sb, n, n);
        return list;
    }
	
	public static void generateParenthesis(List<String> list, StringBuilder sb, int left, int right) {
		if((left==0 && right==0)) {
			list.add(sb.toString());
		}
		if(left>0) {
			generateParenthesis(list, sb.append("("), left-1, right);
			sb.setLength(sb.length()-1);
			
		}
		if(right>0 && right>left) {
			generateParenthesis(list, sb.append(")"), left, right-1);
			sb.setLength(sb.length()-1);
		}
    }
}
