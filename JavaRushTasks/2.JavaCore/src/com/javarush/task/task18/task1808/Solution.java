package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        String fileName3 = scanner.nextLine();
        scanner.close();

        FileInputStream inputStream = new FileInputStream(fileName1);
        OutputStream file2OutputStream = new FileOutputStream(fileName2);
        OutputStream file3OutputStream = new FileOutputStream(fileName3);

        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);
        if (count%2 != 0){
            file2OutputStream.write(buffer, 0, count/2 + 1);
            file3OutputStream.write(buffer, count/2 + 1, (buffer.length-count/2 - 1));
        }
        else {
            file2OutputStream.write(buffer, 0, count/2);
            file3OutputStream.write(buffer, count/2, (buffer.length-count/2));
        }
        System.out.println(count);
        inputStream.close();
        file2OutputStream.close();
        file3OutputStream.close();
    }
}
