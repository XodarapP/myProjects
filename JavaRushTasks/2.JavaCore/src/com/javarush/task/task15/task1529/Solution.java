package com.javarush.task.task15.task1529;

/*
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flyable result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String parameter = reader.readLine();

        if (parameter.equals("helicopter")){
            result = new Helicopter();
        }
        if (parameter.equals("plane")){
            int numberOfPassengers = reader.read();
            result = new Plane(numberOfPassengers);
        }
        reader.close();
    }
}
