package com.leelcode.medium;

import java.util.*;

/**
 * 
 * @author Anirban
 *
Given a string containing digits from 2-9 inclusive, return all possible letter combinations 
that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */

public class LetterCombinationsOfPhoneNumber {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(letterCombinations("2345").toArray()));
		System.out.println(Arrays.toString(letterCombinations("").toArray()));
	}
	
    public static List<String> letterCombinations(String digits) {
    	if(digits==null || digits.length()==0)
    		return new ArrayList<String>();
    	Map<String, String> keyMap = loadMap();
    	return getCombination(digits, keyMap);
    }
    
    public static List<String> getCombination(String digits, Map<String, String> keyMap){
    	List<String> result = new ArrayList<>();
    	if(digits.length()==1) {
    		for(int i=0; i<keyMap.get(digits).length(); i++) {
    			result.add(Character.toString(keyMap.get(digits).charAt(i)));
    		}
    		return result;
    	}
    	for(Character c: keyMap.get(digits.substring(0, 1)).toCharArray()) {
    		for(String s: getCombination(digits.substring(1), keyMap)) {
    			result.add(Character.toString(c)+s);
    		}
    	}
    	return result;
    }
	
	
	public static Map<String, String> loadMap(){
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("2", "abc");
        keyMap.put("3", "def");
        keyMap.put("4", "ghi");
        keyMap.put("5", "jkl");
        keyMap.put("6", "mno");
        keyMap.put("7", "pqrs");
        keyMap.put("8", "tuv");
        keyMap.put("9", "wxyz");
        return keyMap;
    }
	
	

}
