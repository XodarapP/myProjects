package com.javarush.task.task01.task0129;

/* 
Считаем длину окружности
*/

public class Solution {
    public static void main(String[] args) {
        printCircleLength(5);
    }

    public static void printCircleLength(int radius) {
        double pi = 3.14;
        double result = 2 * pi * radius;
        System.out.println(result);
    }
}