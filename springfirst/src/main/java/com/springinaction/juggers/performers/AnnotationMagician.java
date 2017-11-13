package com.springinaction.juggers.performers;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// Передача аргументов аннотированным советам
@Aspect
public class AnnotationMagician implements MindReader {
    private String thoughts;

    @Pointcut("execution(* com.springinaction.juggers.performers.Thinker.thinkOfSomething(String)) && args(thoughts)")

    public void thinking(String thoughts){

    }

    @Before("thinking(thoughts)")
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        System.out.println(thoughts);
        return thoughts;
    }
}
