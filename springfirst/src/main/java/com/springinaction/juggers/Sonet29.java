package com.springinaction.juggers;

public class Sonet29 implements Poem {
    private static String[] LINES = {
            "ABCDEFG John is hiding far from me",
            "Looking here looking there I can see him anywhere"
    };

    @Override
    public void recite() {
      for (int i = 0; i < LINES.length;  i++){
            System.out.println(LINES[i]);
        }
    }
}
