package com.javarush.task.task18.task1801;

import java.io.FileInputStream;/*
Максимальный байт
*/
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        byte data = 0;
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            long lastByte = 0;
            while (inputStream.available() > 0){
                data = (byte) inputStream.read();
                if (data > lastByte)
                    lastByte = data;
            }
            System.out.println(data);
            inputStream.close();
            System.out.println(lastByte);
        } catch (FileNotFoundException e){
            System.out.println("FileNotFound");
        }

    }
}
