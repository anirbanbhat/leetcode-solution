package com.leelcode.medium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 
 * @author Anirban
 * 
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * Example 2:
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */

public class LongestSubstringWithoutRepeatingCharacters {

	@Test
	public void test() {
		assertEquals(2, lengthOfLongestSubstring("abba"));
		assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, lengthOfLongestSubstring("bbbbb"));
		assertEquals(3, lengthOfLongestSubstring("pwwkew"));
		
		assertEquals(2, lengthOfLongestSubstring2("abba"));
		assertEquals(3, lengthOfLongestSubstring2("abcabcbb"));
		assertEquals(1, lengthOfLongestSubstring2("bbbbb"));
		assertEquals(3, lengthOfLongestSubstring2("pwwkew"));
		
	}

	public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }
	
	public int lengthOfLongestSubstring2(String s) {
        List<Character> list = new ArrayList<>();
        int result=0;
        for(Character c: s.toCharArray()){
            if(list.contains(c)){
                result = (list.size()>result)?list.size():result;
                int index = list.indexOf(c);
                for(int i=0; i<=index; i++) {
                	list.remove(0);
                }
                list.add(c);
            } else {
                list.add(c);
            }
        }
        result = (list.size()>result)?list.size():result;
        return result;
    }
}
