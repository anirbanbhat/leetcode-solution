package com.leelcode.medium;

/**
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and 
 * mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero, which means losing its fractional part. For example, 
 * truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * 
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed 
 * integer range: [−2^31, 2^31 − 1]. For this problem, assume that your function returns 2^31 − 1 when the 
 * division result overflows.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * 
 * Example 2:
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * 
 * Example 3:
 * 
 * Input: dividend = 0, divisor = 1
 * Output: 0
 * 
 * Example 4:
 * 
 * Input: dividend = 1, divisor = 1
 * Output: 1
 *
 * Constraints:
 * 
 * -2^31 <= dividend, divisor <= 2^31 - 1
 * divisor != 0
 * 
 * @author Anirban Bhattacherji
 *
 */

public class DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(Integer.MIN_VALUE, -1));
	}
	
		
    /**
      * We can follow the below steps —
      * 
      * A variable quotient will keep the track of answer.
      * A while loop will check the condition dividend >= divisor
      * Inside this while loop, we will have one variable shift which will left shift the divisor by one bit and check if the result is less than the dividend. This will repeat until the condition is false.
      * Once, we are out of inner loop, then we will add the number of times we shifted to the quotient.
      * Also, we will now subtract the result of shifting to divisor from the dividend for the next iteration. Remember that since in the while loop the value of shifting had gone beyond the dividend, the value we need to subtract is one bit less shifted.
      * We will repeat the process unless we reach to the point where divisor is greater than dividend.
      * You must be wondering that why are we shifting the bits? The answer is, one left shift bit means the number is doubled. And since we cannot use multiplication, we are using left shifting.

      * Time Complexity
      * Since the divisor is increasing exponentially, the time complexity will be O(log n).

      * Space Complexity
      * No internal data structure has been used in the intermediate computations, the space complexity will be O(1).
	  * */
	public static int divide(int dividend, int divisor) {
	    if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
	        return Integer.MAX_VALUE;
	    }
	    // Sign of result
	    int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
	    // Quotient
	    int quotient = 0;
	    // Take the absolute value
	    long absoluteDividend = Math.abs((long) dividend);
	    long absoluteDivisor = Math.abs((long) divisor);
	    // Loop until the  dividend is greater than divisor
	    while (absoluteDividend >= absoluteDivisor) {
	        // This represents the number of bits shifted or
	        // how many times we can double the number
	        int shift = 0;
	        while (absoluteDividend >= (absoluteDivisor << shift)) {
	            shift++;
	        }
	        // Add the number of times we shifted to the quotient
	        quotient += (1 << (shift - 1));
	        // Update the dividend for the next iteration
	            absoluteDividend -= absoluteDivisor << (shift - 1);
	        }
	        return sign == -1 ? -quotient : quotient;
	   }
}
