package com.javarush.task.task18.task1805;

/*
Сортировка байт
*/

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            FileInputStream inputStream = new FileInputStream(new File(scanner.nextLine()));
            ArrayList<Integer> list = new ArrayList<>();

            while (inputStream.available() > 0){
                list.add(inputStream.read());
            } Collections.sort(list);

            for (int i = list.size() - 1; i > -1; i--)
                if (list.indexOf(list.get(i)) != i) list.remove(i);

            for (Integer i : list){
                System.out.print(i + " ");
            }
            inputStream.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

