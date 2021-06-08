package com.leelcode.medium;

/**
 * 
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * 
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * 
 * Example 1:
 * 
 * Input: x = 4
 * Output: 2
 * Example 2:
 * 
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * 
 * Constraints:
 * 
 * 0 <= x <= 231 - 1
 * 
 * @author Anirban Bhattacherji
 *
 */
public class Sqrt {

	public static void main(String[] args) {
		System.out.println(mySqrt(1));
		System.out.println(mySqrt(4));
		System.out.println(mySqrt(8));
		System.out.println(mySqrt(624));
		System.out.println(mySqrt(625));
		System.out.println(mySqrt(2147483647));
	}

	public static int mySqrt(int x) {
		if(x == 1) {
			return x;
		}
        long val = x;
        
        long mid = val;
        while(mid * mid >= val) {
        	if(mid*mid == val) {
        		return (int) mid;
        	}
        	mid = mid >> 1;
        }
        long max = mid << 1, min = 1;
        while(max >= min){
            mid = min + (max - min) / 2;
            if(mid * mid > val){
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (int)max;
    }
}
