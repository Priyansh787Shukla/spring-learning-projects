package com.endeavour.aopDemo.service;

import com.endeavour.aopDemo.dto.Student;
import com.endeavour.aopDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService
{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) //only business logic written here, all thanks decorator concept using the-
    {                                   //-LoggingDecorator class to do logging work (infra work) and execution time
                                        // computed by ExecutionTimeService class
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){}
        
        studentRepository.save(student);
    }
}
