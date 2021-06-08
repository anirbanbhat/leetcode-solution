package com.leelcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses2 {

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
		if(left == 0 && right == 0){
            list.add(sb.toString());
            return;
        }
        if(left > 0){
            sb.append('(');
            generateParenthesis(list, sb, left - 1, right);
            sb.setLength(sb.length() - 1);
        }
        if(right > left){
            sb.append(')');
            generateParenthesis(list, sb, left, right - 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
