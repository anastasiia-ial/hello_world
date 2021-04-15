package com.company;

/* 1. вывести на экран символы # так чтобы получилась лестница
    #
   ##
  ###
 ####
#####
######
       в зависимоти от высоты n. n > 0, n < 100;*/

public class Task1 {
    public static void main(String[] args) {

            showStairs(-1);
            showStairs(3);
            showStairs(7);
            showStairs(100);
        }

        private static void showStairs(int number) {
            System.out.println("Получено число " + number);
            if (number < 1) {
                System.out.println("Число не должно быть менее 1!");
                System.out.println();
                return;
            }

            if (number >= 100) {
                System.out.println("Число должно быть менее 100!");
                System.out.println();
                return;
            }

            String line = "";
            for(int i = 0 ; i < number ; i++){
                line += "#";
                System.out.printf("%" + number +"s\n", line);

            }
            System.out.println();
        }
    }

