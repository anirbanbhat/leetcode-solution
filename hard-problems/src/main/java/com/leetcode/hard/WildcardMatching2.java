package com.leetcode.hard;

public class WildcardMatching2 {

	public static void main(String[] args) {
		isMatch("acdcb", "a*c?b");
		isMatch("acdcb", "ac*?b");
	}
	
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while(i<s.length()) {
			if(j<p.length() && (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i))) {
				++i;
				++j;
			} else if(j<p.length() && p.charAt(j)=='*') {
				star = j;
				j++;
				mark = i;
			} else if(star != -1) {
				j = star + 1;
				mark++;
				i = mark;
			} else {
				return false;
			}
		}
		while(j<p.length() && p.charAt(j)=='*') {
			j++;
		}
		System.out.println("result=" + (j==p.length()));
		return j==p.length();
	}

}
