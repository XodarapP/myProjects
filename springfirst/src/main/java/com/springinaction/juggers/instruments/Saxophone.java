package com.springinaction.juggers.instruments;
@StringedInstrument
public class Saxophone implements Instrument {
    @Override
    public void play() {
        System.out.println("TOOT TOOT TOOT");
    }
}
