package com.javarush.task.task15.task1515;

/*
Статики 2
*/

import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static int A;
    public static int B;

    public static final int MIN = min(A, B);

    static {
        try {
            Scanner scanner = new Scanner(System.in);
            A = scanner.nextInt();
            B = scanner.nextInt();
            scanner.close();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
