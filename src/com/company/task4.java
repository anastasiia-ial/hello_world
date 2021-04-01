package com.company;
/*
 поместить строку в центр другой строки чтобы получилось другая строка
пример
s1 = "abceee";
s2 = "vvvbbb";

resulted sting is "abcvvvbbbeee";
 */
public class task4 {
    public static void main(String[] args) {
        String one = "abceee";
        String two = "vvvbbb";
        System.out.println(one.substring(0, one.length() / 2) + two + one.substring(one.length() / 2));
    }
}
