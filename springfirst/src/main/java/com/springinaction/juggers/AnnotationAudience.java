package com.springinaction.juggers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AnnotationAudience {
    // определение среза
    @Pointcut("execution(* com.springinaction.juggers.performers.Performer.perform(..))")

    // Имя среза определеятся именем метода, к которому применяется аннотация, то есть
    // данный срез имеет имя performance(). Фактически тело метода не имеет значения
    // и должно быть пустым. Сам метод служит точкой подключения аннотации @Pointcut
    public void performance(){
    }

    // Аннотации советов
    @Before("performance()")
    public void takeSeats() {
        System.out.println("The auditorium is taking their seats");
    }

    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund () {
        System.out.println("Boo! We want our money back!");
    }

    @Around("performance()")
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
