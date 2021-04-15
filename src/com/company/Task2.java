package com.company;
/*
посчитать абсолютную разницу диагоналей в матрице n * n

пример:
1 2 3
4 5 6
9 8 9

1 + 5 + 9 = 15
3 + 5 + 9 = 17

|15 - 17| = 2
 */


public class Task2 {
        public static void main(String[] args) {
            System.out.println(calculate(new int[][]{
                            {1, 2},
                            {2, 1}
                    })
            );

            System.out.println(calculate(new int[][]{
                            {1, 2, 3},
                            {4, 5, 6},
                            {9, 8, 9}
                    })
            );

            System.out.println(calculate(new int[][]{
                            {0, 1, 2, 3},
                            {0, 0, 3, 3},
                            {0, 3, 0, 3},
                            {3, 1, 2, 0}
                    })
            );
        }

        public static int calculate(int[][] inputArray) {
            int first = 0;
            int second = 0;

            for (int i = 0; i < inputArray.length; i++) {
                first += inputArray[i][i];
                second += inputArray[i][inputArray.length - i - 1];
            }
            return Math.abs(first - second);
        }
    }

