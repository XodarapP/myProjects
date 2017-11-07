package com.javarush.task.task18.task1804;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(new File(scanner.nextLine()));
        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0){
            list.add(inputStream.read());
        }

        inputStream.close();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Integer am;
        for (Integer i : list) {
            am = hm.get(i);
            hm.put(i, am == null ? 1 : am + 1);
        }

        Iterator<Map.Entry<Integer,Integer>> iterator = hm.entrySet().iterator();
        Integer repeatValue = iterator.next().getValue();
        //System.out.println("repeatValue = " + repeatValue);
        while (iterator.hasNext())
        {
            Map.Entry<Integer,Integer> pair = iterator.next();
            if (repeatValue > pair.getValue()){
                repeatValue = pair.getValue();
            }
        }

        iterator = hm.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> pair = iterator.next();
            if (pair.getValue() == repeatValue) {
                System.out.print(pair.getKey() + " ");
            }
        }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}