package com.springinaction.juggers;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {

    public void takeSeats() {
        System.out.println("The auditorium is taking their seats");
    }

    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    public void demandRefund () {
        System.out.println("Boo! We want our money back!");
    }

    // для вызова совета до и после выполнения метода используется следующий метод:
    public void watchPerformance (ProceedingJoinPoint joinPoint){
        try {
            System.out.println("The auditorium is taking their seats");
            System.out.println("The audience is turning off their cellphones");

            long start = System.currentTimeMillis();

            joinPoint.proceed();

            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP CLAP CLAP");
            System.out.println("The performance took " + (end - start) + " ms.");


        } catch (Throwable throwable) {
            System.out.println("Boo! We want our money back!");
        }
    }
}
