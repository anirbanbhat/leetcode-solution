package com.leetcode.hard;

/**
 * 
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of 
substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllwords {

	public static void main(String[] args) {
		List<Integer> result = null;
//		result = findSubstring("barfoothefoobarman", new String[] {"foo", "bar"});
//		System.out.println(result.toString());
//		result = findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"});
//		System.out.println(result.toString());
		result = findSubstring("barfoofoobarthefoobarfooman", new String[] {"bar","foo","foo","the"});
		System.out.println(result.toString());
	}
	
	public static List<Integer> findSubstring(String s, String[] words) {
		System.out.println(s);
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if(s==null||s.length()==0||words==null||words.length==0){
	        return result;
	    } 
	 
	    //frequency of words
	    HashMap<String, Integer> map = new HashMap<String, Integer>();
	    for(String w: words){
	        if(map.containsKey(w)){
	            map.put(w, map.get(w)+1);
	        }else{
	            map.put(w, 1);
	        }
	    }
	    System.out.println("map: " + map.toString());
	 
	    int len = words[0].length();
	 
	    for(int j=0; j<len; j++){
	        HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
	        int start = j;//start index of start
	        int count = 0;//count total qualified words so far
	 
	        for(int i=j; i<=s.length()-len; i=i+len){
	            String sub = s.substring(i, i+len);
	            if(map.containsKey(sub)){
	                //set frequency in current map
	                if(currentMap.containsKey(sub)){
	                    currentMap.put(sub, currentMap.get(sub)+1);
	                }else{
	                    currentMap.put(sub, 1);
	                }
	 
	                count++;
	                System.out.println("i: " + i);
	                System.out.println("currentMap: " + currentMap.toString());
	 
	                while(currentMap.get(sub)>map.get(sub)){
	                	System.out.println("sub: " + sub);
	                    String left = s.substring(start, start+len);
	                    System.out.println("start: " + start);
	                    System.out.println("left: " + left);
	                    
	                    currentMap.put(left, currentMap.get(left)-1);
	 
	                    count--;
	                    start = start + len;
	                }
	                System.out.println("currentMap After while: " + currentMap.toString());
	 
	                if(count==words.length){
	                    result.add(start); //add to result
	 
	                    //shift right and reset currentMap, count & start point         
	                    String left = s.substring(start, start+len);
	                    currentMap.put(left, currentMap.get(left)-1);
	                    count--;
	                    start = start + len;
	                }
	            }else{
	                currentMap.clear();
	                start = i+len;
	                count = 0;
	            }
	        }
	    }
	 
	    return result;
	}

}
