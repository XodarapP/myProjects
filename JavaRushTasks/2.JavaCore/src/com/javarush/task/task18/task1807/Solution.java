package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        scanner.close();
        int readByte = 0;
        long commasCount = 0;
        while (inputStream.available() > 0){
            readByte = inputStream.read();
            if (readByte == 44)
                commasCount++;
        }
        inputStream.close();
        System.out.println(commasCount);
    }
}
