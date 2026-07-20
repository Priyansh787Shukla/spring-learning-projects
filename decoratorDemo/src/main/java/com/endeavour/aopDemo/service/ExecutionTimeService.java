package com.endeavour.aopDemo.service;

import com.endeavour.aopDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ExecutionTimeService implements StudentService
{
    private LoggingDecorator loggingDecorator;
    public ExecutionTimeService(LoggingDecorator loggingDecorator)
    {
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public void create(Student student)
    {
        long start = System.currentTimeMillis();
        loggingDecorator.create(student);
        long duration = System.currentTimeMillis()-start;
        System.out.println("Execution Time: "+duration);
    }
}
