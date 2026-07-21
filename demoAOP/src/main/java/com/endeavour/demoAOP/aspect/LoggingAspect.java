package com.endeavour.demoAOP.aspect;

import com.endeavour.demoAOP.dto.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    /**proxies for target create() of StudentService*/


//    @Before("execution(String com.endeavour.demoAOP.service.StudentService.create())")
//    public void log()
//    {
//        System.out.println("Student is going to be saved");
//    }

//    @AfterReturning(value = "execution(" +
//                             "com.endeavour.demoAOP.dto.Student com.endeavour.demoAOP.service.StudentService" +
//                              ".create(com.endeavour.demoAOP.dto.Student))",
//                    returning = "result")
//    public void afterReturning(Student result)
//    {
//        result.setName("Rohit");
//        result.setAge(30);
//        System.out.println("afterReturning() Called");
//    }

    @AfterThrowing("execution(* com.endeavour.demoAOP.service.StudentService.create(..))")
    public void afterThrowing()
    {

    }
}











