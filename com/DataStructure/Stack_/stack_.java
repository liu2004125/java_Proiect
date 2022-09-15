package com.DataStructure.Stack_;

import java.util.Scanner;

//栈的模拟
public class stack_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());//输入操作次数
        stack sta = new stack(n);//通过操作次数来给栈分配空间

        while (in.hasNextLine()) {//判断是否还有输入
            String s = in.nextLine();
            String str[] = s.split(" ");
            if (str[0].equals("push")) {
                sta.push(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop")) {
                sta.pop();
            } else if (str[0].equals("top")) {
                sta.top();
            }
            if (s.equals("@")) break;
        }
    }
}

class stack {
    int[] data;
    int size = 0;
    int maxsize;
    int top = 0;//栈顶指针

    public stack(int maxsize) {
        this.maxsize = maxsize;
        this.data = new int[maxsize];
    }

    public void push(int val) {
        if (this.size == this.maxsize)
            System.out.println("error");
        else {
            data[top++] = val;
            this.size++;//栈顶执政+1
        }
    }

    public void pop() {
        if (this.size == 0)
            System.out.println("error");
        else {
            System.out.println(data[--top]);
            this.size--;
        }
    }

    public void top() {
        if (this.size == 0)
            System.out.println("error");
        else {
            System.out.println(data[top - 1]);
        }
    }
}