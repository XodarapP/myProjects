package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i;
        double sum = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            i = scanner.nextInt();
            if (i == -1){
                break;
            }
            else {
                sum += i;
                count ++;
            }
        }
        sum = sum/count;
        System.out.println(sum);

    }
}

