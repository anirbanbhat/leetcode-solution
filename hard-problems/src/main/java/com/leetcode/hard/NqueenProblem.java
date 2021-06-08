package com.leetcode.hard;

import java.util.Arrays;

public class NqueenProblem {
	static int[] item;
	public static void main(String[] args) {
		//printBoard(new int[] {1, 3, 0, 2}, 4);
		item = new int[8];
		solve(8);
	}
	
	public static void solve(int n) {
		Arrays.fill(item, -1);
		dfs(0, n);
	}
	public static void dfs(int position, int n) {
		if(position==n) {
			printBoard(item, n);
			return;
		}
		else {
			for (int i = 0; i < n; i++) {
				item[position] = i;
				if(isValid(item, position))
					dfs(position+1, n);
			}
		}
	}
	public static boolean isValid(int[] item, int position) {
		for (int i = 0; i < position; i++) {
			if(item[i]==item[position] || Math.abs(item[i]-item[position])==(position-i))
				return false;
		}
		return true;
	}
	
	public static void printBoard(int[] item, int len) {
		System.out.print("-----------------------\n");
		for (int i = 0; i < len; i++) {
			System.out.print(" ");
			for (int j = 0; j < len; j++) {
				if(item[i]==j)
					System.out.print("Q ");
				else
					System.out.print(". ");
			}
			System.out.println();
		}
	}
}
