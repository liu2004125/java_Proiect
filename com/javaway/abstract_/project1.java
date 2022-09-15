package com.javaway.abstract_;


public class project1 {
    public static void main(String[] args) {
        manager jack = new manager(10, "jack", 5000);
        jack.setBouns(100);
        jack.work();
        commond hao = new commond(100, "hao", 4500);
        hao.work();
        System.out.println(jack.getBouns());
    }

    //get 和 set 用于后期改变数字
    public abstract static class employee {
        private int id;
        private double salary;
        private String name;

        public employee(int id, String name, double salary) {
            this.salary = salary;
            this.name = name;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }


        public abstract void work();
    }

    public static class commond extends employee {
        public commond(int id, String name, double salary) {
            super(id, name, salary);
        }

        @Override
        public void work() {
            System.out.println("hard");
        }
    }

    public static class manager extends employee {
        private double bouns;

        public manager(int id, String name, double salary) {
            super(id, name, salary);
        }

        public double getBouns() {
            return bouns;
        }

        public void setBouns(double bouns) {
            this.bouns = bouns;
        }

        @Override
        public void work() {
            System.out.println("经理" + getId() + getName() + getSalary());
        }
    }
}
