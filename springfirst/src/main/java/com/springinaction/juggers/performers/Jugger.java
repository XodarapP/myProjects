package com.springinaction.juggers.performers;

import org.springframework.context.annotation.Bean;

public class Jugger implements Performer {
    private int beanBags;

    public Jugger(int beanBags) {
        this.beanBags = beanBags;
    }

    public Jugger() {

    }

    @Override
    public void perform() {
        System.out.println("Juggling " + beanBags + " BEANBUGS!");
    }
}
