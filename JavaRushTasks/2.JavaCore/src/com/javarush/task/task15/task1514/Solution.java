package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(0.2554, "main");
        labels.put(5.2554, "her");
        labels.put(1.2554, "his");
        labels.put(7.2554, "them");
        labels.put(6.2554, "their");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
