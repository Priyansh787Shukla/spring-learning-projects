package com.endeavour.filterDemo.service;

import com.endeavour.filterDemo.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    public void create(Student student)
    {
        System.out.println("Student Created");
        System.out.println(student.getEmail());
        System.out.println(student.getName());
    }
}