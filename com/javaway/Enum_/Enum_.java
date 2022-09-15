package com.javaway.Enum_;

enum week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THUSDAY("星期四"), FRIDAY("星期五");
    private String a;

    private week(String a) {
        this.a = a;
    }

    ;

    @Override
    public String toString() {
        return a;
    }
}

public class Enum_ {
    public static void main(String[] args) {
        week[] weeks = week.values();
        for (week week : weeks) {
            System.out.println(week);
        }
    }
}
