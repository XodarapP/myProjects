package com.springinaction.juggers;

import com.springinaction.juggers.performers.Performer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("juggers.xml");
        Performer performer = (Performer) context.getBean("poeticJuggler");
        performer.perform();
        Stage stage = (Stage) context.getBean("theStage");
        Ticket ticket = (Ticket) context.getBean("ticket");
        Performer kenny = (Performer) context.getBean("kenny");
        kenny.perform();
        Performer hank = (Performer) context.getBean("hank");
        hank.perform();
    }
}
