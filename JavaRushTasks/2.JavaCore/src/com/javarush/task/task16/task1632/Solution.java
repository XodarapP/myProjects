package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread());
        threads.add(new Thread());
        threads.add(new Thread());
        threads.add(new Thread());
        threads.add(new Thread());
        threads.add(0, new Thread()); //класс наследующий от Thread и выполняющий определенные действия
    }

    public static void main(String[] args) {

    }
}