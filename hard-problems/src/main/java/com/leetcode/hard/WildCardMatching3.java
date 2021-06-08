package com.leetcode.hard;

public class WildCardMatching3 {

	public static void main(String[] args) {
		System.out.println(isMatch("acdcb", "a*c?b"));;
		System.out.println(isMatch("acdcb", "ac*?b"));;
	}
	
	public static boolean isMatch(String s, String p) {
		int i=0;
		int j=0;
		int mark=-1;
		int star=-1;
		while(i<s.length()) {
			if(j<p.length() && (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i))) {
				i++;
				j++;
			} else if(j<p.length() && p.charAt(j)=='*') {
				mark = i;
				star = j;
				j++;
			} else if(star != -1){
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
		return j==p.length();
	}

}
