package com.springinaction.juggers.performers;

import com.springinaction.juggers.instruments.Instrument;

import java.util.Map;

public class OneManBand implements Performer {
    private Map<String, Instrument> instruments;

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }


    public OneManBand() {
    }

    @Override
    public void perform() {
        for (String key : instruments.keySet()){
            System.out.println(key + " : ");
            Instrument instrument = instruments.get(key);
            instrument.play();
        }

    }
}
