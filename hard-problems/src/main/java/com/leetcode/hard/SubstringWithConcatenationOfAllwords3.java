package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllwords3 {

	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"}));
		List<Integer> result = findSubstring("barfoofoobarthefoobarfooman", new String[] {"bar","foo","foo","the"});
		System.out.println(result);
	}

	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words == null || words.length == 0 || s == null || s.equals("")){
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int len = words[0].length();
        for(int i = 0; i < len; i++){
            int start = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();
            for(int j = i; j <= s.length()-len; j+=len){
                String sub = s.substring(j, j+len);
                if(map.containsKey(sub)){
                    currentMap.put(sub, currentMap.getOrDefault(sub, 0) + 1);
                    count++;
                    while(map.get(sub)<currentMap.get(sub)){
                        String str = s.substring(start, start+len);
                        currentMap.put(str, currentMap.get(str) - 1);
                        start += len;
                        count--;
                    }
                    if(count == words.length){
                        result.add(start);
                        String str = s.substring(start, start+len);
                        currentMap.put(str, currentMap.get(str) - 1);
                        start += len;
                        count--;
                    }
                } else {
                    count = 0;
                    currentMap.clear();
                    start = j + len;
                }
            }
        }
        return result;
    }
}
