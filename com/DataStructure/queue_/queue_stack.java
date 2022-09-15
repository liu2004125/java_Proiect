package com.DataStructure.queue_;

import java.util.Scanner;
import java.util.Stack;

public class queue_stack {//双栈模拟队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {//确保之前加入的元素完全清除
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
