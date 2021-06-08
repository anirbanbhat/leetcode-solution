package com.leetcode.treesandgraphs;

/**
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded 
 * by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four 
 * edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * 
 * @author Anirban Bhattacherji
 *
 */

public class NumberOfIslands {
	
	public static void main(String[] args) {
		char[][] grid1 = new char[][]{
							{'1','1','1','1','0'}, 
							{'1','1','0','1','0'}, 
							{'1','1','0','0','0'}, 
							{'0','0','0','0','0'}};
		System.out.println(numIslands(grid1));			
		char[][] grid2 = new char[][]{
							{'1','1','0','0','0'}, 
							{'1','1','0','0','0'}, 
							{'0','0','1','0','0'}, 
							{'0','0','0','1','1'}};
		System.out.println(numIslands(grid2));
	}
	
	public static int numIslands(char[][] grid) {
		if(grid.length == 0){
            return 0;
        }
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!isVisited[i][j]){
                    if(traverse(grid, isVisited, i, j)){
                        islands++;
                    }
                }
            }
        }
        return islands;
    }
    
    public static boolean traverse(char[][] grid, boolean[][] isVisited, int c, int r){
        if(isVisited[c][r]){
            return false;
        }
        isVisited[c][r] = true;
        if(grid[c][r] == '0'){
            return false;
        }
        int[] col = new int[]{0, -1, 0, 1};
        int[] row = new int[]{-1, -0, 1, 0};
        for(int dir = 0; dir < 4; dir++){
            int i = c + col[dir], j = r + row[dir];
            if(i >= 0 && i < grid.length && j >=0 && j < grid[0].length){
                traverse(grid, isVisited, i, j);
            }
        }
        return true;
    }
}
