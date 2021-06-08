package com.leetcode.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestCommonPrefix {

	@Test
	public void test() {
		assertEquals("fl", longestCommonPrefix(new String[] {"flower","flow","flight"}));
		assertEquals("", longestCommonPrefix(new String[] {"dog","racecar","car"}));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0) {
			return "";
		}
        StringBuilder prefix = new StringBuilder(strs[0]);
        for(String str: strs){
            int i=0;
            while(i<str.length() && i<prefix.length() && str.charAt(i)==prefix.charAt(i)){
                i++;
            }
            prefix.delete(i, prefix.length());
        }
        return prefix.toString();
    }

}
