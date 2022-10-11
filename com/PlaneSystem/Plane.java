package com.PlaneSystem;

import java.util.LinkedList;
import java.util.List;

public class Plane extends Client {
    private String name;
    private String destinastion;
    private String number;

    private int flyday;
    private int Maxnum;
    private int tickets;

    private List<Client> clients;
    private List<Client> wait;

    public Plane(String name, String destinastion, String number, int flyday, int maxnum, int tickets) {
        super();
        this.name = name;
        this.destinastion = destinastion;
        this.number = number;
        this.flyday = flyday;
        this.Maxnum = maxnum;
        this.tickets = tickets;
        clients = new LinkedList<>();
        wait = new LinkedList<>();
    }

    public List<Client> getWait() {
        return wait;
    }

    public List<Client> getClients() {
        return clients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientname() {
        return name;
    }

    public void setClientname(String clientname) {
        this.name = clientname;
    }

    public String getDestinastion() {
        return destinastion;
    }

    public void setDestinastion(String destinastion) {
        this.destinastion = destinastion;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFlyday() {
        return flyday;
    }

    public void setFlyday(int flyday) {
        this.flyday = flyday;
    }

    public int getMaxnum() {
        return Maxnum;
    }

    public void setMaxnum(int maxnum) {
        Maxnum = maxnum;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        System.out.println("飞机型号:" + name + " 目的地:" + destinastion + " 飞行航次:" + number + " 飞行日期:" + flyday
                + " 额定人数" + Maxnum + " 剩余票数:" + tickets);
        System.out.println("当前订票人信息" + clients);
        return "当前侯票人数" + wait;
    }
}
