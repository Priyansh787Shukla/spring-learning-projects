package com.endeavour.demoAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    public void log()
    {
        System.out.println("Student is going to be saved");
    }
}
