package com.endeavour.customAnnotate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect
{
    @Around("@annotation(com.endeavour.customAnnotate.annotation.TrackTime)")
    public Object trackExecutionTime(ProceedingJoinPoint pjp) throws Throwable
    {
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        }
        finally
        {
            long duration = System.currentTimeMillis()-start;
            System.out.println("Time Taken by method "+pjp.getSignature().getName()+": "+duration);
        }
    }
}
