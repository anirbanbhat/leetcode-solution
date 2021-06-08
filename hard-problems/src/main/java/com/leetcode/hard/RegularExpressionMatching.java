package com.leetcode.hard;

//not completed
public class RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*")); // true
		System.out.println(isMatchRecursive("ab", ".*c")); // false
		System.out.println(isMatch("ab", ".*c")); // false
		System.out.println(isMatchRecursive("a", ".*..a*")); // false
		System.out.println(isMatch("a", ".*..a*")); // false
		System.out.println(isMatchRecursive("aa", "a*")); // true
		System.out.println(isMatchRecursive("ab", ".*")); // true
		System.out.println(isMatchRecursive("aab", "c*a*b")); // true
		System.out.println(isMatchRecursive("mississippi", "mis*is*p*.")); // false
		System.out.println(isMatchRecursive("aaa", "ab*a*c*a")); // true
		System.out.println(isMatchRecursive("a", "ab*")); // true
		System.out.println(isMatchRecursive("aaa", "aaaa")); // false
	}
	
	public static boolean isMatchRecursive(String s, String p) {
		
		return isMatchRecursive(0, 0, s, p);
	}
	
	public static boolean isMatchRecursive(int i, int j, String s, String p) {
		if(i == s.length()) {
			return j == p.length();
		}
		if(j == p.length()) {
			return i == s.length();
		}
		if(p.charAt(j) == '.' || p.charAt(j)==s.charAt(i)) {
			return isMatchRecursive(i+1, j+1, s, p);
		}else if(p.charAt(j) == '*') {
			if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)) {
				return isMatchRecursive(i+1, j+1, s, p) || isMatchRecursive(i, j+1, s, p) || isMatchRecursive(i+1, j, s, p);
			} else if(j==p.length()-1){
				return isMatchRecursive(i, j+1, s, p) || isMatchRecursive(i+1, j+1, s, p);
			} else {
				return isMatchRecursive(i, j+1, s, p);
			}
		} else {
			if(p.charAt(j) != s.charAt(i) && j<p.length()-1 && p.charAt(j+1) == '*') {
				return isMatchRecursive(i, j+1, s, p);
			} 
		}
		return false;
	}
	
	public static boolean isMatch(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        
        if(p.length() >= 2 && p.charAt(1) == '*'){
        	return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

}
