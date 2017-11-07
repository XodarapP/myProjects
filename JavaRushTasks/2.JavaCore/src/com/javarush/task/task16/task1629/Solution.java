package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        t1.start();
        t1.join();
        Read3Strings t2 = new Read3Strings();
        t2.start();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread {
        public String phrase;
        //public String finalPhrase;


        public void run() {
            //for (int i = 0; i < 3; i++){
                try {
                    phrase = reader.readLine() + " " +  reader.readLine() + " " +  reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //finalPhrase = phrase + " ";
            //}
        }

        public void printResult() {
            System.out.println(phrase);
        }
    }
}
