package com.homework;
//有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
//
//        你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
//
//        为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
//        接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，
//        重复该过程。将所有有记录的像素点的颜色值改为newColor。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode.cn/problems/flood-fill
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class dfs {

    public static void main(String[] args) {
        int[][] image = new int[][]{{0, 0, 0}, {0, 0, 0}};
        int sr = 0;
        int sc = 0;
        int color = 0;
        sloution s = new sloution();
        int[][] res = s.floodFill(image, sr, sc, color);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(res[i][j] + ",");
            }
            System.out.println();
        }
    }
}

class sloution {
    int news;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        news = color;
        int clo = image[sr][sc];//记录初始颜色
        image[sr][sc] = news;
        int[][] flag = new int[image.length][image[0].length];//标记点是否已经遍历
        dfs(image, sr, sc, clo, flag);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int start, int[][] flag) {
        flag[sr][sc] = -1;
        int up = up(image, sr, sc);
        int down = down(image, sr, sc);
        int right = right(image, sr, sc);
        int left = left(image, sr, sc);
        if (left != -1 && left == start && flag[sr][sc - 1] != -1) {
            image[sr][sc - 1] = news;
            dfs(image, sr, sc - 1, start, flag);
        }
        if (down != -1 && down == start && flag[sr + 1][sc] != -1) {
            image[sr + 1][sc] = news;
            dfs(image, sr + 1, sc, start, flag);
        }
        if (right != -1 && right == start && flag[sr][sc + 1] != -1) {
            image[sr][sc + 1] = news;
            dfs(image, sr, sc + 1, start, flag);
        }
        if (up != -1 && up == start && flag[sr - 1][sc] != -1) {
            image[sr - 1][sc] = news;
            dfs(image, sr - 1, sc, start, flag);
        }

    }

    public int up(int[][] image, int sr, int sc) {
        if (sr - 1 < 0) return -1;
        return image[sr - 1][sc];
    }

    public int down(int[][] image, int sr, int sc) {
        //

        if (sr + 1 >= image.length) return -1;
        return image[sr + 1][sc];
    }

    public int right(int[][] image, int sr, int sc) {


        if (sc + 1 >= image[0].length) return -1;
        return image[sr][sc + 1];
    }

    public int left(int[][] image, int sr, int sc) {

        if (sc - 1 < 0) return -1;
        return image[sr][sc - 1];
    }
}
