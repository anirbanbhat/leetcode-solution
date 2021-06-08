package com.leelcode.medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author anirban
 * 
 * 
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */


public class LongestSubStringSize {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	public static int lengthOfLongestSubstring(String s) {
		StringBuilder sb = new StringBuilder();
		int maxSize = 0;
		int currentSize = 0;
        for(int i=0; i<s.length(); i++) {
        	sb.append(s.substring(i, i+1));
        	System.out.println(sb);
        	int newStartPosition = isRepeated(sb);
        	if(newStartPosition != -1) {
        		if(maxSize<currentSize) {
        			maxSize = currentSize;
        		}
        		sb = new StringBuilder(sb.substring(newStartPosition+1, sb.length()));
        		currentSize = sb.length();
        	} else {
        		currentSize ++;
        		if(maxSize<currentSize) {
        			maxSize = currentSize;
        		}
        	}
        	System.out.println("maxSize: " + maxSize);
        }
        return maxSize;
    }
	
	public static int isRepeated(StringBuilder sb) {
		int len = sb.length();
		if(len == 1)
			return -1;
		String last = sb.substring(len-1, len);
		int counter = 0;
		boolean flag = false;
		while(counter<len-1) {
			System.out.println("sb.substring(counter, counter+1): " + sb.substring(counter, counter+1) + ";;; last: " + last);
			if(sb.substring(counter, counter+1).equals(last)) {
				flag = true;
				break;
			}
			counter++;
		}
		counter = (flag)?counter:-1;
		System.out.println("flag: " + flag + " counter: " + counter);
		return counter;
	}

}
