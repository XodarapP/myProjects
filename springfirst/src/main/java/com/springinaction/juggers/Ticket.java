package com.springinaction.juggers;

public class Ticket {
    private static int ticketNumber = 0;

    public Ticket() {
        System.out.println(ticketNumber);
        ticketNumber++;
    }
}
