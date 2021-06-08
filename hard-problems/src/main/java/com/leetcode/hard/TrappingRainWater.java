package com.leetcode.hard;

public class TrappingRainWater {

	public static void main(String[] args) {
		int result = 0;
		result = getAmount(new int[] {3, 0, 0, 2, 0, 4});
		System.out.println(result);
		result = getAmount(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
		System.out.println(result);
	}
	
	public static int getAmount(int[] bars) {
		int max = 0;
		int[] leftView = new int[bars.length];
		int[] rightView = new int[bars.length];
		for (int i = 0; i < bars.length; i++) {
			if(bars[i]>=max) 
				max = bars[i];
			leftView[i] = max;
		}
		max = 0;
		for (int i = bars.length-1; i>=0; i--) {
			if(bars[i]>=max) 
				max = bars[i];
			rightView[i] = max;
		}
		int result = 0;
		for (int i = 0; i < bars.length; i++) {
			result += Math.min(leftView[i], rightView[i]) - bars[i];
		}
		return result;
	}

}
