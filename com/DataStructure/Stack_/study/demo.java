package com.DataStructure.Stack_.study;


interface compute {
    int computer(int n, int m);
}

public class demo {
    public static void main(String[] args) {
      /*  plus add = new plus();
        unplus subtraction = new unplus();
        multiplication multiplication = new multiplication();
        division division = new division();

        UserComputer useCompute = new UserComputer();
        useCompute.useCom(add, 100, 900);
        useCompute.useCom(subtraction, 100, 900);
        useCompute.useCom(multiplication, 100, 900);
        useCompute.useCom(division, 100, 900);
        UserComputer s =new UserComputer();
*/ //传统方法
        compute add = new compute() {
            @Override
            public int computer(int n, int m) {
                return m + n;
            }
        };
        UserComputer s1 = new UserComputer();
        s1.useCom(add, 100, 900);
    }
}

class UserComputer {
    public void useCom(compute com, int one, int two) {
        int res = com.computer(one, two);
        System.out.println("计算结果为" + res);
    }
}
/*
class plus implements compute{
    @Override
    public int computer(int n, int m) {
        return m+n;
    }
}
class unplus implements compute{
    @Override
    public int computer(int n, int m) {
        return m > n ? m-n :n-m ;
    }
}
class multiplication implements compute{
    @Override
    public int computer(int n, int m) {
        return n*m;
    }
}
class division implements compute{
    @Override
    public int computer(int n, int m) {
        return n/m;
    }
}
 */ //传统方法