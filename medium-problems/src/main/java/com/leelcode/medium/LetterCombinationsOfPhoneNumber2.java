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

public class LetterCombinationsOfPhoneNumber2 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(letterCombinations("23").toArray()));
		System.out.println(Arrays.toString(letterCombinations("2345").toArray()));
		System.out.println(Arrays.toString(letterCombinations("").toArray()));
	}
	
	 public static List<String> letterCombinations(String digits) {
	        Map<Character, Character[]> map = new HashMap<>();
	        map.put('2', new Character[]{'a', 'b', 'c'});
	        map.put('3', new Character[]{'d', 'e', 'f'});
	        map.put('4', new Character[]{'g', 'h', 'i'});
	        map.put('5', new Character[]{'j', 'k', 'l'});
	        map.put('6', new Character[]{'m', 'n', 'o'});
	        map.put('7', new Character[]{'p', 'q', 'r', 's'});
	        map.put('8', new Character[]{'t', 'u', 'v'});
	        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
	        List<String> result = new ArrayList<>();
	        if(digits != null && digits.length() != 0) {
	        	letterCombinations(result, digits, map);
	        }
	        return result;
	    }
	    
	    public static void letterCombinations(List<String> list, String digits, Map<Character, Character[]> map) {
	        
	        Character ch = digits.charAt(0);
	        if(list.isEmpty()){
	            for(Character chr : map.get(ch)){
	                list.add(chr.toString());
	            }
	        } else {
	            int length = list.size();
	            for(int i = 0; i < length; i++){
	                String str = list.remove(0);
	                for(Character chr : map.get(ch)){
	                    list.add(str + chr.toString());
	                }
	            }
	        }
	        if(digits.length()>1){
	            letterCombinations(list, digits.substring(1, digits.length()), map);
	        }
	    }
	
	

}
