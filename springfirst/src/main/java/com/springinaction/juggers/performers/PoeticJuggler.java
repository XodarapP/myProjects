package com.springinaction.juggers.performers;

import com.springinaction.juggers.Poem;

public class PoeticJuggler extends Jugger {
    private Poem poem;

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public void perform(){
        super.perform();
        System.out.println("While reciting... ");
        poem.recite();
    }
}
