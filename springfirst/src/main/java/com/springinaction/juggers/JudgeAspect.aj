package com.springinaction.juggers;

import org.aspectj.lang.annotation.Aspect;

// Аспект Aspectj для внедрения в программу после выполнения выступления
@Aspect
public aspect JudgeAspect {

    public JudgeAspect() {
    }

    // Срез множества точек сопряжения соответствует методу perform()
    pointcut performance() : execution(* perform(..));

    // После объединения performance() с after() returning() получается аспект, реагирующий на окончание выступления
    after() returning(): performance() {
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
