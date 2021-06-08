package com.leetcode.dynamic;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to 
 * compute the fewest number of coins that you need to make up that amount. If that amount of money cannot 
 * be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * @author Anirban Bhattacherji
 *
 */

public class CoinChange {

	public static void main(String[] args) {
		CoinChange coinChange = new CoinChange();
		System.out.println(coinChange.coinChange(new int[] {186,419,83,408}, 6249)); // -1
		System.out.println(coinChange.coinChange(new int[] {1, 2, 5}, 11)); // 3 (5, 5, 1)
		System.out.println(coinChange.coinChange(new int[] {2}, 3)); // -1
		System.out.println(coinChange.coinChange(new int[] {1, 2, 3}, 5)); // 2 (2,3)
		System.out.println(coinChange.coinChange(new int[] {1, 2, 3}, 11)); // 4 (2,3,3,3)
	}
	
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount + 1];
        for(int i = 1; i < memo[0].length; i++) {
        	for (int j = 0; j < memo[0].length; j++) {
				if(j != 0) {
					memo[0][i] = Integer.MAX_VALUE;
				}
			}
        }
        for (int i = 0; i < memo.length; i++) {
			for (int j = 1; j < memo[0].length; j++) {
				if(i > 0) {
					memo[i][j] = memo[i-1][j];
				}
				if(j >= coins[i] && memo[i][j - coins[i]] != Integer.MAX_VALUE) {
					memo[i][j] = Math.min(memo[i][j], 1 + memo[i][j - coins[i]]);
				}
			}
		}
        printTable(memo);
        return memo[coins.length - 1][amount] == Integer.MAX_VALUE? -1 : memo[coins.length - 1][amount];
    }
    
    public void printTable(int[][] table) {
    	System.out.println("---------------------------------------");
    	for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
    	System.out.println("---------------------------------------");
    }
}
