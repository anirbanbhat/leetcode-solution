package com.leetcode.easy;

import java.util.*;


/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, 
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four 
 * is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it 
 * making four. The same principle applies to the number nine, which is written as IX. There are six instances 
 * where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * 
 * @author Anirban Bhattacherji
 *
 */

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV")); //1994
		System.out.println(romanToInt("DCXXI")); //
	}
	
	
	public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int val = 0;
        int index = 0;
        while(index < s.length()){
            Character ch = s.charAt(index);
            if(ch == 'C'){
                if(index < s.length() - 1 && s.charAt(index + 1) == 'D'){
                    val += 400;
                    index++;
                } else if(index < s.length() - 1 && s.charAt(index + 1) == 'M'){
                    val += 900;
                    index++;
                } else {
                    val += map.get(ch);
                }
                index++;
            } else if(ch == 'X'){
                if(index < s.length() - 1 && s.charAt(index + 1) == 'L'){
                    val += 40;
                    index++;
                } else if(index < s.length() - 1 && s.charAt(index + 1) == 'C'){
                    val += 90;
                    index++;
                } else {
                    val += map.get(ch);
                }
                index++;
            } else if(ch == 'I'){
                if(index < s.length() - 1 && s.charAt(index + 1) == 'V'){
                    val += 4;
                    index++;
                } else if(index < s.length() - 1 && s.charAt(index + 1) == 'X'){
                    val += 9;
                    index++;
                } else {
                    val += map.get(ch);
                }
                index++;
            } else {
                val += map.get(ch);
                index++;
            }
        }
        return val;
    }

}
