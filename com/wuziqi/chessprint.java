package com.wuziqi;

public class chessprint implements GoBandinterface {
    public static void chessprintf(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    System.out.printf("%3d", j);
                else if (j == 0)
                    System.out.printf("%3d", i);
                else if (1 == map[i][j])
                    System.out.printf("%3c", 'O');
                else if (2 == map[i][j])
                    System.out.printf("%3c", 'X');
                else if (0 == map[i][j])
                    System.out.printf("%3c", '*');
            }
            System.out.printf("\n");
        }
    }
}
