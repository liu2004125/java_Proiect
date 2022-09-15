package com.wuziqi;

public class judge implements GoBandinterface {
    public static boolean judge1(int x, int y) {
        int i, j;
        int temp;
        int winflag = 1; //第一个棋子也要算进其中
        int count = 0;
        temp = map[x][y]; //记录该子的数据
        //判断水平方向的棋子
        for (i = x, j = y - 1; j > 0 && count < 5; j--, count++) //该子的左边
        {
            if (map[i][j] == temp) {
                winflag++;
            } else
                break;
        }
        count = 0;
        for (i = x, j = y + 1; j < n && count < 5; j++, count++) //该子的右边
        {
            if (map[i][j] == temp) {
                winflag++;
            } else
                break;
        }
        if (winflag >= 5)
            return true;
        else
            winflag = 1;
        count = 0;

        //垂直方向
        for (i = x - 1, j = y; i > 0 && count < 5; count++, i--) {
            if (map[i][j] == temp) {
                winflag++;
            } else
                break;
        }
        count = 0;
        for (i = x + 1, j = y; i < n && count < 5; count++, i++) {
            if (map[i][j] == temp) {
                winflag++;
            } else
                break;
        }
        count = 0;
        if (winflag >= 5)
            return true;
        else
            winflag = 1;
        count = 0;

        //正对角线方向
        for (i = x - 1, j = y - 1; i > 0 && j > 0 && count < 5; count++, i--, j--) {
            if (map[i][j] == temp) {
                winflag++;
            } else
                break;
        }
        count = 0;
        for (i = x + 1, j = y + 1; i < n && j < n && count < 5; count++, i++, j++) //count是指连续五个
        {
            if (map[i][j] == temp) {
                winflag++;
            } else
                break;
        }
        if (winflag >= 5)
            return true;
        else
            winflag = 1;
        count = 0;

        //斜对角线方向
        for (i = x + 1, j = y - 1; i < n && j > 0 && count < 5; count++, i++, j--) {
            if (map[i][j] == temp) {
                winflag++;
            } else
                break;
        }
        count = 0;
        for (i = x - 1, j = y + 1; i > 0 && j > 0 && count < 5; count++, i--, j++) {
            if (map[i][j] == temp) {
                winflag++;
            } else
                break;
        }
        if (winflag >= 5)
            return true;

        return false;
    }
}
