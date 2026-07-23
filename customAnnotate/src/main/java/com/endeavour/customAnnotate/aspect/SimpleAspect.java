package com.endeavour.customAnnotate.aspect;

import com.endeavour.customAnnotate.annotation.TrackTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect
{
    @Around("@annotation(trackTime)")
    public Object trackExecutionTime(ProceedingJoinPoint pjp, TrackTime trackTime) throws Throwable
    {
        long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        }
        finally
        {
            String operation = trackTime.operation();
            if(operation.isEmpty()) operation = pjp.getSignature().getName();
            long duration = System.currentTimeMillis()-start;
            if(duration>=trackTime.warnAfter())
                System.out.print("SLOW EXECUTION ALERT: ");
            System.out.println("Time Taken by method "+operation+": "+duration);
        }
    }
}
