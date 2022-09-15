package com.DataStructure.Stack_.study;

interface HandleAble {
    String HandleString(String str);
}

public class solution {
    public static void main(String[] args) {
        String str = "23.343252555435";
        HandleAble s1 = new HandleAble() {
            @Override
            public String HandleString(String str) {
                return str.substring(0, str.indexOf("."));
            }
        };

        String str1 = s1.HandleString(str);
        System.out.println("取整" + str1);

        int num = 4;
        HandleAble s2 = new HandleAble() {
            @Override
            public String HandleString(String str) {
                int i = str.indexOf(".") + num + 1;
                char c = str.charAt(i);

                if (c <= '4') {
                    return str.substring(0, i);
                } else {
                    char c1 = (char) (str.charAt(str.indexOf(".") + num) + 1);
                    return str.substring(0, i - 1) + c1;

                }
            }
        };

        String str2 = s2.HandleString(str);
        System.out.println("取小数点后" + num + "位的数为" + str2);
    }
}





