package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        byte data = 0;
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            byte minByte = 0;
            minByte = (byte) inputStream.read();
            while (inputStream.available() > 0){
                data = (byte) inputStream.read();
                if (minByte > data)
                    minByte = data;
            }
            inputStream.close();
            System.out.println(minByte);
        } catch (FileNotFoundException e){
            System.out.println("FileNotFound");
        }

    }
}
