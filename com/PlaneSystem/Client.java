package com.PlaneSystem;

public class Client {
    private String Clientname;
    private int Booknumber;
    private int Garde;

    private Client next = null;

    public Client() {
    }

    public Client(String name, int booknumber, int garde) {
        Clientname = name;
        Booknumber = booknumber;
        Garde = garde;
    }

    public String getClientname() {
        return Clientname;
    }

    public void setClientname(String clientname) {
        this.Clientname = clientname;
    }

    public int getBooknumber() {
        return Booknumber;
    }

    public void setBooknumber(int booknumber) {
        Booknumber = booknumber;
    }

    public int getGarde() {
        return Garde;
    }

    public void setGarde(int garde) {
        Garde = garde;
    }

    @Override
    public String toString() {
        return "姓名" + Clientname + " 订票数 " + Booknumber + " 票等级" + Garde;
    }
}
