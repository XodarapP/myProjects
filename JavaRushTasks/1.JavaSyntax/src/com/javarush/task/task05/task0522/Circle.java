package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public static void main(String[] args) throws InterruptedException {
        TestThread task = new TestThread();
        Thread thread = new Thread(task);
        thread.run();
        thread.sleep(1000);
        System.out.println("My second Thread");
        thread.run();
    }

    public static class TestThread implements Runnable {
        public void run () {
            System.out.println("My first thread");
        }
    }
}

