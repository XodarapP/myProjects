package com.javarush.task.task01.task0102;

/* 
Комплимент учителю
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\JavaRushTasks\\FileForRead.txt");
        FileOutputStream out = new FileOutputStream(new File(String.valueOf(file)));
        BufferedOutputStream bout = new BufferedOutputStream(out);
        ObjectOutputStream dout = new ObjectOutputStream(bout);
        SerializationObject object = new SerializationObject("Olga", 30);
        dout.writeObject(object);
        dout.flush();

        FileInputStream in = new FileInputStream(new File(String.valueOf(file)));
        BufferedInputStream bin = new BufferedInputStream(in);
        ObjectInputStream din = new ObjectInputStream(bin);
        din.read();
        System.out.println(din.read());
    }

    public static class SerializationObject implements Serializable {
        private String name;
        private int age;

        SerializationObject(String name, int age){
            this.age = age;
            this.name = name;
        }
    }
}
