package com.endeavour.demoAOP.service;

import com.endeavour.demoAOP.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    //target
    public Student create(Student student)
    {
        System.out.println("Student Saved");
        //throw new RuntimeException("Hey, I'm an Exception!");
        return student;
    }
}
