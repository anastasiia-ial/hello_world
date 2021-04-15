package com.company;
/*найти кол-во вхождений наибольшего числа в массиве
пример -
[4,2,3,1,4] -> 2
new int[] {1,2,3,4,5,6}

 */

import java.util.Arrays;
public class Task3 {

        public static void main(String[] args) {
            System.out.println(count(new int[] {0, 1, 0, 1, 0, 1}));
            System.out.println(count(new int[] {9, 8, 0, 8, 9, 0, 9, -9}));
        }

        public static long count(int[] array) {
            int max = Arrays.stream(array).max().orElseThrow();
            return Arrays.stream(array).filter(value -> value == max).count();
        }
    }


