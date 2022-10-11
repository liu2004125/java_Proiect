package com.homework;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class bfs4 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        way te = new way();
        int res = te.numEnclaves(grid);
        System.out.println(res);
    }
}

class way {

    int r;
    int c;
    int[][] move = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int res = 0;

    @Test
    public int numEnclaves(int[][] grid) {
        int count = 0;
        r = grid.length;
        c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !isBoundary(i, j)) {
                    bfs(grid, i, j);
                    count += res;
                }
            }
        }
        return count;
    }

    public int bfs(int[][] grid, int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        while (!que.isEmpty()) {
            int[] temp = que.poll();

            int x1 = temp[0];
            int y1 = temp[1];
            if (!outofbounds(x1, y1)) {
                res = 0;
                continue;
            }//越界
            if (grid[x1][y1] != 1) continue;//新结点不可走
            res++;
            grid[x1][y1] = 0;
            for (int[] moves : move) {
                int newx = x1 + moves[0];
                int newy = y1 + moves[1];
                que.add(new int[]{newx, newy});
            }
        }
        return res;
    }

    public boolean isBoundary(int x, int y) {//是否为边界
        return x == 0 || y == 0 || x == r - 1 || y == c - 1;
    }

    public boolean outofbounds(int x, int y) {//是否越界
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
