package com.endeavour.aopDemo.service;

import com.endeavour.aopDemo.dto.Student;

public class LoggingServiceUtil
{
    public static void logStart(String className, String methodName)
    {
        System.out.println("Executing--> "+className+" : "+methodName);
    }

    public static void logEnd(String className, String methodName)
    {
        System.out.println("Finishing--> "+className+" : "+methodName);
    }
}
