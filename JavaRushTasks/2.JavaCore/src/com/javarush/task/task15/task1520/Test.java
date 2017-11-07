package com.javarush.task.task15.task1520;

public class Test {
    public static void main(String[] args) {
            String word = "1.256";
                int number = 0;//Integer.parseInt(word);
                System.out.println(number);
                Double doubleNumber = Double.parseDouble(word);
                int wholePart = Integer.parseInt(String.valueOf(doubleNumber));
                System.out.println(doubleNumber);

                if (doubleNumber - wholePart != 0) {
                    System.out.print("YES");

        }
    }
}