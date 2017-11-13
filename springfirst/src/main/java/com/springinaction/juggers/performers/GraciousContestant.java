package com.springinaction.juggers.performers;

public class GraciousContestant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("Realization of interface Gracious");
    }
}
