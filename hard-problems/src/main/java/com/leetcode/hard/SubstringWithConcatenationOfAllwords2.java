package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllwords2 {

	public static void main(String[] args) {
		List<Integer> result = null;
		result = findSubstring("barfoofoobarthefoobarfooman", new String[] {"bar","foo","foo","the"});
		System.out.println(result.toString());
	}
	
	public static List<Integer> findSubstring(String s, String[] words) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if(s==null||s.length()==0||words==null||words.length==0){
	        return result;
	    } 
	    Map<String, Integer> wordMap = new HashMap<>();
	    for (String w : words) {
	    	wordMap.put(w, (wordMap.containsKey(w))?wordMap.get(w)+1:1);
		}
	    int len = words[0].length();
	    for(int j=0; j<len; j++) {
	    	int start = j;
	    	int count = 0;
	    	Map<String, Integer> currentMap = new HashMap<>();
	    	for(int i=j; i<=s.length()-len; i+=len) {
	    		String sub = s.substring(i, i+len);
	    		if(wordMap.containsKey(sub)) {
	    			currentMap.put(sub, currentMap.containsKey(sub)?currentMap.get(sub)+1:1);
	    			count++;
	    			while(currentMap.get(sub)>wordMap.get(sub)) {
	    				String left = s.substring(start, start+len);
	    				currentMap.put(left, currentMap.get(left)-1);
	    				start=start+len;
	    				count--;
	    			}
	    			if(count==words.length) {
	    				result.add(start);
	    				String left = s.substring(start, start+len);
	    				currentMap.put(left, currentMap.get(left)-1);
	    				start=start+len;
	    				count--;
	    			}
	    		}else {
	    			currentMap.clear();
	    			count = 0;
	    			start = i+len;
	    		}
	    	}
	    }   
	    return result;
	}
}
