package com.springinaction.juggers.performers;

import org.springframework.context.annotation.Bean;

public class Juggler implements Performer {
    private int beanBags;

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    public Juggler() {

    }

    @Override
    public void perform() {
        System.out.println("Juggling " + beanBags + " BEANBUGS!");
    }
}
