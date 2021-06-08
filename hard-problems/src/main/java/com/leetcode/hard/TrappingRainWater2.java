package com.leetcode.hard;

public class TrappingRainWater2 {

	public static void main(String[] args) {
		System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}

	public static int trap(int[] height) {
        int[] leftView = new int[height.length];
        int[] rightView = new int[height.length];
        int max = 0;
        for (int i = 0; i < leftView.length; i++) {
        	leftView[i] = max = Math.max(max, height[i]);
		}
        max = 0;
        for (int i = rightView.length - 1; i >= 0; i--) {
        	rightView[i] = max = Math.max(max, height[i]);
		}
        int amount = 0;
        for (int i = height.length - 1; i >= 0; i--) {
        	amount += Math.min(leftView[i], rightView[i]) - height[i];
		}
        return amount;
    }
	
	public static void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
