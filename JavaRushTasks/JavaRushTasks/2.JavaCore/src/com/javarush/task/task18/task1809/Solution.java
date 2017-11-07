package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameForRead = reader.readLine();
        String fileNameForWrite = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileNameForRead);
        FileOutputStream outputStream = new FileOutputStream(fileNameForWrite);

        //while (inputStream.available() > 0){

            byte[] buffer = new byte[inputStream.available()];

            int count = inputStream.read(buffer);

            for (int i = 0; i < count / 2; i++) {
                int tmp = buffer[i];
                buffer[i] = buffer[count - i - 1];
                buffer[count - i - 1] = (byte) tmp;
            }

            outputStream.write(buffer, 0, count);
        //}
        inputStream.close();
        outputStream.close();
    }
}
