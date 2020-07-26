package com.wuzeen.leetcode.algorithm.DFS;

/**
 * @program: design_pattern
 * @description: 岛屿的个数
 * **题目描述：**
 *
 * 给定一个由 `'1'`（陆地）和 `'0'`（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * **示例 1:**
 *
 * ```
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * ```
 *
 * **示例 2:**
 *
 * ```html
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 * ```
 * @author: 吴泽恩
 * @create: 2020-07-17 21:52
 **/
public class numIslands {
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private static void dfs (char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        for (int[] d : directions) {
            dfs(grid, row + d[0], col + d[1]);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
        {'1','1','0','1','0'},
        {'1','1','1','0','0'},
        {'0','0','0','0','0'},
        {'1','0','1','0','1'},
        {'1','0','0','1','0'}};
        System.out.println(numIslands(grid));
    }
}
