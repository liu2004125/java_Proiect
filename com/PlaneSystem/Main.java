package com.PlaneSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // static ArrayList<Client> Preorder = new ArrayList<>();
    static ArrayList<Plane> planes = new ArrayList<>();
    static system sys = new system(planes);
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        planes.add(new Plane("C817", "广州", "001", 3, 100, 1));
        planes.add(new Plane("C817", "湖南", "071", 4, 150, 2));
        planes.add(new Plane("C817", "北京", "003", 4, 250, 1));
        planes.add(new Plane("C777", "广州", "010", 4, 310, 3));
        planes.add(new Plane("C747", "新疆", "012", 5, 150, 3));
        planes.add(new Plane("C919", "湖北", "919", 2, 300, 0));
        planes.add(new Plane("C919", "上海", "002", 1, 300, 0));
        planes.add(new Plane("C919", "上海", "002", 3, 300, 3));
        planes.get(0).getClients().add(new Client("小王", 3, 3));
        planes.get(0).getWait().add(new Client("小明", 1, 3));
        planes.get(0).getWait().add(new Client("小红", 2, 3));
        planes.get(1).getClients().add(new Client("小劳", 3, 1));
        planes.get(2).getClients().add(new Client("小六", 2, 1));
        planes.get(2).getWait().add(new Client("小七", 2, 3));
        planes.get(3).getClients().add(new Client("吴天", 1, 2));
        //上面为初始化实验数据
        System.out.println("3121009322 刘伟皓 计科六");
        menu();
    }

    public static void printMain() {
        System.out.println("------欢迎进入航空订票系统-----");
        System.out.println("---------1:查询航班---------");
        System.out.println("---------2:订购机票---------");
        System.out.println("---------3:退订机票---------");
        System.out.println("--------4:所有航班信息-------");
        System.out.println("--------5:退出程序----------");
        System.out.println("-----输入对应数字选择功能------");
    }

    public static void menu() {

        printMain();

        int i;
        while (true) {
            i = in.nextInt();
            if (i <= 5 && i >= 1) break;
            System.out.println("输入错误，请重新输入");
        }
        in.nextLine();//清除缓存
        switch (i) {
            case 1: {
                String end;
                while (true) {
                    System.out.println("请输入终点");
                    //try是用于判断输入格式是否合法
                    try {
                        end = in.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("输入格式错误，请重新输入");
                        in.nextLine();
                    }
                }
                sys.serchplanes(end);
                System.out.println("按enter键返回菜单");
                in.nextLine();
                menu();
            }
            break;
            case 2: {
                String str;
                while (true) {
                    try {
                        System.out.println("请输入航班号");
                        str = in.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("输入格式错误，请重新输入");
                        in.next();
                    }
                }
                sys.Ordering(str);
                System.out.println("按enter键返回菜单");
                in.nextLine();
                menu();
            }
            break;
            case 3: {
                String str;
                int fly;
                while (true) {
                    try {
                        System.out.println("请输入航班号");
                        str = in.nextLine();
                        System.out.println("请输入起飞日期（星期数）");
                        fly= in.nextInt();
                        in.nextLine();//清除缓存
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("输入格式错误，请重新输入");
                        in.next();
                    }
                }
                sys.OutOrder(str,fly );
                System.out.println("按enter键返回菜单");
                in.nextLine();
                menu();
            }
            break;
            case 4: {
                sys.printall();
                System.out.println("按enter返回菜单");
                in.nextLine();
                menu();
            }
            break;
            case 5:
        }
    }
}
