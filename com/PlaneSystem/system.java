package com.PlaneSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class system {
    ArrayList<Plane> planes;
    Scanner in = new Scanner(System.in);

    public system(ArrayList<Plane> planes) {
        this.planes = planes;
    }
    /* 订票成功之后，将乘客信息插入到对应航班的订成员名单域中（链表）*/

    public void addplane(String name, String destinastion, String number, int flyday, int maxnum, int tickets) {
        planes.add(new Plane(name, destinastion, number, flyday, maxnum, tickets));
    }

    public void addClient(Plane plane, String name, int num, int grade) {
        plane.getClients().add(new Client(name, num, grade));
    }

    public void addlorder(Plane plane, String name, int num, int grade) {
        plane.getWait().add(new Client(name, num, grade));
    }

    private Plane serchplane(String number) {//根据航班号查找航班
        for (int i = 0; i < planes.size(); i++) {
            if (number.equals(planes.get(i).getNumber())) {
                System.out.println("成功查询到该航班，航班信息如下");
                System.out.println(planes.get(i));
                return planes.get(i);
            }
        }
        System.out.println("没有该航班号的航班");
        return new Plane("null", "null", "null", 0, 0, 0);
    }


    private Plane serchplane(String number, int flyday) {//根据航班号和起飞时间
        for (int i = 0; i < planes.size(); i++) {
            if (number.equals(planes.get(i).getNumber()) && flyday==planes.get(i).getFlyday()) {
                System.out.println("成功查询到该航班，航班信息如下");
                System.out.println(planes.get(i));
                return planes.get(i);
            }
        }
        System.out.println("目前没有前往该地点的航班");
        return new Plane("null", "null", "null", 0, 0, 0);
    }

    private Plane serortherPlane(Plane p, int nedtick) {
        //plane是临时结点，nedtick是客户需要的票数
        Plane plane = new Plane("null", "null", "null", 7, 0, 0);
        for (int i = 0; i < planes.size(); i++) {
            //相同目的地,不同飞行日
            if (p.getDestinastion().equals(planes.get(i).getDestinastion()) && p.getFlyday() != planes.get(i).getFlyday())
                //飞行日期最近，且有足够票数
                if (planes.get(i).getFlyday() < plane.getFlyday() && planes.get(i).getTickets() > nedtick)
                    plane = planes.get(i);
        }
        return plane;
    }

    public Plane serchplanes(String end) {
        //临时结点
        Plane plane = new Plane("null", "null", "null", 7, 0, 0);
        ;
        for (int i = 0; i < planes.size(); i++) {
            if (planes.get(i).getDestinastion().equals(end)) {
                if (planes.get(i).getFlyday() < plane.getFlyday())
                    plane = planes.get(i);
            }
        }
        if (Objects.equals(plane.getName(), "null")) System.out.println("查无此航班");
        else System.out.println(plane);
        return plane;
    }

    public Client inputClient() {
        System.out.println("输入订购人信息");

        System.out.println("姓名");
        String name = in.nextLine();
        System.out.println("所需票数");
        int num = in.nextInt();
        System.out.println("舱位等级");
        int garde = in.nextInt();
        while (num <= 0) {
            System.out.println("输入票数不合法，重新输入票数");
            num = in.nextInt();
        }
        return new Client(name, num, garde);
    }

    private void addotherClient(Plane otherplane, Client temp) {
        System.out.println("为您推荐其他符合条件的航班");
        System.out.println(otherplane);
        System.out.println("是否购买该航班的票，1：是  2：否");
        if (in.nextInt() == 1) {
            addClient(otherplane, temp.getClientname(), temp.getBooknumber(), temp.getGarde());
            //属性维护
            otherplane.setTickets(otherplane.getTickets() - temp.getBooknumber());
        }
    }

    public void Ordering(String number) {//订票
        Plane plane = serchplane(number);
        if (plane.getName() == "null") return;

        System.out.println("确认购票吗,1:是  2：否");
        //询问是否购票
        if (in.nextInt() == 1) {
            in.nextLine();//清除缓存
            Client temp = inputClient();
            //票数充足
            if (temp.getBooknumber() <= plane.getTickets()) {
                //将其信息加入到购票链表
                addClient(plane, temp.getClientname(), temp.getBooknumber(), temp.getGarde());
                System.out.println("您已成功订票");
                //输出座位
                if (temp.getBooknumber() > 1)
                    System.out.println("您的座位是" + plane.getTickets() + "至" +
                            (plane.getTickets() - temp.getBooknumber() - 1));
                else System.out.println("您的座位是" + plane.getTickets());
                //剩余票数调整
                plane.setTickets(plane.getTickets() - temp.getBooknumber());
            } else {//没有足够的票，询问是否加入侯票
                Plane otherplane = serortherPlane(plane, temp.getBooknumber());
                System.out.println("您需要的票数过多，是否加入排队侯票，目前排队人数为");
                System.out.println(plane.getWait().size());
                System.out.println("1:是");
                System.out.println("2:否");
                if (in.nextInt() == 1) {
                    addlorder(plane, temp.getClientname(), temp.getBooknumber(), temp.getGarde());
                    System.out.println("成功加入排队侯票");
                } else if (!otherplane.getName().equals("null")) {
                    addotherClient(otherplane, temp);
                }
                in.nextLine();
            }
        }else
        in.nextLine();//否则返回到信息界面
    }

    public void OutOrder(String number, int flyday) {//退票
        //根据航班ID，和起飞星期数搜索航班
        Plane plane = serchplane(number, flyday);
        if (plane.getName() == "null") return;
        //读入信息
        System.out.println("请输入退票人信息");
        System.out.println("姓名");
        String name = in.nextLine();
        boolean t = false;//标记是否找到
        //查询是否有该退票人
        for (int i = 0; i < plane.getClients().size(); i++) {
            if (name.equals(plane.getClients().get(i).getClientname())) {
                t = true;
                System.out.println("您已经成功退票");
                //retic是退票数
                int retic = plane.getClients().get(i).getBooknumber();
                //利用迭代器循环
                //因为普通的for循环remove会动态改变list中的元素位置
                /*Iterator.remove() 方法会在删除当前迭代对象的同时，
                会保留原来元素的索引。所以用迭代删除元素是最保险的方法*/
                Iterator iteratorWait = plane.getWait().iterator();
                while (iteratorWait.hasNext()) {
                    Client tempwait = (Client) iteratorWait.next();
                    if (tempwait.getBooknumber() <= retic) {
                        retic -= tempwait.getBooknumber();
                        //将其加入已经购票的队列
                        plane.getClients().add(tempwait);
                        iteratorWait.remove();
                    }
                }
                plane.getClients().remove(i);
            }
        }
        if (!t) System.out.println("没有此人的订票信息");
    }

    public void printall() {
        for (int i = 0; i < planes.size(); i++) {
            System.out.println(planes.get(i));
        }
    }
}

