package com.springinaction.juggers.performers;

import com.springinaction.juggers.instruments.Instrument;
import com.springinaction.juggers.instruments.StringedInstrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Instrumentalist implements Performer {
    public Instrumentalist() {
    }

    private String song;

    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public String screamSong () {
        return song;
    }
    @Autowired
    @StringedInstrument
    private Instrument instrument;

    @Autowired
    @Qualifier("guitar")
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public void perform() {
        System.out.println("Playing " + song + " : ");
        instrument.play();
    }
}
