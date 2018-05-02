package com.springinaction.juggers.performers;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {
    @DeclareParents(value = "com.springinaction.juggers.performers.Performer+", defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
