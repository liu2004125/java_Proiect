package com.javaway.thread;


public class sync {

    public static void main(String[] args) {
        //Thread(target),是一个构造方法
        bank bank = new bank();
        bank.start();
        Thread a1 = new Thread(bank);
        Thread a2 = new Thread(bank);
        a2.start();
        a1.start();
    }
}

class bank extends Thread {//继承了Thread，相当于实现Runnable接口
    private int money = 10000;

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (this) {//自己作为对象是一把锁
            while (money > 0) {
                setMoney(money - 1000);
                System.out.println("out money" + money);
                try {
                    Thread.sleep(1000 >> 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("end");
        }
    }
}


