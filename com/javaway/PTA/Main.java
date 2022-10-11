package com.javaway.PTA;

public class Main {
    public static void main(String[] args) {
        //  Scanner in = new Scanner(System.in);
        int[] nums = {3, 5};
        String s = "123231";
        int i = Integer.parseInt(s);
        Character r = 's';
        r.isLetterOrDigit('s');
        System.out.println(isPalindrome("rac a car"));
    }

    public static boolean isPalindrome(String s) {
        String[] res = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            ans.append(res[i]);
        }
        String temp1 = ans.reverse().substring(ans.length() / 2 + 1);
        String temp2 = ans.substring(0, ans.length() / 2);

        return temp1.equalsIgnoreCase(temp2);
    }
}


