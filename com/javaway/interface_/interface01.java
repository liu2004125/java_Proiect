package com.javaway.interface_;

public class interface01 {
    public static void main(String[] args) {
        littermonkey wukong = new littermonkey("WUKONG");
        wukong.swim();
        wukong.fly();
        wukong.work();
    }

    interface bird {
        int age = 1;

        void fly();
    }

    interface fish extends bird {
        int age = 2;

        void swim();
    }
}

class monkey {
    private String name;

    public monkey(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println("climbing");
    }
}

class littermonkey extends monkey implements interface01.fish {
    public littermonkey(String name) {
        super(name);
    }

    public void fly() {
        System.out.println("fly" + age);//类实现接口后拥有其属性
    }

    public void swim() {
        System.out.println("swim");
    }
}
