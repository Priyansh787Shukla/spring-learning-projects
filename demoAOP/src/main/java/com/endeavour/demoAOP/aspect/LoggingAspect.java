package com.endeavour.demoAOP.aspect;

import com.endeavour.demoAOP.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

//    @AfterThrowing(value = "execution(* com.endeavour.demoAOP.service.StudentService.create(..))",
//                   throwing = "e")
//    public void afterThrowing(Throwable e)
//    {
//        System.out.println("afterThrowing() called");
//        System.out.println("Exception Type: "+e.getClass().getName());
//        System.out.println("Exception Message: "+e.getMessage());
//    }

//    @After("execution(* com.endeavour.demoAOP.service.StudentService.create(..))")
//    public void after()
//    {
//        System.out.println("after() called");
//    }

//    @Around("execution(* com.endeavour.demoAOP.service.StudentService.create(..))")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable
//    {
//        System.out.println("Starting: "+pjp.getSignature().getName());
//        try
//        {
//            Object result = pjp.proceed();
//            System.out.println("Execution Successful");
//            return result;
//        }
//        catch(Exception e)
//        {
//            System.out.println("Some Error Occurred, Execution Failed");
//            throw e;
//        }
//        finally
//        {
//            System.out.println("Execution Completed");
//        }
//    }

    @Around("execution(* com.endeavour.demoAOP.service.StudentService.get(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable
    {
        Object[] ar = pjp.getArgs();
        String st = (String) ar[0]; //ar[0].toString() will also work
        String nst = st.toUpperCase();
        Object[] nar = {nst};
        return pjp.proceed(nar);
    }
}























