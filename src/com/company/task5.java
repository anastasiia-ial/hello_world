package com.company;
/*
Есть строка в camelCase надо вывести все подстроки начинающиеся на загланую букву
пример:
ILoveJavaProgramming
result:
I
Love
Java
Programming
 */
public class task5 {
    public static void main(String[] args) {
        print(divide("ILoveJavaProgramming"));
        print(divide("тестТЕСтТестТТТесТтеСт"));
    }

    private static String[] divide(String s) {
        s = s.replaceFirst("[a-zа-яё]*", "");
        return s.split("(?=[A-ZА-ЯЁ])");
    }

    private static void print(String[] s) {
        for (String string : s) {
            System.out.println(string);
        }
        System.out.println();
    }
}
