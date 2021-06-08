package com.leetcode.hard;

public class WildcardMatching4 {

	public static void main(String[] args) {
		System.out.println(isMatch("acdcb", "a*c?b"));
		System.out.println(isMatch("acdcb", "ac*?b"));
		System.out.println(isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
	}
	
	public static boolean isMatch(String s, String p) {
		int i=0;
		int j = 0;
		int mark = -1;
		int star = -1;
		while(i < s.length()) {
			if((j < p.length()) && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				i++;
				j++;
			} else if(j < p.length() && p.charAt(j) == '*') {
				mark = i;
				star = j;
				j++;
			} else if(star != -1) {
				mark++;
				i = mark;
				j = star + 1;
			} else {
				return false;
			}
		}
		while(j<p.length() && p.charAt(j)=='*') {
			j++;
		}
		return j==p.length();
	}

}
