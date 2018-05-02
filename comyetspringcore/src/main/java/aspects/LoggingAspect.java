package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

public class LoggingAspect {

    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {

    }

    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("BEFORE: " +
                joinPoint.getTarget().getClass().getSimpleName() + " " +
                joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut="allLogEventMethods()",
            returning="retVal")
    public void logAfter(Object retVal) {
        System.out.println("AFTER_RET: " + retVal);
    }

    @AfterThrowing(pointcut="allLogEventMethods()",
            throwing="ex")
    public void logAfterThrow(Throwable ex) {
        System.out.println("AFTER_THR: " + ex);
    }
}
