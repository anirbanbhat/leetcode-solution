package com.leelcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestSubStringSize2 {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("dvdf"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		
	}
	
	public static int lengthOfLongestSubstring(String s) {
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
