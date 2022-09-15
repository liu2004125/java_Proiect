package com.homework;

//给你一个大小为 m x n 的二进制矩阵 grid 。
//
//        岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//
//        岛屿的面积是岛上值为 1 的单元格的数目。
//
//        计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
//
//         
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/max-area-of-island
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class dfs3 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        sol s = new sol();
        int res = s.maxAreaOfIsland(grid);
        System.out.println(res);
    }

}
class sol {
    public int maxAreaOfIsland(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        island max =new island(0);
        int[][] flag = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1 && flag[i][j]!=-1){
                    island s1=new island(0);
                    s1.num=s1.dfs(grid,flag,i,j,0);
                    if(s1.num>max.num) max.num=s1.num;
                }//找到岛屿点

            }
        }
        return max.num;
    }
    class island {
        int num;

        public island(int num) {
            this.num = num;
        }

        public int dfs(int[][] grid, int[][] flag, int i, int j, int num) {
            flag[i][j] = -1;//标记已经遍历过
            this.num++;
            if (left(grid, flag, i, j)) dfs(grid, flag, i, j - 1, num);
            if (up(grid, flag, i, j)) dfs(grid, flag, i - 1, j, num);
            if (right(grid, flag, i, j)) dfs(grid, flag, i, j + 1, num);
            if (down(grid, flag, i, j)) dfs(grid, flag, i + 1, j, num);
            return this.num;
        }

        public boolean left(int[][] grid, int[][] flag, int i, int j) {
            if (j - 1 < 0 || flag[i][j - 1] == -1 || grid[i][j - 1] == 0) return false;
            return true;
        }

        public boolean up(int[][] grid, int[][] flag, int i, int j) {
            if (i - 1 < 0 || flag[i - 1][j] == -1 || grid[i - 1][j] == 0) return false;
            return true;
        }

        public boolean right(int[][] grid, int[][] flag, int i, int j) {
            if (j + 1 >= grid[0].length || flag[i][j + 1] == -1
                    || grid[i][j + 1] == 0) return false;
            return true;
        }

        public boolean down(int[][] grid, int[][] flag, int i, int j) {
            if (i + 1 >= grid.length || flag[i + 1][j] == -1
                    || grid[i + 1][j] == 0) return false;
            return true;
        }
    }
}
