package com.javarush.task.task15.task1519;

import java.io.IOException;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String word = scanner.nextLine();

            try {
                Double doubleNumber = Double.parseDouble(word);
                int number = (int) Math.round(doubleNumber);

                if (doubleNumber - number != 0) {
                    print(doubleNumber);
                }

                else if (number > 0 && number < 128){
                    short shortNumber = (short) number;
                    print(shortNumber);
                }

                else if (number <= 0 || number >= 128){
                    print(number);
                }

            } catch (Exception e){
                    if (word.equals("exit")) {
                        break;
                    }
                    else {
                        print(word);
                    }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
