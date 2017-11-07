package com.javarush.task.task15.task1520;

/*
Список и нити
*/

import java.util.Date;

/*
Поговорим о музыке?
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument {
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
            System.out.println(this.owner + " starts playing");
            return new Date();
        }

        public Date stopPlaying() {
            System.out.println(this.owner + " stops playing");
            return new Date();
        }

        @Override
        public void run() {
            int start = (int) startPlaying().getTime();
            sleepNSeconds(1);
            int stop = (int) stopPlaying().getTime();
            System.out.println("Playing " + (stop-start) + " ms.");
        }
    }
}
