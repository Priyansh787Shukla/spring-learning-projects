package com.endeavour.aopDemo.service;

import com.endeavour.aopDemo.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class LoggingDecorator implements StudentService
{
    private StudentServiceImpl studentServiceImpl;
    public LoggingDecorator(StudentServiceImpl studentServiceImpl)
    {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void create(Student student)
    {
        LoggingServiceUtil.logStart("StudentServiceImpl", "create()");
        studentServiceImpl.create(student);
        LoggingServiceUtil.logEnd("StudentServiceImpl", "create()");
    }
}
