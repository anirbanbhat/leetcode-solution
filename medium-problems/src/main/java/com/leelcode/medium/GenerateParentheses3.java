package com.leelcode.medium;

import java.util.*;

public class GenerateParentheses3 {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(5));
	}
	
	public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateParenthesis(list, n, n, new StringBuilder());
        return list;
    }
    
    public static void generateParenthesis(List<String> list, int left, int right, StringBuilder sb) {
        if(left == 0 && right == 0) {
            list.add(sb.toString());
            return;
        }
        if(left > 0) {
            generateParenthesis(list, left - 1, right, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right > left) {
            generateParenthesis(list, left, right - 1, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
