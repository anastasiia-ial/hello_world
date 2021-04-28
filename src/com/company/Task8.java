package com.company;
/*
1. найти в массиве строк частоту слов с помощью Map
string array example:
String [] array = new String [] {"cat", "mouse", "dog", "crocodile", "tiger", "deer", "cat", "moose", "wolf"};
 */

import java.util.HashMap;
import java.util.Map;


public class Task8 {
    public static void main(String[] args) {
        String[] array = new String[] {"cat", "mouse", "dog", "crocodile", "tiger", "deer", "cat", "mouse", "wolf"};
        Map<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
    }
}