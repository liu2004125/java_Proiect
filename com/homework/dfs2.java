package com.homework;

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//        此外，你可以假设该网格的四条边均被水包围。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/number-of-islands
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class dfs2 {
    public static void main(String[] args) {
//        char[][] grid = new char[][]{ {'1',"1","1","1","0"},
//            ["1","1","0","1","0"],
//            ["1","1","0","0","0"],
//            ["0","0","0","0","0"]
//        Solution S = new Solution();
//        S.numIslands()
    }
}

class Solution {

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int sum = 0;
        int[][] flag = new int[r][c];//标记是否遍历
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1' && flag[i][j] != -1) {
                    dfs(grid, flag, i, j);
                    sum++; //找到岛屿点
                }
            }
        }
        return sum;
    }

    public void dfs(char[][] grid, int[][] flag, int i, int j) {
        flag[i][j] = -1;
        if (left(grid, flag, i, j)) dfs(grid, flag, i, j - 1);
        if (up(grid, flag, i, j)) dfs(grid, flag, i - 1, j);
        if (right(grid, flag, i, j)) dfs(grid, flag, i, j + 1);
        if (down(grid, flag, i, j)) dfs(grid, flag, i + 1, j);
    }

    public boolean left(char[][] grid, int[][] flag, int i, int j) {
        if (j - 1 < 0 || flag[i][j - 1] == -1 || grid[i][j - 1] == '0') return false;
        return true;
    }

    public boolean up(char[][] grid, int[][] flag, int i, int j) {
        if (i - 1 < 0 || flag[i - 1][j] == -1 || grid[i - 1][j] == '0') return false;
        return true;
    }

    public boolean right(char[][] grid, int[][] flag, int i, int j) {
        if (j + 1 >= grid[0].length || flag[i][j - 1] == -1
                || grid[i][j + 1] == '0') return false;
        return true;
    }

    public boolean down(char[][] grid, int[][] flag, int i, int j) {
        if (i + 1 >= grid.length || flag[i + 1][j] == -1
                || grid[i + 1][j] == '0') return false;
        return true;
    }
}
