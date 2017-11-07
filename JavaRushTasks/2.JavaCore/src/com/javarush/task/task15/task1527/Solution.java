package com.javarush.task.task15.task1527;

import java.util.Scanner;

/*
Парсер реквестов
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String link = scanner.nextLine();
        link = link.substring(link.indexOf("?") + 1, link.length());

        String arrayLink[] = link.split("&");

        for (int i = 0; i < arrayLink.length;  i++) {
            if (arrayLink[i].contains("=")){

                String arLink[] = arrayLink[i].split("=");
                for (int j = 0; j < arLink.length; j = j + 2) {
                    System.out.print(arLink[j] + " ");
                }
            }

            else {
                System.out.print(arrayLink[i] + " ");
            }
        }

        if (link.contains("obj")){
            System.out.println();
            arrayLink = link.split("&");
            for (int i = 0; i < arrayLink.length; i = i + 2) {
                arrayLink = arrayLink[0].split("=");
                try {
                    alert(Double.parseDouble(arrayLink[i]));
                }
                catch (Exception e){
                    alert(arrayLink[i]);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
