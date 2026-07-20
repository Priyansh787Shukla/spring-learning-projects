package com.endeavour.demoAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    @Before("execution(String com.endeavour.demoAOP.service.StudentService.create())")
    public void log()
    {
        System.out.println("Student is going to be saved");
    }
}